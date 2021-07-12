package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayApplicantActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_applicant);

        //initiating a shared preference object
        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);

        String applicantId = myPref.getString("ApplicantId", "");
        ((TextView) findViewById(R.id.txtView_ApplicantId)).setText(applicantId);

        String app_FirstName = myPref.getString("App_FirstName", "");
        ((TextView) findViewById(R.id.txtView_AppFirstName)).setText(app_FirstName);

        String app_LastName = myPref.getString("App_LastName", "");
        ((TextView) findViewById(R.id.txtView_App_LastName)).setText(app_LastName);

        String testCenter = myPref.getString("Test_Center", "");
        ((TextView) findViewById(R.id.txtView_TestCenter)).setText(testCenter);

        String examinerId = myPref.getString("ExaminerId", "");
        ((TextView) findViewById(R.id.txtView_ExaminerId)).setText(examinerId);


    }
}