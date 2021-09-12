import java.util.Scanner;

public class calculator {

    public static void main(String[] args){
        while(true){

            try{
                Scanner s = new Scanner(System.in);
                System.out.println("Please enter a Number");
                float firstNumber = s.nextFloat();
                s.nextLine();
                System.out.println("Please enter another number");
                float secondNumber = s.nextFloat();
                s.nextLine();
                System.out.println("Please enter an operation");
                String operation = s.nextLine();

                switch (operation) {
                    case "+":
                        System.out.println(firstNumber + secondNumber);
                        break;
                    case "-":
                        System.out.println(firstNumber - secondNumber);
                        break;
                    case "/":
                        if(secondNumber != 0) {
                            System.out.println(firstNumber / secondNumber);
                        }else {
                            System.out.println("Error, cannot divide by 0");
                        }
                        break;
                    case "*":
                        System.out.println(firstNumber * secondNumber);
                        break;
                    default:
                        System.out.println("Invalid operation!");
                        break;

                }
            } catch (java.util.InputMismatchException e){
                System.out.println("Invalid Input");
            }




        }

    }

}
