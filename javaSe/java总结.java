
java常识
	Java语言前身叫Oak
	Java之父：James Gosling
	95年，Sun发布JDK1.0
	98年，JDK1.2,更名为Java2
	后续JDK1.3、1.4
	JDK1.5、更名为Java5.0

	J2SE - Java 2 Standard Edition
	(标准版) :用于创建典型的桌面与工作站应用的Java平台。 (ftp、聊天室之类)
	J2EE - Java 2 Enterprise Edition
	(企业版):用于创建可扩缩的企业应用的Java平台。(大型应用网站、EJB)
	J2ME - Java 2 Micro Edition
	(缩微版):用于创建嵌入式应用程序的Java平台(如PDA、仪表)

java特点
	开源
	免费
	简单
	安全
	强壮
	多线程
	跨平台

java注释

	//单行注释
	/*多行注释*/
	/**
	 *文档注释
	 */

javadoc 文档生成

	javadoc Test.java -d dir//为Test.java生成文档，存在于dir目录内
	javadoc Test.java -d ./doc -author -version

	@author：作者
	@version：版本
	@docroot：表示产生文档的根路径
	@deprecated：不推荐使用的方法
	@param：方法的参数类型
	@return：方法的返回类型
	@see："参见"，用于指定参考的内容
	@exception：抛出的异常
	@throws：抛出的异常，和exception同义

从键盘接收输入
	//java.util.Scanner
	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();
	System.out.print(i);
	--------------------------
	byte[] buff = new byte[1024]; // 定义数组
	while (true)
	{
		try
		{
			int n = System.in.read(buff); // 从System.in读出数据
			if (new String(buff,0,4).equals("exit")) break;
			System.out.write(buff, 0, n); // 写入System.out中
		}
		catch (Exception e)
		{ // 异常处理
			System.exit(1);
		}

	}
	-------------------------------接收输入写入文件
	byte[] buff = new byte[1024]; // 定义数组
	File file = new File("f:\\2.txt");
	if (!file.exists())
	{
		file.createNewFile();
	}		
	FileOutputStream out  = new FileOutputStream(file);
	while (true)
	{
		try
		{
			int n = System.in.read(buff); // 从System.in读出数据
			if (new String(buff,0,4).equals("exit")) break;
			//System.out.write(buff, 0, n); // 写入System.out中
			out.write(buff,0,n);				
		}
		catch (Exception e)
		{ // 异常处理
			System.exit(1);
		}
	}		
	out.close();

转义字符
	转义符	含义			Unicode值
	\b		退格（backspace）	\u0008
	\n		换行				\u000a
	\r		回车				\u000d
	\t		制表符（tab）		\u0009
	\“		双引号				\u0022
	\‘		单引号				\u0027
	\\		反斜杠				\u005c

数值型
	byte	1字节 	-128 ~ 127
	short	2字节 	-2 15 ~ 2 15-1 （-32768~32767）
	int 	4字节 	-2 31 ~ 2 31-1 (-2147483648~2147483647)
	long	8字节 	-2 63 ~ 2 63-1
	float	4字节 	-3.403E38~3.403E38
	double	8字节 	-1.798E308~1.798E308

运算符优先级
	运算符说明		Java运算符
	分割符			. [] () , ;
	单目运算符		+ - ~ ! ++expr --expr
	创建或类型转换	New (type)expr
	乘法／除法		* / %
	加法／减法		+ -
	移位			<< >> >>>
	关系			< <= >= > instanceof
	等价			== !=
	按位与			&
	按位异或		^
	按位或			|
	条件与			&&
	条件或			||
	条件			?:
	赋值			=

java常用包
	java.io
	java.lang
	java.math
	java.sql
	java.text
	java.util
	java.awt
	java.applet

常用类
	java.lang.Math
	java.util.Date
	java.text.DateFormat
	String
	StringBuffer
	System
	Arrays

时间
	//import java.text.DateFormat;
	//import java.text.SimpleDateFormat;
	//import java.util.Date;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
	Date d = new Date();
	System.out.println(df.format(d));


	 //Calendar calendar = new GregorianCalendar();
	Calendar calendar = Calendar.getInstance();
	Date trialTime = new Date();
	calendar.setTime(trialTime);
	System.out.println("YEAR: " + calendar.get(Calendar.YEAR));

Java关健字
	synchronized  同步
	transient 序列化时，不被存储
	volatile 多线程共享又不要互斥
	native java调用非java代码的接口

Java数据类型
	简单数据类型
		数值型
			整数类型
				byte  1字节
				short 2字节
				int		4字节
				long	8字节
			浮点类型
				float	4字节
				double	8字节
		字符型
		布尔型
	引用数据类型
		类（对象）
		接口
		数组

数组
	int i[] = new int[3];
	int j[] = {1,2,3};
	int k[] = new int[]{3,4,5};

集合
	List
		ArrayList
		LinkedList
		Vector
	Set
		HashSet
		TreeSet
	Map
		HashMap
		Hashtable
	Collection
	Iterator

IO流
	输入流		
	输出流

	节点流
	处理流

	字符流
	字节流

	程序可以从中连续读取字节的对象叫输入流，用InputStream类完成
	程序能向其中连续写入字节的对象叫输出流，用OutputStream类完成
	InputStream 抽象类
	OutputStream 抽象类

	Reader 抽象类
	Writer 抽象类

	RandomAccessFile
		File file = new File("f:\\1.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.write("中国人ssss".getBytes());
		raf.seek(0);
		byte b[] = new byte[(int)raf.length()]; 
		int i = raf.read(b);
		
		while (i != -1)
		{
			System.out.println(new String(b));
			i = raf.read();
		}
		raf.close();

	FileInputStream
	FileOutputStream
			FileInputStream fis = new FileInputStream ("d:\\a.jpg");
			FileOutputStream fos = new FileOutputStream ("d:\\temp.jpg");
			//fis.read()方法读取a.jpg中的下一个字节
			//在读取时有一个文件指针，标记当前的读取位置，每read一次，文件指针会下移到下一个字节。
			//当文件指针到达文件末尾再进行读取会则返回-1,此时read=-1
			int read = fis.read();		
			//值为255,一个字节大小
			while ( read != -1 ) {
				//如果本次read读取的内容不等于-1,说明读取到一个有效的字节信息
				//将读取的这个字节信息写出到fos字节输出流对象所关联的目标文件中去
				fos.write(read);	
				//再读取源文件中的下一个字节
				read = fis.read();
			}			
			fis.close();
			fos.close();
			-----------------------------------------------------------------
			FileInputStream fis = new FileInputStream ("d:\\a.jpg");
			FileOutputStream fos = new FileOutputStream ("d:\\temp.jpg");
			//创建一个字节数组，实现字节数据的成批读取
			byte[] b=new byte[1024];
			int read=fis.read(b);
			System.out.println(read);
			while ( read != -1 ) {
				//将b字节数组中从下标为0开始的连续read个字节元素写出到当前fos对象所关联的数据源中去
				fos.write(b,0,read);	
				//再读取源文件中的下一个字节
				read = fis.read(b);
			}			
			fis.close();
			fos.close();
			----------------------------------------------------------------
			FileInputStream fis = new FileInputStream ("d:\\a.jpg");
			FileOutputStream fos = new FileOutputStream ("d:\\temp.jpg");
			//创建一个字节数组，实现字节数据的成批读取
			byte[] b=new byte[1024];
			int read=fis.read(b);
			System.out.println(read);
			while ( read != -1 ) {
				//将b字节数组中从下标为0开始的连续10个字节元素写出到当前fos对象所关联的数据源中去
				fos.write(b,0,10);	
				
				//再读取源文件中的下一个字节
				read = fis.read(b);
				System.out.println(read);
			}			
			fis.close();
			fos.close();

	FileReader
	FileWriter
			FileReader input = new FileReader("d:\\a.txt");
			FileWriter output = new FileWriter("d:\\temp.txt");
			int read = input.read();	
			System.out.println(read);
			//读取字符，如果已到达流的末尾，则返回 -1 
			while ( read != -1 ) {
				output.write(read);	
				read = input.read();
			}			
			input.close();
			output.close();

	BufferedReader
	BufferedWriter
			FileReader input = new FileReader("d://Test.java");
			//创建一个BufferedReader对象br封装FileReader对象input
			BufferedReader br = new BufferedReader(input);
			FileWriter output = new FileWriter("d://temp.txt");
			BufferedWriter bw = new BufferedWriter(output);
			//br.readLine()以行为单位读取源文件中的内容
			//readLine()方法在每执行一次的过程中会多次调用它所封装的input对象的read()方法，
			//读取一个个字符,直到遇到换行符，再将积累的字符转换成一个字符串并返回。这个字符串并不包括作为标记的换行符
			String s = br.readLine();	
			//readLine()方法读取到文件结尾，返回null
			while ( s!=null ) {
				//将本次所读取出的这一行，写出到bw所关联的数据源
				bw.write(s);
				//增加一个换行到bw所关联的数据源,否则源文件将不会换行。
				//bw.newLine();		
				//读取源文件下一行信息
				s = br.readLine();
			}			
			br.close();
			bw.close();
			-------------------------------------------------------
			char[] c = new char[1024];
			while (true)
			{
				BufferedReader in
				   = new BufferedReader(new InputStreamReader(System.in));			
				int i = in.read(c);
				if (new String(c,0,i-2).equals("exit")) break;
				System.out.print(new String(c,0,i));
				
			}

	InputStreamReader
	OutputStreamWriter
		char[] c = new char[1024];
		while (true)
		{
			BufferedReader in
			   = new BufferedReader(new InputStreamReader(System.in));			
			int i = in.read(c);
			if (new String(c,0,i-2).equals("exit")) break;
			System.out.print(new String(c,0,i));
			
		}

	PrintStream extends FilterOutputStream
	PrintWriter extends Writer

	DataInputStream
	DataOutputStream
		FileOutputStream fos;
		DataOutputStream dos;
		FileInputStream fis;
		DataInputStream dis;
		fos = new FileOutputStream("d:\\myfile.data");
		dos = new DataOutputStream(fos);
		dos.writeUTF("休.格兰特");
		dos.writeInt(40);
		dos.close();
		fis = new FileInputStream("d:\\myfile.data");
		dis = new DataInputStream(fis);
		System.out.println("name:" + dis.readUTF());
		System.out.println("age:" + dis.readInt());
		fis.close();
	
	CharArrayReader
		char[] b = {'I',' ','a','m',' ','S','a','i','l','i','n','g','!'};
		//car实例对象并没有关联到一个文本文件作为数据源，而是关联到内存中的一个字符数组b
		CharArrayReader c = new CharArrayReader(b);
		//		逐个读取参数reader关联的数据源
		int i = c.read();
		while(i != -1){
			//当没有读取完，将b造型成字符类型
			System.out.print((char)i);
			//继续读取下一个字符
			i = c.read();	
		}
	CharArrayWriter
		CharArrayWriter cw = new CharArrayWriter(); 
		//将cw再封装成一个PrintWriter类的对象，true表示信息采用追加方式。
		PrintWriter pw = new PrintWriter(cw,true); 
		pw.append("aaaa");
		pw.append("eeee");
		System.out.println(cw.toString());
		-----------------------------------------------
		try{
			BufferedReader br = new BufferedReader(new FileReader("d://a1.txt"));
			String s ;
			while((s=br.readLine()) != null){
				System.out.println(s);	
			}
			//当程序出现异常时
		}catch(IOException e){
			CharArrayWriter cw = new CharArrayWriter(); 
			//将cw再封装成一个PrintWriter类的对象，true表示信息采用追加方式。
			PrintWriter pw = new PrintWriter(cw,true); 
	 		//e.printStackTrace();调用exception类的printStackTrace()会将异常信息输出到控制台屏幕上
			//将异常信息输出到与pw对象相关的输出流中去，这时将会写到内存中的cw中。
			e.printStackTrace(pw);
			//将cw对象所保存的内容一次性的转换成一个字符串
	 		String info = cw.toString(); 
	 		Date time = new Date();
	 		//将time和info信息写入数据库---	
	 		System.out.println("出错时间: " + time);
	 		System.out.println("错误信息:\n" + info);
		}
		
	
	Properties
		read
			Properties props = new Properties();
			File f=new File("d:\\OracleSetup.properties");
			FileInputStream in = new FileInputStream(f);
			props.load(in);
			in.close();
			oracle_url   = props.getProperty("oracle_url");

		write
			//得到系统的属性信息System.getProperties()
			//Properties props = System.getProperties();
			Properties props = new Properties();
			File f=new File("f:\\aaaa.properties");
			FileOutputStream out = new FileOutputStream(f);
			props.setProperty("oracle_url", "jdbc:oracle:thin:@localhost:1521:ocsec");
			props.setProperty("oracle_name", "ocsec");
			props.setProperty("oracle_user", "scott");
			props.setProperty("oracle_pwd", "tiger");
			props.store(out, null);
			out.close();

范型
	Wildcard
	extends 上边界 只能是子类
		public static void main(String[] args) throws IOException {		
			List<Long> l = new ArrayList<Long>();
			l.add(100l);
			test(l);
		}
		public static void test(List<? extends Number> l)
		{
			Integer n = new Integer(45);
			Number x = l.get(0); //从链表中取数据是允许的
			System.out.println(x);
			//l.add(n);  //错误！！往链表里面插入数据是被编译器严格禁止的！！
		}

	super 下边界 只能是父类
		public static void main(String[] args) throws IOException {		
			List<Number> l = new ArrayList<Number>();
			l.add(100);
			test(l);
		}
		public static void test(List<? super Integer> l) {
			Integer n = new Integer(45);
			l.add(n);  //与上面使用extends关键字相反，往链表里面插入指定类型的数据是被允许的。
			Object x = l.get(0); //从链表里取出一个数据仍然是被允许的，不过要赋值给Object对象。
			System.out.println(x);
			//l.add(x);   //错误！！将刚刚取出的数据再次插入链表是不被允许的。
		}


线程
	Runnable 优势
		多个相同程序处理同一资源
		避免单继承带来的局限
		有利于程序的健壮性
	实现 Runnable
		//使用实现接口 Runnable 的对象创建一个线程时，启动该线程将导致在独立执行的线程中调用对象的 run 方法。 
		class Runner1 implements Runnable {
			public void run() {
				for(int i=0; i<30; i++) {	
					System.out.println("No. " + i);
				}
			}
		}
		public class TestThread1 {
			public static void main(String args[]) {
				Runner1 r = new Runner1();
				//定义一个Thread类型对象t，相当于定义一个处理器，r是传递给处理器要处理的数据，r中的run()方法就是处理器要处理的代码
				Thread t = new Thread(r);
				//线程t在工作时，隐含的调用了它所封装的Runnable接口实现类对象r的run()方法
				t.start();
			}
		}
		/*
		创建一个线程的过程:
		1.定义一个类实现Runnable接口,重写其中的run()方法，在run()方法中加入处理代码
		2.创建一个实现Runnable接口的类的对象
		3.创建一个Thread类型的对象，它要封装实现了Runnable接口的类的对象
		4.调用Thread类型对象的start()方法，启动线程
		*/

	继承 Thread
		public class TestThread3 {	
			public static void main(String args[]){
				//声明一个父类的类型实际引用一个子类的对象,增强可读性。
				Thread t = new Runner3();
				t.strat();
			}
		}
		//Thread类已经实现了Runnable接口,所以可以认为类Runner3间接实现了Runnable接口
		class Runner3 extends Thread {
			public void run() {
				for(int i=0; i<30; i++) {	
					System.out.println("No. " + i);
				}
			}
		}
		/*
		 创建一个线程的过程:
		 1.定义一个类继承Thread类，重写run()方法
		 2.直接创建一个Thread类的对象t
		 3.调用Thread类对象t的start()方法，实际上是调用run()方法
		*/

	设置为后台线程
		//一个进程只有后台线程，该进程就结束啦
		t2.setDaemon(true);

	线程合并
		new Thread().join();

	线程同步安全
		//任意对象0、1两种状态，开始为1，执行过程0，结束转为1
		//synchronized的参数为任意对象
		synchronized ("") {}//代码块为同步代码块
		public synchronized void t(){} //同步方法

	死锁

	线程 休眠/唤醒

	sleep和wait有什么区别
		sleep是线程类（Thread）的方法，导致此线程暂停执行指定时间，给执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。调用sleep不会释放对象锁。
		wait是Object类的方法，对此对象调用wait方法导致本线程放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象发出notify方法（或notifyAll）后本线程才进入对象锁定池准备获得对象锁进入运行状态。

	线程同步方法
		wait():使一个线程处于等待状态，并且释放所持有的对象的lock。
		sleep():使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要捕捉InterruptedException异常。
		notify():唤醒一个处于等待状态的线程，注意的是在调用此方法的时候，并不能确切的唤醒某一个等待状态的线程，而是由JVM确定唤醒哪个线程，而且不是按优先级。
		notifyAll():唤醒所有处入等待状态的线程，注意并不是给所有唤醒线程一个对象的锁，而是让它们竞争。

Java生成随机数
	import org.apache.commons.lang.RandomStringUtils;
	//产生5位长度的随机字符串
	RandomStringUtils.random(5);
	//使用指定的字符生成5位长度的随机字符串
	RandomStringUtils.random(5, new char[]{'a','b','c','d','e','f'});
	//生成指定长度的字母和数字的随机组合字符串
	RandomStringUtils.randomAlphanumeric(5); 
	//生成随机数字字符串
	RandomStringUtils.randomNumeric(5); 


jar打war包
	jar -cvf aa.war .    //.代表找包当前目录 aa.war代表打包的文件











