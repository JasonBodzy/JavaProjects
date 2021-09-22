import java.util.Scanner;

public class calculator {

    public static void main(String[] args){

        boolean first = true; //Variable to determine if it is the first equation
        while(true){ //main loop

            try{
                Scanner s = new Scanner(System.in); //initializes scanner

                if(!first) { //If it isn't the first equation
                    System.out.println("Type exit to exit, press enter to continue");
                    String answer = s.nextLine();
                    if (answer.equals("exit")) {
                        break; //exits program
                    }
                }


                System.out.println("Please enter a Number");
                String firstNumber = s.nextLine();//stores first
                System.out.println("Please enter another number");
                String secondNumber = s.nextLine();//stores second
                System.out.println("Please enter an operation");
                String operation = s.nextLine(); //stores op
                first = false;

                double firstDouble;
                double secondDouble;


                if(firstNumber.equals("pi")){
                    firstDouble = Math.PI;
                } else {
                    firstDouble = Double.parseDouble(firstNumber);
                }

                if(secondNumber.toLowerCase().equals("pi")){
                    secondDouble = Math.PI;
                } else {
                    secondDouble = Double.parseDouble(secondNumber);
                }



                switch (operation) { //basic operations
                    case "+":
                        System.out.println(firstDouble + secondDouble);
                        break;
                    case "-":
                        System.out.println(firstDouble - secondDouble);
                        break;
                    case "/":
                        if(secondDouble != 0) {
                            System.out.println(firstDouble / secondDouble);
                        }else {
                            System.out.println("Error, cannot divide by 0");
                        }
                        break;
                    case "*":
                        System.out.println(firstDouble * secondDouble);
                        break;
                    case "%":
                        System.out.println(firstDouble % secondDouble);
                        break;
                    case "^":
                        System.out.println(Math.pow(firstDouble, secondDouble));
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
