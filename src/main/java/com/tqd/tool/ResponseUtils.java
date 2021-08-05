package com.tqd.tool;

import org.apache.commons.io.IOUtils;
import org.apache.hc.core5.http.HttpEntity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResponseUtils {

    public static String readContentAsString(HttpEntity entity){
        try(InputStream in=entity.getContent()){
            String content= IOUtils.toString(new InputStreamReader(in));
            return content;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
