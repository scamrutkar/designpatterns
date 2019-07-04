package com.sagar.javabase.singleton;

import java.io.Serializable;

/*Double Checking*/
class Singleton {

	private static Singleton instance = null;

	private Singleton() {};

	public static Singleton getInstance() throws InterruptedException {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					System.out.println("Object is created");
					Thread.sleep(2000);
					instance = new Singleton();
				} else 
					System.out.println("Object is alread created");
			}
		}
		return instance;
	}

	public void executeSIngletonMethod() {
		System.out.println("Executing singleton method for thread : " + Thread.currentThread().getName());
	}

}

class SingeltonThreadCaller implements Runnable {
	@Override
	public void run() {
		System.out.println("In Thread");
		try {
			Singleton.getInstance().executeSIngletonMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/* Using static instance class - Bill phug implementation */
class SingletonUsingStaticInnerClass {
	
	private static class SingletonHelper{
		private static final SingletonUsingStaticInnerClass instance = new SingletonUsingStaticInnerClass();
	}
	
	private SingletonUsingStaticInnerClass() {};
	
	public static SingletonUsingStaticInnerClass getInstance() {
		return SingletonHelper.instance;
	}

}

/*
 * Using reflection we can break singleton deign pattern. Hence we need to add
 * one more check to in private constructor, whether instance is null or not
 */
class SingletonReflectionCase{
	
	private static SingletonReflectionCase instance = null;

	private SingletonReflectionCase() {
		if(instance != null)
			throw new IllegalStateException();
	};

	public static SingletonReflectionCase getInstance() throws InterruptedException {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) 
					instance = new SingletonReflectionCase();
			}
		}
		return instance;
	}
	
}

/*
 * De-serialization always creates new object, Hence we need to override
 * readResolve() method and return same instance.
 */
class SingletonSerializationCase implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static SingletonSerializationCase instance = null;

	private SingletonSerializationCase() {
		if(instance != null)
			throw new IllegalStateException();
	};

	public static SingletonSerializationCase getInstance() throws InterruptedException {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) 
					instance = new SingletonSerializationCase();
			}
		}
		return instance;
	}
	
	protected SingletonSerializationCase readResolve() {
		return instance;
	}
}

public class SingletonExample {

	public static void main(String[] args) {

		SingeltonThreadCaller object = new SingeltonThreadCaller();

		new Thread(object).start();
		new Thread(object).start();
		new Thread(object).start();
		new Thread(object).start();
		new Thread(object).start();

	}

}
