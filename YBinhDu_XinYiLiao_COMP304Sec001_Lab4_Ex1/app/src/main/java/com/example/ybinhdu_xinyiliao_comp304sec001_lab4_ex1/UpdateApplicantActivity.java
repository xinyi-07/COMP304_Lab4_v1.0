package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateApplicantActivity extends AppCompatActivity {

    String firstName, lastName, testCenter;
    String applicantId, examinerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_applicant);

        //initiating a shared preference object
        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);

        applicantId = myPref.getString("ApplicantId", "");
        ((TextView) findViewById(R.id.edtTxt_ApplicantId)).setText(applicantId);

        firstName = myPref.getString("App_FirstName", "");
        ((TextView) findViewById(R.id.edtText_FirstName)).setText(firstName);

        lastName = myPref.getString("App_LastName", "");
        ((TextView) findViewById(R.id.edtText_LastName)).setText(lastName);

        testCenter = myPref.getString("Test_Center", "");
        ((TextView) findViewById(R.id.edtText_TestCenter)).setText(testCenter);

        examinerId = myPref.getString("ExaminerId", "");
        ((TextView) findViewById(R.id.edtText_ExaminerId)).setText(examinerId);

    }

    public void UpdateApplicant(View v){
        Intent intent = new Intent(UpdateApplicantActivity.this, DisplayApplicantActivity.class);

        //Get all info from fields and save it to the variables
        firstName = ((EditText) findViewById(R.id.edtText_FirstName)).getText().toString();
        lastName = ((EditText) findViewById(R.id.edtText_LastName)).getText().toString();
        testCenter = ((EditText) findViewById(R.id.edtText_TestCenter)).getText().toString();

        if(firstName.isEmpty() | lastName.isEmpty() | testCenter.isEmpty()){
            Toast.makeText(this, "Error: Empty fields found!", Toast.LENGTH_SHORT).show();
        }
        else {
            SharedPreferences sharedPreferences = getSharedPreferences("MyShared", 0);
            SharedPreferences.Editor prefEdit = sharedPreferences.edit();

            prefEdit.putString("App_FirstName", firstName);
            prefEdit.putString("App_LastName", lastName);
            prefEdit.putString("Test_Center", testCenter);
            prefEdit.commit();
            startActivity(intent);
        }
    }
}