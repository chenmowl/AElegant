package com.eme.aelegant.model.net.api;


import com.eme.aelegant.model.bean.ZhihuDaily;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 知乎api
 */
public interface ZhihuApi {

    @GET("/api/4/news/latest")
    Observable<ZhihuDaily> getLastDaily();

}
