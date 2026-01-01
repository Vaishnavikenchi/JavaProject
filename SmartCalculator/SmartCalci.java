import java.util.ArrayList;
import java.util.Scanner;

public class SmartCalci
{
    
    static double lastResult = 0;
    static int operationCount = 0;
    static ArrayList<String> history = new ArrayList<>();

    static double add(double a, double b) 
    {
        return a + b;
    }
    static double sub(double a, double b)
    {
        return a - b;
    }
    static double mul(double a, double b) 
    {
        return a * b;
    }
    static double div(double a, double b) 
    {
        if (b == 0) 
        {
            System.out.println("Number can't be divided by zero");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args)
     {

        Scanner sc = new Scanner(System.in);
        int choice;

        do 
        {
            System.out.println("\n--- Welcome to SmartCalci ---");
            System.out.println("1. ADDITION");
            System.out.println("2. SUBTRACTION");
            System.out.println("3. MULTIPLICATION");
            System.out.println("4. DIVISION");
            System.out.println("5. VIEW HISTORY");
            System.out.println("6.VIEW TOTAL OPERATIONS COUNT");
            System.out.println("7. EXIT");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4)
            {

            int usePrev;
            while(true)
            {
                System.out.print("Use previous result? (Yes=1 / No=0): ");
                usePrev = sc.nextInt();
                
                if(usePrev==1 || usePrev==0)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid Input ! Please Enter Either 1(Yes) or 0 (No)");
                }
            }

                double num1;
                if (usePrev == 1) 
                {
                    num1 = lastResult;
                    System.out.println("Using previous result: " + num1);
                }
                else
                {
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                }

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                double result = 0;
                String expression = "";

                switch (choice) 
                {
                    case 1:
                        result = add(num1, num2);
                        expression = num1 + " + " + num2 + " = " + result;
                        break;

                    case 2:
                        result = sub(num1, num2);
                        expression = num1 + " - " + num2 + " = " + result;
                        break;

                    case 3:
                        result = mul(num1, num2);
                        expression = num1 + " * " + num2 + " = " + result;
                        break;

                    case 4:
                        result = div(num1, num2);
                        expression = num1 + " / " + num2 + " = " + result;
                        break;
                }

                lastResult = result;
                operationCount++;
                history.add(expression);

                System.out.println("Result: " + result);
            }

            else if (choice == 5) 
            {
                System.out.println("\n--- SmartCalci History ---");
                if (history.isEmpty()) 
                {
                    System.out.println("No calculations yet...");
                } 
                else 
                {
                    for (String h : history) 
                    {
                        System.out.println(h);
                    }
                }
                System.out.println("Total operations: " + operationCount);
            }

            else if(choice==6)
            {
                 System.out.println("Total calculations done: " + operationCount);
            }
            else if (choice == 7) 
            {
                System.out.println("Thank you for using SmartCalci!");
                System.out.println("Total calculations done: " + operationCount);
            }

            else 
            {
                System.out.println("Invalid choice...");
            }

        } while (choice != 7);

        sc.close();
    }
}
