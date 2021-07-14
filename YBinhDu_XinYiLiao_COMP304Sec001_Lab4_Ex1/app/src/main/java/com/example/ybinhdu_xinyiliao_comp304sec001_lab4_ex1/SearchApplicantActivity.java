package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SearchApplicantActivity extends AppCompatActivity {

    String applicantId;
    EditText editApplicantId;
    public AppDatabase appDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_applicant);
//        try {
//            //appDB = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "userDB").allowMainThreadQueries().build();
//            appDB  = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "applicantDB")
//                    .allowMainThreadQueries().build();
//            int userInput = Integer.parseInt("99");
//
//            List<Applicant> applicants = appDB.appDao().getApplicant(userInput);
//
//            int length = applicants.size();
//            if (length != 0){
//                Applicant dbApplicant = applicants.get(0);
//                Toast.makeText(getApplicationContext(),"Dlength " + dbApplicant.getFirstName() + dbApplicant.getLastName(), Toast.LENGTH_SHORT).show();
//
//
//            }else{
//                Toast.makeText(getApplicationContext(),"not good " + 12, Toast.LENGTH_SHORT).show();
//
//            }
//
//
//
//        }catch (Exception e){
//            Toast.makeText(getApplicationContext(),"Not good " + e.toString(), Toast.LENGTH_LONG).show();
//        }
        appDB  = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "applicantDB")
                .allowMainThreadQueries().build();

        editApplicantId = ((EditText) findViewById(R.id.edtTxt_ApplicantId));

    }

    public void SearchAnApplicant(View v){

        try {
            Intent intent = new Intent(SearchApplicantActivity.this, DisplayApplicantActivity.class);

            SharedPreferences sharedPreferences = getSharedPreferences("MyShared", 0);
            SharedPreferences.Editor prefEdit = sharedPreferences.edit();

            applicantId = editApplicantId.getText().toString();


            //int userInput = Integer.parseInt("99");
            //int userInput = applicantId;

            List<Applicant> applicants = appDB.appDao().getApplicant(Integer.parseInt(applicantId));

            int length = applicants.size();
            if (length != 0){
                Applicant dbApplicant = applicants.get(0);
                Toast.makeText(getApplicationContext(),"Applicant: " + dbApplicant.getFirstName() +" "+ dbApplicant.getLastName(), Toast.LENGTH_SHORT).show();
                prefEdit.putString("ApplicantId", applicantId);
                prefEdit.commit();

                startActivity(intent);

            }else{
                Toast.makeText(getApplicationContext(),"ERROR: Applicant not valid.", Toast.LENGTH_SHORT).show();

            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Exception Error: " + e.toString(), Toast.LENGTH_LONG).show();
        }


    }
}