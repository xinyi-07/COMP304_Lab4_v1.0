package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DisplayApplicantActivity extends AppCompatActivity {

    int applicantId = 0;
    String app_FirstName = "";
    String app_LastName = "";
    String testCenter = "";
    int examinerId = 0;
    public AppDatabase appDB;


    TextView txtApplicantId, txtFirstName, txtLastName, txtTestCenter, txtExaminerId;

    //public AppDatabase appDB = AppDatabase.getDatabase(DisplayApplicantActivity.this);
    //public AppDatabase appDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_applicant);
//        Toast.makeText(getApplicationContext(),"Database does not exist or some errors happens", Toast.LENGTH_SHORT).show();

        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);
        try {
            applicantId = Integer.parseInt( myPref.getString("ApplicantId", ""));
    //        ((TextView) findViewById(R.id.txtView_ApplicantId)).setText(applicantId);
    //        Toast.makeText(getApplicationContext(),"should not be default to 0 " + applicantId, Toast.LENGTH_SHORT).show();
            appDB  = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "applicantDB")
                    .allowMainThreadQueries().build();
            List<Applicant> applicants = appDB.appDao().getApplicant(applicantId);
            Applicant dbApplicant = applicants.get(0);

    //        Toast.makeText(getApplicationContext(),"Dlength " + dbApplicant.getFirstName() + dbApplicant.getLastName(), Toast.LENGTH_SHORT).show();


            applicantId = dbApplicant.getApplicantId();
            ((TextView) findViewById(R.id.txtView_ApplicantId)).setText(String.valueOf(applicantId));

            app_FirstName = dbApplicant.getFirstName();
            txtFirstName =(TextView) findViewById(R.id.txtView_AppFirstName);
            txtFirstName.setText(app_FirstName);

            app_LastName = dbApplicant.getLastName();
            txtLastName = (TextView) findViewById(R.id.txtView_App_LastName);
            txtLastName.setText(app_LastName);

            testCenter = dbApplicant.getTestCenter();
            txtTestCenter = (TextView) findViewById(R.id.txtView_TestCenter);
            txtTestCenter.setText(testCenter);

            examinerId = dbApplicant.getExaminerId();
            txtExaminerId = (TextView) findViewById(R.id.txtView_ExaminerId);
            txtExaminerId.setText(String.valueOf(examinerId));



        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"not good " + e.toString(), Toast.LENGTH_SHORT).show();

        }



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