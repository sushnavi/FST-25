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