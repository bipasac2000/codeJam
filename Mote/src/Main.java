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
		String[] splits;  
		splits = reader.readLine().split(" "); 
		
		int myMote = Integer.parseInt(splits[0]); 
		int N = Integer.parseInt(splits[1]);
		ArrayList <Integer> motes = new ArrayList <Integer>();
		
		
		splits = reader.readLine().split(" ");
		for (int i = 0; i<N; i++){
			int otherMote = Integer.parseInt(splits[i]);
			if (motes.isEmpty()){
				motes.add(otherMote);
			}
			else {
				int j;
				boolean added = false; 
				for (j = 0; j<motes.size(); j++){
					if (otherMote <= motes.get(j)){
						motes.add(j, otherMote);  
						added = true; 
						break; 
					}
				}
				if (!added)
					motes.add(j, otherMote);
			}
		}
		
		if (myMote == 1)
			return N+""; 
		
		int bestAnswer = N; 
		int myAnswer = 0; 
		
		for (int i = 0; i<N; i++){
				if (myMote > motes.get(i)){
					myMote = myMote + motes.get(i); 
					continue; 
				}
				
					bestAnswer = Math.min(bestAnswer, myAnswer + N - i);
					while (myMote <= motes.get(i)){
						myMote = myMote + myMote - 1; // the new mote
						myAnswer++; 
					}
					myMote = myMote + motes.get(i); // the mote that I will absorb next
		}
		bestAnswer = Math.min(myAnswer, bestAnswer); 
		write = bestAnswer + ""; 
		return write; 
	}
public static void main(String[] args) {
		
		
		File file = new File("A-small-attempt0.in");
		File wfile = new File("outputsmall3.txt");
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
