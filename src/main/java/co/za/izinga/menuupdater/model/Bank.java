package co.za.izinga.menuupdater.model;

import javax.validation.constraints.NotBlank;

public class Bank {

    @NotBlank(message = "Bank name not valid")
    private String name;
    @NotBlank(message = "Bank phone not valid")
    private String phone;
    @NotBlank(message = "Bank account id not valid")
    private String accountId;
    private BankAccType type;
    @NotBlank(message = "Bank Branch code not valid")
    private String branchCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BankAccType getType() {
        return type;
    }

    public void setType(BankAccType type) {
        this.type = type;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
}

enum BankAccType {
    CHEQUE("1"), EWALLET("D"), SAVINGS("2"), TRANSMISSION("3"), wallet(""), string("");

    String code;

    BankAccType(String code) {
       this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
