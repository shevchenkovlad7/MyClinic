package Clinic;

/**
 * Created by Vlad on 21.10.2015.
 */
public class Cat extends Animal implements Pet {
    private final String kind = "Cat";
    public Cat(String animalName, int age) {
        super(animalName, age);
    }

    @Override
    public void setAnimalName(String animalName) {
        super.setAnimalName(animalName);
    }

    @Override
    public String getAnimalName() {
        return super.getAnimalName();
    }

    public String getKind() {
        return kind;
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    /**
     public Dog(final String  name){

     }
     */


    @Override
    public void makeSound() {
           System.out.println("Mi Mi Mi");
    }

    @Override
    public boolean showsAggression() {
        return false;
    }
}
