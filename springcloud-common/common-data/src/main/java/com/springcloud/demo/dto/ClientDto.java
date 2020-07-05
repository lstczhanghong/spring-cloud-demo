package com.springcloud.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClientDto {

    private Integer id;
    private String clientName;
    private String clientPath;
    private Integer delFlag;
    private LocalDateTime createTime;
    private String createBy;
    private LocalDateTime updateTime;
    private String updateBy;
}
