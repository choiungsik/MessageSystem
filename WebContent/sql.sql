1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
   컬럼명 : email / pw / tel / address

drop table web_member;

create table web_member(
email varchar2(100),
pw varchar2(100),
tel varchar2(100),
address varchar2(100));

desc web_member

select * from web_member;






