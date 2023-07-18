package jpa.blog.dto;

import lombok.Data;

@Data
public class AjaxResult {

    private String resultCode;
    private String resultMessage;
    private Object data;
    private Object data2;
}