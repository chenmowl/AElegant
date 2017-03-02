package com.eme.aelegant;

import android.content.Context;

import com.eme.aelegant.annotation.AppScope;

import dagger.Component;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    App provideApp();

    Context provideContext();
}
