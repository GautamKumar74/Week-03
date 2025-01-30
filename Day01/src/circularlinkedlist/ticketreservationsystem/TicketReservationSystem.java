package circularlinkedlist.ticketreservationsystem;

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;
    private int count = 0; // Total booked tickets

    // Add a new ticket reservation at the end
    public void bookTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) { // First ticket
            head = tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular link
        }
        count++;
        System.out.println("Ticket booked successfully! Ticket ID: " + ticketID);
    }

    // Remove a ticket by Ticket ID
    public void cancelTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket current = head, prev = null;
        boolean found = false;

        do {
            if (current.ticketID == ticketID) { // Found the ticket
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket ID not found.");
            return;
        }

        if (current == head && current == tail) { // Only one ticket
            head = tail = null;
        } else if (current == head) { // Removing head
            head = head.next;
            tail.next = head;
        } else if (current == tail) { // Removing tail
            prev.next = head;
            tail = prev;
        } else { // Removing in between
            prev.next = current.next;
        }
        count--;
        System.out.println("Ticket ID " + ticketID + " has been canceled.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket: ID " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for: " + query);
        }
    }

    // Count total booked tickets
    public void totalTickets() {
        System.out.println("Total Booked Tickets: " + count);
    }
}

