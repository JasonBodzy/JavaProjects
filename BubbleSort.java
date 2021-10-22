public class BubbleSort {

    BubbleSort(){

    }

    //returns sorted integer array as a string
    String sort(int[] input){
        Sorter sorter = new Sorter();
        String sorted = "";


        while(!sorter.isSorted(input)){
            int i = 0;
            while (i < input.length - 1){
                if(input[i] > input[i + 1]){
                    int tracker = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = tracker;
                }
                i++;
            }
        }

        for(int t : input){
            sorted += t + " ";
        }

        return sorted;


    }


}
