package base;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private String username;
    private String password;

    // TODO: other fields
}
