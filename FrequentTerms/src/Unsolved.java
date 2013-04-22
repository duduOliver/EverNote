import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
 * @author
 * Du Huang
 */
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String ele;
		int position;
		int printNum;
		int times = 0;
		ArrayList<String> terms = new ArrayList<String>(length);
		int[] freq = new int[length];
		ArrayList<Integer> refer = new ArrayList<Integer>(length);
		
		terms.add(br.readLine().trim());
		freq[0] = 1;
		refer.add(1);
		
		for(int i = 1; i < length; i++){
			ele = br.readLine().trim();
			position = terms.indexOf(ele);
			if(position == -1){
				terms.add(ele);
				freq[i] = 1;
				refer.add(1);
			}
			else {
				freq[position] = freq[position] + 1;
				refer.set(position, refer.get(position)+1);
			}
		}
		
		printNum = Integer.parseInt(br.readLine().trim());
		refer.trimToSize();
		java.util.Arrays.sort(freq, 0, refer.size());
		int prP = printNum;
		
		while(printNum > 0) {
			int key = freq[refer.size() - 1 - prP + printNum];
			String[] toPrint = (new termsToPrint()).termsToPrint(key, refer, terms);
			for(times = 0; times < toPrint.length && times < printNum; times++) System.out.println(toPrint[times]);
			printNum = printNum - times;
		}
		
	}
}

class termsToPrint {
	ArrayList<String> toP = new ArrayList<String>();
	public String[] termsToPrint(int k, ArrayList<Integer> r, ArrayList<String> t){
		int firstPo = r.indexOf(k);
		int lastPo  = r.lastIndexOf(k);
		String[] priT;
		
		if(firstPo == lastPo && firstPo != -1){
			toP.add(t.get(firstPo));
		}
		else if(firstPo != -1) {
			r.set(firstPo, -1);
			r.set(lastPo, -1);
			toP.add(t.get(firstPo));
			toP.add(t.get(lastPo));
			termsToPrint(k, r, t);	
		}
		
		priT = new String[toP.size()];
		priT = toP.toArray(priT);
		java.util.Arrays.sort(priT);
		return priT;
	}
}