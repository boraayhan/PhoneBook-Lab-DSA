import java.io.IOException;
import java.util.ArrayList;

public class Data {
    ArrayList<Contact> contacts;
    Serializer serializer = new CSVSerializer();

    public Data(){
        ArrayList<Contact> contacts = new ArrayList<>();
    }

    public void add(Contact c){
        contacts.add(c);
    }

    public void viewAll(){
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " " + contact.getNumber());
        }
    }
    public String delete(Contact c){
        for (int i = 0; i < contacts.size(); i++){
            if (c.equals(contacts.get(i))){
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
}
