from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color
with webdriver.Firefox() as driver:
    #using only xpath locator
    driver.get("https://training-support.net/webelements/target-practice")

    print("The title of the page is ", driver.title)
    
    third_head = driver.find_element(By.XPATH,"//h3[contains(text(), '#3')]")
    print("the third header text is ", third_head.text)
    
    fifth_color= Color.from_string(driver.find_element(By.XPATH,"//h5[contains(text(), '#5')]").value_of_css_property('color'))
    print("the color in rgb ", fifth_color.rgb)
    print("the color in hex ", fifth_color.hex)
    #Find the purple button and print all it's classes.
    purple_button = driver.find_element(By.XPATH, "//button[contains(@class, 'bg-purple-200')]")
    print("The class are : ", purple_button.get_dom_attribute("class"))
    #Find the slate button and print it's text.
    slate_button = driver.find_element(By.XPATH, "//button[contains(@class, 'bg-slate-200')]")
    print("The text is  : ", slate_button.text)
    
    driver.close