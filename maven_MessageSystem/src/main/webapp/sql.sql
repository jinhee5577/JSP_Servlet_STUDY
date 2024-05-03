-- 1. 회원 정보를 관리할수 있는 테이블 생성 --

CREATE TABLE WEB_MEMBER
(   email VARCHAR2(50) primary key,
    pw VARCHAR2(50) NOT NULL,
    tel VARCHAR2(50) NOT NULL,
    address VARCHAR2(100) NOT NULL
);
 
insert into WEB_MEMBER values('admin','1234','오진희', 'AI메타버스센터');

select case when count(*)>0 then 1 else 0 end result from web_member where email=email  


--- 메시지를 관리하기위한 테이블 생성.---
-- 메시지의 번호(PK), 보내는 사람, 받는 사람, 내용, 보낸날짜 --
CREATE TABLE WEB_MEMBER_MESSAGE
(   NUM NUMBER primary key,
    SENDNAME VARCHAR2(50) NOT NULL,  -- 내용들이 다있어야하니
    RECEVIEMAIL VARCHAR2(50) NOT NULL,
    MASSAGE VARCHAR2(100) NOT NULL,
    M_DATE DATE
);

select * from WEB_MEMBER_MESSAGE;

-- 메세지 추가시 자동적으로 NUM를  생성해줄 시퀀스 생성!. --
CREATE SEQUENCE NUM_MESSAGE INCREMENT BY 1 START WITH 1;

INSERT INTO WEB_MEMBER_MESSAGE VALUES(NUM_MESSAGE.NEXTVAL,'CSM','TEST','TEST MESSAGE', SYSDATE);  -- NUMBER.NEXTVAL: 순차적으로 1씩 증가해서 만들겠습니다.
INSERT INTO WEB_MEMBER_MESSAGE VALUES(NUM_MESSAGE.NEXTVAL,'SMHRD','TEST','TEST MESSAGE2', SYSDATE);  -- NUMBER.NEXTVAL: 순차적으로 1씩 증가해서 만들겠습니다.

select * from WEB_MEMBER;
select * from WEB_MEMBER;



-- 게시판 사용을 위한 테이블 생성.--
CREATE TABLE WEB_BOARD
(   NUM NUMBER primary key,  --중복 불가하기위해
    TITEL VARCHAR2(50) NOT NULL,  -- 내용들이 다있어야하니
    WRITER VARCHAR2(50) NOT NULL,
    FILENAME VARCHAR2(100),   -- 파일의 경로
    CONTENT VARCHAR2(100) NOT NULL,
    B_DATE DATE
);

drop table web_board;


select * from WEB_BOARD;


-- 게시글 추가시 자동적으로 NUM를  생성해줄 시퀀스 생성!. --
CREATE SEQUENCE NUM_BOARD INCREMENT BY 1 START WITH 1;








