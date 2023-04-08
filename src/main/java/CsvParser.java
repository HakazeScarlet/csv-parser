import com.opencsv.CSVReader;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public List<User> parse() {
        List<String[]> list = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Path.of(CsvParser.class.getResource("emails.csv").toURI()));
                CSVReader csvReader = new CSVReader(reader)
        ) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                list.add(line);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("the end");
        }
        return null;
    }
}
