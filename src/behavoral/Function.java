package behavoral;

import creat.Contact;
import creat.FileCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Function {
    ArrayList<Contact> listContacts;

    FileCSV fileCSV = new FileCSV();

    transient Scanner sc = new Scanner(System.in);

    public Function() throws IOException {
        this.listContacts = fileCSV.swapFileCSV(fileCSV.reader(fileCSV.FILE_PATH));
    }

    public Contact input() {
        Contact newContact = new Contact();

        System.out.println("Enter the name");
        newContact.setName(sc.nextLine());

        System.out.println("Enter the phone number");
        newContact.setTelephone(sc.nextLine());

        System.out.println("Enter the address");
        newContact.setAddress(sc.nextLine());

        System.out.println("Enter the email");
        newContact.setEmail(sc.nextLine());

        System.out.println("Enter the facebook");
        newContact.setFacebook(sc.nextLine());

        return newContact;
    }

    public void add(ArrayList<Contact> list) throws IOException {
        fileCSV.reader(fileCSV.FILE_PATH);

        System.out.println("Enter the quantity want to add");
        int quantity = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < quantity; i++) {
            System.out.println("Enter the index " + (i + 1));
            list.add(input());
        }
        show(list);
        fileCSV.writer(list, fileCSV.FILE_PATH);
    }

    public void edit(ArrayList<Contact> list) throws IOException {
        fileCSV.reader(fileCSV.FILE_PATH);

        System.out.println("Enter the phone number want to edit");
        String telephone = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(telephone)) {
                list.set(i, input());
            }
        }
        show(list);
        fileCSV.writer(list, fileCSV.FILE_PATH);
    }

    public void delete(ArrayList<Contact> list) throws IOException {
        fileCSV.reader(fileCSV.FILE_PATH);

        System.out.println("Enter the phone number want to delete");
        String telephone = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(telephone)) {
                list.remove(list.get(i));
            }
        }
        fileCSV.writer(list, fileCSV.FILE_PATH);
    }

    public void find(ArrayList<Contact> list) {
        System.out.println("Enter the phone number want to find");
        String telephone = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(telephone)) {
                System.out.println(list.get(i));
            }
        }
    }

    public void show(ArrayList<Contact> list) {
        sort(list);
        for (Contact c :
                list) {
            System.out.println(c);
        }
    }

    public void sort(ArrayList<Contact> list) {
        list.sort((o1, o2) -> {
            if (o1.getName().compareTo(o2.getName()) > 0) {
                return -1;
            } else {
                return 1;
            }
        });
    }

    public void menu() throws IOException {
        int choice;
        do {
            System.out.println("menu:" +
                    "\n1. add" +
                    "\n2. edit" +
                    "\n3. delete" +
                    "\n4. find" +
                    "\n5. show" +
                    "\n6. read_file" +
                    "\n7. write_file" +
                    "\n8. exit" +
                    "\nEnter your choice");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    add(listContacts);
                    break;
                case 2:
                    edit(listContacts);
                    break;
                case 3:
                    delete(listContacts);
                    break;
                case 4:
                    find(listContacts);
                    break;
                case 5:
                    show(listContacts);
                    break;
                case 6:
                    fileCSV.reader(fileCSV.FILE_PATH);
                    break;
                case 7:
                    fileCSV.writer(listContacts, fileCSV.FILE_PATH);
                    break;
                case 8:
                    System.exit(8);
            }
        } while (choice != 0);
    }
}
