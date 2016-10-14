package com.ssa.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.ssa.entity.Member;
import com.ssa.entity.Note;
import com.ssa.entity.Project;
import com.ssa.entity.ProjectNoteRel;
import com.ssa.entity.ProjectTeamRel;
import com.ssa.entity.Team;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {
	
	@Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tracky?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Member.class, Team.class, Project.class, Note.class, ProjectTeamRel.class, ProjectNoteRel.class)
                .buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager hibTransMan() {
        return new HibernateTransactionManager(sessionFactory());
    }
	

//  @Bean
//  public HibernateTemplate hibernateTemplate() {
//      return new HibernateTemplate(sessionFactory());
//  }
//
//  @Bean
//  public DataSource getDataSource() {
//      BasicDataSource dataSource = new BasicDataSource();
//      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//      dataSource.setUrl("jdbc:mysql://localhost:3306/tracky?autoReconnect=true&useSSL=false");
//      dataSource.setUsername("root");
//      dataSource.setPassword("admin");
//      return dataSource;
//  }
//
//  @Bean
//  public SessionFactory sessionFactory() {
////      return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Member.class, Team.class)
////              .buildSessionFactory();
//	  
//	  LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getDataSource());
//	  sessionBuilder.scanPackages("com.ssa.entity");
//	  sessionBuilder.addProperties(getHibernateProperties());
//	  return sessionBuilder.buildSessionFactory();
//  }
//  
//  public Properties getHibernateProperties() {
//	  Properties properties = new Properties();
//	  properties.put("hibernate.show_sql", "true");
//	  properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//	  return properties;
//	  
//  }
//
//  @Autowired
//  @Bean
//  public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
//      return new HibernateTransactionManager(sf);
//  }
  
//  @Autowired
//  @Bean
//  public ITeamDAO getTeamDAO(HibernateTemplate ht) {
//	  return new TeamDAO(ht); 
//  }
//  
//  @Autowired
//  @Bean
//  public IMemberDAO getMemberDAO(HibernateTemplate ht) {
//	  return new MemberDAO(ht); 
//  }

}

//@Configuration
//@EnableTransactionManagement
//@PropertySource(value = { "classpath:application.properties" })
//public class DBConfiguration {
//    
//    @Autowired
//    private Environment environment;
//    
//    @Bean
//    public DataSource getDataSource() {
//         DriverManagerDataSource dataSource = new DriverManagerDataSource();
//         dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//         dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//         dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//         dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
//         return dataSource;
//    }
//      private Properties hibernateProperties() {
//            Properties properties = new Properties();
//            properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
//            properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
//            properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//            return properties;        
//        }
//
//       @Bean
//        public LocalSessionFactoryBean sessionFactory() {
//            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); //org.ssa.tiy.entity
//            sessionFactory.setDataSource(getDataSource());
//            sessionFactory.setPackagesToScan(new String[] { "com.ssa.entity" });
//            sessionFactory.setHibernateProperties(hibernateProperties());
//            return sessionFactory;
//         }
//       @Bean 
//       @Autowired
//       public HibernateTransactionManager transactionManager(SessionFactory session) {
//           HibernateTransactionManager txManager = new HibernateTransactionManager();
//           txManager.setSessionFactory(session);
//           return txManager;
//        }

//        @Bean
//        @Autowired
//        public HibernateTemplate hibernateTemplate() {
//            return new HibernateTemplate((SessionFactory) sessionFactory());
//        }
        //@Bean
//        public SessionFactory sessionFactory() {
//            return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Student.class)
//                    .buildSessionFactory();
//        }
//
//}
