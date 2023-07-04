package bd.uz;

public class Cordinate implements Comparable<Cordinate> {


    private int x;
    private int y;

    public static Cordinate random() {
        return new Cordinate(
                AquariumUtil.getrandom(Configuration.AKVARIUM_LENGTH + 1),
                AquariumUtil.getrandom(Configuration.AKVARIUM_WEIGHT + 1)
        );
    }

    public void move() {
        int act = AquariumUtil.getrandom(7);
        switch (act) {
            case 0 -> {
                if (y < Configuration.AKVARIUM_WEIGHT) y++;
            }
            case 1 -> {
                if (x < Configuration.AKVARIUM_LENGTH) x++;
            }
            case 2 -> {
                if (y > 0) y--;
            }
            case 3 -> {
                if (x > 0) x--;
            }
        }
    }


    @Override
    public int hashCode() {

        return (x << 2) + (y << 3);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Cordinate that))
            return false;
        return that.x == x && that.y == y;
    }

    @Override
    public int compareTo(Cordinate o) {
        return (x - o.x) + (y - o.y);
    }

    public Cordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
