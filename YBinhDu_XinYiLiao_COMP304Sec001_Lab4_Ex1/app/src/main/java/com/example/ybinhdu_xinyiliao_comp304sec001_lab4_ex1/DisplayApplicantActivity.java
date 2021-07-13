package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayApplicantActivity extends AppCompatActivity {

    String applicantId;
    String app_FirstName;
    String app_LastName;
    String testCenter;
    String examinerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_applicant);

        //initiating a shared preference object
        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);

        applicantId = myPref.getString("ApplicantId", "");
        ((TextView) findViewById(R.id.txtView_ApplicantId)).setText(applicantId);

        app_FirstName = myPref.getString("App_FirstName", "");
        ((TextView) findViewById(R.id.txtView_AppFirstName)).setText(app_FirstName);

        app_LastName = myPref.getString("App_LastName", "");
        ((TextView) findViewById(R.id.txtView_App_LastName)).setText(app_LastName);

        testCenter = myPref.getString("Test_Center", "");
        ((TextView) findViewById(R.id.txtView_TestCenter)).setText(testCenter);

        examinerId = myPref.getString("ExaminerId", "");
        ((TextView) findViewById(R.id.txtView_ExaminerId)).setText(examinerId);

    }

    public void UpdateApplicant(View v){
        Intent intent = new Intent(DisplayApplicantActivity.this, UpdateApplicantActivity.class);
        startActivity(intent);
    }

    public void CreateNewTest(View v){
        Intent intent = new Intent(DisplayApplicantActivity.this, NewTestActivity.class);
        startActivity(intent);
    }
}