
import java.util.*;
import java.io.*;

	public class Quick{
	  public static void main(String[] args){
	    //testing partition
	    int[] sorted = {-100,-99,-88,0,2,3,99,100};
      int[] ary = {-100,-99,99,-88,100,0,3,2};
	    for(int i=0;i<8;i++){

	      System.out.println(Arrays.toString(ary));
	      int val = quickSelect(ary,i);
	      System.out.println(val);
	      if(val != sorted[i]) System.out.println("error: "+Arrays.toString(ary));

	    }

      quicksort(ary);
      System.out.println(Arrays.toString(ary));
	  }
    private static void swap(int[] data, int a, int b) {
    		int x = data[a];
    		data[a] = data[b];
    		data[b] = x;
    	}

  	public static int quickSelect(int[] data, int k) {
  		int start = 0;
  		int end = data.length-1;

  		while (true) {
  			int pivot = partition(data, start, end);
  			if (k == pivot) return data[k];

  			if (k < pivot) end = pivot;
  			else start = pivot;
  		}
  	}

    /*private int partitionDutch(int[] data,int start, int end){
       int n = data.length - 1;

       while(start<= end){

       }

    }*/

    private static int partition(int[] data, int start, int end) {
      int pivot = (int)(Math.random() * (end - start + 1)) + start;

  		swap(data, start, pivot);
  		pivot = start++;

  		while (start != end) {
  			if (data[start] < data[pivot] || data[start] == data[pivot]) start++;

  			else {
  				swap(data, start, end);
  				end--;
  			}
  		}

  		if (data[start] > data[pivot]) start--;
  		swap(data, pivot, start);
  		return start;
	   }

     private static void quicksort(int[] data){
       quicksortH(data, 0, data.length-1);
     }
     private static void quicksortH(int[] data, int start, int end){
       if( start < end){
         int pivot = partition(data,start,end);
         quicksortH(data,start,pivot -1);
         quicksortH(data, pivot+1, end);
       }
     }
}
