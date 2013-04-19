import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class TopFourIntArray {

	/**
	 * @author
	 * Du Huang
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		int length;
		int data;
		int[] getData;
		int[] topFour = new int[4]; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		//Integer.parseInt(br.readLine());
		
		length = Integer.parseInt(br.readLine());//sc.nextInt();
		getData = new int[length - 4];
		int[] ini = {Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())};//sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
		for(int i = 0; i < length - 4; i++) getData[i] = Integer.parseInt(br.readLine());//sc.nextInt(); 
		java.util.Arrays.sort(ini);
		for(int i = 0; i < 4; i++) topFour[i] = ini[i]; 
		for(int i = 0; i < length - 4; i++){
			data = getData[i];
			if(data > topFour[0]){
				if(data > topFour[1]){
					topFour[0] = topFour[1];
					if(data > topFour[2]){
						topFour[1] = topFour[2];
						if(data > topFour[3]){
							topFour[2] = topFour[3];
							topFour[3] = data;
						}
						else topFour[2] = data;
					}
					else topFour[1] = data;
				}
				else topFour[0] = data;
			}
		}		
		for(int i = 3; i > -1; i--) System.out.println(topFour[i]);
	}
}