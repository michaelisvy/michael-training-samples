package config.javaconfig.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@ComponentScan("config.javaconfig.componentscan")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

}
