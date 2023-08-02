import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    private static final int NUMBER_OF_LINES_TO_SKIP = 1;

    // TODO: add test
    public List<User> parse() {
        List<User> users = new ArrayList<>();
        try (
            Reader reader = Files.newBufferedReader(Path.of(CsvParser.class.getResource("emails.csv").toURI()));
            CSVReader csvReader = new CSVReader(reader)
        ) {
            csvReader.skip(NUMBER_OF_LINES_TO_SKIP);

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                User user = new User();
                user.setName(line[0]);
                user.setSurname(line[1]);
                user.setEmail(line[2]);
                users.add(user);
            }
        } catch (URISyntaxException e) {
            throw new ResourcesReadingException("Cannot find path of CSV file", e);
        } catch (IOException | CsvValidationException e) {
            throw new CsvParsingException("Cannot parse CSV file", e);
        }
        return users;
    }

    private static final class ResourcesReadingException extends RuntimeException {

        public ResourcesReadingException(String message, Exception e) {
            super(message, e);
        }
    }

    private static final class CsvParsingException extends RuntimeException {

        public CsvParsingException(String message, Exception e) {
            super(message, e);
        }
    }
}
