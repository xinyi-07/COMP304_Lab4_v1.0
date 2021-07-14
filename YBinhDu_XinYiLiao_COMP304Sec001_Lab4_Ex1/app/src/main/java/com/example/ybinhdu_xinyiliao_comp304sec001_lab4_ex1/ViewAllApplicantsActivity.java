package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewAllApplicantsActivity extends AppCompatActivity {

    public AppDatabase appDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_applicants);
        try {
//            appDB = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "userDB").allowMainThreadQueries().build();
            appDB  = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "applicantDB")
                    .allowMainThreadQueries().build();
            int userInput = Integer.parseInt("99");

            List<Applicant> applicants = appDB.appDao().getApplicant(userInput);

            int length = applicants.size();
            if (length != 0){
                Applicant dbApplicant = applicants.get(0);
                Toast.makeText(getApplicationContext(),"Dlength " + dbApplicant.getFirstName() + dbApplicant.getLastName(), Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getApplicationContext(),"not good " + 12, Toast.LENGTH_SHORT).show();

            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Not good " + e.toString(), Toast.LENGTH_LONG).show();
        }


    }
}