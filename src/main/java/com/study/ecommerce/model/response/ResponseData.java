package com.study.ecommerce.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseData<T> {
    private String message;
    private Integer status;
    private T data;
}
