package Clinic;

/**
 * Created by Vlad on 20.10.2015.
 */
public class Client {
    private int age;
    private String clientName;
    private Animal animal;
    private int id;
    MyClinic clinic = new MyClinic();

    public Client(int id, int age,String name, Animal animal) {


        this.age = age;
        this.clientName = name;
        this.animal = animal;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id = "+ getId() +
                " ,age=" + age +
                ", clientName='" + clientName + '\'' +
                ", animal=" + animal +
                '}';
    }
}
