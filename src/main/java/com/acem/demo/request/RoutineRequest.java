package com.acem.demo.request;

import com.acem.demo.entity.Batch;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoutineRequest {
    private Batch batch;
}
