package alexlew;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class PausableThreadPoolExecutor extends ThreadPoolExecutor {
   
	private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
	
	   public PausableThreadPoolExecutor() {
		   super(10,10, 10l, TimeUnit.SECONDS, queue);
	   }
 
 }