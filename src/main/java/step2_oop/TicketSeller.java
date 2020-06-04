package step2_oop;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));

    }
}

