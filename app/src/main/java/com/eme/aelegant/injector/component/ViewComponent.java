package com.eme.aelegant.injector.component;

import com.eme.aelegant.annotation.ActivityScope;
import com.eme.aelegant.injector.module.ViewModule;
import com.eme.aelegant.ui.MainActivity;

import dagger.Component;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ViewModule.class)
public interface ViewComponent {

    void inject(MainActivity mainActivity);
}
