package com.shama.jpractice;

import java.math.BigDecimal;

public class Employee {
    private final String name;
    private final String designation;
    private final int experience;
    private final BigDecimal salary;
    private boolean techLead;
    private boolean manager;

    public Employee(String name, String designation, int experience, BigDecimal salary) {
        this.name = name;
        this.designation = designation;
        this.experience = experience;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                '}';
    }

    public void setTechLead(boolean techLead) {
        this.techLead = techLead;
    }

    public boolean isTechLead() {
        return techLead;
    }

    public boolean setManager() {
        return  manager;
    }
}
