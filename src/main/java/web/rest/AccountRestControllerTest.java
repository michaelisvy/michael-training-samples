package web.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringJUnitConfig(classes=RestControllerApplicationConfig.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestControllerTest {
    
    @Autowired
    private WebApplicationContext applicationContext;
    
    private MockMvc mockMvc;
    
    @BeforeEach
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
