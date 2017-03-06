package com.eme.aelegant.model.net;

import com.eme.aelegant.model.bean.ZhihuDaily;
import com.eme.aelegant.model.net.api.ZhihuApi;

import rx.Observable;

/**
 * Created by dijiaoliang on 17/3/6.
 */

public class RetrofitHelper {

    private ZhihuApi zhihuApi;

    public RetrofitHelper(ZhihuApi zhihuApi) {
        this.zhihuApi = zhihuApi;
    }

    public Observable<ZhihuDaily> getLastDaily() {
        return zhihuApi.getLastDaily();
    }


}
