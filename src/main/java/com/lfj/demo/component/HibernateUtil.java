package com.lfj.demo.component;

import com.lfj.demo.entity.GirlEntity;
import com.lfj.demo.model.PersionTag;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

@Component
public class HibernateUtil {

    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        String dataBaseHost = "10.156.1.71";
        String dataBasePort = "3306";
        String dataBaseName = "db_selflearning";
        String dataBaseUserName = "root";
        String dataBasePassword = "123456";
        String dataBaseUrl = "jdbc:mysql://" + dataBaseHost + ":" + dataBasePort.toString() + "/" + dataBaseName + "?useUnicode=true&characterEncoding=UTF-8";
        configuration.addAnnotatedClass(GirlEntity.class);
        configuration.setProperty("connection.driver_class", "org.mariadb.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", dataBaseUrl);
        configuration.setProperty("hibernate.connection.username", dataBaseUserName);
        configuration.setProperty("hibernate.connection.password", dataBasePassword);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("show_sql", "false");
        configuration.setProperty("hibernate.connection.pool_size", "10");
        SessionFactory sessionFactory;
        try {
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

            GirlEntity girlEntity = new GirlEntity();
            //girlEntity.setId("6");
            girlEntity.setName("lyp");
            girlEntity.setAge(20);
            girlEntity.setBirthDate(new Date());
            girlEntity.setBirthTime(new Date());
            girlEntity.setBirthTimestamp(new Date());
            girlEntity.setCupSize("C");
            File file = new File("src\\main\\resources\\pictures\\girl.jpg");
            byte[] content = new byte[(int)file.length()];
            new FileInputStream(file).read(content);
            girlEntity.setHeadImage(content);

            girlEntity.setPersionTag(PersionTag.九零后);
            girlEntity.setPersionTag2(PersionTag.外貌协会);

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(girlEntity);
            session.getTransaction().commit();
            session.close();

//            session = sessionFactory.openSession();
//            Query query = new Query();
//            GirlEntity girlEntity1 = ;
//            session.close();

            sessionFactory.close();
        } catch (Exception e) {
            logger.error("fail to visit the db!", e);
        }
    }
}
