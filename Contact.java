import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}

public class ContactManager {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        this.contacts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private void editContact() {
        viewContacts();
        System.out.print("Enter the number of the contact to edit: ");
        int contactNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (contactNumber > 0 && contactNumber <= contacts.size()) {
            Contact contact = contacts.get(contactNumber - 1);
            System.out.print("Enter new name: ");
            contact.name = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            contact.phoneNumber = scanner.nextLine();
            System.out.print("Enter new email: ");
            contact.email = scanner.nextLine();
            System.out.println("Contact edited successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    private void deleteContact() {
        viewContacts();
        System.out.print("Enter the number of the contact to delete: ");
        int contactNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (contactNumber > 0 && contactNumber <= contacts.size()) {
            contacts.remove(contactNumber - 1);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        contactManager.run();
    }
}