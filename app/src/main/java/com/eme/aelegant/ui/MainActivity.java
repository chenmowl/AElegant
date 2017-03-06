package com.eme.aelegant.ui;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eme.aelegant.App;
import com.eme.aelegant.R;
import com.eme.aelegant.base.BaseRxActivity;
import com.eme.aelegant.contract.MainContract;
import com.eme.aelegant.injector.component.DaggerViewComponent;
import com.eme.aelegant.injector.module.ViewModule;
import com.eme.aelegant.model.bean.ZhihuDaily;
import com.eme.aelegant.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 应用入口页
 */
public class MainActivity extends BaseRxActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.tv_show)
    TextView tvShow;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void show(ZhihuDaily zhihuDaily) {
        tvShow.setText(zhihuDaily.toString());
    }

    @Override
    protected void initInject() {
        DaggerViewComponent.builder().appComponent(App.getAppInstance().getAppComponent()).viewModule(new ViewModule(this)).build().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.subscribe();
    }

}
