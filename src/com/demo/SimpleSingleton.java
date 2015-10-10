package com.demo;

/**
 * �򵥵ĵ���ģʽʵ��
 * 
 * @author ximan
 * 
 */
public class SimpleSingleton {

	private static SimpleSingleton singleton = new SimpleSingleton();

	private SimpleSingleton() {
	}

	public static SimpleSingleton getInstance() {
		return singleton;
	}
}
