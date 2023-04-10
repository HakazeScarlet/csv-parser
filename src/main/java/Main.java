import java.util.List;

public class Main {

    public static void main(String[] args) {
        CsvParser parser = new CsvParser();
        List<User> users = parser.parse();
        for (User user : users) {
//            System.out.println(user.getName());
//            System.out.println(user.getSurname());
//            System.out.println(user.getEmail());
            System.out.println(user);
        }
    }
}
