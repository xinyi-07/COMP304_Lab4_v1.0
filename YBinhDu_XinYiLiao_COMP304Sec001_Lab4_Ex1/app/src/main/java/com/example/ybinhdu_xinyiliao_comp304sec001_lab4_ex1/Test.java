package com.example.ybinhdu_xinyiliao_comp304sec001_lab4_ex1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Test {

    @PrimaryKey
    private int testId;

    @ColumnInfo(name = "Applicant_Id")
    private int applicantId;

    @ColumnInfo(name = "Examiner_Id")
    private int examinerId;

    @ColumnInfo(name = "Test Result")
    private String testResult;

    @ColumnInfo(name = "Test_Date")
    private Date testDate;

    @ColumnInfo(name = "Test_Out")
    private Date testrout;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public int getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(int examinerId) {
        this.examinerId = examinerId;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Date getTestrout() {
        return testrout;
    }

    public void setTestrout(Date testrout) {
        this.testrout = testrout;
    }


}
