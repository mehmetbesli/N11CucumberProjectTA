package N11Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * created by MehmetBesli on 02.2020
 */
public class AbstractTest {

    Logger log = Logger.getLogger((TAProject.class).toString());
    WebDriver driver ;
    WebDriverWait wait ;

    protected void untilElementAppear(By by) throws InterruptedException {
        try {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            log.warning("webelement'e tıklamaya çalışırken hata aldı : " + e);
            log.info("webelement'e tıklamaya çalışırken hata aldı : " + e);

            throw new RuntimeException(e);
        }
    }

    protected WebElement findElement(By by, int... index) throws InterruptedException {
        WebElement webElement = null;

        untilElementAppear(by);
        try {
            if (index.length == 0) {
                webElement = driver.findElement(by);
            } else {
                webElement = driver.findElements(by).get(index[0]);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);arguments[0].focus();", webElement);
            }
        } catch (Exception e) {
            log.warning("webelement'e tıklamaya çalışırken hata aldı : " + e);
            log.info("webelement'e tıklamaya çalışırken hata aldı : " + e);
            throw new RuntimeException(e);
        }

        return webElement;
    }

    protected List<WebElement> findElements(By by) throws InterruptedException {
        List<WebElement> webElements=null;

        untilElementAppear(by);
        try {
            webElements=driver.findElements(by);
        }catch (Exception e){
            log.warning("webelement'e tıklamaya çalışırken hata aldı : " + e);
            log.info("Error while listing webelements by css selector : " + e);
        }

        return webElements;
    }

    protected void click(By by, int... index) throws InterruptedException {
        WebElement webElement = null;

        //untilElementAppear(by);
        try {
            if (index.length == 0) {
                webElement = findElement(by);
                webElement.click();
            } else {
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                wait.until(ExpectedConditions.elementToBeClickable(by));
                webElement = findElement(by);
                webElement.click();
            }
        } catch (Exception e) {
            log.warning("webelement'e tıklamaya çalışırken hata aldı : " + e);
            log.info("webelement'e tıklamaya çalışırken hata aldı : " + e);
            throw new RuntimeException(e);
        }
    }

    protected void clickJS(By by) throws InterruptedException {

        WebElement element = findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void sendKeys(By by,String text,int... index) throws InterruptedException {
        WebElement webElement=null;

        //untilElementAppear(by);
        try{
            webElement=findElement(by,index);
            if (webElement.isEnabled()){
                webElement.clear();
                webElement.sendKeys(text);
            }
        }catch (Exception e){
            log.warning("webelement'e yazmaya çalışırken hata aldı : " + e);
            log.info("webelement'e yazmaya çalışırken hata aldı : " + e);
            throw new RuntimeException(e);
        }
    }

    protected String getTextOfElement(By by,int... index) throws InterruptedException {
        WebElement webElement = null;
        String text=null;

        //untilElementAppear(by);
        try {
            if (index.length == 0) {
                webElement = driver.findElement(by);
                text=webElement.getText();
            }else {
                webElement = findElements(by).get(index[0]);
                text=webElement.getText();
            }
        } catch (Exception e) {
            log.warning("Text'i almaya çalışırken hata aldı : " + e);
            log.info("Text'i almaya tıklamaya çalışırken hata aldı : " + e);
            throw new RuntimeException(e);
        }

        return text;
    }

    protected void moveToElement(By by) {
        try {
            Actions action = new Actions(driver);
            WebElement we = findElement(by);
            action.moveToElement(we).build().perform();
        } catch (Exception e) {
            log.warning("Move yapmaya çalışırken hata aldı : " + e);
            log.info("Hesabım'a tıklamaya  çalışırken hata aldı : " + e);
            throw new RuntimeException(e);
        }
    }

    protected void moveToElement(WebElement we) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(we).build().perform();
        } catch (Exception e) {
            log.warning("Move yapmaya çalışırken hata aldı : " + e);
            log.info("Move yapmaya çalışırken hata aldı : " + e);
            throw new RuntimeException(e);
        }
    }

    protected void control(boolean statament, String Ontrue, String Onfalse) {
        if (statament == true) {
            log.info(Ontrue);
        } else {
            log.info(Onfalse);
        }
    }

    protected boolean isElementExist(By by) {
        return isElementExist(by, 15);
    }

    protected boolean isElementExist(By by, int timeSeconds) {
        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
        boolean isExist = driver.findElements(by).size() > 0;
        return isExist;
    }

    protected String getValueOfElement(By by, int... index) {
        String value = null;

        try {
            if (index.length == 0) {
                value = findElement(by).getAttribute("value");
            } else {
                value = findElements(by).get(index[0]).getAttribute("value");
            }
        } catch (Exception e) {
            log.info("Error while getting value of element : " + e);
            log.warning("Error while getting value of element : " + e);

            throw new RuntimeException(e);
        }
        return value;
    }

    protected String getTitleOfElement(By by, int... index) {
        String title = null;

        try {
            if (index.length == 0) {
                title = driver.findElement(by).getAttribute("title");
            } else {
                title = driver.findElements(by).get(index[0]).getAttribute("title");
            }
        } catch (Exception e) {
            log.info("Error while getting title of element : " + e);
            log.warning("Error while getting title of element : " + e);

            throw new RuntimeException(e);
        }
        return title;
    }



}