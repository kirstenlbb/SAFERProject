import java.util.ArrayList;
import java.util.List;

public class TicketDatabase {

    private List<Ticket> tickets = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public TicketDatabase() {
        loadSampleStudents();
        loadSampleTickets();
    }

    // Sample students for demo
    private void loadSampleStudents() {
        students.add(new Student("Kirsten Louise Barroma", "CICS", "BSIT", "24-32648"));
        students.add(new Student("Hannah Sarvia Doromal", "CICS", "BSIT", "24-26473"));
        students.add(new Student("Jhon Paul Boa", "CICS", "BSIT", "24-36572"));
    }

    // Sample tickets (Pending, Acknowledged, Accomplished, Dismissed) for demo
    private void loadSampleTickets() {
        tickets.add(new Ticket("Kirsten Louise Barroma", "24-32648",
                "Student Affairs and Services Office",
                "Student Discipline Concern",
                "A concern regarding classroom behavior.",
                TicketStatus.PENDING));

        tickets.add(new Ticket("Hannah Sarvia Doromal", "24-26473",
                "Scholarship Office",
                "Scholarship Renewal",
                "Follow-up on scholarship renewal application.",
                TicketStatus.ACKNOWLEDGED));

        tickets.add(new Ticket("Kirsten Louise Barroma", "24-32648",
                "Public Relations Office",
                "Event Promotion",
                "Request for promotion of an upcoming student event.",
                TicketStatus.ACCOMPLISHED));

        tickets.add(new Ticket("Kirsten Louise Barroma", "24-32648",
                "ICT Services",
                "System Access or Login Problems",
                "Unable to access school portal.",
                TicketStatus.DISMISSED));
    }

    // Getters
    public List<Ticket> getTickets() { return tickets; }
    public List<Student> getStudents() { return students; }

    // Add more tickets or students
    public void addTicket(Ticket t) { tickets.add(t); }
    public void addStudent(Student s) { students.add(s); }
}
