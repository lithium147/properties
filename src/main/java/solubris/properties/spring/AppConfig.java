package solubris.properties.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import solubris.properties.profile.Profile;
import solubris.properties.profile.PropertyBasedProfileBuilder;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "solubris.properties")
public class AppConfig {

    @Autowired
    private ConfigurableEnvironment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Profile apple() throws IOException {
        return PropertyBasedProfileBuilder.aProfileUsing(env).named("apple").build();
    }

    @Bean
    public Profile google() throws IOException {
        return PropertyBasedProfileBuilder.aProfileUsing(env).named("google").build();
    }

//    @Bean
//    public Map<String, Profile> profileMap() throws IOException {
//        env.getPropertySources().replace("profile-properties",
//                new ResourcePropertySource("profile-properties", new ClassPathResource(
//                        "META-INF/profile/google.properties")));
//        ProfileImplForGoogle profileForGoogle = new ProfileImplForGoogle();
//        HashMap<String, Profile> result = new HashMap<>();
//        result.put("google", profileForGoogle);
//        return result;
//    }
}
