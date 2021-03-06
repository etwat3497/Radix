package radixtest;

// IMPORT ARRAYLIST
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RadixTest extends RadixSorting{

    /**
     * Main method for the sorting
     * @param args 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // DECLARATIONS AND INITIALIZATIONS
        long timeStart; // measure the time at the start of the program
        long elapsedTime = 0; // variable for the elapsed time since start
        
        
        
        // READ LINES FROM THE TEXT FILE
        int[] intArray={9, 420, 666, 324, 65, 645, 65, 87, 436, 78, 43 ,87 ,43 ,876};
        
        // BEGIN COUNTING TIME
        timeStart = System.currentTimeMillis();
        
        // CALL THE SORTING METHOD
        intArray=radix(intArray);
        
        // measure the count of time at the end of the program
        elapsedTime=System.currentTimeMillis();
        
        // PRINT THE NUMBERS IN ORDER AND THE DELTA TIME
        for(int i=0; i<intArray.length; i++){
            System.out.println(intArray[i]);
        }
        
        System.out.println("The time is "+ (elapsedTime - timeStart)+"ms\nor "+(elapsedTime - timeStart)/1000.0+"seconds"); //Output
        
        
        //Get user input for number to be searched
        Scanner sc = new Scanner(System.in);
        
        //Declare variables for binary search
        int searchNum = 0;
        String endLoop;
        Boolean runBinarySearch = true;
        Boolean runNumInput = true;
        
        //Catch bad user input when getting number
        while(runBinarySearch){
            //Set to true again if binary search is rerun
            runNumInput = true;
            while(runNumInput){
                try{
                    //Get user input
                    System.out.println("What number would you like to search for?");    
                    searchNum = Integer.parseInt(sc.nextLine());
                    //If valid number end loop and accept search num
                    runNumInput = false;
                }
                //Catch bad user input and repeat loop
                catch(NumberFormatException e){
                    System.out.println("Please input a valid number");
                }   
            }
            
            //Run searches class to determine location of number in the array
            int location = binarySearch(intArray, 0, intArray.length-1, searchNum);
            //If the number is not in the array
            if(location == -1){
                System.out.println("The number "+searchNum+" is not in this array!");
            }
            //If the number is in the array
            else{
                //Output the location
                System.out.println("The location of "+searchNum+" in the sorted array is "+location); 
            }
            //Get user input
            System.out.println("Input 'done' to finish the program. If you want to search for another number input any other character.");
            endLoop = sc.nextLine();
            //If done is input, end program
            if(endLoop.equalsIgnoreCase("done")){
               runBinarySearch = false;
            }
            //Otherwise, repeat binary search again
        }
    }
    
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

