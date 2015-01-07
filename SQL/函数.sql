--数学函数：abs():绝对值
--abs(数值|字段)
select ABS(gprice),gname from goods

select ABS(-28.9)

--rand():随机数 产生的随机数范围在 0< =num <1
--rand()

select RAND()*10

--round(数值,精度) ：round(2.55,1)  四舍五入
select ROUND(2.54787,1)

--求0-9之间的随机数

select ROUND(RAND()*9,0)

--3D彩票
select ROUND(RAND()*9,0) as 第一球,ROUND(RAND()*9,0) as 第二球,ROUND(RAND()*9,0) as 第三球

--取整：向上取整(ceiling())，向下取整(floor())
select CEILING(99.000000001)

select FLOOR(1.99999999)
--sqrt():开平方
--sqrt(数值|字段)
select SQRT(4)



--求所有商品的价格整数总和
select ROUND(SUM(gprice),0) from goods
--苹果、口香糖、大果粒酸奶

select floor(SUM(gprice)*39) from goods where gname in('大果粒酸奶','口香糖','苹果')


--字符串函数：
--1.left(列名,n)  从左边取字符个数n位
select LEFT(gname,2) from goods

--2.rigth(列名,n)
select RIGHT(gname,2) from goods

--3,len():求字符长度
select LEN('徐松林你快醒来，别再沉睡不醒！')
alter table shopper add constraint shopper_single check(len(single)<=100)

--4.lower：大写向小写转换   UPPER：小写向大写转换
select LOWER('ASDFGH')

insert into goods values(12,UPPER('coffee'),'雀巢','2011-7-20',19.89,5)

select * from goods

--ltrim():去除左边的空格

select * from goods where gname='苹果'

select * from goods where LTRIM(gname)='薯片'

--rtrim():去除右边的空格
select * from goods where rtrim(gname)='苹果'
--去除左右两边的空格

select * from goods where ltrim(rtrim(gname))='苹果'

--replace(字段,搜索内容,替换字段) : 替换
select REPLACE(gfamous,'蒙牛','伊利') from goods

update goods set gfamous=REPLACE(gfamous,'蒙牛','伊利')
--reverse(字段名)：翻转
select REVERSE(gname) from goods

--substring(字段名,开始位置,个数)：截取字符串 
select SUBSTRING(gname,1,1) from goods


--T_sql：程序设计
--变量声明：declare @变量名 数据类型
declare @name varchar(10)

--赋值：  格式： set 变量名=值
set @name='张三'

--输出：select 变量名 别名


--例子：
declare @num int
set @num=(select COUNT(no) from shopper)
select @num 个数

select * from score
select * from course

--查看考了100分的课程名称
declare @c_no int,@c_name varchar(10)
set @c_no=(select cno from score where degree=100)
set @c_name=(select cname from course where cno=@c_no)
select @c_name  课程名称

--查询买过最贵的商品的用户名称

--查询买过“饼干”商品的用户名称（假设只有一个人买过饼干）