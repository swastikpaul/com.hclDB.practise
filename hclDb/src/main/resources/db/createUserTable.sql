CREATE TABLE user(
   ID          INT NOT NULL,
   NAME        VARCHAR (20) NOT NULL,
   GENDER      VARCHAR (5) NOT NULL,
   PROFILE_DESC VARCHAR(100),
   DOB      DATE,
   PRIMARY KEY (ID)
);