package com.eme.aelegant.contract;

import com.eme.aelegant.model.javabean.ZhihuDaily;
import com.eme.aelegant.presenter.MainPresenter;
import com.eme.elegant.BasePresenter;
import com.eme.elegant.BaseView;

/**
 * Created by dijiaoliang on 17/3/2.
 */
public interface MainContract {

    interface View extends BaseView<MainPresenter>{
        void show(ZhihuDaily zhihuDaily);
    }

    interface Presenter extends BasePresenter{
    }

}
