import java.util.ArrayList;
import java.util.Scanner;


public class CircularBuffer {
	/**
	 * @author
	 * Du Huang
	 */
	public static void main(String[] args) {
		int tailIndex = 0;
		int headIndex = 0;
		String token ; 
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		String[] cirBuf = new String[size];
		while(sc.hasNext()) {
			token = sc.next();
			if(token.equals("A")) { 
				int addNum = sc.nextInt();
				for(int i = 0; i < addNum; i++){
					if(cirBuf[tailIndex] != null) {
						headIndex++;
						if(headIndex == size) headIndex = 0;
					}
					cirBuf[tailIndex] = sc.next();
					tailIndex++;
					if(tailIndex == size) tailIndex = 0;
				}
			}
			else if(token.equals("R")) {
				int delNum = sc.nextInt();
				for(int i = 0; i < delNum; i++){
					cirBuf[headIndex] = null;
					headIndex++;
					if(headIndex == size) headIndex = 0;
				}	
			}
			else if(token.equals("L")) {
				if(cirBuf[headIndex] == null){}
				else if(tailIndex > headIndex) {
					for(int i = headIndex; i < tailIndex; i++) System.out.println(cirBuf[i]);					
						
				}
				else {
					int printCur = headIndex;
					for(int i = 0; i < size - headIndex + tailIndex; i++) {
						System.out.println(cirBuf[printCur]);
						printCur++;
						if(printCur == size) printCur = 0;

					}
				}
					
			}
			else
				System.exit(0);
			
		}

	}

}

