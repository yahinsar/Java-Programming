CREATE TABLE employeesAge (
    id SERIAL PRIMARY KEY,
    employeeName VARCHAR(255),
    age INTEGER
);

CREATE TABLE departmentSalary (
    id SERIAL PRIMARY KEY,
    employeeName VARCHAR(255),
    departmentName VARCHAR(255),
    salary INTEGER
);

CREATE TABLE departmentEmployee (
    id SERIAL PRIMARY KEY,
    employeeName VARCHAR(255),
    departmentId INTEGER
);

CREATE TABLE departmentLocation (
    id SERIAL PRIMARY KEY,
    departmentName VARCHAR(255),
    location VARCHAR(255)
);

INSERT INTO employeesAge (employeeName, age) VALUES ('Кирилл', 18);
INSERT INTO employeesAge (employeeName, age) VALUES ('Саша', 20);
INSERT INTO employeesAge (employeeName, age) VALUES ('Катя', 25);

INSERT INTO departmentSalary (employeeName, departmentName, salary) VALUES ('Кирилл', 'IT', 30000);
INSERT INTO departmentSalary (employeeName, departmentName, salary) VALUES ('Иван', 'IT', 20000);
INSERT INTO departmentSalary (employeeName, departmentName, salary) VALUES ('Маша', 'HR', 40000);

INSERT INTO departmentEmployee (employeeName, departmentId) VALUES ('Кирилл', 1);
INSERT INTO departmentEmployee (employeeName, departmentId) VALUES ('Иван', 1);
INSERT INTO departmentEmployee (employeeName, departmentId) VALUES ('Маша', 2);

INSERT INTO departmentLocation (departmentName, location) VALUES ('IT', 'Саратов');
INSERT INTO departmentLocation (departmentName, location) VALUES ('HR', 'Москва');