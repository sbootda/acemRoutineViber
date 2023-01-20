package com.acem.demo.controller;

import com.acem.demo.constant.service.BatchService;
import com.acem.demo.entity.Batch;
import com.acem.demo.request.RoutineRequest;
import com.acem.demo.response.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routine")
public class RoutineController {

    private final BatchService batchService;

    public RoutineController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping
    public Response setRoutine(@Validated @RequestBody RoutineRequest request){
        return batchService.save(request.getBatch());
    }

    @GetMapping
    public Response getAll(){
        return batchService.getAll();
    }


}
