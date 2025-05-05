from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    driver.get("https://training-support.net/webelements/alerts")

    #verify title
    print("The title of the page ",driver.title)

    driver.find_element(By.ID,'prompt').click()
    
    promptAlert = wait.until(EC.alert_is_present())
    
    txt = promptAlert.text
    print("The text on alert is :"+txt)

    promptAlert.send_keys('Awesome')
    promptAlert.accept()
    # Print the message
    print(driver.find_element(By.ID, "result").text)