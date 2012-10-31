package alexlew;

import java.util.ArrayList;
import java.util.List;

public class Counter {

	private int count;
	
	PausableThreadPoolExecutor executor = new PausableThreadPoolExecutor();
	
	private List<MyRunnable> runnables = new ArrayList<MyRunnable>();

	public void incremente(String name) {
		synchronized (this) {
			count++;
			System.out.println(name + "increments counter (" + count +")");
		}
	}
	
	public void count(){
		for(int i=0; i < 10; i++){
			MyRunnable runable = new MyRunnable(this);
			runnables.add(runable);
			executor.execute(runable);
		}
	}
	
	public void stop() {
		for(MyRunnable runnable: runnables){
			runnable.kill();
		}
		int size = executor.getPoolSize();
		System.out.println("ThreadPool size: " + size);
		while(executor.getPoolSize() != size-runnables.size()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ThreadPool size: " + executor.getPoolSize());
			System.out.println("remaining: " + (size-runnables.size()));
			executor.shutdown();
		}
			System.out.println("ThreadPool has terminated");
	}

	public int getCount() {
		return count;
	}

	public void reset() {
		this.count = 0;
	}
	
}
