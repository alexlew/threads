package alexlew;

public class MyRunnable extends Thread {

	  private boolean stop = false;
	  private Counter counter;
	  
	  public MyRunnable(Counter counter) {
		  this.counter = counter;
	  }
	
	  @Override
	  public void run(){
		  System.out.println(this.toString() + "is running");
		  while(!stop){
			  counter.incremente(this.toString());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		  }
		 System.out.println(this.toString() + "is stopping");
	  }
	  
	  public void kill(){
		  this.stop = true;
	  }
}
