package com.lowcode.lowcodeboot.bean.dto;


import lombok.Data;

@Data
public class ProjectDTO {
    private Long  projectId;
    private  String title;
    private  String type;
    private  Boolean funcBoxIsShow;

}
