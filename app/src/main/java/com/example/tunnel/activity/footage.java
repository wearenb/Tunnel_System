package com.example.tunnel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.tunnel.R;

import java.util.Calendar;



public class footage extends AppCompatActivity {
    private EditText editText1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinchi);


//日志按钮响应事件
        Button button_rizhi = (Button) findViewById(R.id.button_rizhi);
        button_rizhi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(footage.this, MainActivity.class);
                startActivity(i);
            }
        });


        //搜索按钮
        Button button_search = (Button) findViewById(R.id.button_search);
        button_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(footage.this, listview_footage.class);
                startActivity(i);
            }
        });
//日历框输入1
        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    showDatePickDlg1();
                    return true;
                }
                return false;
            }
        });
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePickDlg1();
                }
            }
        });
    }


    //弹出日历框1(开始时间)
    protected void showDatePickDlg1() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(footage.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                footage.this.editText1.setText(year + "-" + monthOfYear + "-" + dayOfMonth);

            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }
}