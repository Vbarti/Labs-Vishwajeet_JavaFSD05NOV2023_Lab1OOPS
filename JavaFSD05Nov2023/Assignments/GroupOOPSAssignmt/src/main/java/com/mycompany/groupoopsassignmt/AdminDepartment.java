/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupoopsassignmt;

/**
 *
 * @author Vishwajeet.Bharti
 */
public class AdminDepartment extends SuperDepartment {
    @Override
    public String departmentName() {
        return "Admin Department";
    }

    @Override
    public String getTodaysWork() {
        return "Complete your documents submission";
    }

    @Override
    public String getWorkDeadline() {
        return "Complete by EOD";
    }
}

