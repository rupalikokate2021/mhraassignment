package com.mhra.stepdefinitions;

import com.mhra.pages.CartDetails;
import com.mhra.pages.LoginSteps;
import com.mhra.pages.OrderPlaced;
import com.mhra.pages.ProductDetails;
import com.mhra.pages.CivilServicesJobSearch;
import com.mhra.utils.BaseTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MHRAAssignment extends BaseTest {
    LoginSteps loginsteps;
    ProductDetails productdetails;
    CartDetails cartdetails;
    OrderPlaced orderplaced;
    CivilServicesJobSearch civilServicesJobSearch;
    
    @Before
    public void before(){
        setup();
       // loginsteps= new LoginSteps(driver);
        //productdetails= new ProductDetails(driver);
        //cartdetails=new CartDetails(driver);
        //orderplaced=new OrderPlaced(driver);
        civilServicesJobSearch = new CivilServicesJobSearch(driver);
    }

    @Given ("I am on the Login Page")
        public void i_am_on_the_Login_Page(){
         loginsteps.i_am_on_the_Login_Page (); 
        }
    

     @When ("I enter Valid \"(.*)\" and \"(.*)\"$")
        public void i_enter_Valid_username_and_Password(String username, String password ){
         System.out.println("Hello I am "+username+":"+password);
         loginsteps.i_enter_Valid_username_and_password(username,password);
        }

      @When("I enter valid username and password")
         public void i_enter_valid_username_and_password(){
         loginsteps.i_enter_valid_username_and_password();
        }

      @When("I enter invalid \"(.*)\" and \"(.*)\"$")
        public void i_enter_invalid_username_and_password(String username, String password){
         System.out.println("Hello I am "+username+":"+password);
         loginsteps.i_enter_invalid_username_and_password(username,password);
        }

      @Then ("I click on the Login button")
        public void i_click_on_the_Login_button(){
         loginsteps.i_click_on_the_Login_button();
        }
     
      @Then ("I should see the landing page")
         public void i_should_see_the_landing_page() {
        loginsteps.i_should_see_the_landing_page();
        }

      @Then ("I should see an error message")
         public void i_should_see_an_error_message(){
        loginsteps.i_should_see_an_error_message();
       }
      @Then( "I click on First item")
         public void i_click_on_First_item(){
         productdetails.i_click_on_First_item();
       }

       @Then("I Add item to Cart")
         public void i_add_item_to_Cart(){
        productdetails.i_add_item_to_Cart();
       }

       @Then ("I add another item to cart")
         public void i_add_another_item_to_cart(){
         productdetails.i_add_another_item_to_cart();
         }
       

      @Then("I click on sort product by \\\"(.*)\\\"$")
         public void i_click_on_sort_product_by_price(String priceSortOrder){
         productdetails.i_click_on_sort_product_by_price(priceSortOrder);
        }

       @Then ("I click on Cart Details")
         public void i_click_on_Cart_Details(){
         cartdetails.i_click_on_Cart_Details();
         }

      @Then ("I should see the cart details")
        public void i_should_see_the_cart_details(){
        cartdetails.i_should_see_the_cart_details();
         }

      @Then ("I click on Checkout")
      public void i_click_on_Checkout(){
         orderplaced.i_click_on_Checkout();
          }

       @Then("I enter valid firstname and lastname and zippostalcode")
         public void i_enter_valid_firstname_and_lastname_and_zippostalcode(){
            orderplaced.i_enter_valid_firstname_and_lastname_and_zippostalcode();
         }

         @Then("I click on continue")
         public void i_click_on_continue(){
            orderplaced.i_click_on_continue();
         }

         @Then("I click on finish")
         public void i_click_on_finish(){
            orderplaced.i_click_on_finish();
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
          civilServicesJobSearch.i_filter_based_on_department (department); 
         }


         
       
    
}
