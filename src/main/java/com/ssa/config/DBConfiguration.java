package com.ssa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class DBConfiguration {
    
    @Autowired
    private Environment environment;
    
    @Bean
    public DataSource getDataSource() {
         DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
         dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
         dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
         dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
         return dataSource;
    }
      private Properties hibernateProperties() {
            Properties properties = new Properties();
            properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
            properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
            properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
            return properties;        
        }

       @Bean
        public LocalSessionFactoryBean sessionFactory() {
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); //org.ssa.tiy.entity
            sessionFactory.setDataSource(getDataSource());
            sessionFactory.setPackagesToScan(new String[] { "com.ssa.entity" });
            sessionFactory.setHibernateProperties(hibernateProperties());
            return sessionFactory;
         }
       @Bean 
       @Autowired
       public HibernateTransactionManager transactionManager(SessionFactory session) {
           HibernateTransactionManager txManager = new HibernateTransactionManager();
           txManager.setSessionFactory(session);
           return txManager;
        }

//        @Bean
//        public HibernateTemplate hibernateTemplate() {
//            return new HibernateTemplate(sessionFactory());
//        }
        //@Bean
//        public SessionFactory sessionFactory() {
//            return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Student.class)
//                    .buildSessionFactory();
//        }

}

//@Configuration
//@EnableTransactionManagement
//public class DBConfiguration {
//	
//
//    @Bean
//    public HibernateTemplate hibernateTemplate() {
//        return new HibernateTemplate(sessionFactory());
//    }
//
//    @Bean
//    public DataSource getDataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/tracky?autoReconnect=true&useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("admin");
//        return dataSource;
//    }
//
//    @Bean
//    public SessionFactory sessionFactory() {
//        return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Member.class)
//                .buildSessionFactory();
//    }
//
//    @Bean
//    public HibernateTransactionManager hibTransMan() {
//        return new HibernateTransactionManager(sessionFactory());
//    }
//
//}
