
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddressBookJSON {
    private static final String HOME = System.getProperty("user.dir");
    private static final String fileName = "AddressBook.json";
    private static final Path homePath = Paths.get(HOME);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static boolean jsonWrite(Contactinfo contacts) throws IOException {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            if (Files.exists(filePath)) {
                String s = gson.toJson(contacts);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(filePath)));
                bufferedWriter.write(s);
                bufferedWriter.close();
            }
            else {
                Files.createFile(filePath);
                String s = gson.toJson(contacts);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(filePath)));
                bufferedWriter.write(s);
                bufferedWriter.close();
            }
            return true;
        }
        return true;
    }
    public static boolean jsonRead() {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath)));
                    Contactinfo contactPerson = gson.fromJson(br, Contactinfo.class);
                    System.out.println("ContactPerson{" +
                            "firstName='" + contactPerson.firstName + '\'' +
                            ", lastName='" + contactPerson.lastName + '\'' +
                            ", address='" + contactPerson.address + '\'' +
                            ", city='" + contactPerson.city + '\'' +
                            ", state='" + contactPerson.state + '\'' +
                            ", zip=" + contactPerson.zip +
                            ", phoneNumber='" + contactPerson.phoneNumber + '\'' +
                            ", email='" + contactPerson.email + '\'' +
                            '}' );
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}
