from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form/")

    print(driver.title)
    #username
    driver.find_element(By.ID,'username').send_keys('admin')
    driver.find_element(By.ID, 'password').send_keys('password')

    #submit
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()
    msg = driver.find_element(By.CSS_SELECTOR, "h1.text-center")
    print("The message is ", msg.text)

    driver.close