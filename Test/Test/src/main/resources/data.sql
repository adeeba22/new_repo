-- drop table if already exists --
DROP TABLE OrderDetails;

-- table for the exercise --
CREATE TABLE OrderDetails (OrderId INT, ProductName VARCHAR(30), Price INT, Quantity INT, CustomerName VARCHAR(30));

-- initial data --
INSERT INTO OrderDetails (OrderId, ProductName, Price, Quantity, CustomerName) VALUES (1, 'LENOVO LAPTOP', 40000, 1, 'Bob');
INSERT INTO OrderDetails (OrderId, ProductName, Price, Quantity, CustomerName) VALUES (2, 'DELL LAPTOP', 50000, 1, 'Alex');
INSERT INTO OrderDetails (OrderId, ProductName, Price, Quantity, CustomerName) VALUES (3, 'HP LAPTOP', 45000, 1, 'John');
INSERT INTO OrderDetails (OrderId, ProductName, Price, Quantity, CustomerName) VALUES (4, 'SMART TV', 20000, 1, 'Bob');
INSERT INTO OrderDetails (OrderId, ProductName, Price, Quantity, CustomerName) VALUES (5, 'SONY HEADPHONES', 5000, 2, 'Bob');
INSERT INTO OrderDetails (OrderId, ProductName, Price, Quantity, CustomerName) VALUES (6, 'LENOVO LAPTOP', 40000, 1, 'Katie');
INSERT INTO OrderDetails (OrderId, ProductName, Price, Quantity, CustomerName) VALUES (7, 'LENOVO LAPTOP', 40000, 1, 'Joy');