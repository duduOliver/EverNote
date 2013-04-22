import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
 * @author
 * Du Huang
 */
public class MultiplyExceptSelf {
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Integer> ori;
		int length;
		long mulAll = 1;
		int zeroCon1;
		int zeroCon2;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine().trim());
		ori = new ArrayList<Integer>(length);
		for(int i = 0; i < length; i++) ori.add(Integer.parseInt(br.readLine().trim()));
		zeroCon1 = ori.indexOf(0);
		if(zeroCon1 != -1){
			ori.set(zeroCon1, 1);
			zeroCon2 = ori.indexOf(0);
			if(zeroCon2 != -1) {
				for(int i = 0; i < ori.size(); i++) System.out.println(0);
			}
			else {
				for(int i = 0; i < ori.size(); i++) mulAll = mulAll * ori.get(i);
				for(int i = 0; i < zeroCon1; i++) System.out.println(0);
				System.out.println(mulAll);
				for(int i = zeroCon1 + 1; i < ori.size(); i++) System.out.println(0);
			}
		}
		else {
			for(int i = 0; i < ori.size(); i++) mulAll = mulAll * ori.get(i);
			for(int i = 0; i < ori.size(); i++) System.out.println(mulAll/ori.get(i));
		}

	}
}
