
struts2基本环境配置
	struts2配置的jar
		commons-logging-1.1.1.jar
		freemarker-2.3.16.jar
		ognl-3.0.1.jar
		struts2-core-2.2.3.jar
		xwork-core-2.2.3.jar
		javassist-3.11.0.GA.jar
		commons-lang-2.5.jar

		commons-fileupload-1.2.2.jar
		commons-io-2.0.1.jar

	web.xml
		<?xml version="1.0" encoding="UTF-8"?>
		<web-app version="2.4" 
			xmlns="http://java.sun.com/xml/ns/j2ee" 
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee 
			http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
			<filter>
				<filter-name>struts2</filter-name> 
				<!-- StrutsPrepareAndExecuteFilter是自2.1.3开始就替代了FilterDispatcher -->
				<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class> 
			</filter>
			
			<filter-mapping>
				<filter-name>struts2</filter-name> 
				<!-- 测试时把 / * 中间的空格去掉 -->
				<url-pattern>/ *</url-pattern> 
			</filter-mapping>  
		</web-app>

	//struts.xml文件存放在WEB-INF/classes目录下
	struts.xml
		<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
        "http://struts.apache.org/dtds/struts-2.0.dtd">
		<struts>
			<package name="bwie" extends="struts-default">
				<!-- 请求地址 http://localhost:8080/struts2/login.action -->
				<action name="login" class="com.test.UserAction">
					<result name="sucess">suc.jsp</result>
					<result name="error">fail.jsp</result>
				</action>
			</package>
		</struts>

	Action
		package com.test;
		public class UserAction {	
			private String username = "";//获取页面用户名
			private String password = "";//获取页面密码		
			public String execute()
			{
				System.out.println(username + "__" + password);
				if (username.equals("admin") && password.equals("admin"))
				{
					return "sucess";
				}
				else
				{
					return "error";
				}
			}			
			public String getPassword() {
				return password;
			}			
			public void setPassword(String password) {
				this.password = password;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
		}

OGNL
	
	OGNL上下文中的根对象可以直接访问，不需要使用任何特殊的“标记”，而引用上下文中的其他对象则需要使用“#”来标记。
		由于值栈是上下文中的根对象，因此可以直接访问。
		Struts2框架总是把Action实例放在栈顶。因为Action在值栈中，而值栈又是OGNL中的根，
		所以引用Action的属性可以省略“#”标记，这也是为什么我们在结果页面中可以直接访问Action的属性的原因。

	“#”主要有三种用途：

		1. 访问OGNL上下文和Action上下文，#相当于ActionContext.getContext()；下表有几个ActionContext中有用的属性：  
			名称			作用																例子 
			parameters		包含当前HTTP请求参数的Map											#parameters.id[0]作用相当于request.getParameter("id") 
			request			包含当前HttpServletRequest的属性（attribute)的Map					#request.userName相当于request.getAttribute("userName") 
			session			包含当前HttpSession的属性（attribute）的Map							#session.userName相当于session.getAttribute("userName") 
			application		包含当前应用的ServletContext的属性（attribute）的Map				#application.userName相当于application.getAttribute("userName") 
			attr			用于按request > session > application顺序访问其属性（attribute）	#attr.userName相当于按顺序在以上三个范围（scope）内读取userName属性，直到找到为止 

		2. 用于过滤和投影（projecting)集合，如books.{?#this.price<100}； 
			
			1.集合的投影（过滤）有以下三种方式：
				a.“?#”：投影（过滤）所有符合条件的集合，如：users.{?#this.age > 19}；
				b.“^#”：投影（过滤）第一个符合条件的元素，如：users.{^#this.age > 19}；
				c.“$#”：投影（过滤）最后一个符合条件的元素，如：users.{$#this.age > 19} 。
			2.“this”表示集合中的元素；
			3.投影（过滤）操作返回的是一个集合，可以使用索引取得集合中指定的元素，如：users.{?#this.age > 19}[0]。

		3. 构造Map，如#{'foo1':'bar1', 'foo2':'bar2'}。

	“%” 将字符串变量的值按照OGNL表达式解析。也就是说字符串中#将按照特殊字符处理，仅此作用。：

		<s:set name="foobar" value="#{'foo1':'bar1', 'foo2':'bar2'}" />	 
		<p><s:url value="#foobar['foo1']" /></p>
		<p><s:url value="%{#foobar['foo1']}" /></p>

		输出：
		#foobar['foo1']
		bar1
	
	“$”有两个主要的用途
		用于在国际化资源文件中，引用OGNL表达式，例子请参考《在Struts 2.0中国际化(i18n)您的应用程序》 
		在Struts 2配置文件中，引用OGNL表达式，如 
		<action name="AddPhoto" class="addPhoto">
            <interceptor-ref name="fileUploadStack" />            
            <result type="redirect">ListPhotos.action?albumId=${albumId}</result>
        </action>

注解
	struts.xml存放在src目录
	Action必须存在*.action包内

struts2+spring+hibernate整合

	struts.xml
		<!-- 把struts2交给spring来管理 -->
		<constant name="struts.objectFactory" value="spring"></constant>

if elseif else 执行基本的条件流转。
	test:决定标志里内容是否显示的表达式

	<%request.setAttribute("name", request.getParameter("name")); %>		
	<s:if test="#request.name == 'Max'">
		Max's file here
	</s:if>
	<s:elseif test="#request.name == 'Scott'">
		Scott's file here
	</s:elseif>
	<s:else>
		Other's file here
	</s:else>

struts2 修改 struts.xml的存储位置
	<filter>
		<filter-name>struts2</filter-name> 
		<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
		
		<init-param> 
			<!-- 声明 加载struts.xml文件 -->  
			<param-name>config</param-name>   
			<param-value>
				struts-default.xml,
				../config/struts.xml
			</param-value>
		</init-param> 
	</filter>

package
	配置
	<package name="bwie"  extends="struts-default" namespace="/t">
		<action name="test" class="com.bwie.Test2">
			<result>/s.jsp</result>
		</action>
	</package>
	调用
	<s:form action="test" namespace="/t"></s:form>

Action接口 常量说明
	com.opensymphony.xwork2.Action 常量说明
	SUCCESS = "success"; 表示动作执行成功并应该把结果视图显示给用户
	NONE = "none";  动作执行成功，但不把任何结果视图显示给用户
	ERROR = "error"; 动作执行不成功，并应该把一个报错视图显示给用户
	INPUT = "input"; 表示输入验证失败并把输入的界面重新显示给用户
	LOGIN = "login"; 表示动作没有执行，因为用户没有登录，并应把登录视图显示给用户

上传文件
	lib
		commons-fileupload-1.2.jar
		commons-io-1.3.2.jar
	jsp页面
		<s:form action="HelloWorld2" enctype="multipart/form-data" method="post">
			<s:file name="upFile"></s:file>
			<s:submit></s:submit>
		</s:form>
	action
		private File upFile = null;
		private String contentType = null;
		private String fileName = null;
		/**
		 * 本方法会自动设置
		 */
		public void setUpFileContentType(String contentType)  {
			this.contentType = contentType;
		} 
		
		/**
		 * 本方法会自动设置
		 */
		public void setUpFileFileName(String fileName)  {
			this.fileName = fileName;
		}

		public File getUpFile() {
			return upFile;
		}

		public void setUpFile(File upFile) {
			this.upFile = upFile;
		}

		public String upFile()
		{

			System.out.println(this.contentType);//文件类型
			String dataDir = ServletActionContext.getServletContext().getRealPath("/");
			String imageFileName = new Date().getTime() + getExtention(fileName);
			File saveFile = new File(dataDir + "/upFile/" + imageFileName);		
			upFile.renameTo(saveFile);
			return "upFileDefault";
		}
		
		private String getExtention(String fileName)  {
			int pos = fileName.lastIndexOf( "." );
			return fileName.substring(pos);
		}

执行Action的某一方不法
	http://localhost:8181/struts2/login!test.action  执行login action里的test方法

国际化
	properties文件 存在于src目录
		struts.properties  声明国际化文件
			struts.custom.i18n.resources=globalMessages
		globalMessages_zh.properties	国际化数据
			HelloWorld=欢迎您！！
		globalMessages_en.properties	国际化数据
			HelloWorld=Hello World value!!!!!
	jsp调用
		<s:text name="HelloWorld"/><br>
    	<s:property value="%{getText('HelloWorld')}"/>
	

页面获取get/post参数
	<s:property value="#parameters.p"/>

theme
	struts2中theme属性包括xhtml,html,simple,ajax 。默认是xhtml

	theme：设置struts2标签的主题，默认为xhtml。
	theme=xhtml时：会默认额外生成tr,td。
	theme=simple时：就生成标签所对应的html标签形式。

	struts2中form的theme的修改 
		在的html页面中使用struts2的ui tag的时候一般都要把theme设置为simple，在每个tag都设置比较麻烦。此时，我们可以使用如下两种方法修改默认值xhtml：
		（1）在struts.xml文件中修改默认值：<constant name="struts.ui.theme" value="simple"/>；
		（2）在struts.properties文件中，设置以下语句：struts.ui.theme=simple

错误处理
	Javassist library is missing in classpath! Please add missed dependency!
	在项目里加入：javassist-3.11.0.GA.jar

get乱码问题
	javascript:
	var str = encodeURI(encodeURI('中国'));

	action:
	str = URLDecoder.decode(URLDecoder.decode(str, "utf-8"),"utf-8");



	

	

struts2标签html转码 加入escape="false"
	<s:property value="username" escape="false"/>

标签调用类方法(不好使)

	方法一：

	<s:set name="str" value="'Hello World'"></s:set>

	<s:property value="%{@com.common.Constant@func(#str)}"/>

	func是类com.common.Constant里面的一个静态方法

	str是动态的参数

	方法二：

	<s:bean name="com.common.StrutsHelper" id="helper" />

	<s:set name="str" value="'Hello World'"></s:set>

	<s:property value="#helper.func(#str)" />

	func是类com.common.StrutsHelper里面的一个普通方法

	str是动态方法

	s:bean其实是对类StrutsHelper的实例化，跟方法一有些区别，方法一里的函数必须是静态的






