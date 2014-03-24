import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) {
		
		
		File file = new File("/Users/bipasachattopadhyay/Documents/workspace/RecycledNumbers/src/C-large-practice.in");
		File wfile = new File("/Users/bipasachattopadhyay/Documents/workspace/RecycledNumbers/src/output.txt");
		BufferedReader reader = null;
		BufferedWriter writter = null; 

		try {
			
				if (!wfile.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(wfile);
			  writter = new BufferedWriter(fw);
				
		    reader = new BufferedReader(new FileReader(file)); 
		    String text = ""; 
		    int number = Integer.parseInt(reader.readLine()); 
		    int count = 0; 
		    int a = 0; 
		    int b = 0; 
		    int num = 0; 
		    while (count < number){
		    	count++; 
		    	text = reader.readLine(); 
		    	StringTokenizer st = new StringTokenizer(text);
		    	num = 0; 
		    	while (st.hasMoreElements()){
		  			a = Integer.parseInt((String)st.nextElement()); 
		  			b = Integer.parseInt((String)st.nextElement());
		    	} 
		    	
		    	for (int i = a; i< b; i++){
		    		String newStr = "" + i; 
		    		int n = newStr.length(); 
		    		ArrayList <Integer> ar = new ArrayList<Integer> (); 
		    		for (int j = n-1; j>0; j--){
		    				String recycle = newStr.substring(j, n) + newStr.substring(0, j); 
		    				int re = Integer.parseInt(recycle); 
		    				if ( i < re && re <= b && re >= a && !ar.contains(re)){
		    						ar.add(re); 
		    						num++;
		    				}
		    		}
		    	}
		    	writter.write("Case #" + count + ": " + num + "\n"); 
		    }
		    
		} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
	        if (reader != null) {
	            reader.close();
	        }
	        if (writter != null){
	        	writter.close(); 
	        }
	    } catch (IOException e) {
	    }
	}
}
}
