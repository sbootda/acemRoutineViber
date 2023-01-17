package com.acem.demo;

import com.acem.demo.constant.AppConstants;
import com.acem.demo.util.GoogleAPIUtil;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class App
{
    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        GoogleAPIUtil googleAPIUtil = new GoogleAPIUtil();

        Properties properties = googleAPIUtil.getProperties(AppConstants.PROPERTIES_PATH);
        String spreadsheetId = (String) properties.get("spreadsheetId");
        String range = (String) properties.get("range");
//        Integer row1 = (Integer) properties.get("row1");
//        Integer row2 = (Integer) properties.get("row2");
        Integer sheetId = AppConstants.sheetId;

        try{
            googleAPIUtil.getRecordsFromSheet(spreadsheetId, sheetId ,range,0,1);
        }catch (Exception ex){
            System.out.println("Exception: " +ex.getMessage());
        }
    }
}


