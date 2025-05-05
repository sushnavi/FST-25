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
    
    for i in range(2):
        driver.find_element(By.ID,'confirmation').click()
    
        comfirmAlert = wait.until(EC.alert_is_present())
        txt = comfirmAlert.text
        print("The text on alert is :"+txt)
        if i==0:
            comfirmAlert.accept()
            print(driver.find_element(By.ID, "result").text)
        else:
            comfirmAlert.dismiss()
            print(driver.find_element(By.ID, "result").text)
    
    driver.close