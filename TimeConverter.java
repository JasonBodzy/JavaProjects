public class TimeConverter {


    public static String timeConversion(String s) {
        // Write your code here

        String[] splitTime = s.split(":");
        int newTime = Integer.parseInt(splitTime[0]);


        if(s.contains("P") && newTime != 12) {
            newTime += 12;
        }

        if(s.contains("A") && newTime == 12){
            char[] finalChars = splitTime[2].toCharArray();
            String output = ("00" + ":" + splitTime[1] + ":" + finalChars[0] + finalChars[1]);
            return(output);
        } else if (s.contains("A")){
            return(s.substring(0, 8));
        } else if (s.contains("P") && newTime == 12){
            return(s.substring(0, 8));
        } else {
            char[] finalChars = splitTime[2].toCharArray();
            String output = (newTime + ":" + splitTime[1] + ":" + finalChars[0] + finalChars[1]);
            return(output);
        }



    }

    public static void main(String[] args) {
        String input = "12:12:02AM";
        System.out.println(timeConversion(input));
    }


}
