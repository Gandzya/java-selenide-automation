import base.BaseGuiTest;
import models.SignInModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static pages.InitPages.signInPage;

class SignInTests extends BaseGuiTest {

    private static final String CORRECT_EMAIL="username@domain.com";
    private static final String CORRECT_PASSWORD="MyStrongPassword123$";
    private static final String REPEAT_PASSWORD="MyOtherStrongPassword123$";





    @BeforeEach
    public void openPage() throws URISyntaxException {
        signInPage.get();
    }

    @Test
     void successfulSignInTest() {
        var correctUserDetails = new SignInModel(CORRECT_EMAIL, CORRECT_PASSWORD, CORRECT_PASSWORD);

        signInPage.signIn(correctUserDetails);

        softly.assertThat(signInPage.getCurrentUrl()).isEqualTo("Some new URL or message");
    }

    @Test
     void passwordsNotMatchingTest() {
        var notMatchingPasswordsDetails = new SignInModel(CORRECT_EMAIL, CORRECT_PASSWORD, REPEAT_PASSWORD);

        signInPage.signIn(notMatchingPasswordsDetails);

        softly.assertThat(signInPage.getCurrentUrl()).isEqualTo("Some new URL or message");
    }
}

