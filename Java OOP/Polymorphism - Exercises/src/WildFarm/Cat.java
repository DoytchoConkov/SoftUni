package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    @Override
    public String toString() {
        String pattern = "0.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String formated = decimalFormat.format(super.getAnimalWeight());
        return String.format("%s[%s, %s, %s, %s, %d]%n",
                super.getAnimalType(), super.getAnimalName(), this.getBreed(), formated, super.getLivingRegion(), super.getFoodEaten());
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }


}
