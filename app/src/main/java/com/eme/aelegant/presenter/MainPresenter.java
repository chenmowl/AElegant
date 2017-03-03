package com.eme.aelegant.presenter;

import android.content.Context;
import android.util.Log;

import com.eme.aelegant.AppModule;
import com.eme.aelegant.contract.MainContract;
import com.eme.aelegant.model.javabean.ZhihuDaily;
import com.eme.aelegant.model.net.ApiClient;
import com.eme.aelegant.model.net.api.ZhihuApi;
import com.eme.aelegant.presenter.component.DaggerPresenterComponent;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dijiaoliang on 17/3/2.
 */
public class MainPresenter implements MainContract.Presenter {

    private static final String TAG=MainPresenter.class.getSimpleName();

    private MainContract.View view;

    private CompositeSubscription compositeSubscription;

    ZhihuApi zhihuApi;

    @Inject
    public MainPresenter(Context context, MainContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        compositeSubscription = new CompositeSubscription();
        zhihuApi= ApiClient.getZhihuApi();
        DaggerPresenterComponent.builder().appModule(new AppModule(context)).build().inject(this);

    }

    @Override
    public void subscribe() {
        //请求数据
        loadData();
    }

    private void loadData() {
        Subscription subscription = zhihuApi.getLastDaily()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ZhihuDaily>() {
                    @Override
                    public void call(ZhihuDaily zhihuDaily) {
                        Log.e(TAG, "next");
                        view.show(zhihuDaily);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, throwable.toString());
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        Log.e(TAG, "complete");
                    }
                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void unSubscribe() {
        compositeSubscription.clear();
    }
}
