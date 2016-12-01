package com.jomcode.flexcility;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fadhil on 17/11/2016.
 * Generates a retrofit client used to access an api at BASE_URL
 */

public class ServiceGenerator {
    private static final String BASE_URL = "http://10.0.2.2:3000";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    public static Retrofit retrofit(){
        return builder.client(httpClient.build()).build();

    }
}
