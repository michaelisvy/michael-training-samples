package boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication
public class ApplicationConfig {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    /*@Bean
    public DataSource dataSource () {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setType(EmbeddedDatabaseType.HSQL);
        builder.addScript("classpath:database/schema.sql");
        return builder.build();
    }*/

    /*@Bean public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.dataSource);
    }*/

    /*@Bean public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(this.dataSource);
        return txManager;
    }*/

    @Bean
    AccountDao accountDao() {
        return new AccountDao(this.jdbcTemplate);
    }

    @Bean AccountService accountService() {
        return new AccountService(accountDao());
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class);
    }


}
