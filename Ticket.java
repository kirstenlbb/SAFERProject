public class Ticket {
    private static int counter = 1;

    private int id;
    private String studentName;
    private String studentCode;
    private String office;
    private String category;
    private String description;
    private TicketStatus status;
    private boolean spamFlag = false; // NEW: spam flag

    public Ticket(String studentName, String studentCode, String office,
                  String category, String description, TicketStatus status) {
        this.id = counter++;
        this.studentName = studentName;
        this.studentCode = studentCode;
        this.office = office;
        this.category = category;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getStudentCode() { return studentCode; }
    public String getOffice() { return office; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public TicketStatus getStatus() { return status; }
    public void setStatus(TicketStatus status) { this.status = status; }

    // Spam flag
    public boolean isSpamFlag() { return spamFlag; }
    public void setSpamFlag(boolean spamFlag) { this.spamFlag = spamFlag; }

    @Override
    public String toString() {
        return "\n--------------- TICKET " + id + " ---------------\n" +
                "Student: " + studentName + "\n" +
                "SR-Code: " + studentCode + "\n" +
                "Office: " + office + "\n" +
                "Category: " + category + "\n" +
                "Description: " + description + "\n" +
                "Status: " + status + "\n" +
                "Spam: " + spamFlag + "\n" +
                "-------------------------------------------\n";
    }
}
