package com.eme.aelegant.model.net;

import com.eme.aelegant.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {

    void inject(MainPresenter mainPresenter);

}
