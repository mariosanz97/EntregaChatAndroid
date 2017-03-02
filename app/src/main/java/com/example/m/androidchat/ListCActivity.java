package com.example.m.androidchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.utad.chatsdk.data.ChatUser;
import com.utad.chatsdk.presenter.UsersPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListCActivity extends AppCompatActivity implements UsersPresenter.UsersPresenterListener{


    private List<String> Array;
    private ListView listv;
    ListCAdapter listCAdapter;
    UsersPresenter usersPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_contactos);
        usersPresenter = new UsersPresenter(this);
        usersPresenter.attach(this);

        listv = (ListView)findViewById(R.id.listView);


        Array = new ArrayList<String>();

        listCAdapter = new ListCAdapter(this, Array);
        listv.setAdapter(listCAdapter);

        usersPresenter.getUsers();

        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ListCActivity.this, conversacion.class));
            }
        });

    }

    @Override
    public void onSuccess(ArrayList<ChatUser> arrayList) {
        for (ChatUser user: arrayList) {
            Array.add(user.getUserName());
        }
        listCAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String s) {

    }

}
