import java.io.*;


public class BasicFileIO {
    public static void main(String[] args) {
        // Create an array of type Customer

        Customer[] customers = getCustomers();

        //creating customer class and throwing customer
        // objects into array

        //create a file - location in parentheses

        // PrintWriter is used to write characters to a file in this situatio
        PrintWriter custOutput = createFile("customers.txt");

        // Enhanced for loop for arrays
        //fill file with information by going throug the customers one by one:
        //Cycles through all of the people in the customers array

        for (Customer person : customers) {
            createCustomers(person, custOutput);
        }
        custOutput.close();
        getFileInfo(); //another method to read info from the file
    }

    //class that defines all the fields for my customers
    private static class Customer {
        public String firstName, lastName;
        public int custAge;

        //constructor:
        public Customer(String firstName, String lastName, int custAge) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.custAge = custAge;
        }


    }

    // Creates an array of Customer Objects
    //create Get Customers method:
    private static Customer[] getCustomers() {

        Customer[] customers = new Customer[5]; //customer is an array of 5 members:

        customers[0] = new Customer("Maria", "Bure", 33);
        customers[1] = new Customer("Bridget", "Johnes", 23);
        customers[2] = new Customer("Douglas", "Morris", 21);
        customers[3] = new Customer("Jason", "Castella", 21);
        customers[4] = new Customer("Steve", "Jobson", 21);

        return customers;

    }

    //Create the file and the PrintWriter that will write to the file:
    private static PrintWriter createFile(String fileName) {
        try {
            // Creates a File object that allows you to work with files on the hardrive
            //create new file object and then using
            //that new file object create new objects for:
            //fileWriter, BufferedWriter and PrintWriter

            File listOfNames = new File(fileName);
            PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(
                    new FileWriter(listOfNames)));
            return infoToWrite;
        }

        // FileWriter is used to write streams of characters to a file

        // BufferedWriter gathers a bunch of characters and then writes

        // them all at one time (Speeds up the Program)

        // PrintWriter is used to write characters to the console, file

        // You have to catch this when you call FileWriter


        catch (IOException e) {
            System.out.println("An I/O Error Occured");
            System.exit(0);
        }
        return null;
    }
    // Create a string with the customer info and write it to the file

    private static void createCustomers(Customer customer, PrintWriter custOutput) {
        // Create the String that contains the customer info

        String custInfo = customer.firstName + " " + customer.lastName + " ";
        custInfo += Integer.toString(customer.custAge); //to put customer age into string as well

        // Writes the string to the file

        custOutput.println(custInfo);
    }

    //Read info from the file and write it to the screen:

    private static void getFileInfo() {
        System.out.println("Info Written to File\n");
        //open the file
        // Open a new connection to the file

        File listOfNames = new File("customers.txt");

        //read from the file:
        try {
            // FileReader reads character files
            // BufferedReader reads as many characters as possible

            BufferedReader getInfo = new BufferedReader(new FileReader(listOfNames));

            // Reads a whole line from the file and saves it in a String

            String custInfo = getInfo.readLine();
            //readline reads each line at a time
            // readLine returns null when the end of the file is reached

            while (custInfo != null) {
                System.out.println(custInfo);
                custInfo = getInfo.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("An Io Error occurred");
            System.exit(0);

        }


    }
}

