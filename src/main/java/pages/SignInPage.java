package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import models.SignInModel;

import static com.codeborne.selenide.Selenide.$;

@Data
@EqualsAndHashCode(callSuper=false)
public class SignInPage extends ProjectPage {

    private final String link = "register.html";

    private SelenideElement email = $("#email");
    private SelenideElement password = $("#psw");
    private SelenideElement passwordRepeat = $("#psw-repeat");
    private SelenideElement registerButton = $("button.registerbtn");

    public void fillForm(SignInModel data) {
        email.setValue(data.getEmail());
        password.setValue(data.getPassword());
        passwordRepeat.setValue(data.getPasswordRepeat());
    }

    public void signIn(SignInModel data) {
        fillForm(data);
        registerButton.click();
    }

    @Override
    public String getLink() {
        return link;
    }
}
