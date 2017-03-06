package com.eme.aelegant.presenter;

import android.util.Log;

import com.eme.aelegant.base.BaseView;
import com.eme.aelegant.contract.MainContract;
import com.eme.aelegant.model.bean.ZhihuDaily;
import com.eme.aelegant.model.net.RetrofitHelper;

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

    RetrofitHelper retrofitHelper;

    @Inject
    public MainPresenter(BaseView view, RetrofitHelper retrofitHelper) {
        this.view = (MainContract.View)view;
        this.retrofitHelper=retrofitHelper;
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void subscribe() {
        //请求数据
        loadData();
    }

    private void loadData() {
        Subscription subscription = retrofitHelper.getLastDaily()
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
