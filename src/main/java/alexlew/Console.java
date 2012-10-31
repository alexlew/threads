package alexlew;

import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

	/**
	 * @param args
	 */
	private static int D = 100;
	private static int K = 107;
	private static int R = 114;
	private static int S = 115;
	

	public static void main(String[] args) throws IOException {
		Counter counter = new Counter();
		int input;
		InputStreamReader reader = new InputStreamReader(System.in);
		while(( input = reader.read()) != K ){
			//System.out.println("key:" + input);
			if(input == D){
				System.out.println("Counter="+counter.getCount());
			}
			if(input == S){
				counter.count();
			}
			if(input == R){
				counter.reset();
			}
		}
		counter.stop();
		System.out.println("end");
	}

}
