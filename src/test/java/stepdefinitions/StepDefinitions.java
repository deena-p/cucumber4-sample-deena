package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.drivermanagement.DriverFactory;
import framework.drivermanagement.DriverType;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions extends DriverFactory {

    private void searchGoogle(final String searchKeyword){
        WebDriver driver = DriverFactory.getDriver();
        driver.get("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(searchKeyword);
        System.out.println(driver.getTitle() + " is the page title");
        searchField.submit();
        (new WebDriverWait(driver,30)).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return webDriver.getTitle().toLowerCase().startsWith(searchKeyword.toLowerCase());
            }
        });
    }

    @Given("this is step one")
    public void this_is_step_one() {
        System.out.println("This is step one");
        //searchGoogle("sachin");
    }

    @When("there is step two")
    public void there_is_step_two() {
        System.out.println("This is step two");
        //searchGoogle("messi");
    }

    @When("there is step three")
    public void there_is_step_three() {
        System.out.println("This is step three");
        //searchGoogle("dhoni");
    }

    @Then("verify if there is step four")
    public void verify_if_there_is_step_four() {
        System.out.println("This is step four");
        searchGoogle("fcb");
    }
}
