package practice.signup.domain.authentication;

public class EmailAuthentication implements Authentication{
    @Override
    public boolean isSatisfied(final String certificationNumber) {
        return false;
    }
}
