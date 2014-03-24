import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Pair{
	String robot; 
	int num; 
	Pair(String s, int n){
		robot = s; 
		num = n;
	}
}

public class Main1 {
	
	
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String text = reader.readLine(); 
		StringTokenizer st = new StringTokenizer(text);
		int time = 0; 
		int opos = 1; 
		int bpos = 1; 
		int moves = Integer.parseInt((String)st.nextElement()); 
		LinkedList <Integer> Omoves = new LinkedList <Integer>(); 
		LinkedList <Integer> Bmoves = new LinkedList <Integer>(); 
		LinkedList <Pair> Allmoves = new LinkedList <Pair>();
		
		while (st.hasMoreElements()){	 
			for (int i=0; i<moves; i++){
				String robot = (String)st.nextElement(); 
				int num = Integer.parseInt((String)st.nextToken()); 
				Allmoves.add(new Pair(robot, num)); 
				if (robot.equals("O"))
					Omoves.add(num); 
				else if (robot.equals("B"))
					Bmoves.add(num); 
			}
		}
    
		while (!Allmoves.isEmpty() && !Bmoves.isEmpty() && !Omoves.isEmpty()){
			
			Pair p = Allmoves.remove(); 
			int bnum = Bmoves.peek(); 
			int onum = Omoves.peek(); 
			
			if (p.robot.equals("O")){
				Omoves.remove();
				while(opos!=onum){
					
					if (opos < onum){
						opos++; 
						time++; 
					}
					else if (opos > onum){
						opos--; 
						time++; 
					}
					
					if(bpos < bnum) 
						bpos++; 
					else if (bpos > bnum)
						bpos--; 
				}
				time++; // to push the button
				if(bpos < bnum) 
					bpos++; 
				else if (bpos > bnum)
					bpos--; 
			}
			else if (p.robot.equals("B")){
				Bmoves.remove();
				while(bpos!=bnum){
					
					if (bpos < bnum){
						bpos++; 
						time++; 
					}
					else if (bpos > bnum){
						bpos--; 
						time++; 
					}
					
					if(opos < onum) 
						opos++; 
					else if (opos > onum)
						opos--; 
				}
				time++; // to push the button
				if(opos < onum) 
					opos++; 
				else if (opos > onum)
					opos--; 
			}
		}
		
		while (!Allmoves.isEmpty() && !Bmoves.isEmpty()){
			
			Pair p = Allmoves.remove(); 
			int bnum = Bmoves.remove();
			while(bpos!=bnum){
				
				if (bpos < bnum){
					bpos++; 
					time++; 
				}
				else if (bpos > bnum){
					bpos--; 
					time++; 
				}
			}
			time++; // to push the button
		}
		while (!Allmoves.isEmpty() && !Omoves.isEmpty()){
			Pair p = Allmoves.remove(); 
			int onum = Omoves.remove(); 
			while(opos!=onum){
				
				if (opos < onum){
					opos++; 
					time++; 
				}
				else if (opos > onum){
					opos--; 
					time++; 
				}
			}
			time++;  // time to push the button
		}
		write = time+""; 	
		return write; 
	}
public static void main(String[] args) {
		
		
		File file = new File("A-large-practice.in");
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
