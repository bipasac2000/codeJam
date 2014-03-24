import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;


public class Googlerese {
	
	static Hashtable <Character, Character> letter  = new Hashtable<Character, Character>();
	
	public static void buildTable(){
		File gfile = new File("/Users/bipasachattopadhyay/Documents/workspace/Googlerese/src/ginput.txt");
		File efile = new File("/Users/bipasachattopadhyay/Documents/workspace/Googlerese/src/einput.txt"); 
		BufferedReader greader = null; 
		BufferedReader ereader = null;
		String etext = null; 
		String gtext = null; 
		try {
			greader = new BufferedReader(new FileReader(gfile));
			ereader = new BufferedReader(new FileReader(efile)); 
			int number = 3; 
			char e; 
			char g; 
			while (number > 0){
				number --; 
				etext = ereader.readLine(); 
				gtext = greader.readLine(); 
				for (int i=0; i<etext.length(); i++){
					g = gtext.charAt(i); 
					e = etext.charAt(i); 
					letter.put(g, e); 
				}
			}
			letter.put('z', 'q'); 
			letter.put('q', 'z'); 
		}
		catch (FileNotFoundException e) {
	    e.printStackTrace();
	} 
		catch (IOException e) {
	    e.printStackTrace();
	    }finally {
	    try {
	        if (ereader != null) {
	            ereader.close();
	        }
	        if (greader != null) {
            greader.close();
        }
	    } catch (IOException e) {
	     }
		}
	}
	
public static void main(String[] args) {
		
		buildTable(); 
		File file = new File("/Users/bipasachattopadhyay/Documents/workspace/Googlerese/src/A-small-practice-1.in.txt");
		File wfile = new File("/Users/bipasachattopadhyay/Documents/workspace/Googlerese/src/output.txt");
		BufferedReader reader = null;
		BufferedWriter writter = null; 

		try {
			
				if (!wfile.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(wfile);
			  writter = new BufferedWriter(fw);
				
		    reader = new BufferedReader(new FileReader(file)); 
		    ///////////************
		    String text = ""; 
		    String out = ""; 
		    int number = Integer.parseInt(reader.readLine());
		    int count = 0; 
		    char c; 
		    while (count < number){
		    	out = ""; 
		    	count ++; 
		    	text = reader.readLine(); 
		    	for (int i=0; i<text.length(); i++){
						c = text.charAt(i); 
						out = out + letter.get(c); 
		    	}
		    	writter.write("Case #" + count + ": " + out + "\n");
		    	//////////*************
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
