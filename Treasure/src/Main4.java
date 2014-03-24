import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Chest{
	int id; 
	int key; 
	ArrayList <Integer> keys = new ArrayList <Integer>(); 
	boolean opened;  
	Chest(int i, int k, ArrayList<Integer>ks, boolean o, boolean v){
		key = k; 
		keys = ks; 
		opened = o; 
		id = i; 
	}
}

public class Main4 {

	public static Stack <Chest> openChest(ArrayList<Chest>chests, ArrayList<Integer> Keys){
		
		 Stack <Chest> stack = new Stack <Chest>();
		 Stack <Integer> stackKeys = new Stack <Integer>(); 
		 Chest empty = new Chest(0, 0, new ArrayList<Integer>(), false, false); 
	
		if (chests.size()==0)
			return stack; 
		else if(chests.size() == 1){
			if (Keys.contains(chests.get(0).key)){
				Chest c = chests.get(0); 
				stack.push(c); 
				return stack; 
			}
			else{ 
				stack.push(empty); 
				return stack; 
			}
		}
		
		 
		 Chest prevChest = empty; 
		 boolean opened = false; 
		 int count = 0; 
		 while (count < 20){
			 count ++; 
		 ArrayList <Chest> unopened = new ArrayList<Chest>(); 
		 
		 for (int i = 0; i< chests.size(); i++){
			 if (chests.get(i).opened == false)
				 unopened.add(chests.get(i)); 
		 }
		 
		 if (unopened.isEmpty())
		  	return stack; 
		 
		 opened = false;  
			 for (int j = 0; j<unopened.size(); j++){
				 Chest c = unopened.get(j);
				 int theKey = c.key; 
				 if (Keys.contains(theKey) && (c.id > prevChest.id)){
					 prevChest = empty; 
					 stack.push(c); 
					 System.out.println("Pushed to stack " + c.id); 
					 c.opened = true; 
					 stackKeys.push(theKey); 
					 System.out.println("Pushed to stack Keys " + theKey);
					 Keys.remove((Object)theKey); 
					 ArrayList <Integer> keys = c.keys; 
					 for (int k = 0; k<keys.size(); k++){
							 Keys.add(keys.get(k)); 
					 }
					 opened = true; 
					 break; 
				 }
			 }
		 
				if (!opened){
					if (stack.isEmpty()){
						stack.push(empty); 
						return stack; 
					}
					else {
						
						/// this is to exit early
						
						ArrayList<Integer> AllRemain = new ArrayList<Integer>(); 
						for (int k = 0; k<unopened.size(); k++){
							Chest c = unopened.get(k); 
							for (int j = 0; j<unopened.size(); j++){
									Chest helperC = unopened.get(j); 
									ArrayList <Integer> hk = helperC.keys; 
									for (int i = 0; i<hk.size(); i++){
										AllRemain.add(hk.get(i)); 
									}
							}
							if (!AllRemain.contains(c.key)){
								stack.push(empty); 
								return stack;
							}
						}

						
						/// **** 
						
						prevChest = stack.pop(); 
						System.out.println("Popped from stack " + prevChest.id);
						prevChest.opened = false; 
						int popedKey = stackKeys.pop(); 
						System.out.println("Popped from stack Keys " + popedKey);
						Keys.add(popedKey); 
						ArrayList <Integer> keys = prevChest.keys; 
						for (int k = 0; k<keys.size(); k++)
							Keys.remove((Object)keys.get(k)); 
					}
				}
		}
		 return stack; 
	}
	
	public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		String write = ""; 
		String text; 
		String[] splits; 
		ArrayList <Integer> Keys = new ArrayList<Integer>();
		ArrayList <Chest> chests = new ArrayList<Chest>();
		
		text = reader.readLine();  // reading K and N 
		splits = text.split(" "); 
		int K = Integer.parseInt(splits[0]); 
		int N = Integer.parseInt(splits[1]);
		System.out.println(K + " " + N); 
		
		text = reader.readLine(); // reading Keys
		splits = text.split(" "); 
		for(int i = 0; i<K; i++)
			Keys.add(Integer.parseInt(splits[i]));
		
		for (int i =0; i<N; i++){ 
			text = reader.readLine(); 
			splits = text.split(" "); 
			int T = Integer.parseInt(splits[0]); // key to open chest
			int ks = Integer.parseInt(splits[1]); // number of keys in chest
			ArrayList <Integer> arr = new ArrayList<Integer>();  
			for (int j=2; j<ks+2; j++){
				arr.add(Integer.parseInt(splits[j])); 
			}
		  Chest chest = new Chest(i+1, T, arr, false, false); 
		  chests.add(chest); 
		}
		
		Stack <Chest> stack = openChest(chests, Keys); 
		int id; 
		while(!stack.isEmpty()){
			id = stack.pop().id; 
			if (id == 0){
				write = "IMPOSSIBLE";
				break; 
			}
			else
				if (write == "")
					write = id + "";
				else 
					write = id + " " + write;  
		}
		return write; 
	}
	
public static void main(String[] args) {
		
		
		File file = new File("D-small-attempt0.in");
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
