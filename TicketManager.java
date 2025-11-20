import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketManager {

    private List<Ticket> tickets;

    public TicketManager() {
        tickets = new ArrayList<>();
    }

    // Add a new ticket
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println("\n✅ Ticket successfully submitted!");
    }

    // Get all tickets
    public List<Ticket> getTickets() {
        return tickets;
    }

    // View all tickets
    public void viewAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("\nNo tickets filed yet.");
            return;
        }

        System.out.println("\n===== FILED TICKETS =====");
        tickets.forEach(System.out::println);
    }

    // View tickets by status
    public void viewTicketsByStatus(TicketStatus status) {
        List<Ticket> filtered = tickets.stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("\nNo tickets with status: " + status);
            return;
        }

        System.out.println("\n===== TICKETS (" + status + ") =====");
        filtered.forEach(System.out::println);
    }

    // Find ticket by ID
    public Ticket findTicketById(int id) {
        return tickets.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }


}
