import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	 public static void compute(BufferedReader reader, BufferedWriter writter) throws NumberFormatException, IOException{
		   
			String text = reader.readLine(); 
			String[] splits = text.split(" "); 
			double D = Double.parseDouble(splits[0]); 
			int N = Integer.parseInt(splits[1]); 
			int A = Integer.parseInt(splits[2]);
			
			double[] time = new double[N]; 
			double[] distance = new double[N];  
			double[] acc = new double[A]; 
			
			for (int i = 0; i<N; i++){
				text = reader.readLine(); 
				splits = text.split(" "); 
				time[i] = Double.parseDouble(splits[0]); 
				distance[i] = Double.parseDouble(splits[1]);
			}
			
			text = reader.readLine();
			splits = text.split(" "); 
			double vcar, meet, distme; 
			boolean met; 
			for (int i = 0; i<A; i++){
				 acc[i] = Double.parseDouble(splits[i]);
				 vcar = 0.0; 
				 meet = 0.0; 
				 met = false; 
				 distme = 0; 
				 for (int j = 0; j<N; j++){
					 vcar = distance[j]/time[j]; 
					 if(!met){
						 if (j == 0)
							 distme = 0; 
						 else 
							 distme += distance[j-1]; 
						 // Not complete
						 meet = (vcar + vcar)/acc[i]; 
						 if ( meet <= time[j]){
							 met = true;
						 }
					 }
					 else{
						 if (distance[j]<=D){
							 meet += distance[j]/vcar; 
						 }
						 else {
							 meet += (D - distance[j-1])/vcar; 
						 }
					 } 
				 }
				 if (!met){
					 System.out.println("Free fall home " + acc[i]); 
					 meet = Math.sqrt((D + D)/acc[i]); 
				 }
				 writter.write(meet+"\n");
			}
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
			  		writter.write("Case #" + i + ": " + "\n"); 
			  		compute(reader, writter); 
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
