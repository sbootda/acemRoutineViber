package com.acem.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureResponse implements Serializable {
    private String name;
    private String startTime;
    private String endTime;
    private String group;
}
