package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class NewTestActivity extends AppCompatActivity {

    String testResult = "Fail";
    String testType = "G2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test);

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
        Intent intent = new Intent(NewTestActivity.this, NavigationActivity.class);

        String testId = ((EditText) findViewById(R.id.edtTxt_TestId)).getText().toString();
        String testRoute = ((EditText) findViewById(R.id.edtTxt_TestRoute)).getText().toString();
        String testDate = ((EditText) findViewById(R.id.edtTxt_TestDate)).getText().toString();

        if(testId.isEmpty() | testRoute.isEmpty() | testDate.isEmpty()){
            Toast.makeText(this, "Error: Empty fields found!", Toast.LENGTH_SHORT).show();
        }
        else{
            SharedPreferences sharedPreferences = getSharedPreferences("MyShared", 0);
            SharedPreferences.Editor prefEdit = sharedPreferences.edit();

            prefEdit.putString("TestId", testId);
            prefEdit.putString("TestType", testType);
            prefEdit.putString("TestRoute", testRoute);
            prefEdit.putString("TestResult", testResult);
            prefEdit.putString("TestDate", testDate);
            prefEdit.commit();
            startActivity(intent);
        }
    }

}