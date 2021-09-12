import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Pong extends Canvas{

    Pong (){
        this.addKeyListener(new AL());
    }

    static int width = 1000;
    static int height = 500;

    int leftScore = 0;
    int rightScore = 0;

    boolean run = true;

    Paddle leftPaddle = new Paddle(40, height / 2, 20, height / 5);
    Paddle rightPaddle = new Paddle(width - (40 + leftPaddle.width), height / 2, 20, height / 5);

    Ball ball = new Ball(width / 2, height / 2, 20, 20);

    private static Font serifFont = new Font("SanSerif", Font.BOLD, 34);


    void update() throws InterruptedException {

        if(leftPaddle.up == true){
            leftPaddle.movePaddle("up");
        }
        if(rightPaddle.up == true){
            rightPaddle.movePaddle("up");
        }

        if(leftPaddle.down == true){
            leftPaddle.movePaddle("down");
        }
        if(rightPaddle.down == true){
            rightPaddle.movePaddle("down");
        }

        if(ball.x <= leftPaddle.x + leftPaddle.width && ball.x >= leftPaddle.x - leftPaddle.width){
            if(ball.y >= leftPaddle.y && ball.y <= leftPaddle.y + leftPaddle.height){
                ball.switchX();
            }
        }

        if(ball.x >= rightPaddle.x - rightPaddle.width && ball.x <= rightPaddle.x){
            if(ball.y >= rightPaddle.y && ball.y <= rightPaddle.y + rightPaddle.height){
                ball.switchX();
            }
        }

        if(ball.x < 0 - ball.width){
            ball.resetPos();
            rightScore += 1;
        }

        if( ball.x > width + ball.width){
            ball.resetPos();
            leftScore += 1;
        }

        ball.updatePos();

        repaint();


    }

    public static void main (String[] args) {

        JFrame frame = new JFrame("Pong");
        Canvas canvas = new Pong();
        canvas.setSize(width, height);
        canvas.setBackground(Color.black);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }



    public void paint(Graphics g){

        g.setColor(Color.white);

        g.fillRect(leftPaddle.x, leftPaddle.y, leftPaddle.width, leftPaddle.height);
        g.fillRect(rightPaddle.x, rightPaddle.y, rightPaddle.width, rightPaddle.height);

        g.fillOval(ball.x, ball.y, ball.width, ball.height);

        g.setFont(serifFont);
        g.drawString(leftScore + ":" + rightScore, width / 2,  44);


        try {
            update();
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }





    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_W){
                leftPaddle.up = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                leftPaddle.down = true;
            }

            if(e.getKeyCode() == KeyEvent.VK_UP){
                rightPaddle.up = true;
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                rightPaddle.down = true;
            }


        }

        public void keyReleased(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_W){
                leftPaddle.up = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                leftPaddle.down = false;
            }

            if(e.getKeyCode() == KeyEvent.VK_UP){
                rightPaddle.up = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                rightPaddle.down = false;
            }
        }

    }
}
