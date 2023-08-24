package jpa.simpleJavaConfig;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

public class ApplicationConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().
                addScript("classpath:jpa/schema.sql")
                .build();
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter theVendorAdapter = new HibernateJpaVendorAdapter();
        theVendorAdapter.setDatabase(Database.HSQL);
        return theVendorAdapter;
    }
    
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("jpa");
        entityManager.setJpaVendorAdapter(jpaVendorAdapter());
        entityManager.afterPropertiesSet();
        
        EntityManagerFactory emf = entityManager
                .getNativeEntityManagerFactory();
        return emf;
    }

}
