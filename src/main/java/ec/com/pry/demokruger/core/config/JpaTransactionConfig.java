package ec.com.pry.demokruger.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@ComponentScan(basePackages =  "ec.com.pry.demokruger")
@EnableTransactionManagement
public class JpaTransactionConfig {

    /**
     * TransactionManager.
     *
     * @param emf a {@link EntityManagerFactory} object.
     * @return a {@link PlatformTransactionManager} object.
     */
    @Bean
    @Autowired
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory emf){
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
}
