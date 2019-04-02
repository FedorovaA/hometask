package com.student.movies.presenter;

import com.student.movies.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<T extends BaseView> implements LifePresenter{
    protected T view;
    protected CompositeDisposable compositeDisposable;

    public BasePresenter(){compositeDisposable = new CompositeDisposable();}
    public void setView(T view){this.view = view;}

    /**
     * Добавить подписку.
     *
     * @param disposable подписчик
     */
    public void addSubscription(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    /**
     * Отписать всех подписчиков.
     */
    public void unSubscriptions() {
        compositeDisposable.dispose();
    }

    @Override
    public void onDestroy() {
        unSubscriptions();
    }
}
