/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        String line = reader.readLine();
        line = reader.readLine();
        int i = 1;
        while(line != null){
			String inputs[] = line.split(" ");
			int shyMax = Integer.parseInt(inputs[0]);
			String st = inputs[1];
			int[] arr = new int[st.length()];
			for(int j=0;j<st.length();j++){
				arr[j] = Integer.parseInt(""+st.charAt(j));
			}
			System.out.println("Case #"+(i++)+": "+findMinFriends(arr));
            line = reader.readLine();
 
        }  
	}
 
	public static int findMinFriends(int[] arr){
		int noOfFriends = 0;
		int currentShynessLevel = 0;
		int totalPeople = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0){
				if(totalPeople<i){
					noOfFriends += (i-totalPeople);
					totalPeople += (i-totalPeople);
				}
				totalPeople += arr[i];
			}
		}
		return noOfFriends;
	}
 
	public static String readBigStringIn(BufferedReader buffIn) throws IOException {
	    StringBuilder everything = new StringBuilder();
	    String line;
	    while( (line = buffIn.readLine()) != null) {
	       everything.append(line);
	    }
	    return everything.toString();
	}
}