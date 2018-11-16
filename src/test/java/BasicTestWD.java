import framework.drivermanagement.DriverFactory;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicTestWD extends DriverFactory {

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

    @Test
    public void test1(){
        searchGoogle("sachin");
    }

    @Test
    public void test2(){
        searchGoogle("messi");
    }

    @Test
    public void test3(){
        searchGoogle("saurav");
    }

    @Test
    public void test4(){
        searchGoogle("dravid");
    }

    @Test
    public void test5(){
        searchGoogle("dhoni");
    }

    @Test
    public void test6(){
        searchGoogle("raina");
    }

    @Test
    public void test7(){
        searchGoogle("sachin");
    }

    @Test
    public void test8(){
        searchGoogle("messi");
    }

    @Test
    public void test9(){
        searchGoogle("saurav");
    }

    @Test
    public void test10(){
        searchGoogle("dravid");
    }
}
