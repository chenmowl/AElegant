package com.eme.aelegant;

import android.content.Context;

import com.eme.aelegant.annotation.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @AppScope
    App provideApp() {
        return (App) context.getApplicationContext();
    }

    @Provides
    @AppScope
    Context provideContext() {
        return context;
    }
}
