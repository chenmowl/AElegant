package com.eme.aelegant;

import android.app.Application;

import com.eme.aelegant.injector.component.AppComponent;
import com.eme.aelegant.injector.component.DaggerAppComponent;
import com.eme.aelegant.injector.module.AppModule;
import com.eme.aelegant.injector.module.NetModule;

/**
 *
 * 应用的技术:   Dagger2     MVP     RxJava      Retrofit
 *
 *
 * Created by dijiaoliang on 17/3/2.
 */
public class App extends Application {

    private static App app;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent= DaggerAppComponent.builder().appModule(new AppModule()).netModule(new NetModule()).build();
    }

    public static App getAppInstance() {
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
