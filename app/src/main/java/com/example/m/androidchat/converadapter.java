package com.example.m.androidchat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class converadapter extends ArrayAdapter<String>{

    private Context context;
    private List <String> messages;

    public converadapter(Context context, List<String> objects){
        super(context, 0, objects);
        this.context = context;
        this.messages = objects;
    }

    @Override
    public int getCount(){
        return messages.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String message = messages.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.mensaje_enviado, parent, false);
        ConverViewHolder holder = new ConverViewHolder();
        holder.TextView = (TextView)v.findViewById(R.id.mensajee);
        holder.TextView.setText(message);
        return v;
    }


}

