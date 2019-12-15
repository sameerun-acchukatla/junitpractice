package com.shama.jpractice;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class ProjectTest {

    private Project projectX;

    @Before
    public void setUp() throws Exception {
        projectX = new Project("projectX", 5, BigDecimal.valueOf(6000));

    }

    @Test
    public void should_return_false_when_no_employee_specified() {
        boolean fitsForProject = projectX.fitsForProject(null);
        assertFalse(fitsForProject);
    }

    @Test
    public void should_return_true_when_employee_has_enough_experience_and_salary_is_less_than_project_salary_requirement() {
        Employee employee= new Employee("George","Analyst",6,BigDecimal.valueOf(0));
        boolean fitsForProject=projectX.fitsForProject(employee);
        assertTrue(fitsForProject);
    }

    @Test
    public void should_return_true_when_employee_has_enough_experience_and_salary_is_equal_to_project_salary_requirement() {
        Employee employee= new Employee("George","Analyst",6,BigDecimal.valueOf(6000));
        boolean fitsForProject=projectX.fitsForProject(employee);
        assertTrue(fitsForProject);
    }

    @Test
    public void should_return_true_when_employee_is_a_techLead() {
        Employee employee=new Employee("James","Tech Lead",5,BigDecimal.valueOf(10000));
        employee.setTechLead(true);
        boolean fitsForProject=projectX.fitsForProject(employee);
        assertTrue(fitsForProject);
    }

    @Test
    public void should_return_false_when_employee_is_a_manager(){
        Employee employee=new Employee("David","Manager",5,BigDecimal.valueOf(60000));
        employee.setManager();
        boolean fitsForProject=projectX.fitsForProject(employee);
        assertFalse(fitsForProject);
    }



    @Test
    public void should_return_false_when_employee_has_no_enough_experience() {
        Employee employee = new Employee("George","Analyst",2,BigDecimal.valueOf(5000));
        boolean fitsForProject = projectX.fitsForProject(employee);
        assertFalse(fitsForProject);

    }

    @Test
    public void should_return_false_when_project_salary_requirement_does_not_match() {
        Employee employee = new Employee("Amanda","Developer",5,BigDecimal.valueOf(8000));
        boolean fitsForProject = projectX.fitsForProject(employee);
        assertFalse(fitsForProject);

    }

    @Test
    public void should_return_true_when_employee_salary_is_less_than_allotted_salary() {
        Employee employee = new Employee("john", "developer", 3, BigDecimal.valueOf(5000));
        boolean salaryRequirementMatches = projectX.isSalaryRequirementMatches(employee);
        assertTrue(salaryRequirementMatches);

    }

    @Test
    public void should_return_true_when_employee_salary_is_equal_to_allotted_salary() {
        Employee employee = new Employee("john", "developer", 3, BigDecimal.valueOf(6000));
        boolean salaryRequirementMatches = projectX.isSalaryRequirementMatches(employee);
        assertTrue(salaryRequirementMatches);
    }

    @Test
    public void should_return_false_when_employee_salary_is_greater_than_allotted_salary() {
        Employee employee = new Employee("john", "developer", 3, BigDecimal.valueOf(7500));
        boolean salaryRequirementMatches = projectX.isSalaryRequirementMatches(employee);
        assertFalse(salaryRequirementMatches);
    }

    @Test
    public void should_return_true_when_employee_experience_is_greater_than_expected_experience() {
        Employee employee=new Employee("david","Tester",7,BigDecimal.valueOf(6000));
        boolean hasEnoughExperience = projectX.hasEnoughExperience(employee);
        assertTrue(hasEnoughExperience);
    }

    @Test
    public void should_return_true_when_employee_experience_is_equal_to_expected_experience() {
        Employee employee=new Employee("david","Tester",6,BigDecimal.valueOf(6000));
        boolean hasEnoughExperience = projectX.hasEnoughExperience(employee);
        assertTrue(hasEnoughExperience);
    }

    @Test
    public void should_return_false_when_employee_experience_is_less_than_expected_experience() {
        Employee employee=new Employee("david","Tester",2,BigDecimal.valueOf(6000));
        boolean hasEnoughExperience = projectX.hasEnoughExperience(employee);
        assertFalse(hasEnoughExperience);
    }

    @Test
    public void should_return_false_when_employee_is_null() {
        assertFalse(projectX.hasEnoughExperience(null));
    }
}