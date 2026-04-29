import java.io.IOException;
import java.util.ArrayList;

public class Data {
    ArrayList<Contact> contacts = new ArrayList<>();
    Serializer serializer = new CSVSerializer();

    public Data(){
        ArrayList<Contact> contacts = new ArrayList<>();
    }

    public void add(Contact c){
        contacts.add(c);
    }

    public void viewAll(){
        contacts.sort(null);
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " " + contact.getNumber());
        }
    }
    public String delete(Contact c){
        for (int i = 0; i < contacts.size(); i++){
            if (c.getName().equals(contacts.get(i).getName()) && c.getNumber() == contacts.get(i).getNumber()){
                contacts.remove(i);
                return "Deleted";
            }
        }
        return "Nothing to delete";
    }
    public int search(String na){
        for (Contact contact : contacts) {
            if (contact.getName().contains(na)) {
                return contact.getNumber();
            }
        }
        return -1;
    }

    public boolean containsName(String name) {
        for(Contact contact : contacts) {
            if(contact.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNumber(int num) {
        for(Contact contact : contacts) {
            if(contact.getNumber() == num) {
                return true;
            }
        }
        return false;
    }

    public void serialize() {
        try {
            serializer.write(contacts);
        } catch (IOException e) {
            System.out.println("Failed to write to disk");
        }
    }

    public void load() {
        try {
            contacts = serializer.read();
        } catch (IOException e) {
            System.out.println("Failed to read from disk");
        }
    }


    public void edit(String search, String n, int p) {
        int placement = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(n)) {
                placement = i;
            }
        }
        if (placement == -1){
            return;
        }
        contacts.get(placement).setName(n);
        contacts.get(placement).setNumber(p);
    }
}
