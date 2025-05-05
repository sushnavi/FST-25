from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/selects")

    print("The title of he page is :" +driver.title)
    dropdown = driver.find_element(By.CSS_SELECTOR, "select.h-10")
    option = Select(dropdown)
    option.select_by_index(3)
    print("selecting by indx :" +option.first_selected_option.text)
    option.select_by_visible_text('Two')
    print("selecting by visible text :" +option.first_selected_option.text)
    option.select_by_value('four')
    print("selecting by visible Value :" +option.first_selected_option.text)

    allOptions = option.options
    print("All available options")
    for i in allOptions:
        print(i.text)
