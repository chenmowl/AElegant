package com.eme.aelegant.presenter.component;

import com.eme.aelegant.AppModule;
import com.eme.aelegant.annotation.AppScope;
import com.eme.aelegant.presenter.MainPresenter;

import dagger.Component;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@AppScope
@Component(modules = {AppModule.class})
public interface PresenterComponent {

    void inject(MainPresenter mainPresenter);

}
