package com.example.springboot.cruddemo.dao;

import com.example.springboot.cruddemo.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {
}
