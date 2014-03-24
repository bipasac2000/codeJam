import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Square{
	int type; // 0 for mirror, 1 for empty, 2 for myself
	int x; 
	int y; 
	Square (int i, int j, int t){
		x = i; 
		y = j; 
		type = t; 
	}
}

public class Main {
	
	public static void main(String args[]){
		File file = new File("/Users/bipasachattopadhyay/Documents/workspace/HallofMirror/src/input.txt");
		File wfile = new File("/Users/bipasachattopadhyay/Documents/workspace/HallofMirror/src/output.txt");
		BufferedReader reader = null;
		BufferedWriter writter = null; 

		try {
			
				if (!wfile.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(wfile);
			  writter = new BufferedWriter(fw);
				
		    reader = new BufferedReader(new FileReader(file)); 
		    
		    String text = null; 
		    int number = Integer.parseInt(reader.readLine());
		    int count = 0; 
		    int W = 0; 
		    int D = 0; 
		    int H = 0; 
		    while(count < number){
		    	count ++; 
		    	text = reader.readLine(); 
		    	StringTokenizer st = new StringTokenizer(text); 
		    	H = Integer.parseInt((String)st.nextElement()); 
		    	W = Integer.parseInt((String)st.nextElement());
		    	D = Integer.parseInt((String)st.nextElement());
		    	Square[][] maze = new Square[W][H]; 
		    	Square me; 
		    	for (int i = 0; i< H; i++){
		    		text = reader.readLine(); 
		    		for (int j = 0; j<W; j++){
		    			if (text.charAt(j)=='#')
		    				maze[j][i] = new Square(j, i, 0); 
		    			else if (text.charAt(j)=='.')
		    				maze[j][i] = new Square(j , i, 1); 
		    			else if (text.charAt(j) == 'X'){
		    				maze[j][i] = new Square(j, i, 2);
		    				me = maze[j][i]; 
		    			}
		    		}
		    	}
		    	
		    
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

