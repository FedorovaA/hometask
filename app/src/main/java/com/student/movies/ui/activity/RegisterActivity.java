package com.student.movies.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.student.movies.R;
import com.student.movies.presenter.RegisterActivityPresenter;
import com.student.movies.utils.Conditional;
import com.student.movies.view.RegisterActivityView;

public class RegisterActivity extends AppCompatActivity implements RegisterActivityView {
    EditText edtEmail;
    EditText edtPassword;
    EditText edtPassword2;
    Button btnRegister;
    RegisterActivityPresenter registerActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerActivityPresenter = new RegisterActivityPresenter();
        registerActivityPresenter.setView(this);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password1);
        edtPassword2 = findViewById(R.id.edt_password2);
        btnRegister = findViewById(R.id.btn_signIn);
        btnRegister.setOnClickListener(v->{
            if(!Conditional.isNotDataEmpty(getStrings(edtEmail)) &&
                    !Conditional.isNotDataEmpty(getStrings(edtPassword))&&
            !Conditional.isNotDataEmpty(getStrings(edtPassword2))&&
            Conditional.checkDoublePassword(getStrings(edtPassword),getStrings(edtPassword2))){
                registerActivityPresenter.isRegister(
                        registerActivityPresenter.register(getStrings(edtEmail),getStrings(edtPassword))
                );
            }
            else {
                onRegister("Invalid Data");
            }
        });

    }
    @Override
    public void onRegister(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getStrings(EditText text) {
        return text.getText().toString();
    }

    @Override
    public void onAuthActivity() {
        Intent intent = new Intent(getContext(),AuthorizationActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String message) {

    }
}
