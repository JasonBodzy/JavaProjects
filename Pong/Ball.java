public class Ball {

    int x, y, width, height;

    int xVel = 6;
    int yVel = 6;



    Ball(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void updatePos(){

        if(y <= 0){
            switch(yVel){
                case 6:
                    yVel = -6;
                    break;
                case -6:
                    yVel = 6;
                    break;
            }
        }

        if(y >= 500 - height){
            switch(yVel){
                case 6:
                    yVel = -6;
                    break;
                case -6:
                    yVel = 6;
                    break;
            }
        }

        this.y += yVel;
        this.x += xVel;

    }

    void switchX(){
        switch (xVel){
            case 6:
                if(x > 500) {
                    xVel = -6;
                }
                break;
            case -6:
                if(x < 500) {
                    xVel = 6;
                }
                break;
        }
    }

    void resetPos(){
        x = 500;
        y = 250;
    }

}
