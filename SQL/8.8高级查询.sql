use studb
--查询男同学选报的课程，要求显示：学生姓名，学号、课程名，电话
select sname,s.sno,cname,stel from student s inner join course c on s.sno=c.sno where s.ssex='男'

--查询年龄大于20女同学选报的课程以及该课程的考试分数，要求显示：学生姓名，学号、课程名，分数
select sname,s.sno,cname,degree from student s inner join course c on s.sno=c.sno 
inner join score sc on sc.cno=c.cno where s.sage>20 and s.ssex='女'

--完全连接 full join .....on
--相当于左连接与右连接的结合

select * from student left join course on student.sno=course.sno

create table stu
(
id int primary key,
name varchar(10) not null
)
insert into stu values(1,'江舜'),(2,'李秀花'),(3,'刘伟'),(4,'李辉'),(5,'黄校') 

create table sco
(
 id int primary key,
 java float,
 sql float,
 sid int,
 date datetime
)
insert into sco values(5,50,86,9,'2011-6-18')

select * from stu
select * from sco

--左链接
select * from stu left join sco on stu.id=sco.sid

select * from stu right join sco on stu.id=sco.sid
--完全连接(查看两张表中分别出现的空值)

select * from stu full join sco on stu.id=sco.sid


--嵌套查询（子查询）
--没有选报课程的学生姓名和学号
--1.左外连接
select s.sname,s.sno from student s left join course  c on s.sno=c.sno where c.cname is null
--2.子查询（显示的字段都在一张表时，可以考虑使用子查询）
--格式：select 字段名，...字段名 from 表名1 where 字段 =/like/in/> (select 字段 from 表名2 [where 条件])
select sname,sno from student where sno  not in(select sno from course)
--注意：where 后面的字段名 必须与 嵌套查询中的字段名个数和字段名保持一致


--查询选报java课的学生姓名和学号（子查询）
--1.选报java课的学生   select sno from course where cname='java'
--2.从student表中找出对应项: select sname,sno from student where sno in (1,2,3,4,5)

select sname,sno from student where sno in (select sno from course where cname='java')

--查询选报英语课的学生姓名\学号\手机号码
--查询分数大于90分的课程名和课程编号













