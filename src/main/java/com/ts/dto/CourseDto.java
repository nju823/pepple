package com.ts.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Encoded;

/**
 * Created by cong on 2017-11-18.
 */
public class CourseDto {


    private Integer id;

    /**
     * 名称
     */
    @NotBlank
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 课程创建者id
     */
    @NotBlank
    private String ownerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
