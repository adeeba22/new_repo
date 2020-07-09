-- drop table if already exists --
DROP TABLE Users;

-- table for the exercise --
CREATE TABLE Users (UserId INT, UserName VARCHAR(30), PhoneNumber VARCHAR(10));

-- initial data --
INSERT INTO Users (UserId, UserName, PhoneNumber) VALUES (1, 'Rahul', '9876543210');

INSERT INTO Users (UserId, UserName, PhoneNumber) VALUES (2, 'Nikita', '8776543201');

INSERT INTO Users (UserId, UserName, PhoneNumber) VALUES (3, 'Manoj', '8876543012');

INSERT INTO Users (UserId, UserName, PhoneNumber) VALUES (4, 'Rekha', '7896543210');