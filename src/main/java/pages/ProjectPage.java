package pages;


import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Data;
import lombok.experimental.Accessors;
import base.User;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

@Data
@Accessors(chain = true)
public abstract class ProjectPage {
    private String url;

    public static final Logger log = (Logger) LoggerFactory.getLogger(ProjectPage.class);


    public abstract String getLink();

    public String getFullUrl() throws URISyntaxException {
        // this ugly impementation was added only because of file in project.
        // usually I would configure it in maven/gradle profiles
        URL resource = getClass().getClassLoader().getResource(getLink());
        File file = Paths.get(Objects.requireNonNull(resource).toURI()).toFile();

        return file.getAbsolutePath();
    }


    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }

    public void get() throws URISyntaxException {
        get(getFullUrl());
    }

    public void get(final String url) {
        Selenide.open(url);
    }

    public void get(final User user, final String url) {
        // todo: logIn(user)
        get(url);
    }
}
