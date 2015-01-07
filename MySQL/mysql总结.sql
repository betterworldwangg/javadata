

事务特性
	原子性：组成事务处理的语句形成了一个逻辑单元，不能只执行其中的一部分
	一致性：在事务处理执行之前和之后，数据是一致的。
	隔离性：一个事务处理对另一个事务处理没有影响。
	持续性：当事务处理成功执行到结束的时候，其效果在数据库中被永久纪录下来。

创建表
    SET FOREIGN_KEY_CHECKS=0;

    DROP TABLE IF EXISTS user;
    CREATE TABLE user (
        id int(50) NOT NULL auto_increment,
        username varchar(50) default NULL,
        password varchar(50) default NULL,
        PRIMARY KEY  (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    DROP TABLE IF EXISTS user_info;
    CREATE TABLE user_info (
        id int(11) NOT NULL auto_increment,
        user_id int(11) default NULL,
        address varchar(500) default NULL,
        c_date date default NULL,
        PRIMARY KEY  (id),
        KEY fk_user_ui (user_id),
        KEY ui_c_date_index (c_date),
        CONSTRAINT fk_user_ui FOREIGN KEY (user_id) REFERENCES user (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

常用
    delimiter /   修改定界符
	CREATE DATABASE menagerie;     创建数据库
	show databases;		显示所有的库
	user test;	选择库
	show tables;	显示所有的表
	DESCRIBE tablename;   显示表的定义信息
	select version(); 显示版本信息
	select CURRENT_DATE;	显示当前日期
	select curdate();
	select now();	显示当前日期时间
	select user();	显示当前登录用户
	SELECT DISTINCT owner FROM pet;	去除重复项
	SELECT DATABASE();	当前选中的库
	select @a:= username from user where id = 1;	把username值赋给变量@a

自定义函数
    DROP FUNCTION IF EXISTS hello;
    CREATE FUNCTION hello(s varchar(20)) RETURNS varchar(1000)
    BEGIN
         declare t varchar(1000) default '';
         declare id1 int;
         declare username1 varchar(50);
         declare no_more_departments int;

         declare cur1 cursor
         for
            select id,username from test;

         DECLARE CONTINUE HANDLER FOR NOT FOUND SET no_more_departments=1;
         open cur1;

          REPEAT
               FETCH cur1 INTO id1, username1;
               if (no_more_departments is null) then
                set t = concat(t,';',id1,'-',username1);
               end if;
          until no_more_departments END REPEAT;

         close cur1;
         RETURN t;
    END;
    调用
    select hello('') t from dual

存储过程
    delimiter //
    CREATE PROCEDURE p1 (OUT param1 INT)
    BEGIN
      SELECT COUNT(*) INTO param1 FROM t;
    END

    调用
    call p1(@a);
    select @a

视图
    CREATE VIEW v AS SELECT * FROM user;
    调用
    select * from v

触发器

	CREATE TABLE account (acct_num INT, amount DECIMAL(10,2));
	CREATE TRIGGER ins_sum BEFORE INSERT ON account
	FOR EACH ROW SET @sum = @sum + NEW.amount;

	使用别名OLD和NEW，能够引用与触发程序相关的表中的列。OLD.col_name在更新或删除它之前，引用已有行中的1列。NEW.col_name在更新它之后引用将要插入的新行的1列或已有行的1列。

root不能远程登录
    UPDATE mysql.user SET Host='%' WHERE Host='localhost';
    GRANT ALL PRIVILEGES ON *.* TO root@"%" ;
    FLUSH PRIVILEGES;

字符串类函数

    CHARSET(str) //返回字符串字符集
    CONCAT (string2  [,... ]) //连接字串
    INSTR (string ,substring ) //返回substring首次在string中出现的位置,不存在返回0
    LCASE (string2 ) //转换成小写
    LEFT (string2 ,length ) //从string2中的左边起取length个字符
    LENGTH (string ) //string长度
    LOAD_FILE (file_name ) //从文件读取内容
    LOCATE (substring , string  [,start_position ] ) 同INSTR,但可指定开始位置
    LPAD (string2 ,length ,pad ) //重复用pad加在string开头,直到字串长度为length
    LTRIM (string2 ) //去除前端空格
    REPEAT (string2 ,count ) //重复count次
    REPLACE (str ,search_str ,replace_str ) //在str中用replace_str替换search_str
    RPAD (string2 ,length ,pad) //在str后用pad补充,直到长度为length
    RTRIM (string2 ) //去除后端空格
    STRCMP (string1 ,string2 ) //逐字符比较两字串大小,
    SUBSTRING (str , position  [,length ]) //从str的position开始,取length个字符,
    TRIM([[BOTH|LEADING|TRAILING] [padding] FROM]string2) //去除指定位置的指定字符
    UCASE (string2 ) //转换成大写
    RIGHT(string2,length) //取string2最后length个字符
    SPACE(count) //生成count个空格

数学类函数

    ABS (number2 ) //绝对值
    BIN (decimal_number ) //十进制转二进制
    CEILING (number2 ) //向上取整
    CONV(number2,from_base,to_base) //进制转换
    FLOOR (number2 ) //向下取整
    FORMAT (number,decimal_places ) //保留小数位数
    HEX (DecimalNumber ) //转十六进制
    LEAST (number , number2  [,..]) //求最小值
    MOD (numerator ,denominator ) //求余
    POWER (number ,power ) //求指数
    RAND([seed]) //随机数
    ROUND (number  [,decimals ]) //四舍五入,decimals为小数位数]
    SIGN (number2 ) //返回符号,正负或0
    SQRT(number2) //开平方

日期时间类函数

    ADDTIME (date2 ,time_interval ) //将time_interval加到date2
    CONVERT_TZ (datetime2 ,fromTZ ,toTZ ) //转换时区
    CURRENT_DATE (  ) //当前日期
    CURRENT_TIME (  ) //当前时间
    CURRENT_TIMESTAMP (  ) //当前时间戳
    DATE (datetime ) //返回datetime的日期部分
    DATE_ADD (date2 , INTERVAL d_value d_type ) //在date2中加上日期或时间
    DATE_FORMAT (datetime ,FormatCodes ) //使用formatcodes格式显示datetime
    DATE_SUB (date2 , INTERVAL d_value d_type ) //在date2上减去一个时间
    DATEDIFF (date1 ,date2 ) //两个日期差
    DAY (date ) //返回日期的天
    DAYNAME (date ) //英文星期
    DAYOFWEEK (date ) //星期(1-7) ,1为星期天
    DAYOFYEAR (date ) //一年中的第几天
    EXTRACT (interval_name  FROM date ) //从date中提取日期的指定部分
    MAKEDATE (year ,day ) //给出年及年中的第几天,生成日期串
    MAKETIME (hour ,minute ,second ) //生成时间串
    MONTHNAME (date ) //英文月份名
    NOW (  ) //当前时间
    SEC_TO_TIME (seconds ) //秒数转成时间
    STR_TO_DATE (string ,format ) //字串转成时间,以format格式显示
    TIMEDIFF (datetime1 ,datetime2 ) //两个时间差
    TIME_TO_SEC (time ) //时间转秒数]
    WEEK (date_time [,start_of_week ]) //第几周
    YEAR (datetime ) //年份
    DAYOFMONTH(datetime) //月的第几天
    HOUR(datetime) //小时
    LAST_DAY(date) //date的月的最后日期
    MICROSECOND(datetime) //微秒
    MONTH(datetime) //月
    MINUTE(datetime) //分

优化
    in ->  exists
        select * from A where cc in (select cc from B)
        select * from A where exists(select cc from B where cc=A.cc)

备份
    备份一个库
        d:\mysql\bin>mysqldump -u root -p db_name > f:\1.sql

    备份一个库下的多个表
        d:\mysql\bin>mysqldump -u root -p db_name table1 table2 > f:\1.sql

    备份多个库
        d:\mysql\bin>mysqldump -u root -p -B db_name1 db_name2 > f:\1.sql

    备份所个库
        d:\mysql\bin>mysqldump -u root -p -A > f:\1.sql

还原
    d:\mysql\bin>mysql -u root -p db_name < f:\1.sql

    mysql> use dbname;
    mysql>source f:\1.sql;

两表插入
	insert into ttt (num) select t2.num from ttt t2 where t2.id = 2













