package com.almaron.taxiprinter.Helpers;

import com.almaron.taxiprinter.Interfaces.Api;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofittHelper {

    private static String API_URL = "https://autocab-api.azure-api.net/booking/v1/";
    //private static String API_URL = "https://smartcab.com.co/optimizador/api/public/api/";
    private static RetrofittHelper mInstance = null;
    private Retrofit retrofit;
    private Gson gson;

    private static String AUTH;

    public RetrofittHelper() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Ocp-Apim-Subscription-Key", AUTH)
                                //.addHeader("Ocp-Apim-Subscription-Key", )
                                //.addHeader("Ocp-Apim-Subscription-Key", )
                                .build();
                        return chain.proceed(request);
                    }
                });
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public static synchronized RetrofittHelper getInstance(String Token) {
        if (mInstance == null) {
            synchronized (RetrofittHelper.class) {
                if (mInstance == null) {
                    mInstance = new RetrofittHelper();
                }
            }
        }
        AUTH = Token;
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }

}
