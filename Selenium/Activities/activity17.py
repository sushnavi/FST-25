from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/selects")

    print("The title of he page is :" +driver.title)
    dropdown = driver.find_element(By.CSS_SELECTOR, "select.h-80")
    option = Select(dropdown)
   
    option.select_by_visible_text('HTML')

    for i in range(3,6):
        option.select_by_index(i)
        

    option.select_by_value('nodejs')
    
    allOptions = option.all_selected_options
    print("All available options")
    for i in allOptions:
        print(i.text)

    option.deselect_by_index(5)

    allOptions = option.all_selected_options
    print("All available options")
    for i in allOptions:
        print(i.text)

    driver.close