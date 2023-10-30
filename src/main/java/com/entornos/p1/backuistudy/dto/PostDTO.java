package com.entornos.p1.backuistudy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PostDTO implements Serializable {

    private static final long serialVersionUID = 1963900068803623164L;

    private Long id;
    private String title;
    private String description;
    private Long userId;
    private String username;
    private Long subjectId;
    private String subjectName;
    private Date createdAt;

    private String accessUrl;


}
