package com.example.springboot.cruddemo.storage;

import com.example.springboot.cruddemo.entity.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LogStorage {

	private final List<Log> logs = new ArrayList<>();

	public void addLog(Log log) {
		synchronized (logs) {
			logs.add(log);
		}
	}

	public List<Log> getLogs() {
		synchronized (logs) {
			return new ArrayList<>(logs);
		}
	}

	public void clearLogs() {
		synchronized (logs) {
			logs.clear();
		}
	}
}
