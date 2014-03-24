import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ListSum {
	
 public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
	 ArrayList <Integer> list = new ArrayList<Integer>();
		ArrayList <Integer> listUn = new ArrayList<Integer>(); 
		int total = Integer.parseInt(reader.readLine()); 
		int items = Integer.parseInt(reader.readLine());
		String text = reader.readLine();  
		String write = ""; 
		StringTokenizer st = new StringTokenizer(text);
		int newNum;
		int size; 
		while (st.hasMoreElements()){
			String newStr = (String)st.nextElement();  
			if (newStr == "")
				break; 
			else {
				newNum = Integer.parseInt(newStr);
				listUn.add(newNum); 
				size = list.size(); 
				if (size==0){
					list.add(newNum); 
				}
				else {
					int j; 
					for (j = 0; j<size; j++){
						if (newNum < list.get(j)){
							break; 
						}
					}
					if (j == size)
						list.add(newNum); 
					else 
						list.add(j, newNum); 
				}
			}
		} 
		
		int begin = 0; 
		int end = list.size()-1;
		int value; 
		while (begin < end){
			value = list.get(begin) + list.get(end); 
			if ( value == total){
				int a, b; 
				boolean equal = false; 
				equal = (list.get(begin) == list.get(end)); 
				a = listUn.indexOf(list.get(begin));
				if (equal){
					listUn.remove(a); 
				}
			  b = listUn.indexOf(list.get(end)); 
				if (a > b){
					int tmp = a; 
					a = b; 
					b = tmp; 
				}
				else {
					if (equal)
						b++; 
				}
				a++; b++; 
				write =  a + " "+ b; 
				break; 
			}
			else if (value < total)
				begin++; 
			else if (value > total)
				end--; 
		}
		return write; 
}
	
	public static void main(String[] args) {
		
		
		File file = new File("A-large-practice.in.txt");
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
