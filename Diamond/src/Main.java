import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


public class Main {
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String text; 
		String[] splits; 
		int n = Integer.parseInt(reader.readLine()); 
		ArrayList<ArrayList<Integer>> inht = new ArrayList<ArrayList<Integer>>(); 
		for (int i = 0; i<n; i++){
			text = reader.readLine(); 
			splits = text.split(" ");
			int m = Integer.parseInt(splits[0]); 
			ArrayList <Integer> myInht = new ArrayList<Integer>(); 
			for (int j = 1; j<=m; j++){
				myInht.add(Integer.parseInt(splits[j])); 
			}
			inht.add(myInht); 
		}
		
		for (int i = 0; i< n; i++){
			ArrayList <Integer> myInht = inht.get(i);
			ArrayList <Integer> otherInht; 
			Hashtable <Integer, Integer> dup = new Hashtable<Integer, Integer>(); 
			for (int j = 0; j<myInht.size(); j++){
				dup.put(myInht.get(j), 1); 
			}
			while (!myInht.isEmpty()){
				int cl = myInht.remove(0);   
				otherInht = inht.get(cl-1); 
				for(int k = 0; k<otherInht.size(); k++){ 
					int inhtcl = otherInht.get(k);
					if (dup.containsKey(inhtcl)){
						write = "Yes"; 
						return write; 
					}
					dup.put(inhtcl, 1); 
					myInht.add(inhtcl);
				}
			}
		}
		write = "No"; 		 
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
