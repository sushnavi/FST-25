from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/tables")

    print("the totle of the page is : ",driver.title)

    row  = driver.find_elements(By.XPATH,"//table/tbody/tr")
    col = driver.find_elements(By.XPATH,"//table/thead/tr/th")
    print("No of rows is : ", len(row) , " & The No of columns are : ", len(col))

    book_in_fifth_row = driver.find_element(By.XPATH,"//table/tbody/tr[5]/td[2]").text
    print("Book Name in the 5th row is : " , book_in_fifth_row)

    driver.find_element(By.XPATH,"//table/thead/tr/th[5]").click()

    soretd_book_in_fifth_row = driver.find_element(By.XPATH,"//table/tbody/tr[5]/td[2]").text
    print("Book Name in the 5th row is aftr sorting price: " , soretd_book_in_fifth_row)

    driver.close

