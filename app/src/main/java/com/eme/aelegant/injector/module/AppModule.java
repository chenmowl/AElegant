package com.eme.aelegant.injector.module;

import com.eme.aelegant.App;
import com.eme.aelegant.model.net.RetrofitHelper;
import com.eme.aelegant.model.net.api.ZhihuApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    App provideApp() {
        return App.getAppInstance();
    }

    @Singleton
    @Provides
    RetrofitHelper provideRetrofitHelper(ZhihuApi zhihuApi) {
        return new RetrofitHelper(zhihuApi);
    }
}
