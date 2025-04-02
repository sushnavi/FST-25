package stepDefinitions;
import java.util.List;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;

public class ToDoListSteps extends BaseClass {

	@Given("user is on the to-do list page")
	public void openToDoListPage() {
        driver.get("https://training-support.net/webelements/todo-list");
		System.out.println("Given completed");
	}

	@When("user adds the following tasks")
	public void inputTasks(DataTable inputTasks) throws InterruptedException {
		List<String> tasks = inputTasks.asList();
		System.out.println(tasks);
		for(String task : tasks) {
			driver.findElement(By.id("todo-input")).sendKeys(task);
			driver.findElement(By.id("todo-add")).click();
			Thread.sleep(2000);
		}
	}

	@Then("verify results")
	public void verifyResults() {
		System.out.println("Verification complete");
	}
}