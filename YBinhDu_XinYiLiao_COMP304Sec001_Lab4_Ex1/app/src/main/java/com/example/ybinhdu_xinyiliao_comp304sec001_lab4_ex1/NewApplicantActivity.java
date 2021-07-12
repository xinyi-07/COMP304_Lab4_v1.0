package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewApplicantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_applicant);

        //initiating a shared preference object
        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);

        String examinerId = myPref.getString("ExaminerId", "");
        ((TextView) findViewById(R.id.edtText_ExaminerId)).setText(examinerId);

    }

    public void submitNewApplicant(View v){
        if(v.getId() == R.id.btnSubmitNewApplicant)
        {
            Intent intent = new Intent(NewApplicantActivity.this, DisplayApplicantActivity.class);

            String app_Id = ((EditText) findViewById(R.id.edtTxt_ApplicantId)).getText().toString();
            String app_firstName = ((EditText) findViewById(R.id.edtText_FirstName)).getText().toString();
            String app_lastName = ((EditText) findViewById(R.id.edtText_LastName)).getText().toString();
            String test_center = ((EditText) findViewById(R.id.edtText_TestCenter)).getText().toString();


            if(app_firstName.isEmpty() | app_lastName.isEmpty() | test_center.isEmpty()){
                Toast.makeText(this, "Error: Empty fields found!", Toast.LENGTH_SHORT).show();
            }
            else{
                SharedPreferences sharedPreferences = getSharedPreferences("MyShared", 0);
                SharedPreferences.Editor prefEdit = sharedPreferences.edit();

                prefEdit.putString("ApplicantId", app_Id);
                prefEdit.putString("App_FirstName", app_firstName);
                prefEdit.putString("App_LastName", app_lastName);
                prefEdit.putString("Test_Center", test_center);
                prefEdit.commit();
                startActivity(intent);
            }
        }
    }


}