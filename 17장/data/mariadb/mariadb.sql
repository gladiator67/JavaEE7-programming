USE testdb;

CREATE TABLE family(
   EMP_ID VARCHAR(20) NOT NULL,
   EMP_PASSWD VARCHAR(20) NOT NULL,
   EMP_NAME VARCHAR(20) NOT NULL,
   EMP_AGE INT,

   PRIMARY KEY(EMP_ID)
);

INSERT INTO family VALUES('aupres', 'aaa', '������', 50);
INSERT INTO family VALUES('hwa5383', 'bbb', '�˳�', 45);
INSERT INTO family VALUES('julian', 'ccc', '���� �Ƶ�', 20);