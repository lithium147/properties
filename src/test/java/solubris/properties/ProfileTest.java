package solubris.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import solubris.properties.profile.Profile;
import solubris.properties.spring.AppConfig;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProfileTest {

    @Autowired
    Profile apple;

    @Autowired
    Profile google;

    @Autowired
    Map<String, Profile> profileMap;

    @Test
    public void profileCanHaveDifferentPropertyValues() {
        assertThat(apple.getEmail(), not(equalTo(google.getEmail())));
    }

    @Test
    public void profileMapCanHaveDifferentPropertyValues() {
        assertThat(profileMap.get("apple").getEmail(), not(equalTo(profileMap.get("google").getEmail())));
    }
}
