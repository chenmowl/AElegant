package com.eme.aelegant.model.net;

import com.eme.aelegant.model.net.converter.FastJsonConverterFactory;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@Module
public class ApiModule {

    @Singleton
    @Provides
    Retrofit getRetrofitInstance(){

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if (ApiConstant.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor).addNetworkInterceptor(new StethoInterceptor());
        }
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.API_HOST)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

//    @Singleton
//    @Provides
//    ZhihuApi getZhihuApi(Retrofit retrofit){
//        return retrofit.create(ZhihuApi.class);
//    }

}
