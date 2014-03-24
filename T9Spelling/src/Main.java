import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;


class Index {
	int value; 
	int times;
	Index(){
		value = 0; 
		times = 0; 
	}
	Index(int v, int t){
		value = v; 
		times = t; 
	}
}

public class Main {

public static void main(String[] args) {
		
		//File file = new File("/Users/bipasachattopadhyay/Documents/workspace/T9Spelling/src/input.txt");
		File file = new File("/Users/bipasachattopadhyay/Downloads/codeJam/C-small-practice.in.txt"); 
		File wfile = new File("/Users/bipasachattopadhyay/Documents/workspace/T9Spelling/src/output.txt");
		BufferedReader reader = null;
		BufferedWriter writter = null; 

		try {
			
				if (!wfile.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(wfile);
			  writter = new BufferedWriter(fw); 
		    reader = new BufferedReader(new FileReader(file));
		    String text =""; 
		    String t9 =""; 
		    int number = Integer.parseInt(reader.readLine()); 
		    int count = 0; 
		    Hashtable <Integer, Index> hash = new Hashtable <Integer, Index>(); 
		    int i; 
		    
		    for (i = 97; i<=122; i++){  
		    	Index index; 
		    		if (i <= 99)
		    			index = new Index(2, i-96);  
		    		else if (i <= 102)
		    			index = new Index(3, i-99); 
		    		else if (i <= 105)
		    			index = new Index(4, i-102); 
		    		else if (i <= 108)
		    			index = new Index(5, i-105); 
		    		else if (i <= 111)
		    			index = new Index(6, i-108); 
		    		else if (i <= 115)
		    			index = new Index(7, i-111); 
		    		else if (i <= 118)
		    			index = new Index(8, i-115); 
		    		else
		    			index = new Index(9, i-118); 
		    	hash.put(i, index);
		    }
		    Index space = new Index (0, 1); 
		    hash.put(32, space); 
		    
		    int val = 0; 
		    int prevVal = -1; 
		    int c; 
		    int times; 
		    while (count < number){
		    	count ++; 
		    	text = reader.readLine(); 
		    	t9 = ""; 
		    	prevVal = -1;  
		    	for (i=0; i<text.length(); i++){
		    		c = (int)text.charAt(i);
		    		val = hash.get(c).value;
		    	  times = hash.get(c).times; 
		    		if ( prevVal == val)
		    			t9 = t9 + " "; 
		    		for (int j = 0; j<times; j++)
		    			t9 = t9 + ("" + val); 
		    		prevVal = val; 
		    	}
		    	writter.write("Case #"+count+": "+ t9 + "\n"); 
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
