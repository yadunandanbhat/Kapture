package AddressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

class AddressBook {
    // Declaring all the needed utility class functions
    File filePath;
    FileReader reader;
    FileWriter writer;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    static FastReader input;

    // Initializing the arraylist of the entry objects
    private static ArrayList<Entry> al = new ArrayList<Entry>();

    // Init the defualt size which is used to check if the length of the list exceeds more than this
    private static final int DEFAULT_SIZE = 250;
    private static int length;

    // Declaring some variables to help in the functions
    private static String first, last, address, phone, email;

    /**
     * Public constructor which inits the fast reader input class
     * and opens the file in the path given by the user
     */
    public AddressBook() {
        System.out.println("Please enter the path of the address book file below:");
        input = new FastReader();
        filePath = new File(input.nextLine());
    }

    /**
     * Method used to read the entries from the file and add it to the arraylist
     * @throws IOException
     */
    void readFile() {
        try {
            reader = new FileReader(filePath);
            bufferedReader = new BufferedReader(reader);
            length = 0;
            String entryLine;

            while ((entryLine = bufferedReader.readLine()) != null) {
                String[] fields = entryLine.split("\\|");
                al.add(new Entry(fields[1], fields[2], fields[3], fields[4], fields[5]));
                length++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to write the arraylist to the file using the pipe character as the delimiter
     * @throws IOException
     */
    void writeFile() {
        try {
            writer = new FileWriter(filePath, true);
            printWriter = new PrintWriter(writer);

            int id = 1;
            for (Entry en : al) {
                if (id <= length) {
                    printWriter
                            .println("" + id++ + "|" + en.getFirst() + "|" + en.getLast() + "|"
                                    + en.getAddress() + "|"
                                    + en.getPhone() + "|" + en.getEmail());
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to clear the whole file before writing the entries
     * @throws FileNotFoundException
     */
    void clearFile() {
        try {
            printWriter = new PrintWriter(filePath);

            printWriter.print("");
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method used to add a number of entry objects to the arraylist,
     * only while length is less than default size.
     */
    public void addEntry() {
        if (length < DEFAULT_SIZE) {
            while (true) {
                System.out.println("Enter the details for the new entry below:");
                System.out.println("First Name: ");
                first = input.nextLine();
                System.out.println("Last Name: ");
                last = input.nextLine();
                System.out.println("Address: ");
                address = input.nextLine();
                System.out.println("Phone: ");
                phone = input.nextLine();
                System.out.println("Email: ");
                email = input.nextLine();

                al.add(new Entry(first, last, address, phone, email));
                length++;
                System.out.printf("Successfully added a new entry with fields %s, %s, %s, %s, %s\n",
                        first, last,
                        address, phone, email);

                System.out.println("Do you want to add another one (y/N) ? ");
                String response = input.nextLine();
                if (response.toLowerCase().equals("y"))
                    continue;
                else
                    display(al);
                break;
            }
        } else {
            // Prints an error if length is greater than or equals to the default size
            System.err.println("Length of the address book is full!");
        }
    }

    /**
     * Method used to edit the attributes of an entry object which correctly
     * compares to the queries given by the user
     */
    void editEntry() {
        System.out.println("Enter the first and last name of the entry you want to edit");
        System.out.println("First name: ");
        String queryFirst = input.nextLine();
        System.out.println("Last name: ");
        String queryLast = input.nextLine();

        Iterator<Entry> itr = al.iterator();

        while (itr.hasNext()) {
            Entry entry = itr.next();

            if (entry.getFirst().equals(queryFirst) && entry.getLast().equals(queryLast)) {
                System.out.println("Enter the new details for the new entry below:");
                System.out.println("First Name: ");
                first = input.nextLine();
                System.out.println("Last Name: ");
                last = input.nextLine();
                System.out.println("Address: ");
                address = input.nextLine();
                System.out.println("Phone: ");
                phone = input.nextLine();
                System.out.println("Email: ");
                email = input.nextLine();

                // Setter method to set all the attributes at once
                entry.set(first, last, address, phone, email);

                System.out.printf("Successfully edited the entry with fields %s, %s, %s, %s, %s\n",
                        first, last,
                        address, phone, email);
            }
        }
        display(al);
    }

    /**
     * Method used to remove entry object which correctly compared to the user queries from the arraylist
     */
    void removeEntry() {
        if (length <= 0) {
            System.err.println("The address book is empty!");
            return;
        }
        System.out.println("Enter the field (first / last / address / phone / email) :");
        String field = input.nextLine();
        System.out.println("Enter the field value:");
        String fieldVal = input.nextLine();

        Iterator<Entry> itr = al.iterator();
        boolean flag = false;

        while (itr.hasNext()) {
            Entry entry = itr.next();
            switch (field) {
                case "first":
                    if (entry.getFirst().equals(fieldVal)) {
                        itr.remove();
                        flag = true;
                        length--;
                    }
                    break;

                case "last":
                    if (entry.getLast().equals(fieldVal)) {
                        itr.remove();
                        flag = true;
                        length--;
                    }
                    break;

                case "address":
                    if (entry.getAddress().contains(fieldVal)) {
                        itr.remove();
                        flag = true;
                        length--;
                    }
                    break;

                case "phone":
                    if (entry.getPhone().equals(fieldVal)) {
                        itr.remove();
                        flag = true;
                        length--;
                    }
                    break;

                case "email":
                    if (entry.getEmail().contains(fieldVal)) {
                        itr.remove();
                        flag = true;
                        length--;
                    }
                    break;

                default:
                    System.out.println(
                            "Please eneter a correct field to delete the given string from");
            }
        }

        if (flag) {
            System.out.println("Successfully deleted the entry matching the given value");
            display(al);
        } else {
            System.out.println("Field with given field value not found!");
        }
    }

    /**
     * Method used to display the passed arraylist of entry objects
     * @param al is the arraylist of entry objects
     */
    void display(ArrayList<Entry> al) {
        Iterator<Entry> itr = al.iterator();

        System.out.println("\n\tAddress Book with " + length + " entries!\n");
        System.out.println("==========================================================");
        System.out.println("Name\t| Address\t| Phone\t| Email");
        System.out.println("----------------------------------------------------------");

        while (itr.hasNext()) {
            Entry entry = itr.next();
            System.out.println(
                    entry.getFirst() + " " + entry.getLast() + "\t| " + entry.getAddress() + "\t| "
                            + entry.getPhone() + "\t| " + entry.getEmail());
        }

        System.out.println("==========================================================");
    }

    /**
     * Method used to sort the arraylist depending on the field provided by the user.
     * By default first name is taken as the field to sort, unless specified.
     */
    void sort() {
        System.out.println("Enter the field (first (default) / last / address / phone / email) : ");
        String field = input.nextLine();

        switch (field) {
            case "last":
                Collections.sort(al, new Entry.sortByLast());
                break;

            case "address":
                Collections.sort(al, new Entry.sortByAddress());
                break;

            case "email":
                Collections.sort(al, new Entry.sortByEmail());
                break;

            case "phone":
                Collections.sort(al, new Entry.sortByPhone());
                break;

            default:
                Collections.sort(al);
        }

        System.out.println("List has been sorted as per the " + field);
        display(al);
        System.out.println("Select save to file in menu to save this order of entries!");
    }

    /**
     * Method used to search through the arraylist to find relevant entries
     * which match the query by the user. Uses stream, filter to find the entries and then
     * collects all of them as an arraylist of entries.
     */
    void search() {
        System.out.println("Enter the field (first / last / address / phone / email) : ");
        String field = input.nextLine();
        System.out.println("Enter the field value:");
        String fieldVal = input.nextLine();

        ArrayList<Entry> a = new ArrayList<>();

        switch (field) {
            case "first":
                a = (ArrayList<Entry>) al.stream().filter(e -> e.getFirst().contains(fieldVal))
                        .collect(Collectors.toList());
                break;

            case "last":
                a = (ArrayList<Entry>) al.stream().filter(e -> e.getLast().contains(fieldVal))
                        .collect(Collectors.toList());
                break;

            case "address":
                a = (ArrayList<Entry>) al.stream().filter(e -> e.getAddress().contains(fieldVal))
                        .collect(Collectors.toList());
                break;

            case "phone":
                a = (ArrayList<Entry>) al.stream().filter(e -> e.getPhone().contains(fieldVal))
                        .collect(Collectors.toList());
                break;

            case "email":
                a = (ArrayList<Entry>) al.stream().filter(e -> e.getEmail().contains(fieldVal))
                        .collect(Collectors.toList());
                break;

            default:
                System.out.println("Please enter correct field to search from!\n");
                return;
        }

        if (a.isEmpty()) {
            System.out.println("Entry with the given field and field value not found!");
            return;
        }
        display(a);
    }

    public static void main(String[] args) {
        // Instantiating the address book class
        AddressBook ab = new AddressBook();

        while (true) {
            System.out.println("\nWelcome to Address Book!");
            System.out.println("==========================================================");
            System.out.println("1. Load from the file");
            System.out.println("2. Save to file");
            System.out.println("3. Display the list");
            System.out.println("4. Add an entry");
            System.out.println("5. Remove an entry");
            System.out.println("6. Edit an entry");
            System.out.println("7. Sort the address book");
            System.out.println("8. Search for a specific entry");
            System.out.println("9. Quit");
            System.err.println("Enter your choice: ");
            int ch = input.nextInt();
            System.out.println("==========================================================");
            switch (ch) {
                case 1:
                    if (al.isEmpty()) {
                        ab.readFile();
                        System.out.println("\n\tReading from the file done!\n");
                    } else {
                        System.out.println("\n\tThe file has already been read!\n");
                    }
                    break;

                case 2:
                    ab.clearFile();
                    ab.writeFile();
                    System.out.println("\n\tWriting to the file done!\n");
                    break;

                case 3:
                    ab.display(al);
                    break;

                case 4:
                    ab.addEntry();
                    break;

                case 5:
                    ab.removeEntry();
                    break;

                case 6:
                    ab.editEntry();
                    break;

                case 7:
                    ab.sort();
                    break;

                case 8:
                    ab.search();
                    break;

                default:
                    System.out.println("\n\tExiting the program. Thank you!\n");
                    System.exit(1);
            }
        }
    }
}