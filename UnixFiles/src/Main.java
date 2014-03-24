import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
	
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String text; 
		String[] splits; 
		int n, m; 
		ArrayList <String> directories = new ArrayList <String>(); 
		
		text = reader.readLine(); 
		splits = text.split(" "); 
		n = Integer.parseInt(splits[0]);
		m = Integer.parseInt(splits[1]);
		for(int i = 0; i<n; i++){
			text = reader.readLine(); 
			directories.add(text); 
			}
		
		int dirCount = 0; 
		int longestMatch = 0; 
		for (int i = 0; i<m; i++){
			text = reader.readLine().substring(1); 
			splits = text.split("/");
			longestMatch = 0; 
			for (int j = 0; j<directories.size(); j++){
				String dir = directories.get(j).substring(1); 
				String[] osplits = dir.split("/");
				int min = Math.min(osplits.length, splits.length); 
				int match = 0; 
				for (int k = 0; k<min; k++){
					if (!splits[k].equals(osplits[k])){
						break;
					}
					match++; 
				} 
				if (match > longestMatch)
					longestMatch = match; 
			 }
			String newDir = "";
			for (int k =0; k <= longestMatch-1; k++){
				newDir += "/"+splits[k]; 
			}
			System.out.println("prefix "+newDir);
			for (int k = longestMatch; k<splits.length; k++){
				newDir += "/"+splits[k]; 
				System.out.println("added directory "+newDir); 
				directories.add(newDir); 
				dirCount++; 
			}
			
		}
		write = dirCount + ""; 
		return write; 
	}
public static void main(String[] args) {
		
		
		File file = new File("A-large-practice-1.in.txt");
		File wfile = new File("outputlarge.txt");
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
