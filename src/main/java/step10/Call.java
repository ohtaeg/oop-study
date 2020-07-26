package step10;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 개별 통화 기간을 저장
 * 통화 시작시간, 종료시간
 */
public class Call {
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Call(final LocalDateTime from, final LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public Duration getDuration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
