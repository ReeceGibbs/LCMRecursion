//here we import our java packages
import java.util.Arrays;
import java.util.Scanner;

//our LCMRecursion class
public class LCMRecursion {

    //our main method
    public static void main(String[] args) {

        //we give the user a bit of context
        System.out.println("Enter any two integers - separated by a comma - to get the Lowest Common Multiple between them:" +
                "\ne.g. 7, 6");

        //we get the input from the user within a while loop
        //if the user provides invalid input they will be asked to try again
        while (true) {

            //we initialize a scanner to get input from the user
            Scanner userInput = new Scanner(System.in);

            //we initialize a temporary integer array that will contain the values the user entered
            int [] integerInput = new int[2];

            //begin try/catch block
            try {

                //we populate our integer array with the values the user entered
                integerInput = Arrays.stream(userInput.nextLine().split(",")).mapToInt(element ->
                        Integer.parseInt(element.strip())).toArray();

                //if the user enters valid integers, then we call our function to calculate the lowest common multiple and display it
                System.out.println("\nThe Lowest Common Multiple is: " +
                        findLowestCommonMultiple(integerInput[0], integerInput[0], integerInput[1]));

                //we break out of the loop because the user's input was valid
                break;
            } catch (Exception e) {

                //display error message if user provides invalid input but let them correct themselves
                System.out.println("Oops... It looks like your input is invalid. Please" +
                        "\n enter two integer values separated by a comma." +
                        "\ne.g. 7, 6");
            }
        }
    }

    //our recursive function that determines the lowest common multiple of two integer values
    public static int findLowestCommonMultiple(int originalValue, int num1, int num2) {

        //if num2 divides perfectly into num1 then we return it, if it doesn't we call this method again passing num1 plus its original value
        return (num1 % num2 == 0) ? num1 : findLowestCommonMultiple(originalValue, (num1 + originalValue), num2);
    }
}
