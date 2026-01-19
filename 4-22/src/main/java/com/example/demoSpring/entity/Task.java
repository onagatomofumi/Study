package com.example.demoSpring.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "task", schema = "public")
public class Task  {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_id")
  private Integer id;


  @Column(name = "task_name")
  private String name;


  @Column(name = "task_status")
  private String status;


  @Column(name = "start_date")
  private Date startDate;


  @Column(name = "end_date")
  private Date endDate;
}