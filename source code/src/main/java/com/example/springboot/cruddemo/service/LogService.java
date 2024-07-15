package com.example.springboot.cruddemo.service;

import com.example.springboot.cruddemo.entity.Log;

import java.util.List;

public interface LogService {
	void saveAll(List<Log> logs);
}