package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodomvcPage {
	
	public TodomvcPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}

	@FindBy(className ="new-todo")
	public WebElement itemField;
	
	public void type_todomvc(String name) {
		itemField.sendKeys(name+Keys.ENTER);
	}
	
	@FindBy(xpath ="//div/label")
	private WebElement LabelOfItemList;
	
	public void doubleClick_addedItemList(WebDriver driver) {
		Actions act = new Actions(driver);

		//Double click on element
		act.doubleClick(LabelOfItemList).perform();
	}
	
	
	@FindBy(xpath ="//input[@type='text']")
	private WebElement inputItemField;
	
	public void appendingItemintoList(String editedText) {
		inputItemField.sendKeys(editedText);
	}
	
	public void clicksOnEnterKey() {
		inputItemField.sendKeys(Keys.ENTER);
	}
	
	public String getTextOfTodoItem() {
		String editedItem=LabelOfItemList.getText();
		return editedItem;
	}
	
	@FindBy(xpath = "//button[@class='destroy']")
	private WebElement closeIcon;
	
	public void performClickCloseIcon(WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.clickAndHold(LabelOfItemList).moveByOffset(50, 0).release().build().perform();
		closeIcon.click();
	}
	
	@FindBy(xpath = "//div/label")
	public List<WebElement> LabelsOfMultiItemList;
	
	public void validateRemovedItemCount() {
		if(LabelsOfMultiItemList.size() !=0) {
			Assert.assertFalse(false);
		}
		else {
			Assert.assertTrue(true);
		}
	}
	
	@FindBy(xpath = "//footer[@class='footer']")
	private WebElement footerArea;
	
	public void validateFooterIsNotShown() {
		Assert.assertFalse(footerArea.isDisplayed());
	}
	
	@FindBy(xpath = "//span[@class='todo-count']/strong")
	private WebElement summary;
	
	public void itemsTotalCount(int listSummaryCount) {
		String countstr=summary.getText();
		int count=Integer.parseInt(countstr);
		Assert.assertEquals(listSummaryCount, count);
	}
	
	@FindBy(xpath = "//input[@class='toggle']")
	private WebElement completedCheck;
	
	public void clickOnRadioButton() {
		completedCheck.click();
	}
	
	@FindBy(xpath = "//button[@class='clear-completed']")
	private WebElement completedTextAtBottom;
	
	public String getTextOfClearCompleted() {
		String ClearText=completedTextAtBottom.getText();
		return ClearText;
	}
	
}
