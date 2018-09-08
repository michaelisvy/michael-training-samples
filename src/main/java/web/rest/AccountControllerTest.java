package web.rest;

import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=ApplicationConfig.class)
public class AccountControllerTest {
    
    @Autowired
    private WebApplicationContext applicationContext;
    
    private MockMvc mockMvc;
    
    @Before
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
