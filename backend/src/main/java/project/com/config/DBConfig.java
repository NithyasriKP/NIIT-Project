package project.com.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import project.com.Model.Cart;
import project.com.Model.Category;
import project.com.Model.OrderDetail;
import project.com.Model.Product;
import project.com.Model.Supplier;
import project.com.Model.UserDetail;




@Configuration
@EnableTransactionManagement


public class DBConfig {
	
	//Creating the dataSource Bean
			@Bean(name="dataSource")
			public DataSource getH2DataSource()
			{
				DriverManagerDataSource dataSource=new DriverManagerDataSource();
				dataSource.setDriverClassName("org.h2.Driver");
				dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/db");
				dataSource.setUsername("sa");
				dataSource.setPassword("sa");
				System.out.println("==========Data Source Object is Created==============");
				return dataSource;
			}
			
			//Creating a SessionFactory Bean 
			
			@Bean
			public SessionFactory getSessionFactory()
			{
				Properties hibernateProperties=new Properties();
				hibernateProperties.put("hibernate.hbm2ddl.auto","update");
				hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
				hibernateProperties.put("hibernate.show_sql",true);
				
				LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(this.getH2DataSource());
				factory.addProperties(hibernateProperties);
				
				factory.addAnnotatedClass(Category.class);
				factory.addAnnotatedClass(Product.class);
				factory.addAnnotatedClass(Supplier.class);
				factory.addAnnotatedClass(UserDetail.class);
				factory.addAnnotatedClass(Cart.class);
				factory.addAnnotatedClass(OrderDetail.class);
				
				SessionFactory sessionFactory=factory.buildSessionFactory();
				System.out.println("==============SessionFactory Object Created=============");
				return sessionFactory;
			}
			
			//Creating a HibernateTransactionManager Bean
			
			@Bean(name="txManager")
			public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
			{
				System.out.println("=====Hibernate Tranaction Manager Object Created=======");
				return new HibernateTransactionManager(sessionFactory);
			}

}
