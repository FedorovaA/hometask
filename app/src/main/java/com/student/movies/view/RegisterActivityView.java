package com.student.movies.view;

import android.widget.EditText;

public interface RegisterActivityView extends BaseView {
    void onRegister(String message);
    String getStrings(EditText text);
    void onAuthActivity();
}
