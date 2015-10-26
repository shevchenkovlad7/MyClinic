package Clinic;


import java.util.ArrayList;

/**
 * Created by Vlad on 20.10.2015.
 */
public class MyClinic {
    private ArrayList<Client> clients; // list of client

    private int lastClient = 1;                 // last client in clinic



    public MyClinic() {
        clients = new ArrayList<>();
    }

    public boolean hasClient(String clientName) {
        for (Client client : clients) {
            if (client.getClientName().equals(clientName))
                return true;
        }
        return false;
    }
    public boolean hasClientAnimal(String animalName){
        for (Client client : this.clients) {
            if (client.getAnimal().getAnimalName().equals(animalName))
                return true;
        }
        return false;

    }

    /*показать всех клиентов*/
    public void showClients() {
        if (!clients.isEmpty()) {
            for (int i = 0; i < clients.size(); i++) {
                System.out.println(clients.get(i).toString());
            }
        } else System.out.println("List is empty");
    }

    /*добавление клиента*/
    public void addClient(String clientName, int age, Animal animal) {
        clients.add(new Client( lastClient,age, clientName, animal));
        lastClient++;
    }

    /*удаление клиента*/
    public void removClientById(int id) {
        clients.remove(id);
        lastClient--;
        System.out.println(String.format("Remove client the id = " + id + " was successful"));
    }

    public void removClientByName(String nameRemov){
        clients.remove(nameRemov);
        lastClient--;
        System.out.println(String.format("Remove client the name: " + nameRemov + " was successful"));
    }
    /*поиск клиента по имени*/


    public Client searchClientByName(String clientName)  {
        Client clientOfNumber = null;
        if(!hasClient(clientName)){
           System.out.println("Client with the same name is not");
        }   else {

            for (Client client : clients) {
                if (client.getClientName().equals(clientName))
                    clientOfNumber = client;
            }

            System.out.println("Client is found : " + clientOfNumber.toString());

        }

        return clientOfNumber;
    }

    /*поиск клиента по кличке питомца*/
    public Client searchByAnimalName(String animalName) {
        Client searchClient = null;
        if(!hasClientAnimal(animalName)){
            System.out.println("Client with the same animal name is not");

        }   else {
        for (Client client : this.clients) {
            if (client.getAnimal().getAnimalName().equals(animalName)) {
                searchClient = client;
            }

        }
        }
        System.out.println(searchClient.toString());
        return searchClient;
    }

    /*изменение клички питомца*/
    public void changeAnimalNameById(int id, String newName){
        clients.get(id).getAnimal().setAnimalName(newName);
        System.out.println("Changed animal name to " +newName.toString());
    }
    /*удаление питомца*/
    public void removeAnimal(String animalName){
        Client client = searchByAnimalName(animalName);
        client.getAnimal().setAnimalName("no animal");
        System.out.println("Pet was deleted! "+"\nThis client "+client.getAnimal().getAnimalName());
    }

    /*изменение имени клиента*/
    public void changeClientName(String clientName, String newName){
        Client client = searchClientByName(clientName);
        client.setClientName(newName);
        System.out.println("Changed client's name "+clientName.toString()+" to " +newName.toString());

    }
    public int getLastClient() {
        return lastClient;
    }


}
