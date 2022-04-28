package co.za.izinga.menuupdater.model;

public class UserProfile extends Profile {

    private String idNumber;
    private SignUpReason signUpReason;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public SignUpReason getSignUpReason() {
        return signUpReason;
    }

    public void setSignUpReason(SignUpReason signUpReason) {
        this.signUpReason = signUpReason;
    }

    public enum SignUpReason {
        DELIVERY_DRIVER,
        SELL,
        BUY
    }
}
