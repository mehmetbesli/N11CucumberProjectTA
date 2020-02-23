package Steps;

import N11Project.ControlMessage;
import N11Project.TAProject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * created by MehmetBesli on 02.2020
 */
public class MyStepdefs {

    TAProject taProject = new TAProject();

    @Given("^Navigate to the website$")
    public void navigateToTheWebsite() {
        taProject.initializeTest();
        taProject.gotoWebsite("https://www.n11.com/");
    }

    @And("^Click Login Text$")
    public void clickLoginText() throws InterruptedException {
        taProject.clickGirisYapText();
        taProject.controlCorrectPage(ControlMessage.girisYap);
        taProject.controlLoginExist();
    }

    @When("^Filling username and password$")
    public void fillingUsernameAndPassword() throws InterruptedException {
        taProject.enterUsernamePassword();
    }

    @Then("^Click enter button$")
    public void clickEnterButton() throws InterruptedException {
        taProject.clickLogin();
        taProject.controlLoggedOrNot(ControlMessage.hesabimTitle);
    }

    @And("^Search any model mobile phone$")
    public void searchAnyMobilePhone() throws InterruptedException {
        taProject.searchProduct();
    }

    @Then("^Click search button$")
    public void clickSearchButton() throws InterruptedException {
        taProject.clickSearchBtn();
        taProject.controlSearchedCorrect(taProject.getProductName());
    }

    @And("^Go to second page$")
    public void goToSecondPage() throws InterruptedException {
        taProject.gotoSecondPage();
        taProject.controlRightaPage();
    }

    @Then("^Add Favourite third product$")
    public void addFavouriteThirdProduct() throws InterruptedException {
        taProject.addFifthProductinSecondPage();
    }

    @Then("^Click Sepete Ekle button$")
    public void clickSepeteEkleButton() throws InterruptedException {
        taProject.compareTheProduct(taProject.getFifthProductName());
        taProject.clickSepeteEkleBtn();
    }

    @And("^Add Favorite Icon$")
    public void addFavoriteIcon() throws InterruptedException {
        taProject.addFovouriteIcon();
        taProject.addToFavouriteWishListBtn();
    }

    @And("^Move Hesabim and click Favorilerim$")
    public void moveHesabimAndClickFavorilerim() throws InterruptedException {
        taProject.moveHesabimandClickFovorite();
    }

    @Then("^Select product before added$")
    public void selectProductBeforeAdded() throws InterruptedException {
        taProject.selectBeforeAdded();
        taProject.controlCorrectProductAdded(taProject.getFifthProductName());
    }

    @And("^Delete selected mobile phone$")
    public void deleteSelectedMobilePhone() throws InterruptedException {
        taProject.deleteSelectedProduct();
        taProject.deletedProductMessage(ControlMessage.deletedMmessage);
        taProject.controlProductNotExist(ControlMessage.productNotExist);
    }

    @Then("^Click Logout$")
    public void clickLogout() throws InterruptedException {
        taProject.clickLogout();
        taProject.controlCorrectPage(ControlMessage.girisYap);
        taProject.closingTest();
    }


    @When("^Navigate to IETT website$")
    public void navigateToIETTWebsite() {
        taProject.initializeTest();
        taProject.gotoWebsite("https://iett.istanbul/");
    }

    @Then("^Search Line Stop name and select from popup$")
    public void searchLineStopNameAndSelectFromPopup() throws InterruptedException {
        taProject.lineStopText(ControlMessage.lineStopText);
        taProject.typeLineStop();
    }

    @Then("^Get Information about line$")
    public void getInformationAboutLine() throws InterruptedException {
        taProject.lineInfo();
    }

    @And("^Click All Information$")
    public void clickAllInformation() throws InterruptedException {
        taProject.allInfoText(ControlMessage.allInfoText);
        taProject.clickAllInfo(ControlMessage.allInfoText);
    }


    @Then("^Select Stops through$")
    public void selectStopsThrough() throws InterruptedException {
        taProject.busNumberandFromTo();
        taProject.stopThrough();
    }

    @And("^Click Third Stop$")
    public void clickThirdStop() throws InterruptedException {
        taProject.stopName();
        taProject.clickStopDetails(ControlMessage.movestopGetText);
    }

    @And("^Get instand stop information$")
    public void getInstandStopInformation() throws InterruptedException {
        taProject.instandStopInfo();
    }

    @Then("^Select Buses passing through the station$")
    public void selectBusesPassingThroughTheStation() throws InterruptedException {
        taProject.clickbusesPassingThroughStop();
        taProject.busesPassingThroughStopNumber();
    }

    @And("^Go to Line About and get info about it$")
    public void goToLineAboutAndGetInfoAboutIt() throws InterruptedException {
        taProject.clickAboutStop();
        taProject.stopInfoInAbout(ControlMessage.stopInfo);
    }

    @Then("^Click IETT Icon$")
    public void clickIETTIcon() throws InterruptedException {
        taProject.clickIETTicon();
        taProject.menu();
    }

    @Then("^Click Nasıl Giderim Menu$")
    public void clickNasılGiderimMenu() throws InterruptedException {
        taProject.clickHovCanIGo();
        taProject.gotoWebsite("https://nasilgiderim.iett.gov.tr/");
        taProject.closingTest();

    }
}