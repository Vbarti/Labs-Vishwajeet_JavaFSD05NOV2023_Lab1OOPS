/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupoopsassignmt;

/**
 *
 * @author Vishwajeet.Bharti
 */
public class HrDepartment extends SuperDepartment {
    @Override
    public String departmentName() {
        return "Hr Department";
    }

    @Override
    public String getTodaysWork() {
        return "Fill today’s timesheet and mark your attendance";
    }

    @Override
    public String getWorkDeadline() {
        return "Complete by EOD";
    }

    public String doActivity() {
        return "team Lunch";
    }
}

