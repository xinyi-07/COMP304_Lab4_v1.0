package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppDao {

    //Insert -- to add a new examiner user:
    @Insert
    public void addExaminer(Examiner examiner);

    @Insert
    public void addApplicant(Applicant applicant);

    @Query("select * from applicant where applicantId = :applicantId")
    public List<Applicant> getApplicant(int applicantId);

    @Query("select * from applicant")
    public List<Applicant> getAllApplicant();
}
