import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AddressBookTest {
    ArrayList<contact> contact = new ArrayList<>();

    @Test
    public void whenPersonContactDetailsAddedToFile_ShouldReturn_True() {
        contact contact1 = new contact("Vishnu","Vardhan" ,"Ongole","Ongole","Andhrapradesh", "Vishnu388@gmail.com",8106261925L, 523001);
        contact contact2 = new contact("Kiran","Kumar","Ongole","Ongole","Andhrapradesh", "Kirankumar@gmail.com",9989988301L, 523301);

        AddressBookIO addressBook = new AddressBookIO();
        contact.add(contact1);
        contact.add(contact2);

        boolean isAdded = addressBook.addContact(contact);

        Assert.assertTrue(isAdded);
    }

    @Test
    public void givenCSVFile_WhenWrite_ShouldReturnTrue() throws IOException {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.csv";
        ArrayList<String[]> contacts = new ArrayList<>();
        String[] contact1 = {"Vishnu", "Vardhan", "ongole", "Ongole", "AndhraPradesh", String.valueOf(523001), String.valueOf(8106261925L), "Vishnu388@gmail.com"};
        String[] contact2 ={"Kiran","Kumar","ongole","ongole","Andhrapradesh", String.valueOf(523001), String.valueOf(9989988301L),"KiranKumar@gmail.com"};

        contacts.add(contact1);
        contacts.add(contact2);
        AddressBookOpenCSV opencsv=new AddressBookOpenCSV();
        Boolean result = opencsv.writeCSVFile(contacts);
        Assert.assertTrue(result);
    }
}
