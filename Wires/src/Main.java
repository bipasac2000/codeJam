import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


class Wire{
	int left; 
	int right; 
	public Wire(int l, int r){
		left = l; 
		right = r; 
	}
}

public class Main {
	
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String text; 
		String[] splits; 
		ArrayList <Wire> wires = new ArrayList <Wire>(); 
		
		int n = Integer.parseInt(reader.readLine());		
		for(int i = 0; i<n; i++){
			text = reader.readLine(); 
			splits = text.split(" ");
			Wire w = new Wire(Integer.parseInt(splits[0]), Integer.parseInt(splits[1])); 
			if (wires.size() == 0){
				wires.add(w); 
			}
			else {
				int j = 0; 
				for (j = 0; j<wires.size(); j++){
					if (w.left < wires.get(j).left){
						wires.add(j, w); 
						break; 
					}
				}
				if (j == wires.size()){
					wires.add(w); 
				}
			}
		}
		
		int intersects = 0; 
		int right;
		int left; 
		int r, l; 
		for (int i = 0; i<n; i++){
			left = wires.get(i).left;
			right = wires.get(i).right; 
			for (int j = i+1; j<n; j++){
				l = wires.get(j).left; 
				r = wires.get(j).right; 
				if (left < l && right > r)
					intersects++; 
			}
		}
		write = intersects + ""; 
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
