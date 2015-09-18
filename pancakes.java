/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        String line = reader.readLine();
        line = reader.readLine();
        int i = 1;
        while(line != null){
        	int length = Integer.parseInt(line);
        	line = reader.readLine();
			String inputs[] = line.split(" ");
			int[] arr = new int[length];
			for(int j=0;j<inputs.length;j++){
				arr[j] = Integer.parseInt(""+inputs[j]);
			}
			int level = 0;
			System.out.println("Case #"+(i++)+": "+findMinMinutes(arr,level+1));
			line = reader.readLine();
        } 
	}
 
	public static int findMinMinutes(int[] arr,int level){
		//displayArr(arr);
		int max = maxArr(arr);
		int halfMax = max/2;
		int otherHalf = max-halfMax;
		int[] arr1 = new int[arr.length+1];
		boolean maxNotFound = true;
		if(max <= level){
			return max;
		}
		for(int i=0,j=0;i<arr.length;i++,j++){
			if(arr[i]==max && maxNotFound){
				arr1[j] = halfMax;
				arr1[j+1] = otherHalf;
				j++;
				maxNotFound = false;
			}
			else{
				arr1[j] = arr[i];
			}
		}
		return minAB(max,1+findMinMinutes(arr1,level+1));
	}
	
	public static boolean isSameArray(int[] arr1,int[] arr2){
		if(arr1.length != arr2.length)
			return false;
		for(int i = 0 ; i < arr1.length; i++){
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
	}
 
	public static void displayArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(i==arr.length-1)
				System.out.print(arr[i]);
			else
				System.out.print(arr[i]+", ");
		}
		System.out.println(" ");
	}
 
	public static int minAB(int a,int b){
		if(a<b)
			return a;
		else
			return b;
	}
 
	public static int maxArr(int[] arr){
		int max=0;
		for(int i=0;i<arr.length;i++){
			if(max<arr[i])
				max = arr[i];
		}
		return max;
	}
}