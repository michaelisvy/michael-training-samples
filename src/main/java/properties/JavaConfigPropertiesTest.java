package properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isvym on 1/12/16.
 */
@ContextConfiguration(classes = PropertiesConfig.class)
@SpringJUnitConfig
public class JavaConfigPropertiesTest {

    @Autowired
    private String clientName;

    @Test
    public void shouldRetrieveClientNameFromPropertiesFile() {
        assertThat(this.clientName).isEqualTo("tintin");
    }
}

@Configuration
@PropertySource("classpath:properties/mytest.properties")
class PropertiesConfig {
    @Value("${clientName}")
    private String clientName;

    @Bean public String clientName() {
        return this.clientName;
    }

    // mandatory and easy to forget!!
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
