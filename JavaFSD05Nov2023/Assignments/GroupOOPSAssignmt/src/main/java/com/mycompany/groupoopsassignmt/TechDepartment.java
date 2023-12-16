/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupoopsassignmt;

/**
 *
 * @author Vishwajeet.Bharti
 */
public class TechDepartment extends SuperDepartment {
    @Override
    public String departmentName() {
        return "Tech Department";
    }

    @Override
    public String getTodaysWork() {
        return "Complete coding of Module 1";
    }

    @Override
    public String getWorkDeadline() {
        return "Complete by EOD";
    }

    public String getTechStackInformation() {
        return "Core Java";
    }
}
