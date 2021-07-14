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
//        txtApplicantId = findViewById(R.id.txtView_ApplicantId);
//        txtApplicantId.setText(dbApplicant.getFirstName());
//
        ((TextView) findViewById(R.id.txtView_ApplicantId)).setText(dbApplicant.getFirstName());
//
//        txtApplicantId = findViewById(R.id.txtView_ApplicantId);
//        txtExaminerId = findViewById(R.id.txtView_ExaminerId);
//        txtFirstName = findViewById(R.id.txtView_AppFirstName);
//        txtTestCenter = findViewById(R.id.txtView_TestCenter);
//        txtLastName = findViewById(R.id.txtView_App_LastName);
//
//        txtFirstName.setText(dbApplicant.getFirstName());

    }catch (Exception e){
        Toast.makeText(getApplicationContext(),"not good " + e.toString(), Toast.LENGTH_SHORT).show();

    }


        /*
        if(NewApplicantActivity.appDB == null){
            Toast.makeText(getApplicationContext(),"Database does not exist or some errors happens", Toast.LENGTH_SHORT).show();
        } else {
            //appDB = NewApplicantActivity.appDB; //Error might be here, the database is actually closed after we exist the previous page!
            //Or maybe just that we're not reading the DB in the correct way

        }

        //initiating a shared preference object
        SharedPreferences myPref = getSharedPreferences("MyShared", MODE_PRIVATE);

        applicantId = myPref.getInt("ApplicantId", 0);


        List<Applicant> applicants = appDB.appDao().getApplicant(applicantId);
        //List<Applicant> applicants = appDB.appDao().getAllApplicant();
        //txtApplicantId.setText(applicantId);
        //((TextView) findViewById(R.id.txtView_ApplicantId)).setText(applicantId);


        /*app_FirstName = myPref.getString("App_FirstName", "");
        ((TextView) findViewById(R.id.txtView_AppFirstName)).setText(app_FirstName);

        app_LastName = myPref.getString("App_LastName", "");
        ((TextView) findViewById(R.id.txtView_App_LastName)).setText(app_LastName);

        testCenter = myPref.getString("Test_Center", "");
        ((TextView) findViewById(R.id.txtView_TestCenter)).setText(testCenter);

        examinerId = myPref.getString("ExaminerId", "");
        ((TextView) findViewById(R.id.txtView_ExaminerId)).setText(examinerId);*/

        //txtApplicantId = findViewById(R.id.txtView_ApplicantId);
        //txtExaminerId = findViewById(R.id.txtView_ExaminerId);
        //txtFirstName = findViewById(R.id.txtView_AppFirstName);
        //txtTestCenter = findViewById(R.id.txtView_TestCenter);
        //txtLastName = findViewById(R.id.txtView_App_LastName);
//        TextView txtTesting = findViewById(R.id._testingTextview);
//
//
//        String app = "";
//        if(applicants.isEmpty()){
//            app = "List empty???";
//        } else {
//            app ="there are records in list";
//        }


        //String text = "";

        //for (Applicant applicant : applicants){
            //applicantId = applicant.getApplicantId();
        //    app_FirstName = applicant.getFirstName();
        //    app_LastName = applicant.getLastName();
        //    testCenter = applicant.getTestCenter();
        //    examinerId = applicant.getExaminerId();
        //    //txtFirstName.setText(app_FirstName);
        //    text = applicantId + app_FirstName + app_LastName + testCenter + examinerId;

        //}

        //txtTesting.setText(app);
        //txtApplicantId.setText(applicantId);
        //txtFirstName.setText(app_FirstName);
        //txtLastName.setText(app_LastName);
        //txtTestCenter.setText(testCenter);
        //txtExaminerId.setText(examinerId);

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