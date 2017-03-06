package com.eme.aelegant.injector.component;

import com.eme.aelegant.App;
import com.eme.aelegant.injector.module.AppModule;
import com.eme.aelegant.injector.module.NetModule;
import com.eme.aelegant.model.net.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dijiaoliang on 17/3/6.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    RetrofitHelper getRetrofitHelper();

    App provideApp();

}
