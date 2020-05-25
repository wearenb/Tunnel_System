package com.example.tunnel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tunnel.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.tunnel.activity.footage;
import com.example.tunnel.activity.log1;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;

    private List<CheckBox> checkBoxList=new ArrayList<CheckBox>();
    TextView selecttunnle;
    Spinner 一分部;
    Spinner 二分部;
    private Button button_search;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    private CheckBox checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18;


//    selecttunnle=(TextView)findViewById(R.id.)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);


        button_search = (Button) findViewById(R.id.button_search1);
        button_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                button_search.setText("查询");
                Intent i = new Intent(MainActivity.this, log1.class);
                startActivity(i);
            }
        });

//进尺按钮响应事件
        Button button_jinchi = (Button) findViewById(R.id.button_jinchi);
        button_jinchi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, footage.class);
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
//日历框输入2
        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    showDatePickDlg2();
                    return true;
                }
                return false;
            }
        });
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePickDlg2();
                }
            }
        });

    }

    //复选框的选取操作
    public List<String> checkbox_select(){
        CheckBox checkBox;
        List<String>checkbox_name=new ArrayList<String>();

        int[] id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5, R.id.checkBox6,
                R.id.checkBox7, R.id.checkBox11, R.id.checkBox12, R.id.checkBox13, R.id.checkBox14,
                R.id.checkBox15, R.id.checkBox16, R.id.checkBox17, R.id.checkBox18};

        for (int i = 0; i <= 14; i++) {
            checkBox = (CheckBox) findViewById(i);
            if (checkBox.isChecked())//复选框被选取，跳转界面到粗略显示界面，然后粗略显示界面点击进行详细显示
            {
                checkbox_name.add(checkBox.getText().toString());
            }
        }
        return checkbox_name;
    }



//弹出日历框1(开始时间)
    protected void showDatePickDlg1() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.editText1.setText(year + "-" + monthOfYear + "-" + dayOfMonth);

            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

    //弹出日历框2（结束时间）
    protected void showDatePickDlg2() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.editText2.setText(year + "-" + monthOfYear + "-" + dayOfMonth);

            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }
}



