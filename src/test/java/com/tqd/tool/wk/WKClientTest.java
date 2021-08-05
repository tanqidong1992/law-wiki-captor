package com.tqd.tool.wk;

import com.tqd.tool.Config;
import com.tqd.tool.util.JsonUtils;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class WKClientTest {

    @Test
    public void test() throws IOException {
        WKClient wk=WKClient.newInstance();
        String result=wk.login(Config.userName, Config.password);
        String content=wk.getDocumentAbstract("MTAwMTQwMTA1OTQ=");
        DocumentAbstractionWrapper da=JsonUtils.parse(content,DocumentAbstractionWrapper.class);
        System.out.println(da);
        content=wk.getDocumentContent("MTAwMTQwMTA1OTQ=");
        DocumentDetail dd=JsonUtils.parse(content,DocumentDetail.class);
        String css=FileUtils.readFileToString(new File("test-data/main.css"), StandardCharsets.UTF_8);

        String head= String.format("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>%s</title>
                    <style type="text/css">
                    %s
                    </style>
                </head>
                <body>
                """,da.getCurrentDoc().getTitle(),css);
        String end= """
                </body>
                </html>
                """;

        File file=new File("test.html");


        FileUtils.write(file,head+dd.getContent()+end);
        //Desktop.getDesktop().open(file);
        //System.out.println(dd);
    }
}