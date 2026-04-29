import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the phonebook!");
        String name;
        int phone;
        Data d = new Data();
        d.load();
        while (true) {
            System.out.println("Press 1 to add, 2 to View, 3 to Exit, 4 to Search, 5 to Delete, and 6 to Edit");
            int answer = Integer.parseInt(scan.nextLine());
            if (answer == 1) {
                System.out.println("Enter name for new contact:");
                name = scan.nextLine();
                if (name.contains(",") || name.isEmpty()) {
                    System.out.println("Invalid Name");
                    continue;
                }
                System.out.println("Enter " + name + "'s phone number");
                try {
                    phone = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Number!");
                    continue;
                }
                boolean duplicateName = d.containsName(name);
                boolean duplicateNumber = d.containsNumber(phone);
                if (duplicateName){
                    System.out.println("Entry already exists for " + name + "!");
                    continue;
                }
                if (duplicateNumber) {
                    System.out.println("Entry already exists for phone number " + phone + "!");
                    continue;
                }
                Contact c = new Contact(name, phone);
                d.add(c);
            }

            if (answer == 2) {
                d.viewAll();
            }

            if (answer == 3) {
                d.serialize();
                return;
            }

            if (answer == 4) {
                System.out.println("Enter a name or part of a name:");
                name = scan.nextLine();
                System.out.println(d.search(name));
            }
            if (answer == 5) {
                System.out.println("Enter the name of the contact");
                name = scan.nextLine();
                phone = Integer.parseInt(scan.nextLine());
                Contact c = new Contact(name, phone);
                System.out.println(d.delete(c));
            }
            if (answer == 6) {
                System.out.println("Enter name of the contact you wish to replace");
                String replace = scan.nextLine();
                if (!d.containsName(replace)) {
                    System.out.println("No contact found with name : '" + replace + "'!");
                } else {
                    System.out.println("Enter new name for " + replace);
                    name = scan.nextLine();
                    System.out.println("Enter new phone number for " + name + ", or type '0' to retain phone number. ");
                    phone = Integer.parseInt(scan.nextLine());
                    if (phone == 0) {
                        phone = d.search(replace);
                    }
                    d.edit(replace, name, phone);
                }

            }
        }
    }
}
