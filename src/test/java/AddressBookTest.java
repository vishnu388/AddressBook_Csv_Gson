import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AddressBookTest {
    ArrayList<contact> contact = new ArrayList<>();

    @Test
    public void whenPersonContactDetailsAddedToFil_ShouldReturn_True() {
        contact contact1 = new contact("Vishnu", "Vardhan", "Ongole", "Ongole", "AndhraPradesh", "Vishnu388@gmail.com",8106261925L, 523001);
        contact contact2 =new contact("Kiran","Kumar","Ongole","Ongole","Andhrapradesh", "KiranKumar@gmail.com",9989988301L, 523001);
        AddressBookIO addressBook = new AddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        boolean isAdded = addressBook.addContact(contact);
        Assert.assertTrue(isAdded);
    }
    @Test
    public void PersonContactDetailsAddedToFile_WhenRead_ShouldReturn_True() throws IOException {
        contact contact1 = new contact("Vishnu", "Vardhan", "Ongole", "Ongole", "AndhraPradesh", "Vishnu388@gmail.com",8106261925L, 523001);
        contact contact2 =new contact("Kiran","Kumar","Ongole","Ongole","Andhrapradesh", "KiranKumar@gmail.com",9989988301L, 523001);
        AddressBookIO addressBook = new AddressBookIO();
        contact.add(contact1);
        contact.add(contact2);
        boolean isAdded = addressBook.addContact(contact);
        if (isAdded) {
            boolean isRead = addressBook.viewContact();
            Assert.assertTrue(isAdded);
        }
    }
    @Test
    public void givenCSV_FileWhenRead_ShouldReturnTrue() throws IOException{
        AddressBookOpenCSV opencsv= new AddressBookOpenCSV();
        boolean result=opencsv.readCSV();
        Assert.assertTrue(result);
    }
    @Test
    public void givenCSVFile_WhenWrite_ShouldReturnTrue() throws IOException {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.csv";
        ArrayList<String[]> contacts = new ArrayList<>();
        String[] contact1 = {"Sai", "Tarun", "pelluru", "Ongole", "AndhraPradesh", String.valueOf(523001), String.valueOf(7387555893L), "saitarun800@gmail.com"};
        String[] contact2 ={"Sravani","Lakshmi","ongole","ongole","Andhrapradesh", String.valueOf(523001), String.valueOf(8080808022L),"sravs@gm.in"};

        contacts.add(contact1);
        contacts.add(contact2);
        AddressBookOpenCSV opencsv=new AddressBookOpenCSV();
        Boolean result = opencsv.writeCSVFile(contacts);
        Assert.assertTrue(result);
    }
}
