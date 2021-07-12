package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewApplicantActivity extends AppCompatActivity {

    public static AppDatabase appDB;
    public static String applicant_id;


    //
    Button btnAddApplicant;
    EditText editApplicantId, editFirstName, editLastName, editTestCenter, editExaminerId;

    //

    String firstName, lastName, testCenter;
    Integer applicantId, examinerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_applicant);

        //Call the database:
        //appDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "applicantDB")
        //       .allowMainThreadQueries().build();

        //initiating a shared preference object
        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);

        String examinerIdStr = myPref.getString("ExaminerId", "");
        editExaminerId =(EditText) findViewById(R.id.edtText_ExaminerId);
        editExaminerId.setText(examinerIdStr);

        editApplicantId = ((EditText) findViewById(R.id.edtTxt_ApplicantId));


    }

    public void submitNewApplicant(View v){
        if(v.getId() == R.id.btnSubmitNewApplicant)
        {
            Intent intent = new Intent(NewApplicantActivity.this, DisplayApplicantActivity.class);

            //Call the database:
            appDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "applicantDB")
                    .allowMainThreadQueries().build();

            //Get all info from fields and save it to the variables
            applicantId = Integer.parseInt(editApplicantId.getText().toString()); //it is disabled because it is a primary key and should be assigned auto...?
            firstName = ((EditText) findViewById(R.id.edtText_FirstName)).getText().toString();
            lastName = ((EditText) findViewById(R.id.edtText_FirstName)).getText().toString();
            testCenter = ((EditText) findViewById(R.id.edtText_TestCenter)).getText().toString();
            examinerId = Integer.parseInt(editExaminerId.getText().toString());


            if(firstName.isEmpty() | lastName.isEmpty() | testCenter.isEmpty()){
                Toast.makeText(this, "Error: Empty fields found!", Toast.LENGTH_SHORT).show();
            }
            else{
                /*SharedPreferences sharedPreferences = getSharedPreferences("MyShared", 0);
                SharedPreferences.Editor prefEdit = sharedPreferences.edit();

                //prefEdit.putString("ApplicantId", app_Id);
                prefEdit.putString("App_FirstName", app_firstName);
                prefEdit.putString("App_LastName", app_lastName);
                prefEdit.putString("Test_Center", test_center);
                prefEdit.commit();
                startActivity(intent);*/

                Applicant newApplicant = new Applicant();
                newApplicant.setApplicantId(applicantId);
                newApplicant.setFirstName(firstName);
                newApplicant.setLastName(lastName);
                newApplicant.setTestCenter(testCenter);
                newApplicant.setExaminerId(examinerId);

                if(newApplicant != null){

                    Toast.makeText(getApplicationContext(), "New applicant added!", Toast.LENGTH_SHORT).show();
                    NewApplicantActivity.appDB.appDao().addApplicant(newApplicant);

                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Error! New applicant not added!", Toast.LENGTH_SHORT).show();
                }


            }
        }
    }


}