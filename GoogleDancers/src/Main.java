import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
	
	public static void main (String[] args){
	File file = new File("/Users/bipasachattopadhyay/Documents/workspace/GoogleDancers/src/B-large-practice.in");
	File wfile = new File("/Users/bipasachattopadhyay/Documents/workspace/GoogleDancers/src/output.txt");
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
	    int n, s, p; 
	    int num = 0; 
	    int total = 0; 
	    while (count < number){
	    	//ArrayList <Integer> total = new ArrayList<Integer>(); 
	    	total = 0; 
	    	count ++ ; 
	    	text = reader.readLine(); 
	    	StringTokenizer st = new StringTokenizer(text);
	    	n=0; 
	    	s=0; 
	    	p=0; 
	    	num = 0; 
	    	while (st.hasMoreElements()){
	  			n = Integer.parseInt((String)st.nextElement());
	  			s = Integer.parseInt((String)st.nextElement());
	  			p = Integer.parseInt((String)st.nextElement());
	  			for (int j = 0; j<n; j++){
	  				total = Integer.parseInt((String)st.nextElement()); 
	  				if ((3*p) <= total)
	  					num++; 
	  				else if ((3*p -1) <= total && p >= 1)
	  					num++; 
	  				else if ((3*p -2) <= total && p >= 1)
	  					num++; 
	  				else if ((3*p - 3) <= total && s!=0 && p >= 2){
	  					num++; 
	  					s--;
	  				}
	  				else if ((3*p - 4) <= total && s!=0 && p >= 2){
	  					num++; 
	  					s--; 
	  				}
	  			}
	    	}
	    	writter.write("Case #" + count + ": " + num +"\n"); 
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
