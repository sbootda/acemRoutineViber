package com.acem.demo.constant.service.impl;

import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.constant.service.BatchService;
import com.acem.demo.entity.Batch;
import com.acem.demo.repository.BatchRepository;
import com.acem.demo.response.Response;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public Response getAll() {
        try{
            List<Batch> batchList = batchRepository.findAll();
            return new Response()
                    .statusCode(HttpServletResponse.SC_OK)
                    .description(ResponseMessageConstant.Batch.FOUND)
                    .success(true)
                    .data(batchList);
        }catch (Exception ex){
            System.out.println("Exception: "+ex.getMessage());
            return new Response()
                    .statusCode(HttpServletResponse.SC_NOT_FOUND)
                    .description(ResponseMessageConstant.Batch.NOT_FOUND)
                    .success(false);
        }
    }

    @Override
    public Response save(Batch batch) {
        try{
            batchRepository.save(batch);
            return new Response()
                    .statusCode(HttpServletResponse.SC_OK)
                    .description(ResponseMessageConstant.Batch.SAVED)
                    .success(true);
        }catch (Exception ex){
            System.out.println("Exception: "+ex.getMessage());
            return new Response()
                    .statusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                    .description(ResponseMessageConstant.Batch.NOT_SAVED)
                    .success(false);
        }
    }
}
