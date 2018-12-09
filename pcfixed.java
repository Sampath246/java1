import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList; 

class Q
{
	int n;
	boolean valueSet=false;
	synchronized int get () {
		while(!valueSet)
			try {
				wait();
			}
		catch(InterruptedException e)
		{
			System.out.printf("interrupted Exception caught");
			
		}
		System.out.printf("get: "+n);
		System.out.printf("\n");
		valueSet=false;
		notify();
		return n;
	}
	synchronized void put(int n)
	{
		while(valueSet)
			try {
				wait();
				
			}
		catch(InterruptedException e) {
			System.out.printf("interrupted Exception caught");
			
		}
		this.n=n;
		valueSet=true;
		System.out.printf("put: "+n);
		System.out.printf("\n");
		notify();
	}
}
class Producer implements Runnable{
	Q q;
	Producer (Q q)
	{
		this.q=q;
		new Thread(this,"producer").start();
		
	}
	public void run()
	{
		int i=0;
		while(true)
		{
			q.put(i++);
		}
	}
}
class Consumer implements Runnable{
	Q q;
	Consumer(Q q)
	{
		this.q=q;
		new Thread(this,"Consumer").start();
		
	}
	public void run() {
		while(true) {
			q.get();
		}
	}
}
class Pcfixied{
	public static void main(String[]args) {
	Q q=new Q();
	new Producer(q);
	new Consumer(q);
	System.out.printf("press Control-c to stop");
}}