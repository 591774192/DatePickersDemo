package com.casic.datepickersdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import jsc.kit.datetimepicker.widget.DateTimePicker;


/**
 * 详细属性请参照一下网址
 * https://github.com/JustinRoom/JSCKit/blob/master/doc/dateTimePicker/date_time_picker.md
 */
public class MainActivity extends AppCompatActivity {

    private TextView currentDate, currentTime;
    private DateTimePicker dateTimePicker1;
    private DateTimePicker dateTimePicker2;


    SimpleDateFormat format1, format2;
    Date date1, date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_selectDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 日期格式为yyyy-MM-dd
                dateTimePicker1.show(date1);
            }
        });

        findViewById(R.id.btn_selectTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 时间格式为yyyy-MM-dd hh-mm
                dateTimePicker2.show(date2);
            }
        });

        currentDate = findViewById(R.id.tv_currentDate);
        currentTime = findViewById(R.id.tv_currentTime);


        //第三步
        //initDatePicker();
        initDatePicker2();
        initTimePicker();

    }



    private void initTimePicker() {
        format2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.CHINA);
        Calendar calendar = Calendar.getInstance();
        //获取当期的时间
        Date startDate = calendar.getTime();
        date2  = calendar.getTime();
        currentTime.setText(format2.format(date2));


        calendar.set(Calendar.YEAR, 2080);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 8);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date endDate = calendar.getTime();


        dateTimePicker2 = new DateTimePicker(this, new DateTimePicker.ResultHandler() {
            @Override
            public void handle(Date date) {
                date2 = date;
                currentTime.setText(format2.format(date));
            }
        }, startDate, endDate, new DateTimePicker.Builder(this).setLoopScroll(true));


    }

    private void initDatePicker2() {
        format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Calendar calendar = Calendar.getInstance();
        //获取当期的时间
        Date startDate = calendar.getTime();
        date1 = calendar.getTime();
        currentDate.setText(format1.format(date1));

        calendar.set(Calendar.YEAR, 2080);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 8);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date endDate = calendar.getTime();

        //自定义builder
        DateTimePicker.Builder builder = new DateTimePicker.Builder(this)
                .setTitle("选择年月日")
                .setCancelTextColor(Color.RED)
                .setOkTextColor(this.getResources().getColor(R.color.colorBlack))
                .setCancelTextColor(this.getResources().getColor(R.color.colorBlack))
                .setTitleTextColor(0xFF999999)
                .setSelectedTextColor(this.getResources().getColor( R.color.colorAccent))
                .setKeepLastSelected(true)
                .setShowYMDHMLabel(true)
                .setShowType(DateTimePicker.ShowType.DAY);


        dateTimePicker1 = new DateTimePicker(this, new DateTimePicker.ResultHandler() {
            @Override
            public void handle(Date date) {
                date1 = date;
                currentDate.setText(format1.format(date));
            }
        }, startDate, endDate,  builder);


    }


    private void initDatePicker() {
        format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        format2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.CHINA);
        Calendar calendar = Calendar.getInstance();
        //获取当期的时间
        Date startDate = calendar.getTime();
        date2 = date1 = calendar.getTime();
        currentDate.setText(format1.format(date1));
        currentTime.setText(format2.format(date1));

        //        calendar.set(Calendar.YEAR, 2010);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 8);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date endDate = calendar.getTime();

        DateTimePicker.Builder builder = new DateTimePicker.Builder(this)
                .setTitle("选择年月日")
                .setCancelTextColor(Color.RED)
                .setOkTextColor(this.getResources().getColor(R.color.colorPrimary))
                .setTitleTextColor(0xFF999999)
                .setSelectedTextColor(this.getResources().getColor( R.color.colorAccent))
                .setKeepLastSelected(true)
                .setShowYMDHMLabel(true)
                .setShowType(DateTimePicker.ShowType.DAY);
        dateTimePicker1 = new DateTimePicker(this, new DateTimePicker.ResultHandler() {
            @Override
            public void handle(Date date) {
                date1 = date;
                currentDate.setText(format1.format(date));
            }
        }, startDate, endDate, builder);

        dateTimePicker2 = new DateTimePicker(this, new DateTimePicker.ResultHandler() {
            @Override
            public void handle(Date date) {
                date2 = date;
                currentTime.setText(format2.format(date));
            }
        }, startDate, endDate, new DateTimePicker.Builder(this).setLoopScroll(true));
    }
}
