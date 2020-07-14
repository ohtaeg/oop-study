package practice.signup.service;

import practice.signup.domain.BirthDay;
import practice.signup.domain.Id;
import practice.signup.domain.Name;
import practice.signup.domain.Password;
import practice.signup.domain.authentication.PhoneNumberAuthentication;
import practice.signup.domain.dto.SignUpRequest;
import practice.signup.domain.dto.SignUpResult;
import practice.signup.domain.gender.Gender;
import practice.signup.domain.Member;
import practice.signup.domain.phone.Phone;
import practice.signup.domain.phone.generator.DefaultNumberAuthenticationGenerator;
import practice.signup.repository.InMemoryMemberRepository;

public class NaverMemberShipService {
    private InMemoryMemberRepository memberRepository;

    public NaverMemberShipService() {
        this.memberRepository = new InMemoryMemberRepository();
    }

    public boolean signUp(final SignUpRequest request) {
        Id id = createId(request.getId());
        Password password = new Password(request.getPassword(), request.getReConfirmPassword());
        Name name = new Name(request.getName());
        Gender gender = new Gender(request.getGender());
        BirthDay birthDay = new BirthDay(request.getBirthDay());
        Phone phone = new Phone(request.getPhoneNumber(), request.getCertificationPhoneNumber()
                                , new PhoneNumberAuthentication(new DefaultNumberAuthenticationGenerator()));
        Member member = new Member(id, password, name, gender, birthDay, phone);

        memberRepository.save(member);

        return true;
    }

    private Id createId(final String id) {
        checkDuplicateId(id);
        return new Id(id);
    }

    private void checkDuplicateId(final String id) {
        if (memberRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("중복");
        }
    }
}
