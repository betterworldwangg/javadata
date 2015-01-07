其他
	<a href="javascript:void(0)">全部评论</a>
	<a href="javascript:;">全部评论</a>

javascript 改变css
	<style>
		.select{}
	</style>
	var l2 = document.getElementById('l2');
	l2.className = "select";

JavaScript
    <script type="text/javascript" src="js/common.js"></script>
    前身是 Live Script
    正式名称：ECMAScript
    ECMAScript-262是JavaScript标准，基于网景（Netscape）公司提出JavaScript语言和微软公司提出的JScript语言
    ECMA开始于1996年，在1997年7月，采纳了首个版本，1998年，该标准成为了国际ISO标准

    javascript基于对象和事件驱动
    javascript语言特点：
        1.简单性
        2.动态性
        3.跨平台性
        4.节省CGI的交互时间
        5.安全性
	<script language="javascript" type="text/javascript"></script>
		language 老版本
		type 推荐写法

常用关键字
	innerHTML
	innerText
	id.style.display = 'dispaly';
	id.style.display = 'none';
	setInterval("fun()",1000);//一秒钟执行一次函数fun()

数据类型
	3种基本数据类型
		字符串 string
		数值（整数和实数）number
			var i = 09;//八进制
			var j = 0x17;//十六进制
		布尔 boolean
	2种复合数据类型
		对象
		数组
	2种特殊数据类型
		空 null
		undefined

	数据类型转换：
		Number -----> String
			var str = String(num); //使用构造函数
			var str = num.toString();
		String -----> Number
			var num = Number(str); //使用构造函数
			var num = str * str; //自动转换
			var num = str - 0; //但是+0则不行
			var num = parseInt(str); //默认第二参数为基数10，以数字开头的字符均可提取数字，失败返回NaN
			parseFloat(str);
		Boolean -----> Number、String
			Number: true --> 1; false --> 0
			String: true --> "true"; false --> "false"
		Number、String -----> Boolean
			Number: 0、NaN --> false; 其他数字 --> ture
			String: 空值和未定义 --> false; 未空（对象、叔组、函数) --> ture
			var bool = Boolean(x); //构造函数
			var bool = !!x;

		将字符串转换为整数
		var int=parseInt("字符串")
		将字符串转换为浮点数
		var float=parseFloat("字符串")
		将数值转化成字符串
		toString(11);

		数值与字符串相加：将数值强制转换为字符串。
		布尔值与字符串相加：将布尔值强制转换为字符串。
		数值与布尔值相加：将布尔值强制转换为数值。

常规函数
    document.write("");输出信息到页面
	javascript常规函数：
        (1)alert函数：显示一个警告对话框，包括一个OK按钮。
        (2)confirm函数：显示一个确认对话框，包括OK、Cancel按钮。
        (3)escape函数：将字符转换成Unicode码。
        (4)eval函数：计算表达式的结果。
        (5)isNaN函数：测试是(true)否(false)不是一个数字。
        (6)parseFloat函数：将字符串转换成符点数字形式。
        (7)parseInt函数：将符串转换成整数数字形式(可指定几进制)。
        (8)prompt函数：显示一个输入对话框，提示等待用户输入。例如：
			<script language="javascript">
			<!--
				alert("输入错误");
				prompt("请输入您的姓名","姓名");
				confirm("确定否！");
			//-->
			script>
        (9)unescape函数：解码由escape函数编码的字符。

		typeof() 返回一个用来表示表达式的数据类型的字符串
			返回值有六种可能："number"、"string"、"boolean"、"object"、"function" 和 "undefined"。

Error
	try
		x = y   // 产生错误。
	catch(e){   // 创建局部变量 e。
		document.write(e)   // 打印 "[object Error]".
		document.write(e.number & 0xFFFF)   // 打印 5009。
		document.write(e.description)   // 打印 "'y' is undefined".
	}

函数声名
    function t()
    {
    }
    t();

    function a()
    {
        for(var i = 0; i < arguments.length; i++)
        {
            alert(arguments[i]);
        }
    }
    a(1,2,3);

    var f = function()
    {
        alert(111);
    }
    f();

    (function()
    {
        alert('aaa');

    })();

	window.onload = function()
	{
		alert(1);
	}

数组
    声明
        var a1 = new Array();
        var a2 = new Array(3);
        var a3 = new Array(1,2,3);
        var a4 = [1,2,3];

	javascript数组函数包括以下4个函数：
	(1)join函数：转换并连接数组中的所有元素为一个字符串。例:
	function JoinDemo()
	{
	var a, b;
	a = new Array(0,1,2,3,4);
	b = a.join("-");//分隔符
	return(b);//返回的b=="0-1-2-3-4"
	}
	(2)length函数：返回数组的长度。例：
	function LengthDemo()
	{
	var a, l;
	a = new Array(0,1,2,3,4);
	l = a.length;
	return(l);//l==5
	}
	(3)reverse函数：将数组元素顺序颠倒。例：
	function ReverseDemo()
	{
	var a, l;
	a = new Array(0,1,2,3,4);
	l = a.reverse();
	return(l);
	}
	(4)sort函数：将数组元素重新排序。例：
	function SortDemo()
	{
	var a, l;
	a = new Array("X" ,"y" ,"d", "Z", "v","m","r");
	l = a.sort();
	return(l);
	}

日期 Date
	getDate()函数：返回日期的"日"部分，值为1～31。
	getDay()函数：返回星期几，值为0～6，其中0表示星期日，1表示星期一，...，6表示星期六。例：
    getFullYear() 返回四位数年份值 2010
	getHouse() 函数：返回日期的"小时"部分，值为0～23。
    getMilliseconds() 取得毫秒数
	getMinutes函数：返回日期的"分钟"部分，值为0～59。
    getTime();  返回自1970年1月1日至今毫秒数
    getTimezoneOffset() 返回当前时区 以分钟计  -getTimezoneOffset()/60
    getUTCDate() 返回utc(世界标准时间)日期值
    getUTCDay()返回utc(世界标准时间)星期值
    getUTCFullYear()返回utc(世界标准时间)四位数年份值
    getUTCHours() 返回utc(世界标准时间)小时值
    getUTCMilliseconds() utc毫秒数
    getUTCMinutes() utc分
    getUTCMonth()utc月
    getUTCSeconds()utc秒
    getYear()返回年份
    parse 返回自1970.1.1号至解析的日期的毫秒数   Date.parse('Thu Sep 29 16:47:39 UTC+0800 2010')
    setDate 设置日期
    setFullYear 设置年份
    setHours 设置小时
    setMilliseconds 设置毫秒
    setMinutes
    setMonth
    setSeconds
    setTime
    setUTCDate
    setUTCFullYear
    setUTCHours
    setUTCMilliseconds
    setUTCMinutes
    setUTCMonth
    setUTCSeconds
    setYear
    toGMTString 返回utc字符串描述Thu, 30 Sep 2010 08:55:06 UTC
    toLocaleDateString() 返回日期的本地系统字符串描述，只返回日期  2010年9月30日
    toLocaleString() 返回日期的本地系统字符串描述,日期和时间 2010年9月30日 16:57:27
    toLocaleTimeString() 返回时间的本地系统字符串描述，只显示时间，16:58:20
    toString 返回日期时间的字符串描述Thu Sep 30 16:59:27 UTC+0800 2010
    toTimeString 返回时间的字符串描述
    toUTCString 返回日期时间的UTC字符串描述，等同于toGMTString
    UTC 返回自1970.1.1日至解析的日期的毫秒数，必须跟参数 Date.UTC(2005,7,8)
    valueOf 返回自1970.1.1日至解析的日期的毫秒数 1285837416531

事件处理
    绑定事件
    <input type="button" onclick="test();"/>

    <input id="btn" type="button" value="按扭" />
    <script type="text/javascript" for="btn" event="onclick">
    alert(111);
    </script>

    <input id="btn" type="button" value="按扭" />
    <script type="text/javascript">
    function f()
    {
        alert(11);
    }
    btn.onclick = f;
    </script>
    window.event  保存事件的内容信息

打开窗口
    window.open() 非模式对话框
        oNewWindow = window.open( [sURL] [, sName] [, sFeatures] [, bReplace])
        window.open("Sample.htm",null,"height=200,width=400,status=yes,toolbar=no,menubar=no,location=no",true);

    showModelessDialog 和open一样
    window.showModalDialog() 打开模式对话窗口

xml
    方法
        xmlDoc.getElementsByTagName( "from ")[0].childNodes[0].nodeValue;
    xml特点
        xml只有一个根元素
        大小写敏感
        文档元素必须正确嵌套
        必须要有结束标记
        属性值必须有引号
        多个连续空格不会被忽略
        xml声明必须放在文档的最前部

    解析xml
        <?xml version="1.0" encoding="gb2312"?>
        <book>
            <title>CSS</title>
            <author>isaac</author>
            <email>demo@demo.com</email>
            <date>20070624</date>
        </book>

        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
        xmlDoc.async="false";
        xmlDoc.load("name.xml");	//调用数据
        var nodes = xmlDoc.documentElement.childNodes;
        alert(nodes.item(0).text);
        alert(nodes.item(1).text);
        alert(nodes.item(2).text);

    创建xml解析对象
        xml文件
            <r>
                <a>ff</a>
                <a>ggd</a>
            </r>
        js
			var xmlDoc = createXmlDoc('x.xml');
            //ie firefox
            alert(xmlDoc.getElementsByTagName("a")[0].childNodes[0].nodeValue);
            //ie
            //var nodes = xmlDoc.documentElement.childNodes;
            //alert(nodes.item(1).text);

            function createXmlDoc(xmlFilePath)
            {
                if(window.ActiveXObject)
                {
                    var msXMLdom = new ActiveXObject('Microsoft.XMLDOM');
                    msXMLdom.async = false;
                    msXMLdom.load(xmlFilePath);
                    return msXMLdom;
                }
                else // code for Mozilla, Firefox, Opera, etc
                {
                    var oXMLHttp = new XMLHttpRequest();
                    oXMLHttp.open("GET",xmlFilePath,false);
                    oXMLHttp.send(null);
                    return oXMLHttp.responseXML;

                }
            }

cookie
    cookie存储写法
        document.cookie = "key=value; domain=www.bwie.com; path=\user; expires=2010-1-1";
    //存储cookie方法
    function setCookie(sName, sValue, date)
    {
        //var date = new Date();
        //date.setYear(date.getYear()+2);
        if (date)
        {
            alert(1);
            document.cookie = sName + "=" + sValue + "; expires=" + date.toGMTString();

        }
        else
        {
            alert(2);
            document.cookie = sName + "=" + sValue;
        }

    }
    //取cookie方法
    function getCookie(cName)
    {
        var c = document.cookie;
        var cs = c.split('; ');
        for(var i = 0; i < cs.length; i++)
        {
            if(cs[i].indexOf(cName)==0)
            {
                return cs[i].split('=')[1];
            }
        }
    }

数学
	javascript数学函数其实就是Math对象，它包括属性和函数(或称方法)两部分。其中，属性主要有下列内容。
	Math.e:e(自然对数)、Math.LN2（2的自然对数)、Math.LN10(10的自然对数)、Math.LOG2E(e的对数，底数为 2)、Math.LOG10E(e的对数，底数为10)、Math.PI(π)、Math.SQRT1_2(1/2的平方根值)、Math.SQRT2 (2的平方根值)。
	函数有以下18个：
	(1)abs函数：即Math.abs(以下同)，返回一个数字的绝对值。
	(2)acos函数：返回一个数字的反余弦值，结果为0～π弧度(radians)。
	(3)asin函数：返回一个数字的反正弦值，结果为-π/2～π/2弧度。
	(4)atan函数：返回一个数字的反正切值，结果为-π/2～π/2弧度。
	(5)atan2函数：返回一个坐标的极坐标角度值。
	(6)ceil函数：返回一个数字的最小整数值(大于或等于)。
	(7)cos函数：返回一个数字的余弦值，结果为-1～1。
	(8)exp函数：返回e(自然对数)的乘方值。
	(9)floor函数：返回一个数字的最大整数值(小于或等于)。
	(10)log函数：自然对数函数，返回一个数字的自然对数(e)值。
	(11)max函数：返回两个数的最大值。
	(12)min函数：返回两个数的最小值。
	(13)pow函数：返回一个数字的乘方值。
	(14)random函数：返回一个0～1的随机数值。
	(15)round函数：返回一个数字的四舍五入值，类型是整数。
	(16)sin函数：返回一个数字的正弦值，结果为-1～1。
	(17)sqrt函数：返回一个数字的平方根值。
	(18)tan函数：返回一个数字的正切值。

正则表达式
    function test()
	{
		var regExp = /\D*/gi;
		//var reg2 = /(\D*))/gi;
		var str = "faf4444fffsf";
		//alert(regExp.exec(str));//用正则表达式模式在字符串中运行查找，并返回包含该查找结果的一个数组。
		//alert(regExp.test(str));//返回一个 Boolean 值，它指出在被查找的字符串中是否存在模式。
		//alert(str.match(regExp));//使用正则表达式模式对字符串执行查找，并将包含查找的结果作为数组返回。
		//regExp.compile()
		alert(str.replace(regExp,''));
	}

	//原子表，如[ABC].一个正则至少包含一个原子
	/*
	原子				说明
	-------------------------------------------------------------
	\d		匹配一个数字；等价于[0-9]
	\D		匹配除数字以外任何一个字符；等价于[^0-9]
	\w		匹配一个英文字母、数字或下划线；等价于[0-9a-zA-Z_]
	\W		匹配除英文字母、数字和下划线以外任何一个字符；等价于[^0-9a-zA-Z_]
	\s		匹配一个空白字符；等价于[\f\n\r\t\v]
	\S		匹配除空白字符以外任何一个字符；等价于[^\f\n\r\t\v]
	\f		匹配一个换页符等价于 \x0c 或 \cL
	\n		匹配一个换行符；等价于 \x0a 或 \cJ
	\r		匹配一个回车符等价于\x0d 或 \cM
	\t		匹配一个制表符；等价于 \x09\或\cl
	\v		匹配一个垂直制表符；等价于\x0b或\ck
	\oNN	匹配一个八进制数字
	\xNN	匹配一\cC	匹配一个控制字符个十六进制数字

	-------------------------------------------------------------
	*/

	//元字符
	/*
	元字符是用于构造规则表达式的具有特殊含义的字符。如果要在正则表达式中包含元字符本身，必须在其前加上”\”进行转义
	说明			元字符
	*		0次、1次或多次匹配其前的原子(任意次)
	+		1次或多次匹配其前的原子
	?		0次或1次匹配其前的原子
	.		匹配任何一个字符
	|		匹配两个或多个选择
	^或\A		匹配字符串串首的原子
	$或\Z		匹配字符串串尾的原子
	\b		匹配单词的边界
	\B		匹配除单词边界以外的部分
	[]		匹配方括号中的任一原子
	[^]		匹配除方括号中的原子外的任何字符
	()		整体表示一个原子
	{m}		表示其前原子恰好出现m次
	{m,n}	表示其前原子至少出现m次，至少出现n次(n>m)
	{m,}		表示其前原子出现不少于m次

	元字符“.”匹配除换行符外任何一个字符，相当于[^\n](Unix系统)或[^\r\n](windows系统)。
	*/
	/*
	
	

	模式修正符			说明
		i		可同时匹配大小写字母
		g		全文
		M		将字符串视为多行
		s		将字符串视为单行，换行符做为普通字符看待
		  X		模式中的空白忽略不计
		S		当一个模式将被使用若干次时，为加速匹配先对其进行分析
		U		匹配到最近的字符串
		e		将替换的字符串作为表达使用
	*/

	中文匹配
	//var str = '中华人民共和国';
	//alert(str.match(/[\u4e00-\u9fa5]*/));

字符串
	javascript字符串函数完成对字符串的字体大小、颜色、长度和查找等操作，共包括以下20个函数：
	(1)anchor函数：产生一个链接点(anchor)以作超级链接用。anchor函数设定的链接点的名称，另一个函数link设定的URL地址。
	(2)big函数：将字体加到一号，与...标签结果相同。
	(3)blink函数：使字符串闪烁，与...标签结果相同。
	(4)bold函数：使字体加粗，与...标签结果相同。
	(5)charAt函数：返回字符串中指定的某个字符。
	(6)fixed函数：将字体设定为固定宽度字体，与...标签结果相同。
	(7)fontcolor函数：设定字体颜色，与标签结果相同。
	(8)fontsize函数：设定字体大小，与标签结果相同。
	(9)indexOf函数：返回字符串中第一个查找到的下标index，从左边开始查找。
	(10)italics函数：使字体成为斜体字，与...标签结果相同。
	(11)lastIndexOf函数：返回字符串中第一个查找到的下标index，从右边开始查找。
	(12)length函数：返回字符串的长度。(不用带括号)
	(13)link函数：产生一个超级链接，相当于设定的URL地址。
	(14)small函数：将字体减小一号，与...标签结果相同。
	(15)strike函数：在文本的中间加一条横线，与...标签结果相同。
	(16)sub函数：显示字符串为下标字(subscript)。
	(17)substring函数：返回字符串中指定的几个字符。
	(18)sup函数：显示字符串为上标字(superscript)。
	(19)toLowerCase函数：将字符串转换为小写。
	(20)toUpperCase函数：将字符串转换为大写。
    split切割 "aa,bb".split(',');

面向对象
	<script type="text/javascript">
	//创建一个站点的构造函数，name与url是其参数
	function Site(name, url)
	{
			this.url = url;
			this.name = name;
	}
	//为Site增加一个方法，用于显示网址
	Site.prototype.show = function()
	{
			return this.name+"的网址为："+this.url;
	};
	//创建一个站点集合构造函数，sites是其参数
	function Sites(sites)
	{
			this.sites = sites;
	}
	//为Sites增加一个方法，用于显示网址
	Sites.prototype.show = function()
	{
			var retstr = "";
			for(var i=0;i<this.sites.length;i++)
			{
					retstr+=this.sites[i].show()+"<br />";
			}
			return retstr;
	};
	//新建一个站点集合，包括梦之都，百度，谷歌
	var mySites = new Sites([new Site("dream du", "www.dream du.com"), new Site("baidu", "www.baidu.com"), new Site("google", "www.google.com")]);

	//打印站点网址
	document.write(mySites.show());
	</script>

Ajax
	<script language="JavaScript" type="text/javascript">
	//创建XMLHttpRequest的函数
	function createXMLHttp(){

		var request;
		//得到当前浏览器
		var browser=navigator.appName;
		//如果是IE浏览器
		if(browser=="Microsoft Internet Explorer"){
			request=new ActiveXObject("Microsoft.XMLHttp");
			return request;
		}
		//非IE浏览器
		else{
			request=new XMLHttpRequest();
			return request;
		}
	}

	//定义XMLHttpRequest变量
	var xhr=createXMLHttp();

	function HelloSunyang(){
		//跳转路径
		var url="hello.php?name=shao&"+Math.random();
		//跳转
		xhr.open("GET",url,true);
        //POST请求必须设置编码
        //xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//设置回调函数为getHello
		xhr.onreadystatechange=getHello;
		//将请求发送
		xhr.send(null);
        //post传值name
        //xhr.send("name=ttttttt");
	}

	function getHello(){
		//判断XmlHttpRequest状态
		if(xhr.readyState==4){
			//取值 	描述
			//0		描述一种"未初始化"状态；此时，已经创建一个XMLHttpRequest对象，但是还没有初始化。
			//1		描述一种"发送"状态；此时，代码已经调用了XMLHttpRequest open()方法并且XMLHttpRequest已经准备好把一个请求发送到服务器。
			//2		描述一种"发送"状态；此时，已经通过send()方法把一个请求发送到服务器端，但是还没有收到一个响应。
			//3		描述一种"正在接收"状态；此时，已经接收到Http响应头部信息，但是消息体部分还没有完全接收结束。
			//4		描述一种"已加载"状态；此时，响应已经被完全接收。
			//设置变量helloStr的值为响应返回值
			var helloStr = xhr.responseText;
			alert(helloStr);
			//将响应返回值显示在名为hello的div标签中
			//document.getElementById("hello").innerHTML=helloStr;
		}
	}

	</script>

JQuery ajax
	<script type="text/javascript" src="jquery-1.3.2.min.js"></script>
	<script type="text/javascript">
	<!--//$.ajax
	function test() {
		$.ajax({
		 type: "POST",
		 url: "1.php",
		 data:   "name=John",
		 success: function(msg){ alert(msg); }
		});
	}

	//-->
	</script>

	<script type="text/javascript">
	<!--
	function test() {
		$.get("1.php", { name: "John", time: "2pm" },
		   function(data){
			alert(data);
		   }
		);
	}
	//-->
	</script>

	<script type="text/javascript">
	<!--
	function test()
	{
		$.post("1.php",{ name: "John", time: "2pm" },
			function(data){
				alert(data);
			}
		);
	}
	//-->
	</script>

JSON
	JavaScript Object Notation宿写

    格式
		function showJSON() {
			var user =
			{
				"username":"andy",
				"age":20,
				"info": { "tel": "123456", "cellphone": "98765"},
				"address":
					[
						{"city":"beijing","postcode":"222333"},
						{"city":"newyork","postcode":"555666"}
					]
			}

			alert(user.username);
			alert(user['username']);
			alert(user.age);
			alert(user.info.cellphone);
			alert(user.address[0].city);
			alert(user.address[0].postcode);
		}

	循环
		alert(user['username']);
		for(var key in user)
		{
			alert(user[key]);
		}

	字符串转成JSON数据
		var j ="{'a':'aaaaaa','b':'bbbbbbbbb'}";
		i = eval("("+j+")");//需要用一对"()"先将该字符串包住
		alert(i.b);

select option
    var s = document.getElementById("prov2");
    //清除所有option
    while(s.options.length)
        s.options[s.options.length-1] = null;

    var str = result.responseText;
    //追加数据 str="a,a;b,b;c,c;"
    var str1 = str.split(";");
    for (var i = 0; i < str1.length-1; i++)
    {
        str2 = str1[i].split(",");
        var option_node = document.createElement("OPTION");
        option_node.innerHTML=str2[1];
        option_node.value=str2[0];
        document.getElementById("prov2").appendChild(option_node);
    }

    var s = document.getElementById("s");
    var index = s.selectedIndex; // 选中索引
    var text = s.options[index].text; // 选中文本
    var value = s.options[index].value; // 选中值
    s.options[2].selected = "selected"; //选中某一个option
    s.options[2].selected = true; //选中某一个option


    js 代码
    // 1.判断select选项中 是否存在Value="paraValue"的Item
    function jsSelectIsExitItem(objSelect, objItemValue) {
        var isExit = false;
        for (var i = 0; i < objSelect.options.length; i++) {
            if (objSelect.options[i].value == objItemValue) {
                isExit = true;
                break;
            }
        }
        return isExit;
    }

    // 2.向select选项中 加入一个Item
    function jsAddItemToSelect(objSelect, objItemText, objItemValue) {
        //判断是否存在
        if (jsSelectIsExitItem(objSelect, objItemValue)) {
            alert("该Item的Value值已经存在");
        } else {
            var varItem = new Option(objItemText, objItemValue);
            objSelect.options.add(varItem);
            alert("成功加入");
        }
    }

    // 3.从select选项中 删除一个Item
    function jsRemoveItemFromSelect(objSelect, objItemValue) {
        //判断是否存在
        if (jsSelectIsExitItem(objSelect, objItemValue)) {
            for (var i = 0; i < objSelect.options.length; i++) {
                if (objSelect.options[i].value == objItemValue) {
                    objSelect.options.remove(i);
                    break;
                }
            }
            alert("成功删除");
        } else {
            alert("该select中 不存在该项");
        }
    }


    // 4.删除select中选中的项
    function jsRemoveSelectedItemFromSelect(objSelect) {
        var length = objSelect.options.length - 1;
        for(var i = length; i >= 0; i--){
            if(objSelect[i].selected == true){
                objSelect.options[i] = null;
            }
        }
    }

    // 5.修改select选项中 value="paraValue"的text为"paraText"
    function jsUpdateItemToSelect(objSelect, objItemText, objItemValue) {
        //判断是否存在
        if (jsSelectIsExitItem(objSelect, objItemValue)) {
            for (var i = 0; i < objSelect.options.length; i++) {
                if (objSelect.options[i].value == objItemValue) {
                    objSelect.options[i].text = objItemText;
                    break;
                }
            }
            alert("成功修改");
        } else {
            alert("该select中 不存在该项");
        }
    }

    // 6.设置select中text="paraText"的第一个Item为选中
    function jsSelectItemByValue(objSelect, objItemText) {
        //判断是否存在
        var isExit = false;
        for (var i = 0; i < objSelect.options.length; i++) {
            if (objSelect.options[i].text == objItemText) {
                objSelect.options[i].selected = true;
                isExit = true;
                break;
            }
        }
        //Show出结果
        if (isExit) {
            alert("成功选中");
        } else {
            alert("该select中 不存在该项");
        }
    }

    // 7.设置select中value="paraValue"的Item为选中
    document.all.objSelect.value = objItemValue;
    // 8.得到select的当前选中项的value
    var currSelectValue = document.all.objSelect.value;
    // 9.得到select的当前选中项的text
    var currSelectText = document.all.objSelect.options[document.all.objSelect.selectedIndex].text;
    // 10.得到select的当前选中项的Index
    var currSelectIndex = document.all.objSelect.selectedIndex;
    // 11.清空select的项
    document.all.objSelect.options.length = 0;

checkbox
    //必须选中一条
        <input type=checkbox name='nID' value='1'>
        <input type=checkbox name='nID' value='2'>
        <input type=checkbox name='nID' value='3'>
        <input type="button" onclick="test()"/>

        function test()
        {
            var obj = document.getElementsByName("nID");
            var len = obj.length;
            var checked = false;

            for (i = 0; i < len; i++)
            {
                if (obj[i].checked == true)
                {
                    checked = true;
                    break;
                }
            }
            if (!checked)
            {
                alert("请至少选择一条数据！");
                return false;
            }
        }

    //全选/取消全选
        <input type="checkbox" name="checkAll"
                    onclick="javascript:SetAllChecked('productCustomerId',this);" />
                全选
    	<input type="checkbox" name="productCustomerId" value="1"
        	onclick="javascript:CheckAllChecked('productCustomerId','checkAll');"/>
        <input type="checkbox" name="productCustomerId" value="1"
        	onclick="javascript:CheckAllChecked('productCustomerId','checkAll');"/>
        <input type="checkbox" name="productCustomerId" value="1"
        	onclick="javascript:CheckAllChecked('productCustomerId','checkAll');"/>
        <hr />
        <input type="checkbox" name="checkAll"
            onclick="javascript:SetAllChecked('productCustomerId',this);" />
		全选

        <script language="javascript">
        function isAllChecked(oName)
        {
            var oCtl = document.getElementsByName(oName);
            //eval("oCtl = " + oForm + ".elements[\"" + oName + "\"];");
            if (oCtl)
            {
                if (oCtl.length)
                {
                    var isChecked = true;
                    for(i=0;i<oCtl.length;++i)
                    {
                        isChecked = isChecked && oCtl[i].checked;
                    }
                    return isChecked;
                }
                else
                {
                    return oCtl.checked;
                }
            }
            else
            {
                return false;
            }
        }
        function SetAllChecked(sName,oSelf)
        {
            var oCtl = document.getElementsByName(sName);
            //eval("oCtl = " + sForm + ".elements[\"" + sName + "\"];");
            if (oCtl)
            {
                if (oCtl.length)
                {
                    for(i=0;i<oCtl.length;++i)
                    {
                        oCtl[i].checked = oSelf.checked;
                    }
                }
                else
                {
                    oCtl.checked = oSelf.checked;
                }
            }
            //使所有的全选按扭选中
            var c = document.getElementsByName(oSelf.name);
            for (var i = 0; i < c.length; i++)
            {
                c[i].checked = oSelf.checked;
            }
        }
        function CheckAllChecked(sName,oAllCtlName)
        {
            var oAllCtl = document.getElementsByName(oAllCtlName);
            //eval("oAllCtl = " + sForm + ".elements[\"" + oAllCtlName + "\"];");
            if (oAllCtl)
            {
                var c = isAllChecked(sName);
                if (oAllCtl.length)
                {
                    for(i=0;i<oAllCtl.length;++i)
                    {
                        oAllCtl[i].checked = c;
                    }
                }
                else
                {
                    oAllCtl.checked = c;
                }
            }
        }
        </script>

frameset
	parent.frames['m'].location.href = 'http://www.baidu.com';
	parent.document.getElementsByTagName("FRAMESET").item(1).cols = '20,*';
	parent.document.getElementById("framesetter").cols = "40%,60%";

url转码
	var t = encodeURI('中国');
	alert(t);
	var t2 = decodeURI(t);	
	alert(t2);

获取键盘按键
	<INPUT TYPE="text" NAME="" onKeyPress="alert(event.keyCode)">

