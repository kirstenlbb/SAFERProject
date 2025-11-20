import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminPanel {

    private TicketDatabase db;
    private Scanner sc = new Scanner(System.in);

    public AdminPanel(TicketDatabase db) {
        this.db = db;
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n=========== ADMIN MENU ===========");
            System.out.println("1. Dashboard");
            System.out.println("2. Ticket Management");
            System.out.println("3. Student Accounts");
            System.out.println("4. Reports & Analytics");
            System.out.println("5. Notifications");
            System.out.println("6. Settings");
            System.out.println("7. Logout");
            System.out.print("Enter choice: ");
            choice = getInt();

            switch (choice) {
                case 1 -> showDashboard();
                case 2 -> ticketManagement();
                case 3 -> listStudents();
                case 4 -> reports();
                case 5 -> notifications();
                case 6 -> settings();
                case 7 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }

    // DASHBOARD
    private void showDashboard() {
        List<Ticket> t = db.getTickets();

        long pending = t.stream().filter(x -> x.getStatus() == TicketStatus.PENDING).count();
        long ack = t.stream().filter(x -> x.getStatus() == TicketStatus.ACKNOWLEDGED).count();
        long acc = t.stream().filter(x -> x.getStatus() == TicketStatus.ACCOMPLISHED).count();
        long dis = t.stream().filter(x -> x.getStatus() == TicketStatus.DISMISSED).count();

        System.out.println("\n=========== DASHBOARD ===========");
        System.out.println("Total Tickets: " + t.size());
        System.out.println("Registered Students: " + db.getStudents().size());
        System.out.println("Pending: " + pending);
        System.out.println("Acknowledged: " + ack);
        System.out.println("Accomplished: " + acc);
        System.out.println("Dismissed: " + dis);
    }

    // TICKET MANAGEMENT
    private void ticketManagement() {
        System.out.println("\n========= TICKET MANAGEMENT =========");
        System.out.println("1. Ticket Requests (Pending + Acknowledged)");
        System.out.println("2. Accomplished Tickets");
        System.out.println("3. Dismissed Tickets");
        System.out.print("Enter choice: ");

        switch (getInt()) {
            case 1 -> showTicketRequests();
            case 2 -> showByStatus(TicketStatus.ACCOMPLISHED);
            case 3 -> showByStatus(TicketStatus.DISMISSED);
            default -> System.out.println("Invalid.");
        }
    }

    private void showTicketRequests() {
        List<Ticket> list = db.getTickets().stream()
                .filter(t -> t.getStatus() == TicketStatus.PENDING ||
                        t.getStatus() == TicketStatus.ACKNOWLEDGED)
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            System.out.println("\nNo pending or acknowledged tickets.");
            return;
        }

        list.forEach(System.out::println);

        System.out.print("Enter Ticket ID to manage (0 to exit): ");
        int id = getInt();
        if (id == 0) return;

        Ticket t = db.getTickets().stream()
                .filter(x -> x.getId() == id)
                .findFirst().orElse(null);

        if (t == null) {
            System.out.println("Invalid ID.");
            return;
        }

        manageTicket(t);
    }

    private void manageTicket(Ticket t) {
        System.out.println("\n========= MANAGE TICKET =========");
        System.out.println(t);

        System.out.println("1. Acknowledge & Send to Office");
        System.out.println("2. Dismiss Ticket");
        System.out.println("3. Mark as Accomplished");  // NEW
        System.out.println("4. Back");
        System.out.print("Enter choice: ");


        switch (getInt()) {
            case 1 -> {
                t.setStatus(TicketStatus.ACKNOWLEDGED);
                System.out.println("Ticket acknowledged and forwarded.");
            }
            case 2 -> {
                t.setStatus(TicketStatus.DISMISSED);
                System.out.println("Ticket dismissed.");
            }
            case 3 -> {  // NEW
                t.setStatus(TicketStatus.ACCOMPLISHED);
                System.out.println("Ticket marked as accomplished.");
            }
            case 4 -> {} // Back
            default -> System.out.println("Invalid choice.");
        }
    }

    private void showByStatus(TicketStatus status) {
        List<Ticket> list = db.getTickets().stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            System.out.println("\nNo tickets with this status.");
            return;
        }

        list.forEach(System.out::println);
    }

    // STUDENT ACCOUNTS
    private void listStudents() {
        System.out.println("\n========= STUDENT ACCOUNTS =========");
        db.getStudents().forEach(System.out::println);
    }

    // REPORTS
    private void reports() {
        System.out.println("\n========= REPORTS & ANALYTICS =========");
        System.out.println("Nothing to see.");
    }

    // NOTIFICATIONS
    private void notifications() {
        System.out.println("\n========= NOTIFICATIONS =========");
        System.out.println("Nothing to see.");
    }

    // SETTINGS
    private void settings() {
        System.out.println("\n========= SETTINGS =========");
        System.out.println("Nothing to see.");
    }

    private int getInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}
