package com.example.listviewanddate;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edCode;
    private TextView text;
    private Button btnEnter, btdate;
    private RadioButton rbmale;
    private RadioButton rbfemale;
    private ListView listCus;
    private ArrayList<NhanVien> cus;
    private int[] srcImage = new int[100];
    private int mYear,mDay,mMonth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.datetext);
        edName = findViewById(R.id.ed2);
        edCode = findViewById(R.id.ed1);
        btdate = findViewById(R.id.eddate);
        btnEnter = findViewById(R.id.bt);
        listCus = findViewById(R.id.listView);
        cus = new ArrayList<NhanVien>();
        rbmale = findViewById(R.id.rd2);
        rbfemale = findViewById(R.id.rd1);
        rbfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbfemale.setChecked(true);
                rbmale.setChecked(false);
            }
        });
        rbmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbfemale.setChecked(false);
                rbmale.setChecked(true);
            }
        });
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv = new NhanVien();
                String name = edName.getText().toString();
                String code = edCode.getText().toString();
                nv.setName(name);
                nv.setCode(code);
                if (rbmale.isChecked() == true) {
                    nv.setSex(1);
                } else {
                    nv.setSex(2);
                }
                cus.add(nv);
                Adapter adapter = new Adapter(MainActivity.this, srcImage,cus);
                listCus.setAdapter(adapter);
            }
        });
        btdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar= Calendar.getInstance();
                mYear=calendar.get(Calendar.YEAR);
                mDay=calendar.get(Calendar.DAY_OF_MONTH);
                mMonth=calendar.get(Calendar.MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        text.setText(mDay+"/"+mMonth+"/"+mYear);
                    }
                },mYear,mDay,mMonth);
                datePickerDialog.show();
            }
        });
    }
}