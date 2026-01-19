package com.example.demoSpring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)

public class TaskUpdateRequest extends taskRequest implements Serializable {
    @NotNull
    private Integer id;
  

}
