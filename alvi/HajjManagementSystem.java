import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class
public class HajjManagementSystem {
    private static List<Participant> participants = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("======= Hajj Management System =======");
            System.out.println("1. Add Hajj Employee");
            System.out.println("2. Read Hajj Employee");
            System.out.println("3. Update Hajj Employee");
            System.out.println("4. Remove Hajj Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addHajjEmployee(scanner);
                    break;
                case 2:
                    readHajjEmployee(scanner);
                    break;
                case 3:
                    updateHajjEmployee(scanner);
                    break;
                case 4:
                    removeHajjEmployee(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addHajjEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter employee group name: ");
        String groupName = scanner.nextLine();

        Participant hajjEmployee = new StaffMember(name, age, groupName);
        participants.add(hajjEmployee);
        System.out.println("Hajj Employee added successfully!");
    }



    private static void readHajjEmployee(Scanner scanner) {
        System.out.print("Enter employee name to read: ");
        String name = scanner.nextLine();

        boolean employeeFound = false;
        for (Participant participant : participants) {
            if (participant instanceof StaffMember && participant.getName().equalsIgnoreCase(name)) {
                StaffMember employee = (StaffMember) participant;
                System.out.println("======= Employee Details =======");
                System.out.println("Name: " + employee.getName());
                System.out.println("Age: " + employee.getAge());
                System.out.println("Group Name: " + employee.getGroupName());
                System.out.println("--------------------");
                employeeFound = true;
                break;
            }
        }

        if (!employeeFound) {
            System.out.println("Employee not found.");
        }
    }

    private static void updateHajjEmployee(Scanner scanner) {
        System.out.print("Enter employee name to update: ");
        String name = scanner.nextLine();

        boolean employeeFound = false;
        for (Participant participant : participants) {
            if (participant instanceof StaffMember && participant.getName().equalsIgnoreCase(name)) {
                StaffMember employee = (StaffMember) participant;
                System.out.println("======= Update Employee Details =======");
                System.out.print("Enter new employee name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new employee age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter new employee group name: ");
                String newGroupName = scanner.nextLine();

                StaffMember updatedEmployee = new StaffMember(newName, newAge, newGroupName);
                participants.remove(participant);
                participants.add(updatedEmployee);

                System.out.println("Employee details updated successfully!");
                employeeFound = true;
                break;
            }
        }

        if (!employeeFound) {
            System.out.println("Employee not found.");
        }
    }


    private static void removeHajjEmployee(Scanner scanner) {
        System.out.print("Enter employee name to remove: ");
        String name = scanner.nextLine();

        boolean employeeRemoved = false;
        for (Participant participant : participants) {
            if (participant instanceof StaffMember && participant.getName().equalsIgnoreCase(name)) {
                participants.remove(participant);
                employeeRemoved = true;
                break;
            }
        }

        if (employeeRemoved) {
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }



}
