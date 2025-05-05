from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import Keys, ActionChains

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/keyboard-events")

    #verify title
    print("The title of the page ",driver.title)

    #Task 
    #On the page, type out a string from the Selenium script to show on the page
    #Print the message to the console.

    action = ActionChains(driver)

    action.send_keys("This is coming from Selenium!").send_keys(Keys.RETURN).perform()

    msg = driver.find_element(By.CSS_SELECTOR, "h1.mt-3").text
    print("The entered message is : ", msg)

    driver.quit
    
