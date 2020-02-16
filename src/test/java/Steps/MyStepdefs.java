package Steps;

import N11Project.ControlMessage;
import N11Project.N11Project;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * created by MehmetBesli on 02.2020
 */
public class MyStepdefs {

    N11Project n11Project=new N11Project();

    @Given("^Navigate to the website$")
    public void navigateToTheWebsite() {
        n11Project.initializeTest();
        n11Project.gotoN11Website();
    }

    @And("^Click Login Text$")
    public void clickLoginText() throws InterruptedException {
        n11Project.clickGirisYapText();
        n11Project.controlCorrectPage(ControlMessage.girisYap);
        n11Project.controlLoginExist();
    }

    @When("^Filling username and password$")
    public void fillingUsernameAndPassword() throws InterruptedException {
        n11Project.enterUsernamePassword();
    }

    @Then("^Click enter button$")
    public void clickEnterButton() throws InterruptedException {
        n11Project.clickLogin();
        n11Project.controlLoggedOrNot(ControlMessage.hesabimTitle);
    }

    @And("^Search any model mobile phone$")
    public void searchAnyMobilePhone() throws InterruptedException {
        n11Project.searchProduct();
    }

    @Then("^Click search button$")
    public void clickSearchButton() throws InterruptedException {
        n11Project.clickSearchBtn();
        n11Project.controlSearchedCorrect(n11Project.getProductName());
    }

    @And("^Go to second page$")
    public void goToSecondPage() throws InterruptedException {
        n11Project.gotoSecondPage();
        n11Project.controlRightaPage();
    }

    @Then("^Add Favourite third product$")
    public void addFavouriteThirdProduct() throws InterruptedException {
        n11Project.addFifthProductinSecondPage();
    }

    @Then("^Click Sepete Ekle button$")
    public void clickSepeteEkleButton() throws InterruptedException {
        n11Project.compareTheProduct(n11Project.getFifthProductName());
        n11Project.clickSepeteEkleBtn();
    }

    @And("^Add Favorite Icon$")
    public void addFavoriteIcon() throws InterruptedException {
        n11Project.addFovouriteIcon();
        n11Project.addToFavouriteWishListBtn();
    }

    @And("^Move Hesabim and click Favorilerim$")
    public void moveHesabimAndClickFavorilerim() throws InterruptedException {
        n11Project.moveHesabimandClickFovorite();
    }

    @Then("^Select product before added$")
    public void selectProductBeforeAdded() throws InterruptedException {
        n11Project.selectBeforeAdded();
        n11Project.controlCorrectProductAdded(n11Project.getFifthProductName());
    }

    @And("^Delete selected mobile phone$")
    public void deleteSelectedMobilePhone() throws InterruptedException {
        n11Project.deleteSelectedProduct();
        n11Project.deletedProductMessage(ControlMessage.deletedMmessage);
        n11Project.controlProductNotExist(ControlMessage.productNotExist);
    }

    @Then("^Click Logout$")
    public void clickLogout() throws InterruptedException {
        n11Project.clickLogout();
        n11Project.controlCorrectPage(ControlMessage.girisYap);
        n11Project.closingTest();
    }

}