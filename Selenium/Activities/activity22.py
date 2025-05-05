from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    driver.get("https://training-support.net/webelements/popups")
    driver.maximize_window()
    #verify title
    print("The title of the page ",driver.title)

    driver.find_element(By.ID,'launcher').click()

    wait.until(EC.element_to_be_clickable((By.ID, "username")))

    # Find the input fields
    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")
    # Enter the credentials
    username.send_keys("admin")
    password.send_keys("password")
    # Click the submit button
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    # Print the success message
    message = driver.find_element(By.CSS_SELECTOR, "h2.text-center").text
    print("Login message: " + message)


