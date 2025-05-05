from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    driver.get(" https://training-support.net/webelements/dynamic-controls")

    print("The title of the page is :", driver.title)

    
    #Find the input text field.
    input_field = driver.find_element(By.ID,"textInput")

    print("Is the input field enabled ?", input_field.is_enabled())
    #Click the "Enable Input" button to enable the input field.
    enable_input = driver.find_element(By.ID,"textInputButton")
    enable_input.click()

    #Check if the text field is enabled again and print it.
    print("Is the input field enabled ?", input_field.is_enabled())

    driver.close

