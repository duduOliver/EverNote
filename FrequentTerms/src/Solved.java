import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/*
 * @author
 * Du Huang
 */
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] read;
		HashMap<String, Integer> terms;
		int length;
		Collection<Integer> values;
		Integer[] sortedVal;
		ArrayList<String> prt = new ArrayList<String>();
		int printNum;
		int times = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		length = Integer.parseInt(br.readLine().trim());
		read = new String[length];
		for(int i = 0; i < read.length; i++) read[i] = br.readLine().trim();
		printNum = Integer.parseInt(br.readLine().trim());
		
		terms = new HashMap<String, Integer>(length);
		for(int i = 0; i < length; i++) {
			Object incre = terms.put(read[i], 1);
			if(incre == null){}
			else terms.put(read[i], (Integer)incre + 1);
			
		}
		values = terms.values();
		sortedVal = values.toArray(new Integer[0]);
		java.util.Arrays.sort(sortedVal);
		int pm = printNum;
		while(printNum > 0){
			int searchVal = sortedVal[sortedVal.length - 1 - pm + printNum];
			prt.clear();
			for(String key : terms.keySet()){
				if(searchVal == terms.get(key)) prt.add(key);
			}
			String[] toPrint = prt.toArray(new String[0]);
			java.util.Arrays.sort(toPrint);
			for(times = 0; times < toPrint.length && times < printNum; times++) System.out.println(toPrint[times]);
			printNum = printNum - times;
		}
	}
}

