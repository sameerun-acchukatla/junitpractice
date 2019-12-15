package com.shama.jpractice;

import java.math.BigDecimal;

public class Project {
    private final String name;
    private final int requiredExperience;
    private final BigDecimal allottedSalary;

    public Project(String name, int requiredExperience, BigDecimal allottedSalary) {
        this.name = name;
        this.requiredExperience = requiredExperience;
        this.allottedSalary = allottedSalary;
    }

    public String getName() {
        return name;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public BigDecimal getAllottedSalary() {
        return allottedSalary;
    }

    public boolean fitsForProject(Employee employee) {
        boolean hasEnoughExperience = hasEnoughExperience(employee);
        boolean salaryRequirementMatches = isSalaryRequirementMatches(employee);
        return (hasEnoughExperience && salaryRequirementMatches) || (employee != null && (employee.setManager()) || (employee != null && (employee.isTechLead())));
    }

    public boolean isSalaryRequirementMatches(Employee employee) {
        return employee != null && employee.getSalary().compareTo(allottedSalary) <= 0;
    }

    public boolean hasEnoughExperience(Employee employee) {
        return employee != null && employee.getExperience() >= requiredExperience;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", requiredExperience=" + requiredExperience +
                ", allottedSalary=" + allottedSalary +
                '}';
    }
}
