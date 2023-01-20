package com.acem.demo.constant.service;

import com.acem.demo.entity.Batch;
import com.acem.demo.response.Response;

public interface BatchService {

    Response getAll();
    Response save(Batch batch);
}
