package com.student.movies.presenter;

import com.student.movies.view.BaseView;

public abstract class BasePresenter<T extends BaseView> implements LifePresenter{
    protected T view;

    public BasePresenter(){}
    public void setView(T view){this.view = view;}
}
