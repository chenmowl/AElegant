package com.eme.aelegant.ui.module;

import com.eme.aelegant.contract.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@Module
public class MainModule {

    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    MainContract.View getView(){
        return view;
    }
}
