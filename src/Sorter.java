import javax.swing.*;
import java.awt.*;

public class Sorter extends Canvas {

    static final int width = 800;
    static final int height = 500;
    Sorter(){



    }

    public boolean isSorted(int[] input){
        int i = 0;
        while(i < input.length - 1){
            if(input[i] > input[i + 1]){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();

        int[] input = {1,44,66,7,4};

        System.out.println(bubbleSort.sort(input));

        JFrame frame = new JFrame("Sorting Algorithms");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        canvas.setSize(width / 2, height - (height / 5));
        canvas.setBackground(Color.black);

        JPanel upperPanel = new JPanel();
        upperPanel.setSize(width / 2, height - (height / 5));
        upperPanel.add(canvas);

        JPanel lowerPanel = new JPanel();
        lowerPanel.setSize(width / 2, height / 5);


        frame.add(upperPanel);
        frame.add(lowerPanel);

        frame.doLayout();

        frame.setVisible(true);
        frame.pack();




    }


}
