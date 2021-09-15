import java.util.Scanner;

public class calculator {

    public static void main(String[] args){

        boolean first = true; //Varaible to determine if it is the first equation
        while(true){ //main loop

            try{
                Scanner s = new Scanner(System.in); //initializes scanner

                if(!first) { //If it isnt the first equation
                    System.out.println("Type exit to exit, press enter to continue");
                    String answer = s.nextLine();
                    if (answer.equals("exit")) {
                        break; //exits program
                    }
                }


                System.out.println("Please enter a Number");
                double firstNumber = s.nextDouble();//stores first
                s.nextLine();
                System.out.println("Please enter another number");
                double secondNumber = s.nextDouble();//stores second
                s.nextLine();
                System.out.println("Please enter an operation");
                String operation = s.nextLine(); //stores op
                first = false;

                if(firstNumber == 3.14){
                    firstNumber = Math.PI;
                }

                if(secondNumber == 3.14){
                    secondNumber = Math.PI;
                }

                switch (operation) { //basic operations
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
                    case "%":
                        System.out.println(firstNumber % secondNumber);
                        break;
                    default:
                        System.out.println("Invalid operation!");
                        break;




                }
            } catch (java.util.InputMismatchException e){
                System.out.println("Invalid Input"); //if something else is entered
            }





        }

    }

}
