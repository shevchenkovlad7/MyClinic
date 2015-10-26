package Clinic;

/**
 * Created by Vlad on 21.10.2015.
 */
public class Dog extends Animal implements Pet {
    private final String kind = "Dog";


    public Dog(String name, int age) {
        super(name, age);
    }



    @Override
    public String getAnimalName() {
        return super.getAnimalName();
    }

    @Override
    public void setAnimalName(String animalName) {
        super.setAnimalName(animalName);
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
        System.out.println("Gav, Gav, Gav, Ararar");
    }

    @Override
    public boolean showsAggression() {
        return true;
    }
}
