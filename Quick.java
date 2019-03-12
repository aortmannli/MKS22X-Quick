import java.util.*;
import java.io.*;

public class Quick{


    /*Modify the array such that:
   *1. Only the indices from start to end inclusive are considered in range
   *2. A random index from start to end inclusive is chosen, the corresponding
   *   element is designated the pivot element.
   *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
   *4. all elements in range that are larger than the pivot element are placed after the pivot element.
   *@return the index of the final position of the pivot element.
   */

    public static int partition(int start,int end,int[] data){
      Random R = new Random();
      int pivot = data[R.nextInt(data.length)];

      swap(data,start,pivot);
      pivot=start++;
      while(start != end){
        if(data[start] > data[pivot]){
          swap(data,start,end--);
        }else{
          start++;
        }
      }
      if(data[start] > data[pivot]){
        start--;
      }
      swap(data,start,pivot);
      return start;
    }


  private static void swap(int[] data, int a, int b) {
		int x = data[a];
		data[a] = data[b];
		data[b] = x;
	}
  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int []data, int k){
    return 0;
  }

}
