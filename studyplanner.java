import java.util.ArrayList;
import java.util.Scanner;

class StudySession {
    private String subject;
    private int studyDuration; // duration in minutes

    // Constructor
    public StudySession(String subject, int studyDuration) {
        this.subject = subject;
        this.studyDuration = studyDuration;
    }

    // Getters
    public String getSubject() {
        return subject;
    }

    public int getStudyDuration() {
        return studyDuration;
    }

    // Method to display study session details
    public void displaySession() {
        System.out.println("Subject: " + subject + " | Duration: " + studyDuration + " minutes");
    }
}

public class StudyPlannerApp {
    private static ArrayList<StudySession> studySessions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to add a study session
    private static void addStudySession() {
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter study duration (in minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        StudySession session = new StudySession(subject, duration);
        studySessions.add(session);

        System.out.println("Study session added successfully!");
    }

    // Method to display all study sessions
    private static void viewStudySessions() {
        if (studySessions.isEmpty()) {
            System.out.println("No study sessions added yet.");
        } else {
            System.out.println("\n--- Study Plan ---");
            for (StudySession session : studySessions) {
                session.displaySession();
            }
        }
    }

    // Main menu
    private static void showMenu() {
        System.out.println("\nStudy Planner");
        System.out.println("1. Add Study Session");
        System.out.println("2. View Study Sessions");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudySession();
                    break;
                case 2:
                    viewStudySessions();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

