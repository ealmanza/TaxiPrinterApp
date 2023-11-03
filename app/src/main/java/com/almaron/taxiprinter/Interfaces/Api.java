package com.almaron.taxiprinter.Interfaces;

import com.almaron.taxiprinter.Models.Body.QuoteBody;
import com.almaron.taxiprinter.Models.Response.DefaultResponse;
import com.almaron.taxiprinter.Models.Response.QuoteResponse;
import com.almaron.taxiprinter.Models.Response.StreetsDbResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @Headers("Content-Type: application/json")
    @GET("streetsDbAddress")
    Call<List<StreetsDbResponse>> streetsDbAddress(
            @Query("text") String text
    );

    @Headers("Content-Type: application/json")
    @GET("addressFromText")
    Call<StreetsDbResponse> addressFromText(
            @Query("text") String text
    );

    @Headers("Content-Type: application/json")
    @POST("quote")
    Call<QuoteResponse> Quote (
            @Body QuoteBody quoteBody
    );

    @Headers("Content-Type: application/json")
    @GET("ghostg")
    Call<DefaultResponse> Test();

}
