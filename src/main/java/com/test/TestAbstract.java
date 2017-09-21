package com.test;

/**
 *   1、抽象类不能被实例化，实例化的工作应该交由它的子类来完成，它只需要有一个引用即可。
     2、抽象方法必须由子类来进行重写。
     3、只要包含一个抽象方法的抽象类，该方法必须要定义成抽象类，不管是否还包含有其他方法。
     4、抽象类中可以包含具体的方法，当然也可以不包含抽象方法。
     5、子类中的抽象方法不能与父类的抽象方法同名。
     6、abstract不能与final并列修饰同一个类。
     7、abstract 不能与private、static、final或native并列修饰同一个方法。、
 * @author xuanxy
 *
 */
public abstract class TestAbstract {
	
	
	public static void test1(){
		System.out.println("我是实现方法");
	}
	
	public abstract void test();
	
	public static void main(String[] args) {
		//testMath();
	}

}
