import java.util.ArrayList;

public class Data {
    ArrayList<Contact> contacts;

    public Data(){
        ArrayList<Contact> contacts = new ArrayList<>();
    }

    public void add(Contact c){
        contacts.add(c);
    }

    public void viewAll(){
        for (int i = 0; i < contacts.size(); i++){
            System.out.println(contacts.get(i).getName() + " " + contacts.get(i).getNumber());
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
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getName().contains(na)){
                return contacts.get(i).getNumber();
            }
        }
        return -1;
    }
}
