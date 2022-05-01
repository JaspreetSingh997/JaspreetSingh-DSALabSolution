package stacksBalancedBrackets;

import java.util.*;
import java.util.Scanner;

public class BalancingBrackets
{
    static boolean checkBalance(String value)
    {
        // initiating Stack Object
        Stack<Character> stack = new Stack<Character>();
        
        // for loop that will run from starting element to the length of the string.
        for (int i = 0; i < value.length(); i++) 
        {
            char charVal = value.charAt(i);
  
            if (charVal == '(' || charVal == '[' || charVal == '{') 
            {
                stack.push(charVal);
                continue;
            }

            if (stack.isEmpty())
                return false;

            // declaring a char variable to check the String    
            char checkString;
           
            // condition to check string
            if(charVal == ')')
            {
                checkString = stack.pop();
                if (checkString == '{' || checkString == '[')
                    return false;
            }
            if(charVal == '}')
            {
                checkString = stack.pop();
                if (checkString == '(' || checkString == '[')
                    return false;
            }
            if(charVal == ']')
            {
                checkString = stack.pop();
                if (checkString == '(' || checkString == '{')
                    return false;
            }
        }

        // returning empty stack boolean
        return (stack.isEmpty());
    }


    // main method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the String Brackets: ");
        String value = sc.nextLine().trim(); // stored the value in a variable and trim it to check every single character.
  
        // Calling function
        if (checkBalance(value))
            System.out.println("String is Balanced");
        else
            System.out.println("String is not Balanced");


        // closing scanner
        sc.close();
    }
}