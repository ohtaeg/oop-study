package step3_betterOop;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    // 초대받지 않은 관람객
    public Bag(long amount){
        this(null, amount);
    }

    // 초대 받은 관람객
    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0L;
        }else{
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation(){
        return invitation != null;
    }

    private void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    private void minusAmount(Long amount){
        this.amount -= amount;
    }

    private void plusAmount(Long amount){
        this.amount += amount;
    }
}
