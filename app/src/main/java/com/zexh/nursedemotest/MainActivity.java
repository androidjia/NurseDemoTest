package com.zexh.nursedemotest;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    private DatePicker datapicker;
    private TextView tv;
    int year,day,month;
    private Button btn;
    TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        datapicker.setEnabled(true);
        datapicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
              year = i;
                month= i1;
                day = i2;

                showDialog(i,i1,i2);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tv_show.setText("日期："+String.format("%d-%d-%d",i,i1+1,i2));
                    }
                },2000,1,2).show();
            }
        });

    }
    private void showDialog(int i, int i1, int i2) {
        tv.setText(i+ "年"+i1+"月"+i1+"日");
    }

    private void initView() {
       datapicker = (DatePicker) findViewById(R.id.timepicker);
        tv = (TextView) findViewById(R.id.texts);
        btn = (Button) findViewById(R.id.btn_data);
        tv_show = (TextView) findViewById(R.id.showdata);
    }
}
