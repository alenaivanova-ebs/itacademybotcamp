//package com.itacademy.bootcamp.dao;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@ComponentScan("com.itacademy.bootcamp.model")
//@Configuration
//@EnableTransactionManagement
//public class InitTestDataBaseConfig {
//
//    @Bean
//    public DataSource getDataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .setName("testDb;MODE=Oracle;INIT=create " +
//                        "schema if not exists " +
//                        "schema_test1\\;create schema if not exists schema_test2;" +
//                        "DB_CLOSE_DELAY=-1;")
//                .build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.itacademy.bootcamp.model");
//        factory.setDataSource(getDataSource());
//        return factory;
//    }
//
//    @Bean
//    JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
//        final JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//}
//
//
////    final Properties additionalProperties() {
////        final Properties hibernateProperties = new Properties();
////
////        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
////        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
////        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
////        hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", env.getProperty("hibernate.globally_quoted_identifiers"));
////
////        return hibernateProperties;
////    }
//
