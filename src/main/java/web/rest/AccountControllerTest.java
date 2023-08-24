package web.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig(classes=ApplicationConfig.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
    
    @Autowired
    private WebApplicationContext applicationContext;
    
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
    }
    
    
    
    @Test
    public void shouldGetAccount() throws Exception {
        ResultActions actions = this.mockMvc.perform(get("/account/12"));
        actions.andExpect(jsonPath(".id").value(12));
        actions.andExpect(jsonPath(".cashBalance").value(100.0));
        actions.andExpect(status().isOk());
    }
    
    @Test
    public void shouldThrowAnExceptionBecauseNoRespBodyAnnotation() throws Exception {
        ResultActions actions = this.mockMvc.perform(get("/account/12/noannotation"));
        actions.andExpect(status().isOk()); // element found
        
        try {
            actions.andExpect(jsonPath(".id").value(12));   
            fail("should have failed because there is no @ResponseBody annotation");
        }
        catch(Throwable t) {
            // expected. No annotation => responsebody not parsed
        }
}

}

@Configuration
@ComponentScan("web.rest")
@EnableWebMvc
class ApplicationConfig {
    
}
