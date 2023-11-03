package com.almaron.taxiprinter.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.almaron.taxiprinter.Adapter.AutoSuggestAdapter;
import com.almaron.taxiprinter.Helpers.RetrofittHelper;
import com.almaron.taxiprinter.Helpers.SunmiPrintHelper;
import com.almaron.taxiprinter.Models.Body.QuoteBody;
import com.almaron.taxiprinter.Models.Getter.Address;
import com.almaron.taxiprinter.Models.Getter.PickupDestination;
import com.almaron.taxiprinter.Models.Response.QuoteResponse;
import com.almaron.taxiprinter.Models.Response.StreetsDbResponse;
import com.almaron.taxiprinter.R;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button BtnImprimir, BtnConsultar, BtnNuevo;
    private EditText ETPlaca, ETTarifa;
    private AutoCompleteTextView ETOrigen, ETDestino;
    private TextView TVTarifa;
    private RetrofittHelper retrofittHelper;
    private static final int TRIGGER_AUTO_COMPLETE = 100;
    private static final long AUTO_COMPLETE_DELAY = 300;
    private Handler handlerOri, handlerDes;
    private AutoSuggestAdapter AdapterOrigen, AdapterDestino;
    private List<StreetsDbResponse> Listorigen, Listdestino;
    private StreetsDbResponse SOrigen, SDestino;
    private StreetsDbResponse Origen, Destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnNuevo = findViewById(R.id.BtnNuevo);
        BtnConsultar = findViewById(R.id.BtnConsultar);
        BtnImprimir = findViewById(R.id.BtnImprimir);
        ETOrigen = findViewById(R.id.ETOrigen);
        ETDestino = findViewById(R.id.ETDestino);
        ETPlaca = findViewById(R.id.ETPlaca);
        //TVTarifa = findViewById(R.id.TVTarifa);
        ETTarifa = findViewById(R.id.ETTarifa);
        BtnNuevo.setOnClickListener(this);
        BtnConsultar.setOnClickListener(this);
        BtnImprimir.setOnClickListener(this);

        SunmiPrintHelper.getInstance().initSunmiPrinterService(this);
        SunmiPrintHelper.getInstance().initPrinter();


        Listorigen = new ArrayList<>();
        Listdestino = new ArrayList<>();
        Origen = new StreetsDbResponse();
        Destino = new StreetsDbResponse();

        AdapterOrigen = new AutoSuggestAdapter(this, android.R.layout.simple_dropdown_item_1line);
        AdapterDestino = new AutoSuggestAdapter(this, android.R.layout.simple_dropdown_item_1line);

        ETPlaca.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        ETOrigen.setThreshold(2);
        ETOrigen.setAdapter(AdapterOrigen);

        ETDestino.setThreshold(2);
        ETDestino.setAdapter(AdapterDestino);

        ETOrigen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (Listorigen.size() > 0) {
                    Origen = Listorigen.get(i);
                } else {
                    Origen = SOrigen;
                }
            }
        });

        ETDestino.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (Listdestino.size() > 0) {
                    Destino = Listdestino.get(i);
                } else {
                    Destino = SDestino;
                }
            }
        });

        ETOrigen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handlerOri.removeMessages(TRIGGER_AUTO_COMPLETE);
                handlerOri.sendEmptyMessageDelayed(TRIGGER_AUTO_COMPLETE, AUTO_COMPLETE_DELAY);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ETDestino.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handlerDes.removeMessages(TRIGGER_AUTO_COMPLETE);
                handlerDes.sendEmptyMessageDelayed(TRIGGER_AUTO_COMPLETE, AUTO_COMPLETE_DELAY);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        handlerOri = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == TRIGGER_AUTO_COMPLETE) {
                    if (!TextUtils.isEmpty(ETOrigen.getText())) {
                        Buscar(ETOrigen.getText().toString(), 1);
                    }
                }
                return false;
            }
        });

        handlerDes = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == TRIGGER_AUTO_COMPLETE) {
                    if (!TextUtils.isEmpty(ETDestino.getText())) {
                        Buscar(ETDestino.getText().toString(), 2);
                    }
                }
                return false;
            }
        });

        // BtnImprimir.setEnabled(false);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.BtnNuevo) {
            Listorigen = new ArrayList<>();
            Listdestino = new ArrayList<>();
            Origen = new StreetsDbResponse();
            Destino = new StreetsDbResponse();
            //ETOrigen.setText("");
            ETDestino.setText("");
            ETPlaca.setText("");
            ETTarifa.setText("");
            BtnImprimir.setEnabled(false);
            ETOrigen.requestFocus();
        } else if (view.getId() == R.id.BtnConsultar) {
            Consultar();
        } else if (view.getId() == R.id.BtnImprimir) {
            Imprimir();
        }
    }

    private void Buscar1(String text, int Lug) {
        try {
            retrofittHelper = RetrofittHelper.getInstance("b4be231b1e544447acd0f4559c79114a");
            Call<List<StreetsDbResponse>> call = retrofittHelper
                    .getApi()
                    .streetsDbAddress(text);;
            call.enqueue(new Callback<List<StreetsDbResponse>>() {
                @Override
                public void onResponse(Call<List<StreetsDbResponse>> call, Response<List<StreetsDbResponse>> response) {
                    List<String> stringList = new ArrayList<>();
                    List<StreetsDbResponse> listado = response.body();
                    assert listado != null;
                    for (StreetsDbResponse row: listado) {
                        stringList.add(row.getText());
                    }
                    if (Lug == 1) {
                        AdapterOrigen.setData(stringList);
                        AdapterOrigen.notifyDataSetChanged();
                        Listorigen = listado;
                    } else if (Lug == 2) {
                        AdapterDestino.setData(stringList);
                        AdapterDestino.notifyDataSetChanged();
                        Listdestino = listado;
                    }
                }

                @Override
                public void onFailure(Call<List<StreetsDbResponse>> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            Log.d("TAG_", e.getMessage());
        }

    }

    private void Buscar(String text, int Lug) {
        try {
            retrofittHelper = RetrofittHelper.getInstance("5018266f057b4ce093e247b73944350a");
            Call<StreetsDbResponse> call = retrofittHelper
                    .getApi()
                    .addressFromText(text);;
            call.enqueue(new Callback<StreetsDbResponse>() {
                @Override
                public void onResponse(Call<StreetsDbResponse> call, Response<StreetsDbResponse> response) {
                    List<String> stringList = new ArrayList<>();
                    StreetsDbResponse streetsDbResponse = response.body();
                    if (streetsDbResponse != null) {
                        stringList.add(streetsDbResponse.getText());
                        if (Lug == 1) {
                            AdapterOrigen.setData(stringList);
                            AdapterOrigen.notifyDataSetChanged();
                            SOrigen = streetsDbResponse;
                        } else if (Lug == 2) {
                            AdapterDestino.setData(stringList);
                            AdapterDestino.notifyDataSetChanged();
                            SDestino = streetsDbResponse;
                        }
                    }
                }

                @Override
                public void onFailure(Call<StreetsDbResponse> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            Log.d("TAG_", e.getMessage());
        }

    }

    @SuppressLint("SimpleDateFormat")
    private void Consultar() {
        try {
            if ((Origen.getText().equals("")) || (Destino.getText().equals(""))) {
                return;
            }
            QuoteBody quoteBody = new QuoteBody();
            PickupDestination destination = new PickupDestination();
            PickupDestination pickup = new PickupDestination();
            Address address = new Address();
            SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.077Z");
            Calendar calendar = Calendar.getInstance();

            address.setCoordinate(Destino.getCoordinate());
            address.setStreet(Destino.getStreet());
            address.setText(Destino.getText());
            address.setTown(Destino.getTown());
            address.setZone(Destino.getZone());
            address.setZoneId(Destino.getZoneId());

            destination.setAddress(address);
            destination.setCompleted(false);
            destination.setNote("");
            destination.setPassengerDetailsIndex(null);
            destination.setType("Destination");

            address = new Address();
            address.setCoordinate(Origen.getCoordinate());
            address.setStreet(Origen.getStreet());
            address.setText(Origen.getText());
            address.setTown(Origen.getTown());
            address.setZone(Origen.getZone());
            address.setZoneId(Origen.getZoneId());

            pickup.setAddress(address);
            pickup.setCompleted(false);
            pickup.setNote("");
            pickup.setPassengerDetailsIndex(null);
            pickup.setType("Destination");

            quoteBody.setPickupDueTime(DateFormat.format(calendar.getTime()));
            quoteBody.setPickupDueTimeUtc(DateFormat.format(calendar.getTime()));
            quoteBody.setCompanyId(1);
            quoteBody.setDestination(destination);
            quoteBody.setPickup(pickup);

            Log.d("TAG_", new Gson().toJson(quoteBody));
            retrofittHelper = RetrofittHelper.getInstance("5018266f057b4ce093e247b73944350a");
            Call<QuoteResponse> call = retrofittHelper
                    .getApi()
                    .Quote(quoteBody);
            call.enqueue(new Callback<QuoteResponse>() {
                @Override
                public void onResponse(Call<QuoteResponse> call, Response<QuoteResponse> response) {
                    ETTarifa.setText(String.valueOf(response.body().getOutward().getPrice()));
                    BtnImprimir.setEnabled(true);
                }

                @Override
                public void onFailure(Call<QuoteResponse> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            Log.d("TAG_ERROR", e.getMessage());
        }
    }

    @SuppressLint("SimpleDateFormat")
    private void Imprimir() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        SimpleDateFormat DateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Texto = "";
        Calendar calendar = Calendar.getInstance();
        options.inTargetDensity = 160;
        options.inDensity = 160;

        //Andaluz
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.andaluzp, options);
        //bitmap = Bitmap.createScaledBitmap(bitmap, 380, 160, false);

        //Flota b
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.flotabp, options);
        bitmap = Bitmap.createScaledBitmap(bitmap, 380, 160, false);

        //Taxi Taxi
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.taxitaxip, options);
        //bitmap = Bitmap.createScaledBitmap(bitmap, 380, 160, false);

        SunmiPrintHelper.getInstance().printBitmap(bitmap, 1);

        Texto = DateFormat2.format(calendar.getTime());
        SunmiPrintHelper.getInstance().printText(Texto, 30, true, false, 1);

        /* DIRECCIÓN ORIGEN */
        SunmiPrintHelper.getInstance().printText("\n\nDIRECCIÓN ORIGEN", 30, true, false, 1);
        SunmiPrintHelper.getInstance().printText("\n" + ETOrigen.getText().toString().trim(), 28, false, false, 1);

        /* DIRECCIÓN DESTINO */
        SunmiPrintHelper.getInstance().printText("\n\nDIRECCIÓN DESTINO", 30, true, false, 1);
        SunmiPrintHelper.getInstance().printText("\n" + ETDestino.getText().toString().trim(), 28, false, false, 1);

        /* DIRECCIÓN PLACA */
        SunmiPrintHelper.getInstance().printText("\n\nPLACA", 40, true, false, 1);
        SunmiPrintHelper.getInstance().printText("\n" + ETPlaca.getText().toString().trim(), 40, false, false, 1);

        /* DIRECCIÓN PLACA */
        SunmiPrintHelper.getInstance().printText("\n\nPRECIO ESTIMADO", 30, true, false, 1);
        SunmiPrintHelper.getInstance().printText("\n" + ETTarifa.getText().toString().trim(), 40, false, false, 1);

        /* COMUNICATE */
        //SunmiPrintHelper.getInstance().printText("\n\nComunicate al 6043226000", 30, true, false, 1);

        /* CORREO */
        //SunmiPrintHelper.getInstance().printText("\nasemptaxis@hotmail.com", 30, true, false, 1);

        //SunmiPrintHelper.getInstance().printText("\nDescarga", 50, true, false, 1);
        //SunmiPrintHelper.getInstance().printText("\nTaxi Taxi", 50, true, false, 1);

        //Flota b
        /* COMUNICATE */
        SunmiPrintHelper.getInstance().printText("\n\nComunicate al 604 540 21 29", 30, true, false, 1);

        /* CORREO */
        SunmiPrintHelper.getInstance().printText("\nauxservicioalcliente@flotabernal.com.co", 30, true, false, 1);


        SunmiPrintHelper.getInstance().feedPaper();
        SunmiPrintHelper.getInstance().feedPaper();
        SunmiPrintHelper.getInstance().print3Line();
    }

}