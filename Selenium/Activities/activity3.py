from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    #using only xpath locator
    driver.get("https://training-support.net/webelements/login-form/")

    print(driver.title)
    #username
    driver.find_element(By.XPATH,"//input[@id='username']").send_keys('admin')
    driver.find_element(By.XPATH, "//input[@id='password']").send_keys('password')

    #submit
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()
    msg = driver.find_element(By.XPATH, "//h1[contains(@class, 'text-center')]").text
    print("The message is ", msg)

    driver.close