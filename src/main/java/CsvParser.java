import com.opencsv.CSVReader;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public List<User> parse() {
        List<User> users = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Path.of(CsvParser.class.getResource("emails.csv").toURI()));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                User user = new User();
                user.setName(line[0]);
                user.setSurname(line[1]);
                user.setEmail(line[2]);
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("the end");
        }
        return users;
    }
}
