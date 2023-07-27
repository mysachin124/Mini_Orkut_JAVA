import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MiniOrkut {
    private static class User {
        private String name;
        private int age;
        private ArrayList<User> friends;
        private ArrayList<String> posts;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
            friends = new ArrayList<>();
            posts = new ArrayList<>();
        }

        public void addFriend(User friend) {
            friends.add(friend);
        }

        public void addPost(String content) {
            posts.add(content);
        }

        public void viewWall() {
            System.out.println("Wall of " + name + ":");
            for (String post : posts) {
                System.out.println("- " + post);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, User> usersMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Add Friend");
            System.out.println("3. Add Post");
            System.out.println("4. View Wall");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    User user = new User(name, age);
                    usersMap.put(name, user);
                    System.out.println("User created successfully!");
                    break;
                case 2:
                    System.out.print("Enter first user's name: ");
                    String user1Name = scanner.nextLine();
                    System.out.print("Enter second user's name: ");
                    String user2Name = scanner.nextLine();

                    User user1 = usersMap.get(user1Name);
                    User user2 = usersMap.get(user2Name);

                    if (user1 != null && user2 != null) {
                        user1.addFriend(user2);
                        user2.addFriend(user1);
                        System.out.println(user1Name + " and " + user2Name + " are now friends!");
                    } else {
                        System.out.println("Invalid user names!");
                    }
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    User postUser = usersMap.get(userName);
                    if (postUser != null) {
                        System.out.print("Enter post content: ");
                        String content = scanner.nextLine();
                        postUser.addPost(content);
                        System.out.println("Post added to " + userName + "'s wall!");
                    } else {
                        System.out.println("Invalid user name!");
                    }
                    break;
                case 4:
                    System.out.print("Enter user name to view their wall: ");
                    String wallUserName = scanner.nextLine();
                    User wallUser = usersMap.get(wallUserName);
                    if (wallUser != null) {
                        wallUser.viewWall();
                    } else {
                        System.out.println("Invalid user name!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Mini Orkut...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
            System.out.println();
        }
    }
}