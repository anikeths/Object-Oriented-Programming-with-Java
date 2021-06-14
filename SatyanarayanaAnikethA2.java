import java.util.*;
import java.util.Arrays;


public class SatyanarayanaAnikethA2 {

    public static void main(String[] args) {
        //Prompts the user to input a value for the size of the array.
        System.out.println("Please enter the length of an array:");
        Scanner sc = new Scanner(System.in);
        boolean arraySizeCorrect = true;

        try {
            int size = sc.nextInt();

            //Prints this message if the user enters a negative integer for the array size.
            if (size < 0) {
                System.out.println("Array length can't be negative. Enter a positive integer.");
                arraySizeCorrect = false;
            } else if (size == 0) {
                //Exits the program without further action after printing 'Program completed.'
                arraySizeCorrect = false;
            }

            if (arraySizeCorrect) {
                //Taking the array input from the user.
                System.out.println("Please enter " + size + " elements of the array.");
                int[] inpArray = new int[size];
                //Creating a copy of the input for sorting.
                int[] sort = new int[size];

                int i;
                for (i = 0; i < size; i++) {
                    inpArray[i] = sort[i] = sc.nextInt();
                }

                //printing the elements of the input array.
                System.out.print("The input array is: [ ");

                for (i = 0; i < size; i++)
                    System.out.print(inpArray[i] + " ");

                System.out.print("]");

                //Sorting the array using Bubble Sort.
                int j, temp;

                for (i = 0; i < (size - 1); i++)
                    for (j = 0; j < (size - i - 1); j++)
                        if (sort[j] > sort[j + 1]) {
                            temp = sort[j];
                            sort[j] = sort[j + 1];
                            sort[j + 1] = temp;
                        }

                //printing the sorted array.
                System.out.print("\nThe sorted array is:[ ");
                for (i = 0; i < size; i++)
                    System.out.print(sort[i] + " ");

                System.out.println("]");

                // printing the index of the input element.
                int x;
                boolean c = false;
                System.out.println("\nPlease enter the number to be searched: ");  //taking the input of element whose index os to be searched.
                x = sc.nextInt();

                for (i = 0; i < size; i++) {
                    if (sort[i] == x) {
                        c = true;
                        System.out.println("The element found at index : " + i);
                        break;
                    }
                }

                if (!c)
                    System.out.println("No such element present in the array.");

                // reversing of the input array and printing the reversed array.
                System.out.print("The array in reverse order is: [ ");

                int start = 0, end = size - 1;
                int[] rev = new int[size];

                while (start < size) {
                    rev[start] = inpArray[end];
                    System.out.print(rev[start] + " ");
                    start++;
                    end--;
                }

                System.out.println("]");
            }
        } catch(InputMismatchException W){
            //handling if the input for array size is negative integer or a fraction type value.
            System.out.println("\nEnter an integer type value.");
        } finally {
            //closing the scanner
            sc.close();
            System.out.println("\nProgram Completed.");
        }
    }
}