package Clinic;
/**
 * Created by Vlad on 20.10.2015.
 */  /**
 * *   Задаем характеристики присущие любому животному
 * */
public class Animal {

    private String animalName;
    private int age;
   /* private String kind; */

    public Animal(String name, int age) {
        this.animalName = name;
        this.age = age;

    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "animalName='" + animalName + '\'' +
                ", age=" + age
                ;
    }


}
