INSERT INTO customer " +
			"VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?,?)


CREATE TABLE customer(
    id varchar2(20) primary key, --�����̵�
    NAME VARCHAR2(20), --���̸�
    age NUMBER(3), --������
    tel VARCHAR2(30), --������ó
    addr VARCHAR2(50)--���ּ�
)

drop table customer

insert into customer values('jang','������',20,'02-222-8282','����� ������')

insert into customer values('jian','������',22,'02-333-333','����� �߶���')
commit




select * from customer