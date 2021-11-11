package com.gk.learn.code.week1;

public class Hello {
	public static void main(String[] args) {
		char a = 'a';
		byte b = (byte) 1;
		int  i = 2;
		long l = 3L;
		float f = 2.3f;
		double d = 4.2d;

		String s = "qwret";
		int[] r = {1, 2, 4};
		int add = i + 1;
		int sub = i - 2;
		int mul = i * 3;
		int div = i / 2;
		for (int i1 : r) {
			if (i1 == 4) {
				break;
			}
		}
	}

//	Classfile /e:/project/springboot/mybatis-plus-learn/src/main/java/com/mybatis/plus/learn/controller/Hello.class
//	Last modified 2021-11-6; size 955 bytes
//	MD5 checksum 7d5221a82206c13b8cd96865fe55f9a8
//	Compiled from "Hello.java"
//	public class com.mybatis.plus.learn.controller.Hello
//	minor version: 0
//	major version: 52
//	flags: ACC_PUBLIC, ACC_SUPER
//	Constant pool:   // 常量池
//			#1 = Methodref          #9.#48         // java/lang/Object."<init>":()V
//			#2 = Long               3l
//			#4 = Float              2.3f
//			#5 = Double             4.2d
//			#7 = String             #49            // qwret
//			#8 = Class              #50            // com/mybatis/plus/learn/controller/Hello
//			#9 = Class              #51            // java/lang/Object
//			#10 = Utf8               <init>
//  #11 = Utf8               ()V
//  #12 = Utf8               Code
//  #13 = Utf8               LineNumberTable
//  #14 = Utf8               LocalVariableTable
//  #15 = Utf8               this
//			#16 = Utf8               Lcom/mybatis/plus/learn/controller/Hello;
//  #17 = Utf8               main
//  #18 = Utf8               ([Ljava/lang/String;)V
//  #19 = Utf8               i1
//  #20 = Utf8               I
//  #21 = Utf8               args
//  #22 = Utf8               [Ljava/lang/String;
//  #23 = Utf8               a
//  #24 = Utf8               C
//  #25 = Utf8               b
//  #26 = Utf8               B
//  #27 = Utf8               i
//  #28 = Utf8               l
//  #29 = Utf8               J
//  #30 = Utf8               f
//  #31 = Utf8               F
//  #32 = Utf8               d
//  #33 = Utf8               D
//  #34 = Utf8               s
//  #35 = Utf8               Ljava/lang/String;
//  #36 = Utf8               r
//  #37 = Utf8               [I
//  #38 = Utf8               add
//  #39 = Utf8               sub
//  #40 = Utf8               mul
//  #41 = Utf8               div
//  #42 = Utf8               StackMapTable
//  #43 = Class              #22            // "[Ljava/lang/String;"
//			#44 = Class              #52            // java/lang/String
//			#45 = Class              #37            // "[I"
//			#46 = Utf8               SourceFile
//  #47 = Utf8               Hello.java
//  #48 = NameAndType        #10:#11        // "<init>":()V
//			#49 = Utf8               qwret
//  #50 = Utf8               com/mybatis/plus/learn/controller/Hello
//  #51 = Utf8               java/lang/Object
//  #52 = Utf8               java/lang/String
//	{
//  public com.mybatis.plus.learn.controller.Hello();
//		descriptor: ()V
//		flags: ACC_PUBLIC
//		Code:
//		stack=1, locals=1, args_size=1
//		0: aload_0
//		1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//		4: return
//			LineNumberTable:
//		line 3: 0
//		LocalVariableTable:
//		Start  Length  Slot  Name   Signature
//		0       5     0  this   Lcom/mybatis/plus/learn/controller/Hello;
//
//		public static void main(java.lang.String[]);
//		descriptor: ([Ljava/lang/String;)V
//		flags: ACC_PUBLIC, ACC_STATIC
//		Code:
//		stack=4, locals=19, args_size=1
//		0: bipush        97  // 等效于sipush,将97压栈
//		2: istore_1          // 把97写到本地变量表位置1的地方  即97赋值给变量a
//		3: iconst_1          // 将常量1压栈
//		4: istore_2			 // 把常量1写到本地变量表位置2的地方  即1赋值给变量b
//		5: iconst_2          // 将常量2压栈
//		6: istore_3          // 把常量2写到本地变量表位置3的地方  即将2赋值给变量i
//		7: ldc2_w        #2                  // long 3l  将常量池中#2常量3L压栈
//		10: lstore        4                  // 把常量写到本地变量表位置4的地方  即将3L赋值给变量l
//		12: ldc           #4                  // float 2.3f   将常量池中#4常量2.3f压栈
//		14: fstore        6					  // 把常量写到本地变量表位置6的地方  即将2.3f赋值给变量f
//		16: ldc2_w        #5                  // double 4.2d 将常量池中#5常量4.2d压栈
//		19: dstore        7                   // 把常量写到本地变量表位置7的地方  即将4.2d赋值给变量d
//		21: ldc           #7                  // String qwret 将常量池中#7常量qwret压栈
//		23: astore        9                   // 把常量写到本地变量表位置9的地方  即将qwret赋值给变量s
//		25: iconst_3                          // 将常量3压栈
//		26: newarray       int                // 创建int类型的数组
//		28: dup                               // 复制栈顶一个字节的数据，将复制后的数据压栈
//		29: iconst_0                          // 将常量0压栈
//		30: iconst_1                          // 将常量1压栈
//		31: iastore                           // 将栈顶int类型值保存到指定int类型数组 即把常量1保存到数组
//		32: dup                               // 复制栈顶一个字节的数据，将复制后的数据压栈
//		33: iconst_1                          // 将常量1压栈
//		34: iconst_2                          // 将常量2压栈
//		35: iastore                           // 将栈顶int类型值保存到指定int类型数组 即把常量2保存到数组
//		36: dup
//		37: iconst_2                          // 将常量2压栈
//		38: iconst_4                          // 将常量4压栈
//		39: iastore                           // 将栈顶int类型值保存到指定int类型数组 即把常量4保存到数组
//		40: astore        10                  // 把常量写到本地变量表位置10的地方  即将{1,2,3}赋值给变量r
//		42: iload_3                           // 将slot 3 也就是变量i加载到操作数栈
//		43: iconst_1                          // 将常量1加载到操作数栈
//		44: iadd                              // 执行i+1  即2+1
//		45: istore        11                  // 将执行结果3赋值给slot 11  即add=3
//		47: iload_3                           // 将slot 3 也就是变量i加载到操作数栈
//		48: iconst_2                          // 将常量2加载到操作数栈
//		49: isub                              // 执行i-2  即2-2
//		50: istore        12                  // 将执行结果0赋值给slot 12 即sub=0
//		52: iload_3                           // 将slot 3 也就是变量i加载到操作数栈
//		53: iconst_3                          // 将常量加3载到操作数栈
//		54: imul                              // 执行i*3
//		55: istore        13                  // 将执行结果6赋值给slot 13 即mul=6
//		57: iload_3                           // 将slot 3 也就是变量i加载到操作数栈
//		58: iconst_2                          // 将常量加2载到操作数栈
//		59: idiv                              // 执行i/2
//		60: istore        14                  // 将执行结果1赋值给slot 13 即div=1
//		62: aload         10                  // 将slot 10 即变量r 加载到操作数栈
//		64: astore        15                  // 将变量r 保存到本地变量表位置15的地方
//		66: aload         15                  // 将slot 15 即变量r 加载到操作数栈
//		68: arraylength                       // 获取一位数组的长度 即3
//		69: istore        16                  // 将3保存到本地变量 16的位置
//		71: iconst_0                          // 将常量0压栈
//		72: istore        17                  // 将0保存到本地变量17的位置
//		74: iload         17                  // 将本地变量17加载到操作数栈
//		76: iload         16                  // 将本地变量 16 即3加载到操作数栈
//		78: if_icmpge     103                 // 如果本地变量17 大于等于 本地变量16 跳转到103位置
//		81: aload         15                  // 将slot 15 即变量r 加载到操作数栈
//		83: iload         17                  // 将本地变量17加载到操作数栈
//		85: iaload                            // 从int类型数组中装载指定项 (slot 17)的值
//		86: istore        18       // 将数组中指定项保存到slot 18
//		88: iload         18       // 将slot 18 即i1加载到操作数栈
//		90: iconst_4               // 加载常量4到操作数栈
//		91: if_icmpne     97       // 如果i1不等于4 跳转到97
//		94: goto          103      // 跳转到103
//		97: iinc          17, 1    // slot 17 自增
//		100: goto          74      // 跳转到74
//		103: return
//			LineNumberTable:
//		line 5: 0
//		line 6: 3
//		line 7: 5
//		line 8: 7
//		line 9: 12
//		line 10: 16
//		line 12: 21
//		line 13: 25
//		line 14: 42
//		line 15: 47
//		line 16: 52
//		line 17: 57
//		line 18: 62
//		line 19: 88
//		line 20: 94
//		line 18: 97
//		line 23: 103
//		LocalVariableTable:
//		Start  Length  Slot  Name   Signature
//		88       9    18    i1   I
//		0     104     0  args   [Ljava/lang/String;
//		3     101     1     a   C
//		5      99     2     b   B
//		7      97     3     i   I
//		12      92     4     l   J
//		16      88     6     f   F
//		21      83     7     d   D
//		25      79     9     s   Ljava/lang/String;
//		42      62    10     r   [I
//		47      57    11   add   I
//		52      52    12   sub   I
//		57      47    13   mul   I
//		62      42    14   div   I
//		StackMapTable: number_of_entries = 3
//		frame_type = 255 /* full_frame */
//		offset_delta = 74
//		locals = [ class "[Ljava/lang/String;", int, int, int, long, float, double, class java/lang/String, class "[I", int, int, int, int, class "[I", int, int ]
//		stack = []
//		frame_type = 22 /* same */
//		frame_type = 248 /* chop */
//		offset_delta = 5
//	}
//	SourceFile: "Hello.java"


}
