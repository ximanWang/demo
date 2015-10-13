package com.demo;

/**
 * 多线程编程 两个线程，一个打印1-52，另一个打印A-Z 打印顺序为12A34B56C78D...
 * 
 * @author ximan
 * 
 */
public class ThreadTest {

	public static void main(String[] args) {
		Printer p = new Printer();
		Thread t1 = new NumberPrinter(p);
		Thread t2 = new LetterPrinter(p);
		t1.start();
		t2.start();
	}
}

class Printer {
	private int index = 1;

	/*
	 * 打印字母，每打印一个字母等待打印两个数字
	 */
	public synchronized void print(char c) {
		while (index % 3 != 0) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print(" " + c);
		index++;
		notifyAll();
	}

	/*
	 * 打印数字，每打印两个数字等待打印两个字母
	 */
	public synchronized void print(int i) {
		while (index % 3 == 0) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print(" " + i);
		index++;
		notifyAll();
	}

}

class NumberPrinter extends Thread {
	private Printer p;

	public NumberPrinter(Printer p) {
		this.p = p;
	}

	public void run() {
		for (int i = 1; i <= 52; i++) {
			p.print(i);
		}
	}
}

class LetterPrinter extends Thread {
	private Printer p;

	public LetterPrinter(Printer p) {
		this.p = p;
	}

	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			p.print(c);
		}
	}
}