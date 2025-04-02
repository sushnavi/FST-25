-- ACTIVITY 1
CREATE TABLE SALESMAN(salesmen_id int,salesmen_name varchar(32),salesmen_city varchar(32), commision int );
DESCRIBE SALESMAN;

-- ACTIVITY 2
INSERT INTO SALESMAN VALUES(5001, 'James Hoog', 'New York', 15);
INSERT INTO SALESMAN VALUES(5002, 'Nail Knite', 'Paris', 13);
INSERT INTO SALESMAN VALUES(5005, 'Pit Alex', 'London', 11);
INSERT INTO SALESMAN VALUES(5006, 'McLyon', 'Paris', 14);
INSERT INTO SALESMAN VALUES(5007, 'Paul Adam', 'Rome', 13);
INSERT INTO SALESMAN VALUES(5003, 'Lauson Hen', 'San Jose', 12);
SELECT * FROM SALESMAN;
DESCRIBE SALESMAN;

-- ACTIVITY 3
-- Show data from the salesmen_id and city columns
SELECT salesmen_id, salesmen_city FROM SALESMAN;
-- Show data of salesman from Paris
SELECT * FROM SALESMAN WHERE salesmen_city='Paris';
-- Show salesmen_id and commission of Paul Adam
SELECT salesmen_id, commision FROM SALESMAN WHERE salesmen_name='Paul Adam';

-- ACTIVITY 4
-- Add the grade column
ALTER TABLE SALESMAN ADD grade int;
-- Update the values in the grade column
UPDATE SALESMAN SET grade=100;
-- Display data
SELECT * FROM SALESMAN;

-- ACTIVITY 5
-- Update the grade score of salesmen from Rome to 200.
UPDATE SALESMAN SET grade=200 WHERE salesmen_city='Rome';
-- Update the grade score of James Hoog to 300.
UPDATE SALESMAN SET grade=300 WHERE salesmen_name='James Hoog';
-- Update the name McLyon to Pierre.
UPDATE SALESMAN SET salesmen_name='Pierre' WHERE salesmen_name='McLyon';
-- Display modified data
SELECT * FROM SALESMAN;

-- ACTIVITY 6
-- Creating a table named orders
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesmen_id int);
-- Adding values to the table
INSERT ALL
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;
DESCRIBE orders;
-- Get all salesman ids without any repeated values
select distinct salesmen_id from orders;
-- Display the order number ordered by date in ascending order
select order_no, order_date from orders order by order_date;
-- Display the order number ordered by purchase amount in descending order
select order_no, purchase_amount from orders order by purchase_amount DESC;
-- Display the full data of orders that have purchase amount less than 500.
select * from orders where purchase_amount < 500;
-- Display the full data of orders that have purchase amount between 1000 and 2000.
select * from orders where purchase_amount between 1000 and 2000;

-- ACTIVITY 7
select SUM(purchase_amount) AS "Total sum" from orders;
select AVG(purchase_amount) AS "Average" from orders;
select MAX(purchase_amount) AS "Maximum" from orders;
select MIN(purchase_amount) AS "Minumum" from orders;
select COUNT(distinct salesmen_id) AS "Total count" from orders;

--ACTIVITY 8
-- Write an SQL statement to find the highest purchase amount ordered by the each customer with their ID and highest purchase amount.
SELECT customer_id, MAX(purchase_amount) AS "Max Amount" FROM orders GROUP BY customer_id;
-- Write an SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID.
SELECT salesmen_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesmen_id, order_date;
-- Write an SQL statement to find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list 2030, 3450, 5760, and 6000.
SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders
GROUP BY customer_id, order_date
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);

--------------------------------------

--ACTIVITY9
-- Create the customers table
CREATE TABLE customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesmen_id int);
-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;
DESCRIBE customers;
-- Write an SQL statement to know which salesman are working for which customer.
SELECT a.customer_name AS "Customer Name", a.city, b.salesmen_name AS "Salesmen", b.commision FROM customers a 
INNER JOIN SALESMAN b ON a.salesmen_id=b.salesmen_id;
-- Write an SQL statement to make a list of customers in ascending order with a salesman that have a grade less than 300
SELECT a.customer_name, a.city, a.grade, b.salesmen_name AS "Salesmen", b.salesmen_city FROM customers a 
LEFT OUTER JOIN SALESMAN b ON a.salesmen_id=b.salesmen_id WHERE a.grade<300 
ORDER BY a.customer_id;
-- Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission of more than 12%
SELECT a.customer_name AS "Customer Name", a.city, b.salesmen_name AS "Salesmen", b.commision FROM customers a 
INNER JOIN SALESMAN b ON a.salesmen_id=b.salesmen_id 
WHERE b.commision>12;
-- Write an SQL statement to find the following details of an order - order number, order date, purchase amount of order, which customer gives the order and which salesman works for that customer and commission rate they get for the order.
SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.salesmen_name AS "Salesmen", c.commision FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN SALESMAN c ON a.salesmen_id=c.salesmen_id;

-- ACTIVITY 10
-- Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
SELECT * FROM orders
WHERE salesmen_id=(SELECT DISTINCT salesmen_id FROM orders WHERE customer_id=3007);

-- Write a query to find all orders attributed to a salesman in New York.
SELECT * FROM orders
WHERE salesmen_id IN (SELECT salesmen_id FROM SALESMAN WHERE salesmen_city='New York');

-- Write a query to count the customers with grades above New York's average.
SELECT grade, COUNT(*) FROM customers
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

-- Write a query to extract the data from the orders table for those salesman who earned the maximum commission
SELECT order_no, purchase_amount, order_date, salesmen_id FROM orders
WHERE salesmen_id IN( SELECT salesmen_id FROM SALESMAN
WHERE commision=( SELECT MAX(commision) FROM SALESMAN));

--ACTIVITY 11
-- Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order
SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesmen_id, salesmen_name FROM SALESMAN a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesmen_id = b.salesmen_id)
ORDER BY customer_name;
-- Write a query to make a report of which salesman produce the largest and smallest orders on each date.
SELECT a.salesmen_id, a.salesmen_name, o.order_no, 'highest on', o.order_date, o.purchase_amount FROM SALESMAN a, orders o
WHERE a.salesmen_id=o.salesmen_id
AND o.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
UNION
SELECT a.salesmen_id, a.salesmen_name, o.order_no, 'lowest on', o.order_date, o.purchase_amount FROM SALESMAN a, orders o
WHERE a.salesmen_id=o.salesmen_id
AND o.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
ORDER BY order_date;