package com.dmwh.transformer.csvtojson;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CsvToJson  {
    private static final Logger log = LoggerFactory.getLogger(CsvToJson.class);
    //

    public String toString(){
        return getClass().getSimpleName()+"("+hashCode()+")";
    }

    public byte[] transform(byte[] data) throws IOException {
        try{
            Reader reader = new InputStreamReader(new ByteArrayInputStream(data));
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);
            //
            JSONArray result = new JSONArray();
            for (CSVRecord record : records) {
                JSONObject row = new JSONObject();
                for(int i=0; i<record.size(); i++){
                    row.put(String.valueOf(i+1),record.get(i));
                }
                result.put(row);
            }
            return result.toString().getBytes();
        }catch(Throwable t){
            log.error(t.getMessage(),t);
        }
        return  null;
    }




}
