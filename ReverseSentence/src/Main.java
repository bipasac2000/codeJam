import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
public static void main(String[] args) {
		
		
		File file = new File("/Users/bipasachattopadhyay/Documents/workspace/Problem2/src/B-large-practice.in.txt");
		File wfile = new File("/Users/bipasachattopadhyay/Documents/workspace/Problem2/src/output.txt");
		BufferedReader reader = null;
		BufferedWriter writter = null; 

		try {
			
				if (!wfile.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(wfile);
			  writter = new BufferedWriter(fw); 
		    reader = new BufferedReader(new FileReader(file));
		    ///***
		    int number = Integer.parseInt(reader.readLine());
		    int count = 0; 
		    String text = null; 
		    while (count < number){
		    	count ++; 
		    	ArrayList <String> words = new ArrayList<String>(); 
		    	text = reader.readLine(); 
		    	StringTokenizer st = new StringTokenizer(text);
		  		while (st.hasMoreElements()){
		  			String newStr = (String)st.nextElement();  
		  			words.add(newStr); 
		  		}
		  		writter.write("Case #" + count + ": "); 
		  		for (int i=words.size()-1; i>=0; i--)
		  			writter.write(words.get(i)+" "); 
		  		writter.write("\n"); 
		    }
		//**      
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
