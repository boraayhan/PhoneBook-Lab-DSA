import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the phonebook!");
        String name;
        int phone;
        Data d = new Data();
        d.load();
        while(true){
            System.out.println("Press 1 to add, 2 to View, 3 to Exit, 4 to Search, 5 to Delete, and 6 to Edit");
            int answer = Integer.parseInt(scan.nextLine());
            if (answer == 1){
                System.out.println("Add a name and phone number:");
                name = scan.nextLine();
                if(name.contains(",") || name.isEmpty()) {
                    System.out.println("Invalid Name");
                    continue;
                }
                try {
                    phone = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Number");
                    continue;
                }
                if(d.containsName(name) || d.containsNumber(phone)) {
                    System.out.println("Duplicate values");
                    continue;
                }
                Contact c = new Contact(name, phone);
                d.add(c);
            }

            if (answer == 2){
                d.viewAll();
            }

            if (answer == 3) {
                d.serialize();
                return;
            }

            if (answer == 4){
                System.out.println("Enter a name or part of a name:");
                name = scan.nextLine();
                System.out.println(d.search(name));
            }
            if (answer == 5){
                System.out.println("Give a name and phone number to delete:");
                name = scan.nextLine();
                phone = Integer.parseInt(scan.nextLine());
                Contact c = new Contact(name, phone);
                System.out.println(d.delete(c));
            }
            if (answer == 6){
                System.out.println("Say which you want to replace using a name, give a new name, and a phone number");
                String replace = scan.nextLine();
                name = scan.nextLine();
                phone = Integer.parseInt(scan.nextLine());
                d.edit(replace, name, phone);
            }
        }
    }
}
