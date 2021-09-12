public class Paddle {
    int x, y, width, height;
    boolean up, down;

    Paddle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.up = up;
        this.down = down;

    }



    void movePaddle(String direction){

        int velocity = 10;

        if(direction.equals("up")){
            if(y >= 0) {
                this.y -= velocity;
            }
        }

        if(direction.equals("down")){
            if(this.y <= 500 - height)
            this.y += velocity;
        }

    }


}
