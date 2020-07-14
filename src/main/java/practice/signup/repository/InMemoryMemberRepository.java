package practice.signup.repository;

import practice.signup.domain.Id;
import practice.signup.domain.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryMemberRepository {
    private final Map<String, Id> data = new HashMap<>();

    public void save(final Member member) {
        data.put(member.getId().toString(), member.getId());
    }

    public Optional<Id> findById(final String id) {
        return Optional.ofNullable(data.get(id));
    }
}
