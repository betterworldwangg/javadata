
Session创建
	// 找到Hibernate配置
	Configuration config = new Configuration().configure() ;
	// 从配置中取出SessionFactory
	SessionFactory factory = config.buildSessionFactory() ;
	// 从SessionFactory中取出一个Session
	Session session = factory.openSession();

hibernate.cfg.xml
	显示sql语句 <property name="show_sql">true</property> 
	自动提交保存 <property name="connection.autocommit">true</property>

one-to-one 映射
	<one-to-one name="hright" class="com.bwie.oa.entity.HRight" foreign-key="id"></one-to-one>  另一张表的主键
	**************只能主键对主键，指定foreign-key="id"不起作用

many-to-many

	<set name="husers" table="h_user_right" inverse="false" cascade="all"> table关系表, inverse="false" 当前关系表由本类来维护,cascade="all" 影响所有的表
		<key>
			<column name="right_id" /> right_id 关系表列
		</key>
		<many-to-many class="com.bwie.oa.entity.HUser" column="user_id" /> user_id 关系表列
	</set>

one-to-many
	 <set name="h2s" inverse="true">
            <key>
                <column name="h1_id" />//h1_id代表外键
            </key>
            <one-to-many class="com.bwie.entity.H2" />
     </set>

many-to-one
	<many-to-one name="h1" class="com.bwie.entity.H1" fetch="select">
            <column name="h1_id" />
    </many-to-one>

inverse,cascade 区别
	1.cascade="..."？

	cascade属性并不是多对多关系一定要用的，有了它只是让我们在插入或删除对像时更方便一些，只要在cascade的源头上插入或是删除，所有cascade的关系就会被自己动的插入或是删除。便是为了能正确的cascade，unsaved- value是个很重要的属性。

	Hibernate通过这个属性来判断一个对象应该save还是update，如果这个对象的id是 unsaved-value的话，那说明这个对象不是persistence object要save（insert)；如果id是非unsaved-value的话，那说明这个对象是persistence object（数据库中已存在），只要update就行了。saveOrUpdate方法用的也是这个机制。

	2.inverse="ture"?

	inverse 属性默认是false的，就是说关系的两端都来维护关系。这个意思就是说，如有一个Student, Teacher和TeacherStudent表，Student和Teacher是多对多对多关系，这个关系由TeacherStudent这个表来表现。那么什么时候插入或删除TeacherStudent表中的记录来维护关系呢？在用hibernate时，我们不会显示的对 TeacherStudent表做操作。

	对TeacherStudent的操作是hibernate帮我们做的。hibernate就是看 hbm文件中指定的是"谁"维护关系，那个在插入或删除"谁"时，就会处发对关系表的操作。前提是"谁"这个对象已经知道这个关系了，就是说关系另一头的对象已经set或是add到"谁"这个对象里来了。前面说过inverse默认是false，就是关系的两端都维护关系，对其中任一个操作都会处发对表系表的操作。当在关系的一头，如Student中的bag或set中用了inverse＝"true"时，那就代表关系是由另一关维护的（Teacher）。就是说当这插入Student时，不会操作TeacherStudent表，即使Student已经知道了关系。只有当 Teacher插入或删除时才会处发对关系表的操作。

	所以，当关系的两头都用inverse="true"是不对的，就会导致任何操作都不处发对关系表的操作。当两端都是inverse="false"或是default值是，在代码对关系显示的维护也是不对的，会导致在关系表中插入两次关系。在一对多关系中inverse就更有意义了。在多对多中，在哪端inverse="true"效果差不多（在效率上）。但是在一对多中，如果要一方维护关系，就会使在插入或是删除"一"方时去update"多"方的每一个与这个"一"的对象有关系的对象。

	而如果让"多"方面维护关系时就不会有update操作，因为关系就是在多方的对象中的，直指插入或是删除多方对象就行了。当然这时也要遍历"多"方的每一个对象显示的操作修关系的变化体现到DB中。不管怎样说，还是让"多"方维护关系更直观一些。 

	3.cascade和inverse有什么区别？

	可以这样理解，cascade定义的是关系两端对象到对象的级联关系；而inverse定义的是关系和对象的级联关系。在一对多映射中，一的一方要设<set (inverse="false") casecade="save-update" />，多的一方要设<many-to-one inverse=true (casecade="none") />
	Wenic的blog:Wenic的blog:http://www.matrix.org.cn/blog/wenic705
	－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－

	这个是我做的用例。测试cascade和inverse.分析结果以及具体hibernate sql都在，比较容易看明白。
	希望不是很明白的看看，加深印象。
	小弟学识浅薄，如果有不对的地方，请指出来，谢谢！~
	测试环境：Eclispe，用断点测试。
			  数据库是SQLServer2000.

	Area.hbm.xml


	<?xml version="1.0" encoding="utf-8"?><!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 2.0//EN" "http://hibernate.sourceforge.net/hibernate-mapping-2.0.dtd"; ><hibernate-mapping><class name="net.villion.model.test.Area" table="r_area"><id column="ID" type="long" name = "id" length="10" unsaved-value="null"> <generator class = "native"/></id><property column="name" name="name" type="string"/><many-to-one name="state" class="net.villion.model.test.State" cascade="all"> <column name="stateid" index="index_area_state"/></many-to-one></class></hibernate-mapping>State.hbm.xml<?xml version="1.0" encoding="utf-8"?><!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 2.0//EN" "http://hibernate.sourceforge.net/hibernate-mapping-2.0.dtd"; ><hibernate-mapping><class name="net.villion.model.test.State" table="r_state"><id column="ID" type="long" name = "id" length="10" unsaved-value="null"> <generator class = "native"/></id><property column="name" name="name" type="string"/><set name="areas" lazy="true" cascade="all" inverse="false"> <key column="stateid"/> <one-to-many class="net.villion.model.test.Area"/></set></class></hibernate-mapping>



	我们主要看inverse,cascade级联的设置。
	当State.hbm.xml inverse = "false" cascade = "all"

	//添加//code   StateDAO sdao =(StateDAO) ctx.getBean("stateDAO");AreaDAO adao = (AreaDAO)ctx.getBean("areaDAO");              Area a3 = new Area();a3.setName("NewYork");Area a4 = new Area();a4.setName("Frolida");State s2 = new State();s2.setName("America");  Set set = new HashSet();set.add(a3);set.add(a4);s2.setAreas(set);sdao.saveObject(s2);      //sql:Hibernate: insert into r_state (name) values (?)Hibernate: insert into r_area (name, stateid) values (?, ?)Hibernate: insert into r_area (name, stateid) values (?, ?)Hibernate: update r_area set stateid=? where ID=?Hibernate: update r_area set stateid=? where ID=?


	//当State.hbm.xml inverse = "false" cascade = "none"(注意我们操作的是State)

	//sql: insert into r_state (name) values (?)

	Hibernate: update r_area set stateid=? where ID=?
	org.springframework.dao.InvalidDataAccessApiUsageException: object references an unsaved transient instance

	这时候更新area的时候由于area,并未级联插入所以找不到报错。所以这样设置还是会更新Area的stateid
	接着上面的说，我们要看当设置改变时的sql变化。
	上面就说明了cascade="all" 时候能级联插入，而none的时候只是维持两者之间的关系（inverse="false"）。
	上面两种情况的删除又不一样了，但是一个道理
	cascade="all"时，两个表数据都级联删除了。

	而cascade="none"时
	Hibernate: update r_area set stateid=null where stateid=?
	Hibernate: delete from r_state where ID=?说明它只是维持关系。

	而当上面的inverse ="true"时 cascade="none"时
	sql: insert into r_state (name) values (?)
	只插入一条State,不会插入Area表了。
	删除时
	Hibernate: delete from r_state where ID=?
	org.springframework.dao.DataIntegrityViolationException: (Hibernate operation): data integrity violated by SQL ''; nested exception is com.jnetdirect.jsql.u: DELETE 语句与 COLUMN REFERENCE 约束 'FKC7F1003A8EEBF16C' 冲突。该冲突发生于数据库 'hd'，表 'r_area', column 'stateid'。
	com.jnetdirect.jsql.u: DELETE 语句与 COLUMN REFERENCE 约束 'FKC7F1003A8EEBF16C' 冲突
	由于没有维护数据库关系，引起外键冲突报错。


	inverse ="true"时 cascade="all"时
	sql:
	Hibernate: insert into r_state (name) values (?)
	Hibernate: insert into r_area (name, stateid) values (?, ?)
	Hibernate: insert into r_area (name, stateid) values (?, ?)
	全部级联插入,但r_area表中stateid是null。
	删除时。
	Hibernate: delete from r_area where ID=?
	Hibernate: delete from r_area where ID=?
	Hibernate: delete from r_state where ID=?
	级联删除。


	所以总结一下 ，cascade 是级联的程度，而inverse="false|ture" 是指是否维持两个实体的关系。（两个表的外键）。

cascade值
	cascade="all|none|save-update|delete

mysql乱码
	jdbc.url=jdbc:mysql://localhost:3306/test?&amp;useUnicode=true&amp;characterEncoding=GBK&amp;mysqlEncoding=gbk

fetch
	fetch策略用于定义 get/load一个对象时，如何获取非lazy的对象/集合。  这些参数在Query中无效。

主键sequences
	hibernate_sequence

	<id name="id" column="ID">      
		<generator class="sequence">      
			<param name="sequence">DEPARTMENT_ID_SEQ</param>      
		</generator>      
    </id>

	注解
		@GeneratedValue
		@SequenceGenerator(name="aaa_sequence")//可以省略，省略使用默认hibernate_sequence

MyEclipse连接oracle:invalid or unknown NLS parameter value specified 错误

	在本机控制面板中修改区域和语言选项，把"区域选项"中的"标准和格式"自定义为"英语(美国)"; 
	重启MyEclipse，查看help>About MyEclipse Enterprise Workbench>Configuration Details 
	查看其中的两个值: 
	osgi.nl=en_US 
	user.language=en 










