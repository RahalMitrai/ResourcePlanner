package com.mitrai.ResourcePlanner.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Response {

    private String message;
    private String id;
    private Object data;
}
