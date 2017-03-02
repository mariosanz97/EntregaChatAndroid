package com.example.m.androidchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.utad.chatsdk.presenter.RegisterPresenter;

public class Registro extends AppCompatActivity implements RegisterPresenter.RegisterPresenterListener{

    EditText name;
    EditText secondpassword;
    EditText password;
    EditText user;
    Button btnRegistrar;
    Button btatras;
    Intent intent = null;
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        registerPresenter = new RegisterPresenter(this);
        registerPresenter.attach(this);



        user = (EditText)findViewById(R.id.registerEmail);
        name = (EditText)findViewById(R.id.registerName);
        password = (EditText)findViewById(R.id.registerPwd);
        btnRegistrar = (Button)findViewById(R.id.btnRegister);
        btatras = (Button)findViewById(R.id.btatras);

        secondpassword = (EditText)findViewById(R.id.registerPwdComprobar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals(secondpassword.getText().toString())){
                    registerPresenter.doRegister(name.getText().toString(),user.getText().toString(),password.getText().toString());
                }else{
                    Toast.makeText(Registro.this, "Repita contraseña",Toast.LENGTH_LONG).show();
                }
            }
        });

        intent = new Intent(this, Login.class);
        btatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }


    @Override
    public void onSuccess() {
        Toast.makeText(this,"Registrado", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(String s) {
        Toast.makeText(this,"Error al intentar registrar", Toast.LENGTH_LONG).show();
    }
}
