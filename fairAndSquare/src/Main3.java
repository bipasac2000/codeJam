import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main3 {
	
	public static double invSqrt(double x) {
    double xhalf = 0.5d*x;
    long i = Double.doubleToLongBits(x);
    i = 0x5fe6ec85e7de30daL - (i>>1);
    x = Double.longBitsToDouble(i);
    x = x*(1.5d - xhalf*x*x);
    return x;
   }
	
	public static float invSqrt(float x) {
    float xhalf = 0.5f*x;
    int i = Float.floatToIntBits(x);
    i = 0x5f3759df - (i>>1);
    x = Float.intBitsToFloat(i);
    x = x*(1.5f - xhalf*x*x);
    return x;
   }
	
	public static boolean Pallindrome(String num){
		 
		 int begin = 0; 
		 int end = num.length()-1; 
		 while (begin < end){
			 if (num.charAt(begin)!= num.charAt(end))
				 return false; 
			 begin++; 
			 end--; 
		 }
		 if (begin == end || begin == end + 1)
			 return true;
		 
		return false; 
	 }
	
	 public static double Square(double num){
		 
		 double s = invSqrt(num); 
		 if (Math.floor(s) < s)
			 return -1.0f; 
		 else 
		  return s; 
	 }
	
	 public static String compute(BufferedReader reader) throws NumberFormatException, IOException{
		 String write = ""; 
		 String text = reader.readLine(); 
		 StringTokenizer st = new StringTokenizer(text); 
		 double start = Double.valueOf(st.nextToken()).doubleValue();
		 double stop = Double.valueOf(st.nextToken()).doubleValue();
		 int count = 0; 
		 boolean pallindrome; 
		 boolean pallindromeS;
		 double j = Math.floor(invSqrt(start)); 
		 double i = j * j;  
		 if (i < start){
			 j = j + 1; 
			 i = j * j; 
		 }
		 while(i<=stop){
			 
			 pallindromeS = Pallindrome(j+""); 
			 if (!pallindromeS){
				 j = j+1.0; 
				 i = j*j;
				 continue;
			 }
			 
			 pallindrome = Pallindrome(i+""); 
			 if (!pallindrome){
				 j = j+1.0; 
				 i = j*j;
				 continue; 
			 }
			 
			 j = j+1.0; 
			 i = j*j; 
			 count ++; 
		 }
		 write = count + ""; 
		 return write; 
	 }
	 
	public static void main(String[] args) {
	File file = new File("C-large-2.in");
	File wfile = new File("outputlarge2.txt");
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
