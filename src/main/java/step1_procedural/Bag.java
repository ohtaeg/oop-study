package step1_procedural;

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

    public boolean hasInvitation(){
        return invitation != null;
    }

    public boolean hasTicket(){
        return ticket != null;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }
}
