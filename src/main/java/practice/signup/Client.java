package practice.signup;

import practice.signup.domain.dto.SignUpRequest;
import practice.signup.service.NaverMemberShipService;

public class Client {
    public static void main(String[] args) {
        final NaverMemberShipService naverMemberShipService = new NaverMemberShipService();

        final SignUpRequest signUpRequest = createSignUpRequest();
        final boolean signUpResult = naverMemberShipService.signUp(signUpRequest);
        System.out.println(signUpResult);

        // ID 중복
        naverMemberShipService.signUp(signUpRequest);
    }

    private static SignUpRequest createSignUpRequest() {
        return new SignUpRequest.Builder("ohtae", "1234")
                                .reConfirmPassword("1234")
                                .name("오태경")
                                .gender("male")
                                .birthDay("2020-06-29")
                                .email("otk1090@naver.com")
                                .phoneNumber("01044911090")
                                .certificationPhoneNumber("1234")
                                .build();
    }
}
