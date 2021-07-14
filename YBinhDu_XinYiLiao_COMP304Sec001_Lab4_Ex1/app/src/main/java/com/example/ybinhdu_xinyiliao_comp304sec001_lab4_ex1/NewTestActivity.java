package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NewTestActivity extends AppCompatActivity {

    public static AppDatabase appDB;

    String testResult = "Fail";
    String testType = "G2";
    String applicantId;
    String examinerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test);

        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);

        applicantId = myPref.getString("ApplicantId", "");
        ((TextView) findViewById(R.id.edtTxt_ApplicantId)).setText(applicantId);

        examinerId = myPref.getString("ExaminerId", "");
        ((TextView) findViewById(R.id.edtTxt_ExaminerId)).setText(examinerId);

        appDB  = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "applicantDB")
                .allowMainThreadQueries().build();


        try {
            List<Applicant> applicants = appDB.appDao().getAllApplicant();
            int length = applicants.size();
            if (length != 0){
                Toast.makeText(getApplicationContext(),"Dlength " + length, Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getApplicationContext(),"not good " + 12, Toast.LENGTH_SHORT).show();

            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Not good " + e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void selectResult(View v){
        //need to check the state of the radio btn i.e. selected or not selected
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.radioBtn_Pass:
                testResult = "Pass";
                break;
            case R.id.radioBtn_Fail:
                testResult = "Fail";
                break;
        }
    }

    public void selectTestType(View v){
        //need to check the state of the radio btn i.e. selected or not selected
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.radioBtn_G2:
                testType = "G2";
                break;
            case R.id.radioBtn_G:
                testType = "G";
                break;
            case R.id.radioBtn_Motorcycle:
                testType = "Motorcycle";
                break;
            case R.id.radioBtn_Commercial:
                testType = "Commercial";
                break;
        }
    }

    public void AddTest(View v){
        Intent intent = new Intent(NewTestActivity.this, ViewTestActivity.class);

        String testId = ((EditText) findViewById(R.id.edtTxt_TestId)).getText().toString();
        String testRoute = ((EditText) findViewById(R.id.edtTxt_TestRoute)).getText().toString();
        String testDate = ((EditText) findViewById(R.id.edtTxt_TestDate)).getText().toString();

        if(testId.isEmpty() | testRoute.isEmpty() | testDate.isEmpty()){
            Toast.makeText(this, "Error: Empty fields found!", Toast.LENGTH_SHORT).show();
        }
        else{
//            SharedPreferences sharedPreferences = getSharedPreferences("MyShared", 0);
//            SharedPreferences.Editor prefEdit = sharedPreferences.edit();
//
//            prefEdit.putString("TestId", testId);
//            prefEdit.putString("TestType", testType);
//            prefEdit.putString("TestRoute", testRoute);
//            prefEdit.putString("TestResult", testResult);
//            prefEdit.putString("TestDate", testDate);
//            prefEdit.commit();
            Test newTest = new Test();
            newTest.setApplicantId(Integer.parseInt(applicantId));
            newTest.setExaminerId(Integer.parseInt(examinerId));
            newTest.setTestId(Integer.parseInt(testId));
            newTest.setTestType(testType);
            newTest.setTestRoute(testRoute);
            newTest.setTestResult(testResult);
            newTest.setTestDate(testDate);

            if(newTest != null){

                Toast.makeText(getApplicationContext(), "New applicant added!", Toast.LENGTH_SHORT).show();
                appDB.appDao().addNewTest(newTest);
                SharedPreferences sharedPreferences = getSharedPreferences("MyShared", 0);
                SharedPreferences.Editor prefEdit = sharedPreferences.edit();

                prefEdit.putString("ApplicantId",applicantId);
                prefEdit.commit();

                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Error! New applicant not added!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}