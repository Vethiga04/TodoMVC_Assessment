package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.TodomvcPage;

public class TodomvcTaskDefinitions {
	WebDriver driver;
	TodomvcPage todomvcPage = new TodomvcPage(driver);

	@Given("user navigates to Todomvc site")
	public void user_navigates_to_todomvc_site() {
//		browser will be downloaded auto 
		WebDriverManager.chromedriver().setup();
		
//		Initializing chromedriver
		driver=new ChromeDriver();
		
//		Page Navigation
		driver.get("http://todomvc.com/examples/vue/");
	}


	@When("user types {string} and press enter key on the item area")
	public void user_types_and_press_enter_key_on_the_item_area(String todoItem) {
		todomvcPage=new TodomvcPage(driver);
		todomvcPage.type_todomvc(todoItem);
	}


	@Then("user should be able to view {string} as the added item in the list")
	public void user_should_be_able_to_view_as_the_added_item_in_the_list(String todoItemDisplay) {
		todomvcPage = new TodomvcPage(driver);
		Assert.assertEquals(todoItemDisplay, todomvcPage.getTextOfTodoItem());
	}

	@Then("the list summary is shown as {int} item left")
	public void the_list_summary_is_shown_as_item_left(int listSummaryCount) {
		todomvcPage = new TodomvcPage(driver);
		todomvcPage.itemsTotalCount(listSummaryCount);

	}



	// 2nd scenario

	@When("user types below items as todo item in the list and pressing enter key")
	public void user_types_below_items_as_todo_item_in_the_list_and_pressing_enter_key(io.cucumber.datatable.DataTable dataTable) {
		todomvcPage = new TodomvcPage(driver);
		List<String> strList=dataTable.asList(String.class);
		for(int i=0;i<=strList.size()-1;i++) {
			todomvcPage.itemField.sendKeys(strList.get(i)+Keys.ENTER);

		}


	}

	@Then("user should be able to view the below items as the added item in the list")
	public void user_should_be_able_to_view_the_below_items_as_the_added_item_in_the_list(io.cucumber.datatable.DataTable dataTable) {
		todomvcPage = new TodomvcPage(driver);
		List<String> strListexpected=dataTable.asList(String.class);
		List<WebElement> expectedList=todomvcPage.LabelsOfMultiItemList;
		int j=0;
		for(WebElement expectedStr:expectedList) {
			expectedStr.getText().equalsIgnoreCase(strListexpected.get(j));
			j++;
		}

	}

	@Then("the list summary is shown as {int} items left")
	public void the_list_summary_is_shown_as_items_left(int listSummaryCountMulti) {
		todomvcPage = new TodomvcPage(driver);
		todomvcPage.itemsTotalCount(listSummaryCountMulti);
	}



	// 3rd scenario

	@Given("Type todo item in the list as {string}")
	public void type_todo_item_in_the_list_as(String todoItemBeforeEdit) {

		todomvcPage = new TodomvcPage(driver);
		todomvcPage.type_todomvc(todoItemBeforeEdit);

	}

	@When("user double clicks on the added item")
	public void user_double_clicks_on_the_added_item() {
		todomvcPage = new TodomvcPage(driver);
		todomvcPage.doubleClick_addedItemList(driver);
	}

	@When("user appends new word into todo item as {string}")
	public void user_appends_new_word_into_todo_item_as(String todoItemEditted) {
		
		todomvcPage = new TodomvcPage(driver);
		todomvcPage.appendingItemintoList(todoItemEditted);

	}

	@When("user clickcs on enter key")
	public void user_clickcs_on_enter_key() {

		todomvcPage = new TodomvcPage(driver);
		todomvcPage.clicksOnEnterKey();
	}

	@Then("user should be able to view the edited item as {string} in the list")
	public void user_should_be_able_to_view_the_edited_item_as_in_the_list(String todoItemEditedDisplay) {

		todomvcPage = new TodomvcPage(driver);
		Assert.assertEquals(todoItemEditedDisplay, todomvcPage.getTextOfTodoItem());

	}



	// scenario 4

	@When("user clicks on close icon")
	public void user_clicks_on_close_icon() {
		
		todomvcPage=new TodomvcPage(driver);
		todomvcPage.performClickCloseIcon(driver);
	}


	@Then("user shouldnt be able to view the removed items in the list")
	public void user_shouldnt_be_able_to_view_the_removed_items_in_the_list() {

		todomvcPage=new TodomvcPage(driver);
		todomvcPage.validateRemovedItemCount();

	}


	@Then("the list summary is not shown at the bottom")
	public void the_list_summary_is_not_shown_at_the_bottom() {	
		
		todomvcPage=new TodomvcPage(driver);
		todomvcPage.validateFooterIsNotShown();
	}


	// Scenario 5
	
	@When("user clicks on radiobutton of the item")
	public void user_clicks_on_radiobutton_of_the_item() {
	    todomvcPage=new TodomvcPage(driver);
	    todomvcPage.clickOnRadioButton();
		
	}
	
	@Then("user should be able to view the text at bottom as {string}")
	public void user_should_be_able_to_view_the_text_at_bottom_as(String expectedclearTextContent) {
		todomvcPage=new TodomvcPage(driver);
		Assert.assertEquals(expectedclearTextContent, todomvcPage.getTextOfClearCompleted());

		
	}






}
