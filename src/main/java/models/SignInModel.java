package models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SignInModel {
    private String email;
    private String password;
    private String passwordRepeat;

    public SignInModel(String email, String password, String passwordRepeat) {
        this.email = email;
        this.password = password;
        this.passwordRepeat = passwordRepeat;
    }
}