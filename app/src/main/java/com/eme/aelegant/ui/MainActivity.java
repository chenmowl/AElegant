package com.eme.aelegant.ui;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eme.aelegant.App;
import com.eme.aelegant.R;
import com.eme.aelegant.contract.MainContract;
import com.eme.aelegant.model.javabean.ZhihuDaily;
import com.eme.aelegant.presenter.MainPresenter;
import com.eme.aelegant.ui.component.DaggerMainComponent;
import com.eme.aelegant.ui.module.MainModule;
import com.eme.elegant.BaseRxActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 应用入口页
 */
public class MainActivity extends BaseRxActivity implements MainContract.View {

    @BindView(R.id.tv_show)
    TextView tvShow;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        componentInit();
        init();
    }

    private void componentInit() {
        DaggerMainComponent.builder().appComponent(App.getAppInstance().getAppComponent()).mainModule(new MainModule(this)).build().inject(this);
    }

    private void init() {
        mainPresenter.subscribe();
    }

    @Override
    public void setPresenter(MainPresenter presenter) {
        mainPresenter=presenter;
    }

    @Override
    public void show(ZhihuDaily zhihuDaily) {
        tvShow.setText(zhihuDaily.toString());
    }
}
