from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get(" https://training-support.net/webelements/dynamic-controls")

    print("The title of the page is :", driver.title)

    
    #Find the checkbox input element.
    check_box = driver.find_element(By.ID,"checkbox")

    check_box.click()
    #Check if it is seleted
    print("Is the check box selected? " ,check_box.is_displayed())

    #Click the again
    check_box.click()
    #Check if it is selected again and print the result.
    print("Is the check box selected? " ,check_box.is_displayed())

    driver.close

