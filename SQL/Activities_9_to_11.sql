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