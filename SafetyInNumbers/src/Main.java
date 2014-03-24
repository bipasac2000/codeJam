import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


public class Main {
	
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String text; 
		String[] splits; 
		text = reader.readLine(); 
		splits = text.split(" "); 
		int n = Integer.parseInt(splits[0]); 
		int[] myscore = new int[n]; 
		float total = 0; 
		float prob = (float) 1.0;
		if (n == 1)
			return "0.00000"; 
		float min = 101; 
		int pos = 0;
		for (int i = 0; i<n; i++){
			myscore[i] = Integer.parseInt(splits[i+1]); 
			total = total + myscore[i]; 
			if (myscore[i] < min){
				min = myscore[i]; 
				pos = i;
			}
		}
		System.out.println(min + ""); 
		float minvotes = (float)( 2 - n*(float)min/total)/(float)n; 
		System.out.println(minvotes+"");  
		float myvotes; 
		for (int i = 0; i<n; i++)
			if (i == pos){
				write += minvotes * 100 + " "; 
			}
			else { 
				myvotes = minvotes - (myscore[i] - min)/total; 
				if (myvotes < 0)
					write += "0.000000 ";
				else 
					write += myvotes * 100 + " ";
			}
		return write; 
	}
	
public static void main(String[] args) {
		
		
		File file = new File("A-small-practice.in");
		File wfile = new File("outputsmall.txt");
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
