package test.log4j.log4j;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.apache.log4j.Logger;

class Test001{
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(Test001.class);

	public int m1(int a){
		if (logger.isDebugEnabled()) {
			logger.debug("m1(int) - start");
		}

		a=30;

		if (logger.isDebugEnabled()) {
			logger.debug("m1(int) - end");
		}
		return a;
	}
}


/**
 * Hello world!
 *
 */
public class App {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		if (logger.isDebugEnabled()) {
			logger.debug("main(String[]) - start");
		}
		FutureTask<Integer> ft = new FutureTask<Integer>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				if (logger.isDebugEnabled()) {
					logger.debug("call() - start");
				}
				
				System.out.println(Thread.currentThread().getName());

				if (logger.isDebugEnabled()) {
					logger.debug("call() - end");
				}
				return null;
			}
		});
		new Thread(ft,"AA").start();
	
		new Thread(()->{System.out.println(Thread.currentThread().getName());},"DD").start();
		new Thread(()->{System.out.println(Thread.currentThread().getName());},"EE").start();
		new Thread(()->{System.out.println(Thread.currentThread().getName());},"FF").start();
		
		
		
		
		//System.out.println("Hello World!");
		//去重复数值+数值大于4+升序排列后只返回前3个元素
		List<Integer> list = Arrays.asList(1,2,3,3,3,4,0,-11,5,6,7,8,9);
		
		Set<Integer> set = new TreeSet<Integer>();
		for(int i = 0 ;i < list.size();i++){
			set.add(list.get(i));
		}
		int cout = 1 ;
		for (Integer integer : set) {
			if(cout<= 3 && integer>4){
				System.out.print(integer+"\t");
				cout++;
			}
		}
		System.out.println("");

		if (logger.isDebugEnabled()) {
			logger.debug("main(String[]) - end");
		}
	}
}
