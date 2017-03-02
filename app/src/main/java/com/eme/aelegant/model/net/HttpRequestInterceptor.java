package com.eme.aelegant.model.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 */
public class HttpRequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //这里可以添加全局header
        Request request = chain.request()
                .newBuilder()
                .addHeader("USER_ID", "user_id")
                .build();
        return chain.proceed(request);
    }
}
