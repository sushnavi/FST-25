from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/drag-drop")

    print("the title of the page is : ", driver.title)

    #
    ball = driver.find_element(By.ID, "ball")
    drop1 = driver.find_element(By.ID, "dropzone1")
    drop2 = driver.find_element(By.ID, "dropzone2")

    action = ActionChains(driver)

    action.click_and_hold(ball).move_to_element(drop1).pause(5).release().perform()
    if(drop1.find_element(By.CLASS_NAME, "dropzone-text").text == "Dropped!"):
        print("Ball was dropped in Dropzone 1")

    action.drag_and_drop(ball,drop2).pause(5).release().perform()
    if(drop2.find_element(By.CLASS_NAME, "dropzone-text").text == "Dropped!"):
        print("Ball was dropped in Dropzone 2")

    driver.close