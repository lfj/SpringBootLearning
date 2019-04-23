package com.lfj.demo.component;

import com.lfj.demo.entity.GirlEntity;
import com.lfj.demo.entity.Person;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class HibernateUtil {

    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        String dataBaseHost = "10.156.1.71";
        String dataBasePort = "3306";
        String dataBaseName = "db_selflearning";
        String dataBaseUserName = "root";
        String dataBasePassword = "123456";
        String dataBaseUrl = "jdbc:mysql://" + dataBaseHost + ":" + dataBasePort.toString() + "/" + dataBaseName + "?useUnicode=true&characterEncoding=UTF-8";
        configuration.addAnnotatedClass(GirlEntity.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.setProperty("connection.driver_class", "org.mariadb.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", dataBaseUrl);
        configuration.setProperty("hibernate.connection.username", dataBaseUserName);
        configuration.setProperty("hibernate.connection.password", dataBasePassword);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("show_sql", "false");
        configuration.setProperty("hibernate.connection.pool_size", "10");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = getSessionFactory();
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

            List<String> schoolList = new ArrayList<>();
            schoolList.add("铁力一中");
            schoolList.add("鞍山一中");
            schoolList.add("大连理工大学软件学院");
            girlEntity.setSchools(schoolList);

            String[] schoolList1 = new String[]{"清华大学", "北京大学", "南京大学"};
            //girlEntity.setSchools1(schoolList1);

            Person wawa = new Person();
            wawa.setAge(21);
            wawa.setName("cuirutong");
            wawa.getTrainings().add("Java");
            wawa.getTrainings().add("C++");
            wawa.getTrainings().add("Python");
            wawa.getTrainings().add("VB");

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(girlEntity);
            session.persist(wawa);
            session.getTransaction().commit();
            session.close();

            session = sessionFactory.openSession();
            GirlEntity girlEntity1 = (GirlEntity) session.get(GirlEntity.class, girlEntity.getId());
            session.close();

            sessionFactory.close();
        } catch (Exception e) {
            logger.error("fail to visit the db!", e);
        }
    }
}
