package com.reactivemobile.openbankprojectpoc.dagger;

import com.reactivemobile.openbankprojectpoc.rest.RestInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by donalocallaghan on 11/04/2017.
 */
@Module
public class RestModule {

    @Provides
    @Singleton
    RestInterface getRestInterface() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder().
                client(client).
                baseUrl("https://psd2-api.openbankproject.com").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        return retrofit.create(RestInterface.class);
    }
}
