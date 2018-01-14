package com.ts.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by cong on 2017-11-15.
 */
public class UploadQuestionInputDto {


    /**
     * 上传的excel文件路径
     */
    @NotBlank
    private String path;

    /**
     * 所属课程的id
     */
    @NotNull
    private Integer courseId;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

}
