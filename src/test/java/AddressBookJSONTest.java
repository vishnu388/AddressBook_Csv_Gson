import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookJSONTest {
    @Test
    public void givenJSONFile_WhenRead_ShouldReturnTrue(){
        AddressBookJSON json=new AddressBookJSON();
        boolean result=json.jsonRead();
        Assert.assertTrue(result);
    }
    @Test
    public void givenJSONFile_WhenWrite_ShouldReturnTrue() throws IOException {
        AddressBookJSON json = new AddressBookJSON();
        Contactinfo contact1 = new Contactinfo("Vishnu","Vardhan","Ongole","Ongole","Andhrapradesh",523001,
                "8106261925","Vishnu288@gmail.com");
        // ContactInfo contact2=new ContactInfo("Kiran","Kumar","Ongole","Ongole","AndhraPradesh",523001,
        //                                       "9989988301","KiranKumar@gmail.com");
        boolean result1=json.jsonWrite(contact1);
        //boolean result2=json.jsonWrite(contact2);
        Assert.assertTrue(result1);
        //Assert.assertTrue(result2);
    }
}
