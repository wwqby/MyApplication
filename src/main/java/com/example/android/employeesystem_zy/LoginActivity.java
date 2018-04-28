package com.example.android.employeesystem_zy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import View.IUserLoginView;

public class LoginActivity extends AppCompatActivity implements IUserLoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return "123";
    }

    @Override
    public void ClearUser() {

    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgreeBar() {

    }

    @Override
    public void toMainActivity() {

    }

    @Override
    public void loginFailedDialog() {

    }
}
