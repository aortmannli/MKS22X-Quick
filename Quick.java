
import java.util.*;
import java.io.*;

	public class Quick{
		public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

    public static void swap(int[] data, int a, int b) {
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

    /*public int partitionDutch(int[] data,int start, int end){
       int n = data.length - 1;

       while(start<= end){

       }

    }*/

    public static int partition(int[] data, int start, int end){
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

		 private static int[] partitionDutch(int[] data, int lo, int hi){
	 	   int rand_idx = (int)(Math.random() * (hi - lo + 1)) + lo;
	 	   int pivot = data[rand_idx];
	 	   int i = lo;

	 	   while (i <= hi) {
	 	     if (data[i] < pivot) {
	 	       swap(data,lo,i);
	 				 lo++;
	 				 i++;
	 	     } else if (data[i] == pivot) {
	 	       i++;
	 	     } else {
	 	       swap(data,i,hi);
	 	       hi--;
	 	     }
	 	   }
	 	   return new int[] {lo, hi};
		 }



     public static void quicksort(int[] data){
       quicksortH(data, 0, data.length-1);
     }
     public static void quicksortH(int[] data, int start, int end){
			 if( start < end){
				 int[] pivot = partitionDutch(data,start,end);
				 quicksortH(data,start,pivot[0] -1);
				 quicksortH(data, pivot[1]+1, end);
				}
     }
}
