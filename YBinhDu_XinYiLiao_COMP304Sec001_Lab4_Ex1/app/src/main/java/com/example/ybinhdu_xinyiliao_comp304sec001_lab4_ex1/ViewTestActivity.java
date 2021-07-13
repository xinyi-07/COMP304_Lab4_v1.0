package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);

        //initiating a shared preference object
        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);

        String applicantId = myPref.getString("ApplicantId", "");
        ((TextView) findViewById(R.id.txtView_ApplicantId)).setText(applicantId);

        String examinerId = myPref.getString("ExaminerId", "");
        ((TextView) findViewById(R.id.txtView_ExaminerId)).setText(examinerId);

        String testId = myPref.getString("TestId", "");
        ((TextView) findViewById(R.id.txtView_TestId)).setText(testId);

        String testType = myPref.getString("TestType", "");
        ((TextView) findViewById(R.id.txtView_TestType)).setText(testType);

        String testDate = myPref.getString("TestDate", "");
        ((TextView) findViewById(R.id.txtView_TestDate)).setText(testDate);

        String testRoute = myPref.getString("TestRoute", "");
        ((TextView) findViewById(R.id.txtView_TestRoute)).setText(testRoute);

        String testResult = myPref.getString("TestResult", "");
        ((TextView) findViewById(R.id.txtView_TestResult)).setText(testResult);

    }

    public void ReturnHomePage(View v){
        Intent intent = new Intent(ViewTestActivity.this, NavigationActivity.class);
        startActivity(intent);
    }
}