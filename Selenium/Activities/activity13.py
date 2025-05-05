from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/tables")

    print("the totle of the page is : ",driver.title)

    row  = driver.find_elements(By.XPATH,"//table/tbody/tr")
    col = driver.find_elements(By.XPATH,"//table/thead/tr/th")
    print("No of rows is : ", len(row) , " & The No of columns are : ", len(col))

    third_row = driver.find_elements(By.XPATH,"//table/tbody/tr[3]/td")
    
    print("third row of the table is ")
    for i in third_row:
        print(i.text)

    
    print("second row second column is ", driver.find_element(By.XPATH,"//table/tbody/tr[2]/td[2]").text)

    driver.close
