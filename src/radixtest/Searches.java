package radixTest;

/**
 * 
 * @author etwat3497
 */
public class Searches {
    
   /**
    * Method to complete a binary search for the sorted int array
    * @param int array, start of array, end of array, and specific number to be found
    * @return location of specific number
    */
    public static int binarySearch(int[] items, int start, int end, int goal){
        
        //If the goal is not in the array return a -1
        if(start>end){
            return(-1);
        }
        //Otherwise run
        else{
            //Set middle of the int array
            int mid = (start+end)/2;
            
            //Check if the middle number is the specified number; If so, return it
            if(goal==items[mid]){
                return mid;
            }
            //Check if the specified number is less than the middle value
            else if(goal<items[mid]){
                //If so, run the binary search method again, except with different end value (mid-1)
                return(binarySearch(items, start, mid-1, goal));
            }
            //Otherwise, the number is in the 2nd half of the array
            else{
                //Run the binary search method again, except with higher start (mid+1) and same end value
                return(binarySearch(items, mid+1, end, goal));     
            }
                    
        }
    }
}
