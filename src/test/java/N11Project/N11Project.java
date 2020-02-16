package N11Project;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * created by MehmetBesli on 02.2020
 */
public class N11Project extends AbstractTest {

    private String email = "";
    private String password = "";
    private String productName = "Xiaomi";
    private String fifthProductPrice;
    private String fifthProductName;
    private String pageNum="pg=2";

    public void initializeTest() {
        Locale.setDefault(new Locale("en", "EN"));
        System.setProperty("webdriver.chrome.driver", "C:\\N11ProjectAutomation\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        log.info("Chrome browser opened");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void gotoN11Website() {
        driver.get("https://www.n11.com/");
        if (driver.getCurrentUrl().contains("https://www.n11.com/")) {
            log.info("You are in n11 website");
        } else {
            log.info("You are not in n11 website");
            Assert.assertFalse(false);
        }
    }

    public void clickGirisYapText() throws InterruptedException {
        log.info("Click GirisYap Text");
        click(N11ObjeRepo.girisYapText);
    }

    public void controlCorrectPage(String girisYap) throws InterruptedException {
        log.info("Kontrol GirisYap Text exist");

        String girisYapText=getTextOfElement(N11ObjeRepo.girisYapTextAlma);
        log.info("Incoming text: "+girisYapText);
        log.info("Exist Text: "+girisYap);
        Assert.assertEquals(girisYapText, girisYap);
        log.info("Compare Succesful. Compared texts are same.");
        log.info("Compared Text: "+girisYapText);

    }

    public void controlLoginExist() throws InterruptedException {
        log.info("Kontrol GirisYap Text exist");
        control(isElementExist(N11ObjeRepo.loginEkranGeldimiKontrol),"Login screen exist","Login screen doesnt  exist");
    }
    public void enterUsernamePassword() throws InterruptedException {
        log.info("Enter Username ve password ");
        sendKeys(N11ObjeRepo.email, email);
        log.info("typed username: "+email);
        sendKeys(N11ObjeRepo.password, password);
        log.info("typed: password: "+password);
    }

    public void clickLogin() throws InterruptedException {
        log.info("Click login button");
        click(N11ObjeRepo.girisYapBtn);
    }

    public void controlLoggedOrNot(String hesabimTitle,int...index) throws InterruptedException {
        log.info("Control logged button");

        String title = getTitleOfElement(N11ObjeRepo.hesabimTitle2);
        Assert.assertEquals(hesabimTitle, title);
        log.info("Compared successful. Logged to the website");
        log.info("Compared title: "+hesabimTitle);
    }

    public void searchProduct() throws InterruptedException {
        log.info("Enter any product from search text");
        sendKeys(N11ObjeRepo.searchProduct, productName);
    }

    public void controlSearchedCorrect(String productName) throws InterruptedException {
        log.info("control searched correct prodcut");

        String Searchvalue=getValueOfElement(N11ObjeRepo.searchProduct );
        Assert.assertEquals(Searchvalue, productName);
        log.info("Compared successful");
        log.info("Compared value: "+Searchvalue);
    }

    public void clickSearchBtn() throws InterruptedException {
        log.info("Click Search button");
        click(N11ObjeRepo.searchProductBtn);
    }

    public void gotoSecondPage() throws InterruptedException {
        log.info("Click next page");
        click(N11ObjeRepo.nextPage);
    }

    public void controlRightaPage() throws InterruptedException {
        log.info("Click next page");
        String pageNumber=driver.getCurrentUrl();
        if(pageNumber.contains(pageNum)){
            log.info("You are in correct page");
            log.info("Page number: "+pageNum.split("=")[1]);
        } else {
            log.info("You are in wrong page");
            Assert.assertTrue(false);
        }
    }

    public void addFifthProductinSecondPage() throws InterruptedException {
        log.info("Add Third Product in second page");

        fifthProductName=getTitleOfElement(N11ObjeRepo.fifthProductTitle);
        log.info("Selected product name: "+fifthProductName);

        fifthProductPrice = getTextOfElement(N11ObjeRepo.fifthProduct);
        log.info("Seçilen ürün Fiyatı: " + fifthProductPrice);
        log.info("The product has been selected ");

        log.info("Click fifth product");
        click(N11ObjeRepo.fifthProduct);

    }

    public void compareTheProduct(String product) throws InterruptedException {
        log.info("Add Third Product in second page");

        String productAfterSelected = getTextOfElement(N11ObjeRepo.productNameAfterSelected);
        log.info("Selected product: " + product);
        log.info("Product: "+productAfterSelected);

        Assert.assertEquals(productAfterSelected, product);
        log.info("Compare product successful");
        log.info("Compared product: "+productAfterSelected);
    }

    public void clickSepeteEkleBtn() throws InterruptedException {
        log.info("Click Sepete Ekle Button and select color, memory for selected product");
        //clickJS(N11ObjeRepo.selectColor);
        //click(N11ObjeRepo.selectColor);
        click(N11ObjeRepo.sepeteEkleBtn);
    }

    public void addFovouriteIcon() throws InterruptedException {
        log.info("Click WishList and Favourite WishList Button");
        click(N11ObjeRepo.wishList);
    }

    public void addToFavouriteWishListBtn() throws InterruptedException {
        log.info("Click WishList and Favourite WishList Button");
        click(N11ObjeRepo.addToFavouriteWishListBtn);
        click(N11ObjeRepo.okBtnForDelete);
    }

    public void moveHesabimandClickFovorite() throws InterruptedException {
        log.info("Click Hesabım Title");
        moveToElement(N11ObjeRepo.HesabimTitle);
        clickJS(N11ObjeRepo.favorilerimIsteklerim);
    }

    public void selectBeforeAdded() throws InterruptedException {
        log.info("Select favourite before added.");
        click(N11ObjeRepo.selectBeforeAdded);
    }

    public void controlCorrectProductAdded(String productName) throws InterruptedException {
        log.info("Select favourite before added.");

        String product=getTitleOfElement(N11ObjeRepo.productInFavourite);
        log.info("Product in Favourite: "+product);
        log.info("Before selected product: "+productName);

        Assert.assertEquals(product, productName);
        log.info("Compared successful. Product: "+product);

    }

    public void deleteSelectedProduct() throws InterruptedException {
        log.info("Delete selected favourite before added.");
        click(N11ObjeRepo.deleteProduct);
//        click(N11ObjeRepo.okBtnForDelete);
    }

    public void deletedProductMessage(String deletedMessage) throws InterruptedException {
        log.info("Select favourite before added.");

            String message = getTextOfElement(N11ObjeRepo.deletedProductMessage);
            log.info("Message: " + message);
            log.info("Deleted message: " + deletedMessage);

            Assert.assertEquals(message, deletedMessage);
            log.info("Message are same. " + message);

            log.info("Click oky button");
            click(N11ObjeRepo.okBtnForDelete);
    }

    public void controlProductNotExist(String notExistProductMessage) throws InterruptedException {
        log.info("Select favourite before added.");

        String productNotExistText=getTextOfElement(N11ObjeRepo.productNotExist);
        log.info("Message: "+ productNotExistText);
        log.info("Not exist message: "+notExistProductMessage);

        Assert.assertEquals(productNotExistText, notExistProductMessage);
        log.info("Message are same. "+productNotExistText);
    }

    public void clickLogout() throws InterruptedException {
        log.info("Click Hesabım Title and Logout");
        moveToElement(N11ObjeRepo.HesabimTitle);
        click(N11ObjeRepo.logout);
    }

    public void closingTest() {
        driver.quit();
        log.info("Chrome browser closed");
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFifthProductName() {
        return fifthProductName;
    }

    public void setFifthProductNamee(String fifthProductName) {
        this.fifthProductName = fifthProductName;
    }
}