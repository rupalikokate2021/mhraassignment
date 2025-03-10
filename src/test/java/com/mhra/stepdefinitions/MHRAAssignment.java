package com.mhra.stepdefinitions;

import com.mhra.pages.CivilServicesJobSearch;
import com.mhra.pages.DepartmentSearch;
import com.mhra.utils.BaseTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MHRAAssignment extends BaseTest {
 
    CivilServicesJobSearch civilServicesJobSearch;
    DepartmentSearch departmentsearch;
    
    @Before
    public void before(){
        setup();
        civilServicesJobSearch = new CivilServicesJobSearch(driver);
        departmentsearch=new DepartmentSearch(driver);
      }

         @Given ("I am on the Civil Service Jobs Page")
         public void i_am_on_the_civil_service_jobs_page(){
          civilServicesJobSearch.i_am_on_the_civil_service_jobs_page (); 
         }

         @When ("I enter search criteria \"(.*)\" and \"(.*)\"$")
         public void i_enter_search_criteria_on_civil_service_jobs_page(String keyword, String location){
          civilServicesJobSearch.i_enter_search_criteria_on_civil_service_jobs_page (keyword,location); 
         }

         @Then ("I should see all correct job listings for \"(.*)\" and \"(.*)\"$")
         public void i_should_see_all_correct_job_listings_for(String keyword, String location){
          civilServicesJobSearch.i_should_see_all_correct_job_listings_for (keyword,location); 
         }

         @Then ("I filter based on department \"(.*)\"$")
         public void i_filter_based_on_department(String department){
          departmentsearch.i_filter_based_on_department (department); 
         }

         @Then ("I select MHRA department")
         public void  i_select_MHRA_department() throws InterruptedException{
          departmentsearch.i_select_MHRA_department();
         }
       
    
}
