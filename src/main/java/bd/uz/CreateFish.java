package bd.uz;

public class CreateFish {

    public static Fish createFish(Aquarium aquarium) {
        Cordinate cordinate = Cordinate.random();

        int life = AquariumUtil.getrandombetween(
                Configuration.MIN_LIFE_FISH,
                Configuration.MAX_LIFE_FISH
        );
        boolean randomBool = AquariumUtil.getRandomBool();

        return new Fish(life, randomBool, cordinate, aquarium);
    }

}
