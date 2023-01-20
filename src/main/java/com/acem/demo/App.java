package com.acem.demo;

import com.acem.demo.constant.AppConstants;
import com.acem.demo.util.GoogleSheetAPIUtil;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

@SpringBootApplication
public class App
{
    public static void main(String... args){
        SpringApplication.run(App.class,args);
    }

    public static void execute() throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        GoogleSheetAPIUtil googleSheetAPIUtil = new GoogleSheetAPIUtil();

        String spreadsheetId = AppConstants.SPREADSHEET_ID;
        String range = AppConstants.RANGE;

        try{
            googleSheetAPIUtil.getRecordsFromSheet(spreadsheetId, range,0,1);
        }catch (Exception ex){
            System.out.println("Exception: " +ex.getMessage());
        }
    }
}


