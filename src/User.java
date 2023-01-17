import java.util.*;

public record User(int age, String name) {
    static int maxAge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public String toString() {
        return "Возраст " + age + ", "
                + "имя " + name;
    }

    public static void main(String[] args) {

        User user1 = new User(5000, "Петя");
        User user2 = new User(6, "Мотя");
        User user3 = new User(2, "Петя");
        User user4 = new User(6, "Мотя");
        User user5 = new User(6, "Котя");
        User user6 = new User(6, "Алеша");


        Set<User> set = new HashSet<>();
        set.add(user1);
        set.add(user2);
        set.add(user3);
        set.add(user4);
        set.add(user5);
        set.add(user6);
        TreeSet<User> sort = new TreeSet<>(Comparator.comparingInt(User::age).thenComparing(User::name));
        sort.addAll(set);
        for (User user : sort) {
            maxAge = Integer.max(maxAge, user.age);
            System.out.println(user);
        }
        System.out.println("Самые взрослые: ");
        for (User user : set) {
            if (maxAge == user.age()) {
                System.out.println(user);
            }
        }
    }
}


