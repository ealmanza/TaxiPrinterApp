package com.almaron.taxiprinter.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.Settings;
import android.widget.TextView;

import com.almaron.taxiprinter.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpashActivity extends AppCompatActivity {

    private Context mCtx;
    private TextView TVImei, TVVersion;

    private String[] AppPermissions = {
            Manifest.permission.INTERNET,
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN,
    };

    private static final int PERMISSIONS_REQUEST_CODE = 1240;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        TVVersion = findViewById(R.id.TVVersion);
        TVImei = findViewById(R.id.TVImei);
        mCtx = this;

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());

        if (CheckAndRequestPermissions()) {
            inicio();
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            HashMap<String, Integer> permissionResults = new HashMap<>();
            int deniedCount = 0;
            for (int i = 0; i < grantResults.length; i++){
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    permissionResults.put(permissions[i], grantResults[i]);
                    deniedCount++;
                }
            }
            if (deniedCount == 0) {
                inicio();
            } else {
                for (Map.Entry<String, Integer> entry : permissionResults.entrySet()) {
                    String permName = entry.getKey();
                    int permResult = entry.getValue();
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permName)) {
                        ShowDialog("PERMISOS", "La Plicación Necesita El Permiso De [ " + Nombre(permName) + " ] Para Su Correcto Funcionamiento",
                                "Otorgar Permiso", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        CheckAndRequestPermissions();
                                    }
                                }, "Salir", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        finish();
                                        System.exit(0);
                                    }
                                }, false);
                    } else {
                        ShowDialog("PERMISOS", "Usted ha negado algún permiso. Permitir todos los permisos en [Configuración]> [Permisos] [ " + permName + " ]",
                                "Ir A Configuraciones", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null));
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                        System.exit(0);
                                    }
                                }, "Salir", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        finish();
                                        System.exit(0);
                                    }
                                }, false);
                    }
                }
            }
        }
    }

    private AlertDialog ShowDialog(String title, String msg, String positiveLabel, DialogInterface.OnClickListener possitiveOnClick,
                                   String negativeLavel, DialogInterface.OnClickListener negativeOnClick, boolean isCancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(isCancelable);
        builder.setMessage(msg);
        builder.setPositiveButton(positiveLabel, possitiveOnClick);
        builder.setNegativeButton(negativeLavel, negativeOnClick);
        AlertDialog alert = builder.create();
        alert.show();
        return alert;
    }

    private String getAppVersion(Context context) {
        String Res = "";
        try {
            Res = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return Res.replaceAll("[a-zA-Z]|-", "");
    }

    private String Nombre(String nombre) {
        String Res = "-";
        switch (nombre) {

            case Manifest.permission.ACCESS_NETWORK_STATE:
                Res = "Leer El Estado De La Red";
                break;

            case Manifest.permission.CHANGE_NETWORK_STATE:
                Res = "Cambiar El Estado De La Red";
                break;

            case Manifest.permission.ACCESS_WIFI_STATE:
                Res = "Leer El Estado De La Wi-Fi";
                break;

            case Manifest.permission.CHANGE_WIFI_STATE:
                Res = "Cambiar El Estado De La Wi-Fi";
                break;

            case Manifest.permission.INTERNET:
                Res = "Permitir El Acceso A Internet";
                break;

            case Manifest.permission.VIBRATE:
                Res = "Permitir La Vibración";
                break;

            case Manifest.permission.READ_PHONE_STATE:
                Res = "Leer El Estado Del Telefono";
                break;

            case Manifest.permission.READ_EXTERNAL_STORAGE :
                Res = "Leer El Almacenamiento Externo";
                break;

            case Manifest.permission.WRITE_EXTERNAL_STORAGE :
                Res = "Excribir En El Almacenamiento Externo";
                break;

            case Manifest.permission.BLUETOOTH :
            case Manifest.permission.BLUETOOTH_ADMIN :
                Res = "Permite que las aplicaciones se conecten a dispositivos Bluetooth emparejados";
                break;

            case Manifest.permission.ACCESS_FINE_LOCATION:
            case Manifest.permission.ACCESS_COARSE_LOCATION:
                Res = "Permitir Acceder A La Ubicación Precisa";
                break;
        }
        return Res;
    }

    @SuppressLint("SetTextI18n")
    private void inicio() {
        TVVersion.setText("v" + getAppVersion(mCtx));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mCtx, MainActivity.class));
            }
        }, 5000);
    }

    private boolean CheckAndRequestPermissions() {
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String perm : AppPermissions) {
            if (ContextCompat.checkSelfPermission(this, perm) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(perm);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), PERMISSIONS_REQUEST_CODE);
            return false;
        }
        return true;
    }

}