package com.ismail.gads.network;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicesModule {

    private static Retrofit retrofit;
    private static ServicesModule servicesModule;

    private ServicesModule(String baseUrl){
        retrofit = providesRetrofitClient(providesOkHttpClient(),
                baseUrl);
    }

    public static ServicesModule getInstance(String baseUrl){
        if(servicesModule == null) {
            return new ServicesModule(baseUrl);
        } else {
            retrofit = providesRetrofitClient(providesOkHttpClient(),
                    baseUrl);
        }

        return servicesModule;
    }

    private static Retrofit providesRetrofitClient(OkHttpClient httpClient, String baseUrl) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(httpClient).build();
    }


    
    private  static OkHttpClient providesOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }


    public Routes Routes(){
        return createService(Routes.class);
    }


    private  <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }


}
