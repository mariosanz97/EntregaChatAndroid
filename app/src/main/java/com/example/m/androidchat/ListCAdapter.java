package com.example.m.androidchat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MarioSanz on 02/3/17.
 */

public class ListCAdapter extends ArrayAdapter<String>{

    private Context context;
    private List <String> messages;

    public ListCAdapter(Context context, List<String> objects){
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.contacto_row, parent, false);
        ListCViewHolder holder = new ListCViewHolder();

        holder.picture = (ImageView) view.findViewById(R.id.ivFotoPerfil);
        holder.contacto = (TextView) view.findViewById(R.id.tvNombreContacto);
        holder.contacto.setText(messages.get(position));

        return view;
    }

}
