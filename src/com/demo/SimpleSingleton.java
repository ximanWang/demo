package com.demo;

/**
 * 简单的单例模式实现
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
