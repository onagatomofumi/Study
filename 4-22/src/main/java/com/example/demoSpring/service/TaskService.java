package com.example.demoSpring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoSpring.dto.TaskUpdateRequest;
import com.example.demoSpring.dto.taskRequest;
import com.example.demoSpring.entity.Task;
import com.example.demoSpring.repository.TaskRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class TaskService {
  @Autowired
  private TaskRepository taskRepository;


  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<Task> searchAll() {
    return taskRepository.findAll();
  }
  public Task findById(Integer id) {
      return taskRepository.getOne(id);
    }
  
    public void create(taskRequest taskRequest) {
      Date now = new Date();
      Task task = new Task();
      task.setName(taskRequest.getName());
      task.setStartDate(now);
      task.setEndDate(now);
      taskRepository.save(task);
    }
    public void update(TaskUpdateRequest taskUpdateRequest) {
        Task task = findById(taskUpdateRequest.getId());
        task.setName(taskUpdateRequest.getName());
        task.setEndDate(new Date());
        taskRepository.save(task);
      }
      
      public void delete(Integer id) {
          Task task = findById(id);
          taskRepository.delete(task);
      }
}