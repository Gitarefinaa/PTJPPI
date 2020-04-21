package com.example.projectipc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class InspectionMachine {


    @SerializedName("date_inspection2")
    String date_inspection2;
    @SerializedName("status_inspection2")

    String status_inspection2;
    @SerializedName("operation_machine2")

    String operation_machine2;



    public String getDate_inspection() {
        return date_inspection2;
    }

    public void setDate_inspection(String date_inspection2) {
        this.date_inspection2 = date_inspection2;
    }

    public String getStatus_inspection() {

        return status_inspection2;
    }

    public void setStatus_inspection(String status_inspection) {
        this.status_inspection2 = status_inspection;
    }

    public String getOperation_machine() {

        return operation_machine2;
    }

    public void setOperation_machine(String operation_machine) {
        this.operation_machine2 = operation_machine;
    }


}
