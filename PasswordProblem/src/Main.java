import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;


public class Main {
	
	static DecimalFormat decim = new DecimalFormat("0.000000");
	
	 public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		 String write = "";
		 String text= ""; 
		 String[] splits;
		 
		 text = reader.readLine();  // reading K and N 
			splits = text.split(" "); 
			int n = Integer.parseInt(splits[0]); 
			int len = Integer.parseInt(splits[1]);
			
		 float[] prob = new float[n]; 
		 text = reader.readLine(); 
		  splits = text.split(" "); 
		  for (int i = 0; i<n; i++){
		  	prob[i] = Float.parseFloat(splits[i]); 
		  }
		  
		 float best = (float) ((float)len + 2.0);
		 float E; 
		 float x = 1; 
		 for (int i = 0; i<n; i++){
		    x *= prob[i]; 
		    E = (len - i) + (n - i - 1) + (len + 1) * (1 - x); 
		    if (E < best)
		    	best = E; 
		 }
		 write = decim.format(best); 
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
