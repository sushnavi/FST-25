from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/mouse-events")

    print("The title of the page is :", driver.title)

    cargoLock = driver.find_element(By.XPATH,"//h1[text()='Cargo.lock']")
    cargoToml = driver.find_element(By.XPATH,"//h1[text()='Cargo.toml']")
    srcButton = driver.find_element(By.XPATH,"//h1[text()='src']")
    targetButton = driver.find_element(By.XPATH,"//h1[text()='target']")

    actions = ActionChains(driver)
    #Task1
    actions.click(cargoLock).pause(1).move_to_element(cargoToml).pause(2).click(cargoToml).perform()
    actionMessage = driver.find_element(By.ID, "result").text
    print(actionMessage)

    #Double click on the src button. Then right click on the target button and select open. 
    #Print the confirmation text at the end of the sequence

    actions.double_click(srcButton).pause(5).context_click(targetButton).perform()
    actions.click(driver.find_element(By.XPATH, ("//div[@id='menu']/div/ul/li[1]"))).pause(5).perform()
    # Print the front side text
    actionMessage = driver.find_element(By.ID, "result").text
    print(actionMessage)

    driver.close


