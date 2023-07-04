package bd.uz;

public class Fish extends Thread {

    private int life;

    private final boolean famale;

    private final Cordinate cordinate;
    private final Aquarium aquarium;


    public Fish(int life, boolean famale, Cordinate cordinate, Aquarium aquarium) {
        this.life = life;
        this.famale = famale;
        this.cordinate = cordinate;
        this.aquarium = aquarium;
    }


    @Override
    public void run() {
        while (life > 0) {
            move();
            try {
                Thread.sleep(Configuration.FISH_SLEEP_MILLE);
                life--;
                aquarium.checkForCollision(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        aquarium.removeFish(this);
    }


    public void move() {
        cordinate.move();
    }

    public boolean isMale() {
        return !famale;
    }

    public boolean collision(Fish f) {
        return this.cordinate.equals(f.cordinate) && this.famale != f.famale;
    }

    public boolean isFemale() {
        return famale;
    }

}
