--输出：set 只能实现单个赋值，select
declare @i int,@a int
--set @a=6
--set @i=3
select @i=80,@a=10
print @i/@a


--输出不同的类型：@age,@name
declare @age int,@name varchar(10)
select @age=18,@name='赵彦'
print '我叫'+@name+'年龄是：'+convert(varchar(10),@age)

--转换函数：convert(类型,变量),"+"是连字符
--if。。。else，case。。。when。。。then。。。end
--格式：case [列名]
--      when  条件  then  结果
---     when  条件  then  结果
--      else  结果
--      end

--while格式：  while(条件)
--             begin
--               t-sql语句
--             end


--索引：是一种物理结构，该结构能够提供以一列或者多列为基础进行快速查找的能力。
-- 创建条件：1.数据量较大时   2.查询多的时候    
--  缺点：当进行插入，更新操作时会影响速度
--分类：聚集索引、非聚集索引、唯一索引、组合索引
--B-树索引：
--聚集索引：行的存储数据与索引的顺序完全相同
--比如：标识列，主键
--特点：一张表中只能有一个聚集索引
--创建条件：1.包含大量的非重复列  2.使用运算符返回一个范围的查询（>,<,<=）
--          3.返回大型结果集的查询  4.经常使用联接（join）

--创建语法：create clustered index 索引名 on 表(字段名)

--字段名：1.where后面经常出现的字段  2.该字段不可以有多个重复值  3. 如果有多个字段在where后面，距离where最近首先被检索

--查看索引：exec sp_help 表名

exec sp_help shop

create clustered index index_date on shop(date)

--非聚集索引：行的存储数据与索引的顺序不完全相同
--一张表中可以有多个非聚集索引。类似书目录
--语法：create nonclustered index 索引名 on 表名(字段名)

create nonclustered index index_gname on shop(name)
exec sp_help shop

--唯一索引：主键会默认创建唯一索引
--格式：create unique index 索引名 on 表名(字段)

 create unique index index_tel on student(stel)
 
 
 --组合索引
 create index index_aa on student(sname,sage)
 
 exec sp_help student
 
 --删除索引
 --格式：drop index 表名.索引名
 drop index student.index_tel
 
 
 --视图：view   就是虚拟表
 --作用：就是实现方便查询
 select sname,cname,degree from student  s left join course  c on s.sno=c.sno left join score sc on c.cno=sc.cno
 where cname is not null
 
 
 --格式：create view 视图名
 --      as
 --      sql语句
 
 
 create view view_stu
 as
 select sname,cname,degree from student  s left join course  c on s.sno=c.sno left join score sc on c.cno=sc.cno
 where cname is not null
 go
 
 --查看视图  格式：exec sp_helptext 视图名
 exec sp_helptext view_stu
 
 --如何使用视图
 select sname,cname  from view_stu
 
 --修改视图
 --alter view 视图名
 --as
 --sql语句
 
 
alter view aa
as
select * from student where sno in (select sno from course where cname='java')


exec sp_helptext aa


select * from aa


--删除视图

 --格式：drop view 视图名
 drop view aa
 
 
 --总结：虚拟表：视图    创建create  修改 alter   删除 drop
 
 
 select * from view_stu_course
 
 
 
 
 
 
 
 
 
