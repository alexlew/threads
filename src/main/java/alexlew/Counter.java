package alexlew;

import java.util.ArrayList;
import java.util.List;

public class Counter {

	private int count;
	
	PausableThreadPoolExecutor executor = new PausableThreadPoolExecutor();
	
	private List<MyRunnable> runnables = new ArrayList<MyRunnable>();

	public void incremente(String name) {
		System.out.println(name + "wainting");
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
		executor.shutdownNow();
	}

	public int getCount() {
		return count;
	}

	public void reset() {
		this.count = 0;
	}
	
}
