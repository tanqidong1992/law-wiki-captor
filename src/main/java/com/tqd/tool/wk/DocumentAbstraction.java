package com.tqd.tool.wk;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DocumentAbstraction {
    /**
        "docId": "MTAwMTQwMTA1OTQ\u003d",
                "title": "中华人民共和国行政处罚法（2021修订）",
                "summary": "",
                "docType": "legislation",
                "docOrdinal": 0,
                "lang": "cn",
                "permit": false,
                "attention": false,
     */
    private String docId;
    private String title;
    private String summary;
    private String docType;
    private Integer docOrdinal;
    private String lang;
    private Boolean permit;
    private Boolean attention;
    private List<Translation> translations;
    private Map<String,String> additionalFields;
    private List<PromulgatingHistory> promulgatingHistoryList;
    private List<?> contentAnnotationList;
}
