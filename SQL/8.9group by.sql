select * from shopper

--查询买过价格大于100商品的用户信息
select * from shopper where no in(select no from goods where gprice>100)

select * from shopper where no in(2,4)

--查询买过最贵的商品的用户信息
select * from shopper where no =(select top 1 no from goods order by gprice desc)

--查询出厂日期在2011-5-8到2011-8-19的所有商品信息
select * from goods where date>'2011-5-8' and date<'2011-8-19'

--查询手机号码前三位是132的用户信息
select * from shopper where phone like '132%'

----查询买过“饼干”商品的用户信息
select * from shopper where no in (select no from goods where gname like '%饼干%')


--查询总的商品价格，最贵、最便宜、平均价格、商品的统计
--聚合函数：sum(字段名) max(字段名),min(字段名)，avg（字段名），count(字段名)

--查询总的商品价格
select SUM(gprice) as 总的商品价格 from goods 

select min(gprice) as 价格 from goods

--商品的平均价格
select AVG(gprice) as 平均价格 from goods

--查询用户的个数
select COUNT(no) as 个数 from shopper

--分数表中学生的平均成绩
--student表学生的总年龄
--student表中年龄最大是多少
--查询课程表中有多少个选课记录

select  AVG(gprice),date from goods group by date


--分组：group by   一般结合聚合函数较多
--格式：select 聚合函数,字段名 from 表名 [where 条件] group by 字段名 [having 条件]

select * from goods
--查询商品表中各个品牌的平均价格
select AVG(gprice) as 平均价格,gfamous from goods group by gfamous

--查询商品表中各个品牌的总价格超过100
select sum(gprice) as 平均价格,gfamous from goods group by gfamous having sum(gprice)<100

--查询商品表中生产日期在2011-7-1之后各个品牌的平均价格
--分完组之后再过滤就是用having,         where：先过滤再分组

select AVG(gprice) as 平均价格,gfamous from goods where date>'2011-7-1' group by gfamous


--分数：查询出每门课程的最高分          score（scno,degree,cno）
select MAX(degree) as 最高分 ,cno from score group by cno

--select MAX(degree) as 最高分 ,score.cno ,cname  from score 
--inner join course on score.cno=course.cno group by course.cname


--查询student表中每个性别的平均年龄大于28
select AVG(sage) as 平均年龄,ssex from students group by ssex having AVG(sage)>23

--查询student表中各个部门的人员个数
select COUNT(sno) as 个数 ,sdepart from students group by sdepart

--日期函数
--getdate():获得系统当前日期  
--datepart():格式：dateadd(part,number,date)  part:year,month,day,hour,minute,second
--number：正数：加+数字   负数：减+数字    date:指定的日期，字段

--datediff(part,start,end)

insert into  goods values(11,'薯片','上好佳',GETDATE(),3.0,4)


select * from goods

select dateadd(day,4,date) from goods

update goods set date=dateadd(day,4,date)  where gno=2

update goods set date=DATEADD(YEAR,-2,date) where gno=11

select * from students
select * from goods

update students set sbrithday=DATEADD(YEAR,-10,sbrithday) where sno=1



--datediff(part,start,end)

select DATEDIFF(YEAR,sbirthday,GETDATE()) from student where sno=4
select * from student

update students set sage=DATEDIFF(YEAR,sbrithday,GETDATE())

--总结：
--1.聚合函数：5个
--2.group by:分组。例如：各个，每个。。
--3.日期函数：getdate(),dateadd(),datediff()

use studb
select * from score 
select * from course
select * from student
update score set con=5 where scno=5
insert into course values('java',4)
insert into student values ('赵六','男',21,'1982-05-18','13869548569','3G')
insert into student values ('刘七','男',28,'1975-05-28','13869512365','3G')
insert into student values ('赵六','男',21,'1982-05-18','13869564643','3G')
begin
declare @score float
set @score=(select degree from score where cno=(select cno from course where sno=4))
if(@score>95)
print '颁发奖励'
else
print '不颁发奖励'
end
--  通过if。。else if。。。else if 。。else结构实现对分数的等级划分（-90：优，-80：良，-60：合格，否则，差)

  begin 
declare @i int,@s int
set @s=0
set @i=1
  while(@i<=100)
  begin
   set @s=@s+@i
   set @i=@i+1
  end
  print @



  begin 
declare @good varchar(20),@price float,@num int,@id int
set @id=2
set @good=(select gname from 库存 where id=@id)
set @price=(select gprice from 库存 where id=@id)
set @num=4
insert into 订单表 values(@good,@price,@num,@id)
if(@@ERROR=0)

  print '销售成功！'

else
print '销售失败！'
   --嵌套i
    if(@@ROWCOUNT!=0)
  update 库存 set gnumber=gnumber-@num where id=@id
  --print '库存更新成功'

end

 
