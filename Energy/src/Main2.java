import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


public class Main2 {
	
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String[] splits;  
		
		splits = reader.readLine().split(" "); 
		long E = Long.parseLong(splits[0]); 
		long R = Long.parseLong(splits[1]);
		int N = Integer.parseInt(splits[2]);
		long gain = 0; 
		long gain1 = 0; 
		long gain2 = 0; 
		long max = 0; 

		long[] values = new long[N]; 
		splits = reader.readLine().split(" ");
		for (int i = 0; i<N; i++){
			Long value = Long.parseLong(splits[i]); 
			values[i] = value; 
			gain1 += value * R;  
			if (value > max){
				max = value; 
			}
		} 		 
		gain1 = gain1 + max * (E - R);
		if (2*R <= E){
			gain2 = gain1 + max * R;
			/*if (E-R > R){
				gain2 = gain2 + values[]
			}*/
		}
		
		if (gain1 > gain2)
			gain = gain1; 
		else 
			gain = gain2; 
		write = gain + ""; 
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
