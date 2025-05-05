from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get(" https://training-support.net/webelements/dynamic-controls")

    print("The title of the page is :", driver.title)

    
    #Find the checkbox input element.
    checkbox_button = driver.find_element(By.ID,"checkbox")
    #toggle button
    checkbox_toggle = driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']")
    
    #Check if it is visible on the page.
    print("Is the check box visible ? " ,checkbox_button.is_displayed())

    #Click the "Remove Checkbox" button.
    checkbox_toggle.click()
    #Check if it is visible again and print the result.
    print("Is the check box visible, after clicking? " ,checkbox_button.is_displayed())

    driver.close

