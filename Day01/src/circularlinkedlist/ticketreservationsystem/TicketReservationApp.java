package circularlinkedlist.ticketreservationsystem;

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Booking tickets
        system.bookTicket(101, "Alice", "Inception", "A5", "18:00");
        system.bookTicket(102, "Bob", "Avatar", "B3", "20:00");
        system.bookTicket(103, "Charlie", "Inception", "C1", "18:00");

        // Display all tickets
        system.displayTickets();

        // Search for tickets
        system.searchTicket("Inception");
        system.searchTicket("Bob");

        // Cancel a ticket
        system.cancelTicket(102);

        // Display updated tickets
        system.displayTickets();

        // Total tickets
        system.totalTickets();
    }
}

