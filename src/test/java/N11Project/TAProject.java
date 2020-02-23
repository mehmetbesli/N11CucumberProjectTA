package N11Project;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * created by MehmetBesli on 02.2020
 */
public class TAProject extends AbstractTest {

    private String email = "beslim063@gmail.com";
    private String password = "bslmhmtn1163";
    private String productName = "Xiaomi";
    private String fifthProductPrice;
    private String fifthProductName;
    private String pageNum="pg=2";
    private String busNumber="131T";


    public void initializeTest() {
        Locale.setDefault(new Locale("en", "EN"));
        System.setProperty("webdriver.chrome.driver", "C:\\N11ProjectAutomation\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        log.info("Chrome browser opened");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void gotoWebsite(String website) {
        driver.get(website);
        if (driver.getCurrentUrl().contains(website)) {
            log.info("You are in " +website.split("://")[1]+" website");
        } else {
            log.info("You are not in website");
            Assert.assertFalse(false);
        }
    }

    public void clickGirisYapText() throws InterruptedException {
        log.info("Click GirisYap Text");
        click(ObjeRepo.girisYapText);
    }

    public void controlCorrectPage(String girisYap) throws InterruptedException {
        log.info("Kontrol GirisYap Text exist");

        String girisYapText=getTextOfElement(ObjeRepo.girisYapTextAlma);
        log.info("Incoming text: "+girisYapText);
        log.info("Exist Text: "+girisYap);
        Assert.assertEquals(girisYapText, girisYap);
        log.info("Compare Succesful. Compared texts are same.");
        log.info("Compared Text: "+girisYapText);

    }

    public void controlLoginExist() throws InterruptedException {
        log.info("Kontrol GirisYap Text exist");
        control(isElementExist(ObjeRepo.loginEkranGeldimiKontrol),"Login screen exist","Login screen doesnt  exist");
    }

    public void enterUsernamePassword() throws InterruptedException {
        log.info("Enter Username ve password ");
        sendKeys(ObjeRepo.email, email);
        log.info("typed username: "+email);
        sendKeys(ObjeRepo.password, password);
        log.info("typed: password: "+password);
    }

    public void clickLogin() throws InterruptedException {
        log.info("Click login button");
        click(ObjeRepo.girisYapBtn);
    }

    public void controlLoggedOrNot(String hesabimTitle,int...index) throws InterruptedException {
        log.info("Control logged button");

        String title = getTitleOfElement(ObjeRepo.hesabimTitle2);
        Assert.assertEquals(hesabimTitle, title);
        log.info("Compared successful. Logged to the website");
        log.info("Compared title: "+hesabimTitle);
    }

    public void searchProduct() throws InterruptedException {
        log.info("Enter any product from search text");
        sendKeys(ObjeRepo.searchProduct, productName);
    }

    public void controlSearchedCorrect(String productName) throws InterruptedException {
        log.info("control searched correct prodcut");

        String Searchvalue=getValueOfElement(ObjeRepo.searchProduct );
        Assert.assertEquals(Searchvalue, productName);
        log.info("Compared successful");
        log.info("Compared value: "+Searchvalue);
    }

    public void clickSearchBtn() throws InterruptedException {
        log.info("Click Search button");
        click(ObjeRepo.searchProductBtn);
    }

    public void gotoSecondPage() throws InterruptedException {
        log.info("Click next page");
        click(ObjeRepo.nextPage);
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

        fifthProductName=getTitleOfElement(ObjeRepo.fifthProductTitle);
        log.info("Selected product name: "+fifthProductName);

        fifthProductPrice = getTextOfElement(ObjeRepo.fifthProduct);
        log.info("Seçilen ürün Fiyatı: " + fifthProductPrice);
        log.info("The product has been selected ");

        log.info("Click fifth product");
        click(ObjeRepo.fifthProduct);

    }

    public void compareTheProduct(String product) throws InterruptedException {
        log.info("Add Third Product in second page");

        String productAfterSelected = getTextOfElement(ObjeRepo.productNameAfterSelected);
        log.info("Selected product: " + product);
        log.info("Product: "+productAfterSelected);

        Assert.assertEquals(productAfterSelected, product);
        log.info("Compare product successful");
        log.info("Compared product: "+productAfterSelected);
    }

    public void clickSepeteEkleBtn() throws InterruptedException {
        log.info("Click Sepete Ekle Button and select color, memory for selected product");
        //clickJS(ObjeRepo.selectColor);
        //click(ObjeRepo.selectColor);
        click(ObjeRepo.sepeteEkleBtn);
    }

    public void addFovouriteIcon() throws InterruptedException {
        log.info("Click WishList and Favourite WishList Button");
        click(ObjeRepo.wishList);
    }

    public void addToFavouriteWishListBtn() throws InterruptedException {
        log.info("Click WishList and Favourite WishList Button");
        click(ObjeRepo.addToFavouriteWishListBtn);
        click(ObjeRepo.okBtnForDelete);
    }

    public void moveHesabimandClickFovorite() throws InterruptedException {
        log.info("Click Hesabım Title");
        moveToElement(ObjeRepo.HesabimTitle);
        clickJS(ObjeRepo.favorilerimIsteklerim);
    }

    public void selectBeforeAdded() throws InterruptedException {
        log.info("Select favourite before added.");
        click(ObjeRepo.selectBeforeAdded);
    }

    public void controlCorrectProductAdded(String productName) throws InterruptedException {
        log.info("Select favourite before added.");

        String product=getTitleOfElement(ObjeRepo.productInFavourite);
        log.info("Product in Favourite: "+product);
        log.info("Before selected product: "+productName);

        Assert.assertEquals(product, productName);
        log.info("Compared successful. Product: "+product);

    }

    public void deleteSelectedProduct() throws InterruptedException {
        log.info("Delete selected favourite before added.");
        click(ObjeRepo.deleteProduct);
//        click(ObjeRepo.okBtnForDelete);
    }

    public void deletedProductMessage(String deletedMessage) throws InterruptedException {
        log.info("Select favourite before added.");

            String message = getTextOfElement(ObjeRepo.deletedProductMessage);
            log.info("Message: " + message);
            log.info("Deleted message: " + deletedMessage);

            Assert.assertEquals(message, deletedMessage);
            log.info("Message are same. " + message);

            log.info("Click oky button");
            click(ObjeRepo.okBtnForDelete);
    }

    public void controlProductNotExist(String notExistProductMessage) throws InterruptedException {
        log.info("Select favourite before added.");

        String productNotExistText=getTextOfElement(ObjeRepo.productNotExist);
        log.info("Message: "+ productNotExistText);
        log.info("Not exist message: "+notExistProductMessage);

        Assert.assertEquals(productNotExistText, notExistProductMessage);
        log.info("Message are same. "+productNotExistText);
    }

    public void clickLogout() throws InterruptedException {
        log.info("Click Hesabım Title and Logout");
        moveToElement(ObjeRepo.HesabimTitle);
        click(ObjeRepo.logout);
    }

    public void closingTest() {
        driver.quit();
        log.info("Chrome browser closed");
    }

    public void lineStopText(String lineTtext) throws InterruptedException {
        log.info("Select favourite before added.");

        String message = getTextOfElement(ObjeRepo.lineStopText);
        log.info("Message: " + message);
        log.info("Deleted message: " + lineTtext);

        Assert.assertEquals(message, lineTtext);
        log.info("Message are same. " + message);

    }

    public void typeLineStop() throws InterruptedException {
        log.info("Type line or Stop number ");

        click(ObjeRepo.lineStop);
        //findElement(ObjeRepo.lineStopNumber).clear();
        sendKeys(ObjeRepo.lineStopNumber,busNumber);
        log.info("typed Bus Number: "+busNumber);

        boolean durum=false;
        List<WebElement> list=findElements(By.cssSelector("div[class='ResultOption-figure']"));
//        List<WebElement> list=findElements(By.cssSelector("ul[id='select2-searchShortcutsLine-results'] div[class='ResultOption']"));
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getText().contains(busNumber)){
                list.get(i).click();
                durum=true;
                break;
            }
        }

        if(durum==false) {
            log.info("Could not click you typed line or stop number");
            Assert.assertTrue(false);
        }
    }

    public void lineInfo() throws InterruptedException {
        log.info("line Information ");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ObjeRepo.shortestTime));
        String from=getTextOfElement(ObjeRepo.from);
        log.info("From: "+from);

        String to=getTextOfElement(ObjeRepo.to);
        log.info("To: "+to);

        String lineNumber=getTextOfElement(ObjeRepo.lineNumber);
        log.info(lineNumber);

        String shortestTime=getTextOfElement(ObjeRepo.shortestTime);
        log.info(shortestTime);

    }

    public void allInfoText(String allInfo) throws InterruptedException {
        log.info("Control All Informations text");
        Assert.assertEquals((getTextOfElement(ObjeRepo.allInfo)).trim(), allInfo);
    }

    public void clickAllInfo(String allInfoText) throws InterruptedException {
        log.info("Click All Informations");

        boolean durum=false;
        List<WebElement> elementList=driver.findElements(ObjeRepo.allInfo);
        for (int i=0; i<elementList.size(); i++) {
            if (elementList.get(i).getText().contains(allInfoText)){
                log.info("Will click: "+elementList.get(i).getText());
                elementList.get(i).click();
                durum=true;
                break;
            }
        }

        if (durum==false){
            log.info("Could not click");
            Assert.assertTrue(false);
        }

    }

    public void busNumberandFromTo() throws InterruptedException {
        log.info("Bus Number");

        String busNumbers = findElements(ObjeRepo.busNUmberFromTo).get(0).getText();
        Assert.assertEquals(busNumbers, busNumber);
        log.info("Compared succesful. Line Number: "+busNumbers);
        String fromTo = findElements(ObjeRepo.busNUmberFromTo).get(1).getText();

        log.info(busNumbers+" - "+fromTo);
    }

    public void stopThrough() throws InterruptedException {
        log.info("Click stop Through");
        click(ObjeRepo.stopThrough);
    }

    public void stopName() throws InterruptedException {
        log.info("CStop name Informations");

        String textOfElement = getTextOfElement(ObjeRepo.stopName);
        log.info("Stop number and Name: "+textOfElement);
    }

    public void clickStopDetails(String moveStopGetText) throws InterruptedException {
        log.info("Click stop Details");

        moveToElement(ObjeRepo.stopDetails);
        String textOfElement = getTextOfElement(ObjeRepo.moveStopGetText);
        Assert.assertEquals(moveStopGetText, textOfElement.trim());
        log.info("Compared succesfull. Text: "+moveStopGetText);
        click(ObjeRepo.stopDetails);
    }

    public void instandStopInfo() throws InterruptedException {
        log.info("Instand Bus Information");

        String instandBusInfoTex = getTextOfElement(ObjeRepo.instandStopInfoText);
        log.info("instand Bus Info Text: " + instandBusInfoTex);

        boolean durum=false;
        boolean bus=isElementExist(ObjeRepo.instandStopInfo);
        if(bus==true) {
            List<WebElement> instandBusInfo = findElements(ObjeRepo.instandStopInfo);
            for (int i = 0; i < instandBusInfo.size(); i++) {
                log.info("instand Bus Info: " + instandBusInfo.get(i).getText());
                durum = true;
            }

            if (durum==false){
                log.info("No instand Bus Info");
                Assert.assertTrue(false);
            }
        }else {
            log.info("No instand Bus Info actively");
        }

    }

    public void clickbusesPassingThroughStop() throws InterruptedException {
        log.info("Click buses passing through stop");

        click(ObjeRepo.busesPassingThroughStop);
    }

    public void busesPassingThroughStopNumber() throws InterruptedException {
        log.info("Buses passing through stop number");

        boolean durum=false;
        List<WebElement> instandBusInfo = findElements(ObjeRepo.busesPassingThroughStopNumber);
        for(int i=0; i<instandBusInfo.size(); i++) {
            log.info("instand Bus Info: " + instandBusInfo.get(i).getText());
            durum=true;
        }

        if (durum==false){
            log.info("No instand Bus Info");
            Assert.assertTrue(false);
        }

    }

    public void clickAboutStop() throws InterruptedException {
        log.info("Click about stop");
        click(ObjeRepo.aboutStop);
    }

    public void stopInfoInAbout(String info) throws InterruptedException {
        log.info("Control Bus Information");

        Assert.assertEquals((getTextOfElement(ObjeRepo.stopInformationText)).trim(),info);
        log.info("Compared succesfull. Tex: "+info);

        boolean durum=false;
        List<WebElement> instandBusInfo = findElements(ObjeRepo.busDetails);
        for(int i=0; i<instandBusInfo.size(); i++) {
            log.info(instandBusInfo.get(i).getText());
            durum=true;
        }

        if (durum==false){
            log.info("No Bus details");
            Assert.assertTrue(false);
        }
    }

    public void clickIETTicon() throws InterruptedException {
        log.info("Click IETT icon");
        click(ObjeRepo.IETTicon);
    }

    public void menu() throws InterruptedException {
        log.info("Control Bus Information");

        boolean durum=false;
        List<WebElement> instandBusInfo = findElements(ObjeRepo.controlMenu);
        for(int i=0; i<instandBusInfo.size(); i++) {
            log.info("Menues: "+instandBusInfo.get(i).getText());
            durum=true;
        }

        if (durum==false){
            log.info("No Bus details");
            Assert.assertTrue(false);
        }
    }

    public void clickHovCanIGo() throws InterruptedException {
        log.info("Click Hov Can I Go");
        click(ObjeRepo.hovCanIGo);;
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