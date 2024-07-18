package com.example.springboot.cruddemo.scheduler;

import com.example.springboot.cruddemo.entity.Log;
import com.example.springboot.cruddemo.service.LogService;
import com.example.springboot.cruddemo.storage.LogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogContextShutdownHandler implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private LogService logService;

    @Autowired
    private LogStorage logStorage;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        List<Log> logs = logStorage.getLogs();
        if (!logs.isEmpty()) {
            logService.saveAll(logs);
            logStorage.clearLogs();
            System.out.println("Logs saved on context shutdown.");
        } else {
            System.out.println("No logs to save on context shutdown.");
        }
    }
}
