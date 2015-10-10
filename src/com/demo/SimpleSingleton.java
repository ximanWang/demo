package com.demo;

/**
 * 单例模式的简单实现
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
