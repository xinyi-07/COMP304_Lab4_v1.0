package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Applicant {

    @PrimaryKey
    private int applicantId;

    @ColumnInfo(name = "Applicant_FirstName")
    private String firstName;

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(String testCenter) {
        this.testCenter = testCenter;
    }

    public int getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(int examinerId) {
        this.examinerId = examinerId;
    }

    @ColumnInfo(name = "Applicant_LastName")
    private String lastName;

    @ColumnInfo(name = "Test_Center")
    private String testCenter;

    @ColumnInfo(name = "Examiner_Id")
    private int examinerId;
}
