public class SatyanarayanaAnikethA1  //Class name in the format of LastnameFirstNameA1
{
    public static void main(String[] args)
    {
        int a = Integer.parseInt(args[0]);  //Takes the first dimension of the rectangle(program argument) and parses it to an integer.
        int b = Integer.parseInt(args[1]); //Takes the second dimension of the rectangle(program argument) and parses it to an integer.

        //If the user does not pass initial arguments to the program , displays usage on terminal
        if(args.length == 0)
        {
            System.out.println("Usage : LastnameFirstnameA1 {number1 number2}");
        }


        int area = a * b; //Calculation of area.


        //To check if the area of the input rectangle is greater , less or equal to 100.
        if (area > 100) {
            System.out.println("The area for given rectangle is " + area + " and it is greater than 100");
        }

        if (area < 100) {
            System.out.println("The area for given rectangle is " + area  + " and it is less than 100");
        }

        if (area == 100) {
            System.out.println("The area for given rectangle is " + area + " and it is equal to 100");
        }

        //Program completion message.
        System.out.println("Program completed.");
    }
}



















