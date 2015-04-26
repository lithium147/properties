package solubris.properties.profile;

import org.springframework.beans.factory.annotation.Value;

public class ProfileImpl implements Profile {
    @Value("${email}")
    private String email;

    public String getEmail() {
        return email;
    }
}
