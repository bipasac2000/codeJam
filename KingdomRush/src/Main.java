import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Level{
	int oneRating; 
	int twoRating; 
	boolean oneCompleted;
	boolean twoCompleted; 
	public Level(int o, int t, boolean oc, boolean tc){
		oneRating = o; 
		twoRating = t; 
		oneCompleted = oc;
		twoCompleted = tc; 
	}
}

public class Main {
	
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		 String write = "";
		 String text= ""; 
		 String[] splits;
		 int levels; 
		 ArrayList <Level> levelList = new ArrayList<Level>(); 
		 
		 levels = Integer.parseInt(reader.readLine());
		 for (int i = 0; i<levels; i++){
			 text = reader.readLine(); 
			 splits = text.split(" ");
			 Level l = new Level(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]), false, false); 
			 levelList.add(l); 
		 }
		 
		 int count = 0; 
		 boolean played = false; 
		 int stars = 0; 
		 int i=0;
		 int size = levelList.size(); 
		 while (true){
		 played = false; 
		 for (i =0; i<size; i++){
			 Level l = levelList.get(i); 
			 if (!l.twoCompleted && stars >= l.twoRating){ // can play level two
				 if (l.oneCompleted)
					 stars += 1;
				 else 
					 stars += 2; 
				 l.twoCompleted = true;
				 played = true; 
				 System.out.println("Played two star for level " + i);
			  }
			 if (played)
				 break; 
		  }
		 
		  if (played){
		  	count ++; 
		  	continue;  
		  }
		  
		  int j = -1; // will play this level
		  int max = 0; 
			for (i = 0; i<size; i++){ 
				Level l = levelList.get(i);
				if (!l.oneCompleted && stars >= l.oneRating && !l.twoCompleted)
					if (l.twoRating > max){
						j = i; 
						max = l.twoRating;  
					}
			}
			if (j > -1){
				  Level l = levelList.get(j);
					stars += 1; 
					l.oneCompleted = true; 
					played = true; 
					System.out.println("Played one star for level " + j);
			}
			 
			if (played){
				 count++; 
				 continue; 
			 }
			 else 
				 break; 
			 
		 }
		 
		 for (i = 0; i<size; i++){
			 if (!levelList.get(i).twoCompleted){
				 System.out.println("Not played two start level " + i);
				 break; 
			 }
		 }
		 
		 if (i == size)
			 write = count + ""; 
		 else 
			 write = "Too Bad"; 
		 return write; 
	 }
	
public static void main(String[] args) {
		
		
		File file = new File("B-large-practice.in.txt");
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
		  		System.out.println("Case " + i ); 
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
