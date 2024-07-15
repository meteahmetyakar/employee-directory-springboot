package com.example.springboot.cruddemo.scheduler;

import com.example.springboot.cruddemo.entity.Log;
import com.example.springboot.cruddemo.service.LogService;
import com.example.springboot.cruddemo.storage.LogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogScheduler {

	@Autowired
	private LogService logService;

	@Autowired
	private LogStorage logStorage;

	@Scheduled(cron = "0 0 0 * * ?")
	public void saveLogsToDatabase() {
		List<Log> logs = logStorage.getLogs();
		if (!logs.isEmpty()) {
			logService.saveAll(logs);
			logStorage.clearLogs();
		}
	}
}
