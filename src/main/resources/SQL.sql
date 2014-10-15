CREATE TABLE EMPLOYEE
(
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    FIRSTNAME   VARCHAR(30),
    LASTNAME    VARCHAR(30),
    TELEPHONE   VARCHAR(15),
    EMAIL       VARCHAR(30),
    OWNER		VARCHAR(30),
    CREATED     TIMESTAMP DEFAULT NOW()
);
CREATE TABLE USERS
(
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME	VARCHAR(32),
    PASSWORD    VARCHAR(32),
    ENABLED		VARCHAR(32),
    CREATED     TIMESTAMP DEFAULT NOW(),
    UNIQUE (USERNAME)    
);
CREATE TABLE PERSISTENTLOGINS
(
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME	VARCHAR(32),
    SERIES		VARCHAR(32),
    TOKEN		VARCHAR(32),
    LASTUSED	VARCHAR(32),
    UNIQUE (USERNAME)  
);