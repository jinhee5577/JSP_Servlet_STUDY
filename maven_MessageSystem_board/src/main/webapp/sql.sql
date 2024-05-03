-- 1-1. ȸ�������� ������ ������ �� �ִ� 'web_member'���̺��� ����ÿ�.
--    �÷��� : email(pk) / pw / tel / address
-- 	  ������Ÿ�� : varchar2(100)
create table web_member(
	email varchar2(100) primary key,
	pw varchar2(100),
	tel varchar2(100),
	address varchar2(100)
);

-- 1-2. test�� �ֱ�
insert into web_member values('test', 'test', 'test', 'test');

-- 1-3. test�� ��ȸ�ϱ�
select * from web_member;

commit


-- 2-1. �޽��� ������ ������ �� �ִ� 'web_message'���̺��� ����ÿ�.
-- �÷��� : num(pk)/ sendName / receiveEmail / message/ m_date
-- ������Ÿ�� : number / varchar2(100) / date

-- 2-2. num�� �Է��� ������ ���� : num_message

-- 2-3. test�� �ֱ�

-- 2-4. test�� ��ȸ�ϱ�


-- 3-1. �Խñ� ������ ������ �� �ִ� 'web_board' ���̺��� ����ÿ�
-- �÷��� : num(pk)/ title / writer/ filename / content / b_date
-- ������Ÿ�� : number / varchar2(100) / date
create table web_board(
	num number primary key,
	title varchar2(100),
	writer varchar2(100),
	filename varchar2(100),
	content varchar2(100),
	b_date date
);

-- 3-2. num�� �Է��� ������ ���� : num_board
create sequence num_board start with 1 increment by 1;

-- 3-3. test�� �ֱ�
insert into web_board values(num_board.nextval, 'test', 'test', 'test', 'test',sysdate);
insert into web_board values(num_board.nextval, 'test2', 'test2', 'test2', 'test2',sysdate);

-- 3-4. test�� ��ȸ�ϱ�
select * from web_board;



commit


-- 승호샘 버전 아래 테이블 추가해야함. web_message 생성이 없었음.

create table web_message(
   num number primary key,
   sendName varchar2(50) not null,
   receiveEmail varchar2(50) not null,
   message varchar2(100) not null,
   m_date date
);


SELECT * FROM web_message;

CREATE SEQUENCE num_message START WITH 1 INCREMENT BY 1;

insert into web_message VALUES(num_message.nextval,'csm','tests','test Message1',sysdate);





