import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main2 {
	
public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
	String write = ""; 
	String text = ""; 
	text = reader.readLine(); 
	StringTokenizer stNM = new StringTokenizer(text); 
	int n = Integer.parseInt(stNM.nextToken());
	int m = Integer.parseInt(stNM.nextToken()); 
	int[][] garden = new int[n][m]; // row, column 
 	
	for (int i =0; i<n; i++){
 		text = reader.readLine(); 
 		StringTokenizer st = new StringTokenizer(text);
 		for (int j=0; j<m; j++){
 			int value = Integer.parseInt(st.nextToken()); 
 			garden[i][j] = value; 
 		}
 	}
  int curr =0; 
	for(int i =0; i<n; i++){
		for (int j = 0; j<m; j++){
			curr = garden[i][j]; 
 
			boolean first = true;
			for (int k = 0; k<n; k++)
				if (curr<garden[k][j]){
					first = false; 
				}

			  
			boolean second = true; 
			for (int k=0; k<m; k++)
				if(curr<garden[i][k]){
					second = false; 
				}

			if (first){
				continue; 
			}
			else {
				if (second)
					continue; 
				else {
					write = "NO"; 
				  return write;
				}
			}
		}
	}
	
	write = "YES";
	return write; 
}
public static void main(String[] args) {
		
		
		File file = new File("input.txt");
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
		  		//writter.write("Case #" + i + ": "+ compute(reader) + "\n"); 
		  		System.out.println("Case #" + i + ": "+ compute(reader)); 
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
