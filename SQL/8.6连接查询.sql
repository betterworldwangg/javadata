use studb

select * from student
select * from course

--内连接：inner join....on
--格式：select 列名1，列名2，...列名 n from 表1 inner join 表2 on 表1.列名=表2.列名
--理解：on 表1.列名=表2.列名   ----》外键关系

--查询学生选报了哪些课程
select sname,stel,cname from student inner join course on student.sno=course.sno

--表的别名
select sname,stel,cname from student  s inner join course  c on s.sno=c.sno

--查询年龄在20-25之间的学生选报了哪些课程
select sname,stel,cname from student  s inner join course  c on s.sno=c.sno 
where s.sage  between 20 and 25

--列的别名 as
select sname as 学生姓名,stel as 联系方式 ,cname as 选报课程 from student  s inner join course  c on s.sno=c.sno 
where s.sage  between 20 and 25


--查询每门课程的分数course，score，显示：课程名，课程分数
select cname as 课程名,degree as 分数 from course c inner join score s on c.cno=s.cno
--多表连接
--格式：格式：select 列名1，列名2，...列名 n from 表1 inner join 表2 on 表1.列名=表2.列名 inner join 表3 on 表[1,2].列名=表3.列名
--查询学生选报的课程考了多少分  显示：学生学号，姓名，课程名，分数
select s.sno,sname,cname,degree from student s inner join course c on s.sno=c.sno 
inner join score sc on c.cno=sc.cno

update score set cno=2 where scon=6
--查询曹可欣报的课程考了多少分，要求显示：学生学号、学生姓名、课程名、分数
select s.sno,sname,cname,degree from student s inner join course c on s.sno=c.sno 
inner join score sc on c.cno=sc.cno where sname like '[曹,王]%'


--外连接:左外连接和右外连接
--左连接:left join...on  右连接：right join....on
--格式:select 列名1，列名2,....列名n from 表1 left join 表2 on 表1.列名=表2.列名

--学生选报课程
--null的查询使用格式: where 字段 is [not] null
select student.sno,sname,cname from student left join course on student.sno=course.sno where cname is not null

--右外连接
select student.sno,sname,cname from course right join student on student.sno=course.sno





