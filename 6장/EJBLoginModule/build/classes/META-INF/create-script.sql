CREATE TABLE family ( EMP_ID VARCHAR(255) NOT NULL, EMP_PASSWD VARCHAR(255) NOT NULL, EMP_AGE INT NOT NULL, EMP_NAME VARCHAR(255) NOT NULL, PRIMARY KEY(EMP_ID) )

CREATE INDEX my_index ON family(EMP_ID)