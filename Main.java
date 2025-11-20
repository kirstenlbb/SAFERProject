public class Main {
    public static void main(String[] args) {
        TicketDatabase db = new TicketDatabase();
        AdminPanel admin = new AdminPanel(db);
        admin.start();
    }
}
