package web.rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebAppConfiguration // necessary for WebApplicationContext to be injected
@ContextConfiguration(classes=RestControllerApplicationConfig.class)
public class AccountRestControllerTest {
    
    @Autowired
    private WebApplicationContext applicationContext;
    
    private MockMvc mockMvc;
    
    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
    }
    
    
    
    @Test
    public void shouldGetAccountSuccesfullyEvenResponseBodyAnnotationNotNeeded() throws Exception {
        ResultActions actions = this.mockMvc.perform(get("/rest/account/12"));
        actions.andExpect(jsonPath(".id").value(12));
        actions.andExpect(jsonPath(".cashBalance").value(100.0));
        actions.andExpect(status().isOk());
    }
    
    @Test
    public void shouldGetAccountEvenWhenNoResponseBodyAnnotation() throws Exception {
        ResultActions actions = this.mockMvc.perform(get("/rest/account/12/noannotation"));
        actions.andExpect(jsonPath(".id").value(12));
        actions.andExpect(jsonPath(".cashBalance").value(100.0));
        actions.andExpect(status().isOk());
    }

}

@ComponentScan("web.rest")
@EnableWebMvc
class RestControllerApplicationConfig {
    
}
