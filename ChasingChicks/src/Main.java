import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class ChickDetails {
	int speed; 
	int init; 
	int distance; 
	ChickDetails(int s, int i, int d){
		speed = s; 
		init = i; 
		distance = d; 
	}
}
public class Main {
	
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String text, textS; 
		String[] splits, splitsS; 
		int N, K, B, T; 
		ArrayList <ChickDetails> cd = new ArrayList <ChickDetails>(); 
		
		
		text = reader.readLine(); 
		splits = text.split(" "); 
		N = Integer.parseInt(splits[0]);
		K = Integer.parseInt(splits[1]);
		B = Integer.parseInt(splits[2]);
		T = Integer.parseInt(splits[3]);
		
		int[] init = new int[N]; 
		int[] speed = new int[N]; 
		int[] distance = new int[N]; 
		String[] t = new String[T+1]; 
		boolean[] qualify = new boolean[N]; 
		
		text = reader.readLine(); 
		textS = reader.readLine();
		splits = text.split(" "); 
		splitsS = textS.split(" "); 
		int count = 0; 
		for(int i = 0; i<N; i++){
			init[i] = Integer.parseInt(splits[i]); 
			speed[i] = Integer.parseInt(splitsS[i]);
			qualify[i] = false;
			distance[i] = init[i] + T*speed[i]; 
			if (distance[i] >= B)
				count++; 
		}
		if (count < K)
			return "IMPOSSIBLE"; 
		
		int swaps = 0;
		int time = 1; 
		int k = 0; 
		
		for (int i = 0; i<=T; i++){
			t[i] = "";  // meeting points
		}
		
		time = 1; 
		while (time <= T){
			for (int i = 0; i<N; i++){
				distance[i] = init[i] + time*speed[i];
			}
			for (int i = 0; i<N-1; i++){
				for (int j = i+1; j<N; j++){
					if (distance[i] == distance[j]){
						t[time] += i+","+j+","; 
					}
				}
			}
			time ++; 
		}
		
		// need to start from time T
		time = 1; 
		while (time <= T && k < K){
			if (t[time]!=""){
				if (k < K){ // some meeting point
					String[] splitsC = t[time].split(","); 
					for (int i = 0; i<splitsC.length; i=i+2){
						int a = Integer.parseInt(splitsC[i]); 
						int b = Integer.parseInt(splitsC[i+1]);
						if ((distance[a] >= B && distance[b] <=B)  || (distance[a] <= B && distance[b] >= B)){
							swaps++; 
							// need to decide what to do
						}
						else{
							int min = Math.min(speed[a], speed[b]); 
							speed[a] = speed[b] = min; 
							if (distance[a] >=B && distance[b] >= B){
								if (!qualify[a]){
									qualify[a] = true; 
									k = k + 1; 
								}
								if (!qualify[b]){
									qualify[b] = true; 
									k = k + 1;
								}
							}
						}
					}
				}
			}
			else {
				for (int i = 0; i<N; i++){
					if ((init[i] + time*speed[i] >= B) && !qualify[i]){
						k++; 
						qualify[i] = true; 
					}
				}	
			}
		time ++; 		
		}
		write = swaps + ""; 
		return write; 
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
