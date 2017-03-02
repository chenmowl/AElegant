package com.eme.aelegant.model.net;

import com.eme.aelegant.model.net.api.ZhihuApi;
import com.eme.aelegant.model.net.converter.FastJsonConverterFactory;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by dijiaoliang on 17/3/2.
 */

public class ApiClient {

    private static Retrofit retrofit;

    private static void checkInstance() {
        if(retrofit==null){
            synchronized (ApiClient.class){
                if(retrofit==null){
                    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                    if (ApiConstant.DEBUG) {
                        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        builder.addInterceptor(httpLoggingInterceptor).addNetworkInterceptor(new StethoInterceptor());
                    }
                    OkHttpClient client = builder.build();

                    retrofit = new Retrofit.Builder()
                            .baseUrl(ApiConstant.API_HOST)
                            .addConverterFactory(FastJsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(client)
                            .build();
                }
            }
        }
    }


    public static ZhihuApi getZhihuApi() {
        checkInstance();
        return retrofit.create(ZhihuApi.class);
    }


}
