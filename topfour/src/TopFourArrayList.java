import java.util.ArrayList;
import java.util.Scanner;

public class TopFourArrayList {

	/**
	 * @author
	 * Du Huang
	 */
	public static void main(String[] args) {
		int length;
		int data;
		int[] getData;
		ArrayList<Integer> topFour = new ArrayList<Integer>(4);
		Scanner sc = new Scanner(System.in);
		
		length = sc.nextInt();
		getData = new int[length - 4];
		int[] ini = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
		
		for(int i = 0; i < length - 4; i++) getData[i] = sc.nextInt(); 
		
		java.util.Arrays.sort(ini);
		for(int i = 3; i > -1; i--) topFour.add(ini[i]); 
			for(int i = 0; i < length - 4; i++){
			data = getData[i];
			if(data > topFour.get(3)){
				if(data > topFour.get(2)){
					if(data > topFour.get(1)){
						if(data > topFour.get(0)){
							topFour.add(0, data);
						}
						else topFour.add(1, data);
					}
					else topFour.add(2, data);
				}
				else topFour.set(3, data);
			}
		}
		
		for(int i = 0; i < 4; i++) System.out.println(topFour.get(i));
		
	}

}