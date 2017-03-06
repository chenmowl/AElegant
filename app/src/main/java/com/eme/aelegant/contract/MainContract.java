package com.eme.aelegant.contract;

import com.eme.aelegant.base.BasePresenter;
import com.eme.aelegant.base.BaseView;
import com.eme.aelegant.model.bean.ZhihuDaily;

/**
 * Created by dijiaoliang on 17/3/2.
 */
public interface MainContract {

    interface View extends BaseView {
        void show(ZhihuDaily zhihuDaily);
    }

    interface Presenter extends BasePresenter {

    }

}
