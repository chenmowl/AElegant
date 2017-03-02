package com.eme.aelegant.ui.component;

import com.eme.aelegant.AppComponent;
import com.eme.aelegant.ui.MainActivity;
import com.eme.aelegant.ui.module.MainModule;
import com.eme.aelegant.annotation.ActivityScope;

import dagger.Component;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@ActivityScope
@Component(modules = MainModule.class,dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
