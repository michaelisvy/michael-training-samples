package aop.pointcut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class ApplicationConfig {

    @Bean ClientService clientService() {
        return new ClientServiceImpl();
    }

    @Bean LogAspect logAspect() {
        return new LogAspect();
    }

}
