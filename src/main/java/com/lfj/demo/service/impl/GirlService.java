package com.lfj.demo.service.impl;

import com.lfj.demo.model.Girl;
import com.lfj.demo.service.ICountryService;
import com.lfj.demo.service.IGirlService;
import com.lfj.demo.service.ITaskInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GirlService implements IGirlService {

    private static final Logger logger = LoggerFactory.getLogger(GirlService.class);

    private List<ICountryService> countryServiceList = new ArrayList();

    @PostConstruct
    public void initPostConstruct() {
        logger.info("开启GirlService");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("准备销毁GirlService");
    }

    @Resource
    private AsyncService asyncService;

    @Resource
    private GirlClassLoader girlClassLoader;

    @Resource
    private ITaskInterface taskInterface;

    @Override
    public Girl getGirlsInfo() {
        int i = 0;
        logger.info("看是否能调用异步方法");
        asyncService.getGirlInfoFromAbroad("japan");
        int j  = 0;
        Girl girl = new Girl();
        girl.setId("2");
        girl.setName("unknown girl");
        girl.setAge(20);
        logger.info("结束调用异步方法");
        return girl;
    }

    @Override
    public void initCountryServiceList() {
        if (!countryServiceList.isEmpty()) {
            return;
        }
        Map<String, ICountryService> countryServiceMap = girlClassLoader.getBeansOfType(ICountryService.class);
        for (Map.Entry<String, ICountryService> entry : countryServiceMap.entrySet()) {
            countryServiceList.add(entry.getValue());
        }
    }

    @Override
    public void doCountry() {
        OperateCountryTask operateCountryTask = new OperateCountryTask();
        operateCountryTask.setCountryServiceList(countryServiceList);
        taskInterface.executeTask(operateCountryTask);
    }

    public static void main(String[] args) {
        AbstractApplicationContext container = new ClassPathXmlApplicationContext("girl.xml");

        IGirlService girlService = (GirlService) container.getBean("girlService");
        System.out.println(girlService);

        container.close();
        System.out.println(girlService);
    }
}
