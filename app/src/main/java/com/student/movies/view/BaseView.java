package com.student.movies.view;

import android.content.Context;

public interface BaseView {
    Context getContext();
    void showToast(String message);
}
