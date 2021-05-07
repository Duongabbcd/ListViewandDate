package com.example.listviewanddate;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter {

    private Activity context;
    private int[] imagesrc;
    private ArrayList<NhanVien> list;


    public Adapter(@NonNull Activity context,int[] imagesrc,ArrayList<NhanVien> list) {
        super(context, R.layout.list_item, list);
        this.context = context;
        this.imagesrc = imagesrc;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_item, null, true);
        NhanVien nv = new NhanVien();
        ImageView imgView = view.findViewById(R.id.icon);
        TextView textView = view.findViewById(R.id.text);
        CheckBox checkBox = view.findViewById(R.id.cb);
        Button remove=view.findViewById(R.id.remove);
        imgView.setImageResource(imagesrc[position]);
        textView.setText(list.get(position).getCode() + "-" + list.get(position).getName());
        if (list.get(position).getSex() == 1) {
            imagesrc[position] = R.drawable.ic_launcher_background;
            checkBox.setChecked(true);
        } else if (list.get(position).getSex() == 2) {
            imagesrc[position] = R.drawable.ic_launcher_foreground;
            checkBox.setChecked(false);
        }
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}