package com.eme.aelegant.injector.module;

import com.eme.aelegant.annotation.ActivityScope;
import com.eme.aelegant.base.BaseView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dijiaoliang on 17/3/2.
 */
@Module
public class ViewModule {

    private BaseView view;

    public ViewModule(BaseView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BaseView getView() {
        return view;
    }
}
