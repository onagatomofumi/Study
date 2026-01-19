package com.example.demoSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoSpring.dto.TaskUpdateRequest;
import com.example.demoSpring.dto.taskRequest;
import com.example.demoSpring.entity.Task;
import com.example.demoSpring.service.TaskService;



@Controller
public class TaskController {


  @Autowired
  TaskService taskService;


  @RequestMapping("/task/list")
  public String serList(Model model) {
    List<Task> tasklist = taskService.searchAll();
    model.addAttribute("tasklist", tasklist);
    return "task/list";
  }

  @RequestMapping("/task/add")
  public String taskRegister(Model model) {
    model.addAttribute("taskRequest", new taskRequest());
    return "task/add";
  }

  @RequestMapping("/task/create")
  public String taskCreate(@Validated @ModelAttribute taskRequest taskRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {

      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }

      model.addAttribute("validationError", errorList);
      return "task/add";
    }
    taskService.create(taskRequest);
    return "redirect:/task/list";
  }

  @GetMapping("/task/{id}")
  public String taskDetail(@PathVariable Integer id, Model model) {
    Task task = taskService.findById(id);
    model.addAttribute("taskData", task);
    return "task/view";
  }
  
  @GetMapping("/task/{id}/edit")
  public String taskEdit(@PathVariable Integer id, Model model) {
    Task task = taskService.findById(id);
    TaskUpdateRequest taskUpdateRequest = new TaskUpdateRequest();
    taskUpdateRequest.setId(task.getId());
    taskUpdateRequest.setName(task.getName());
    model.addAttribute("taskUpdateRequest", taskUpdateRequest);
    return "task/edit";
  }
  
  @RequestMapping("/task/update")
  public String taskUpdate(@Validated @ModelAttribute TaskUpdateRequest taskUpdateRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "v";
    }
    taskService.update(taskUpdateRequest);
    return String.format("redirect:/task/%d", taskUpdateRequest.getId());
  }
  
  @GetMapping("/task/{id}/delete")
  public String taskDelete(@PathVariable Integer id, Model model) {
      taskService.delete(id);
      return "redirect:/task/list";
  }

}