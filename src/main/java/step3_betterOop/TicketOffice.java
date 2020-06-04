package step3_betterOop;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {

    private Long amount;

    private List<Ticket> tickets = new ArrayList<>();

    public void sellTicketTo(Audience audience){
        plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket(){
        return tickets.remove(0);
    }

    private void minusAmount(Long amount){
        this.amount -= amount;
    }

    private void plusAmount(Long amount){
        this.amount += amount;
    }
}
