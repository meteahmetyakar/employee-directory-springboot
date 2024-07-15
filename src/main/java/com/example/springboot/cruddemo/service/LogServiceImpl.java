package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.entity.Log;
import com.example.springboot.cruddemo.dao.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

	private final LogRepository logRepository;

	@Autowired
	public LogServiceImpl(LogRepository logRepository) {
		this.logRepository = logRepository;
	}

	@Override
	public void saveAll(List<Log> logs) {
		logRepository.saveAll(logs);
	}
}