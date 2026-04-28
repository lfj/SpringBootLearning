package com.lfj.demo.service.impl;

import com.lfj.demo.service.ITaskInterface;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TaskInterface implements ITaskInterface, InitializingBean {

    private ExecutorService executorService;

    private int taskNumber = 10;

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void executeTask(Runnable task) {
        executorService.execute(task);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (0 != taskNumber) {
            executorService = Executors.newFixedThreadPool(taskNumber);
        }
    }
}
