import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter a command (add_user, add_task, complete_task, view_tasks, exit): ");
            command = scanner.nextLine();

            switch (command) {
                case "add_user":
                    System.out.println("Enter user name: ");
                    String userName = scanner.nextLine();
                    users.add(new User(userName));
                    break;

                case "add_task":
                    System.out.println("Enter user name: ");
                    userName = scanner.nextLine();
                    User user = findUser(users, userName);
                    if (user != null) {
                        System.out.println("Enter task description: ");
                        String taskDescription = scanner.nextLine(); // Declare taskDescription here
                        user.addTask(taskDescription);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case "complete_task":
                    System.out.println("Enter user name: ");
                    userName = scanner.nextLine();
                    user = findUser(users, userName);
                    if (user != null) {
                        System.out.println("Enter task description: ");
                        String taskDescription = scanner.nextLine(); // Declare taskDescription here
                        user.markTaskAsCompleted(taskDescription);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case "view_tasks":
                    System.out.println("Enter user name: ");
                    userName = scanner.nextLine();
                    user = findUser(users, userName);
                    if (user != null) {
                        user.printTasks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    private static User findUser(ArrayList<User> users, String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
}
