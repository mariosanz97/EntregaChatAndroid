package com.example.m.androidchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.utad.chatsdk.presenter.LoginPresenter;


public class Login extends AppCompatActivity implements LoginPresenter.LoginPresenterListener{

    EditText Password;
    Button btnLogin;
    EditText  Email;
    Button btnRegister;
    Intent intent;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.attach(this);


        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegistrar);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    loginPresenter.doLogin(Email.getText().toString(), Password.getText().toString());
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Login.this, Registro.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSuccess() {
        intent = new Intent(this, ListCActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    @Override
    public void onError(String s) {
        Toast.makeText(Login.this, "Repita los datos",Toast.LENGTH_LONG).show();
    }
}