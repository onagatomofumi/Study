package com.example.demoSpring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class taskRequest implements Serializable{
    

      @NotEmpty(message = "タスク名入力してください")
      @Size(max = 100, message = "タスク名は50桁以内で入力してください")
      private String name;
      
      @NotEmpty(message = "ステータスを入力してください")
      private String status;

}
