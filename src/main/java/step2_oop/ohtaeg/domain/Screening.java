package step2_oop.ohtaeg.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Screening {
    private final Movie movie;
    private final int sequence;
    private final LocalDateTime whenScreened;

    public Screening(final Movie movie, final int sequence, final LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(final int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public LocalTime getStartTime() {
        return LocalTime.of(whenScreened.getHour(), whenScreened.getMinute());
    }

    public boolean isSequence(final int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}
