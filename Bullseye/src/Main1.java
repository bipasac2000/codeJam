import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


public class Main1 {
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String text; 
		String[] splits; 
		
		text = reader.readLine(); 
		splits = text.split(" "); 
		long r = Long.parseLong(splits[0]); 
		long t = Long.parseLong(splits[1]); 
		long circles = 0; 
    long paint = 0;
    long num = 0; 
    
		while (t>0){
			//paint = (r+1+num)*(r+1+num) - (r+num)*(r+num); 
			paint = (r+num)<<1 + 1; 
			if (t-paint >= 0){
				circles++; 
			}
			t = t - paint;
			num = num + 2; 
		} 		 
		write = circles + ""; 
		return write; 
	}
public static void main(String[] args) {
		
		
		File file = new File("input.txt");
		File wfile = new File("output.txt");
		BufferedReader reader = null;
		BufferedWriter writter = null; 

		try {
			
				if (!wfile.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(wfile);
			  writter = new BufferedWriter(fw);
				
		    reader = new BufferedReader(new FileReader(file)); 
		  	int number = Integer.parseInt(reader.readLine());
		  	for (int i = 1; i<=number; i++){
		  		writter.write("Case #" + i + ": "+ compute(reader) + "\n"); 
		  		//System.out.println("Case #" + i + ": "+ compute(reader)); 
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
