package com.example.test.airbnbcalender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yongbeom.aircalendar.AirCalendarDatePickerActivity;
import com.yongbeom.aircalendar.core.AirCalendarIntent;

public class MainActivity extends AppCompatActivity {

    Button btnCalender,btnCalender2;
    TextView tvStartdate,tvEnddate;
    public final static int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalender=(Button)findViewById(R.id.btnCalender);
        btnCalender2=(Button)findViewById(R.id.btnCalender2);
        tvStartdate=(TextView)findViewById(R.id.tvStartdate);
        tvEnddate=(TextView)findViewById(R.id.tvEnddate);
        btnCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AirCalendarIntent intent = new AirCalendarIntent(getApplicationContext());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        btnCalender2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if(data != null){
                tvStartdate.setText(data.getStringExtra(AirCalendarDatePickerActivity.RESULT_SELECT_START_DATE));
                tvEnddate.setText(data.getStringExtra(AirCalendarDatePickerActivity.RESULT_SELECT_END_DATE));
            }


        }
    }
}
