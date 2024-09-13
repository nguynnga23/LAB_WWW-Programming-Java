package com.example.week01_lab_nguyenthinga_21130791.respositories;

import com.example.week01_lab_nguyenthinga_21130791.entities.Log;

import java.util.List;

public interface LogRepository {
    public List<Log> getLogs();
    public Log getLog(int id);
    public boolean addLog(Log log);
    public boolean removeLog(int id);
    public boolean updateLog(int id, Log log);
}
