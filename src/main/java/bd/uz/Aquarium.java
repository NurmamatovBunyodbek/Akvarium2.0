package bd.uz;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private final List<Fish> fishList = new ArrayList<>();

    public void start() {
        int size = AquariumUtil.getrandombetween(
                Configuration.MIN_COUNT_INIT_FISH, Configuration.MAX_COUNT_INIT_FISH
        );
        for (int i = 0; i < size; i++) {
            fishList.add(CreateFish.createFish(this));
        }
        for (Fish fish : fishList) {
            fish.start();
        }
    }

    public void checkForCollision(Fish fish) {
        synchronized (fishList) {
            if (!(fishList.size() < Configuration.LIMIT_FISH)) {
                printDetail();
                return;
            }

            Fish babyFish = null;
            for (Fish f : fishList) {
                if (fish.collision(f)) {
                    babyFish = CreateFish.createFish(this);
                    String str = String.format("Collision :Fish1 - {%s},Fish2 - {%s} ,baby - {%s},female -{%f}",
                            fish.hashCode(), f.hashCode(), babyFish.hashCode(), babyFish.isFemale());
                    System.out.println(str);
                    break;
                }
            }
            if (babyFish != null) {

                babyFish.start();
                fishList.add(babyFish);
            }
            printDetail();


        }
    }

    public synchronized void printDetail() {

        int totalSize = fishList.size();
        int m = 0;
        int f = 0;
        for (Fish fish : fishList) {
            if (fish.isMale()) {
                m++;
            } else {
                f++;
            }
        }
        System.out.println("Total count : " + totalSize);
        System.out.println("Male: " + m);
        System.out.println("Female: " + f);

    }

    public void removeFish(Fish fish) {
        synchronized (fishList) {
            fishList.remove(fish);
            System.out.println("Fish dead " + fish);
            printDetail();
        }
    }

}
