import java.util.*;

// Class to store Patient details
class Patient {
    int patientId;
    String name;
    String disease;
    String doctorName;

    // Constructor
    Patient(int patientId, String name, String disease, String doctorName) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.doctorName = doctorName;
    }

    // Method to display patient details
    void display() {
        System.out.println("ID: " + patientId +
                ", Name: " + name +
                ", Disease: " + disease +
                ", Doctor: " + doctorName);
    }
}

public class HospitalManagementSystem {

    // Main list to store patients
    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        // Menu-driven loop
        do {
            System.out.println("\n--- Hospital Patient Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Discharge Patient");
            System.out.println("5. Count Total Patients");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    displayPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    dischargePatient();
                    break;
                case 5:
                    countPatients();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Function to add a patient
    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();

        // Add new patient to list
        patients.add(new Patient(id, name, disease, doctor));

        System.out.println("Patient added successfully.");
    }

    // Function to display all patients
    static void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n--- Patient List ---");
        for (Patient p : patients) {
            p.display();
        }
    }

    // Function to search patient by ID
    static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.patientId == id) {
                System.out.println("Patient Found:");
                p.display();
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    // Function to discharge (remove) patient
    static void dischargePatient() {
        System.out.print("Enter Patient ID to discharge: ");
        int id = sc.nextInt();

        Iterator<Patient> iterator = patients.iterator();

        while (iterator.hasNext()) {
            Patient p = iterator.next();

            if (p.patientId == id) {
                iterator.remove(); // safe removal
                System.out.println("Patient discharged successfully.");
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    // Function to count total patients
    static void countPatients() {
        System.out.println("Total Patients: " + patients.size());
    }
}