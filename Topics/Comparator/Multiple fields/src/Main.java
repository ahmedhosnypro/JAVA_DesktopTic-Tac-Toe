import java.util.Comparator;
import java.util.List;

class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Utils {

    public static void sortUsers(List<User> users) {
        users.sort(Comparator.comparing(User::getName).
                thenComparing(Comparator.comparing(User::getAge).reversed()));
    }
}