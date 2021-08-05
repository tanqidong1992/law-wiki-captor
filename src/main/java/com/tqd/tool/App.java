package com.tqd.tool;

import com.tqd.tool.util.JsonUtils;
import com.tqd.tool.wk.WKClient;

import java.io.IOException;

public class App {


    public static void main(String[] args) throws IOException {

        WKClient wk=WKClient.newInstance();
        String result=wk.login(Config.userName, Config.password);
        System.out.println(result);
        String content=wk.search();
        System.out.println(JsonUtils.prettyFormat(content));
        //content=wk.getDocumentAbstract("MTAwMTQwMTA1OTQ=");
        //System.out.println(JsonUtils.prettyFormat(content));
        //content=wk.getDocumentContent("MTAwMTQwMTA1OTQ=");
        //System.out.println(content);
    }
}
