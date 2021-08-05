package com.tqd.tool.wk;

import lombok.Data;

@Data
public class PromulgatingHistory {

    /**
     * "legislationID": "MTAxMDAwMDIxODk\u003d",
     *         "documentTitle": "中华人民共和国行政处罚法（1996）",
     *         "promulgatingDate": "1996.03.17",
     *         "validityStatusText": "已被修订"
     */
    private String legislationID;
    private String documentTitle;
    private String promulgatingDate;
    private String validityStatusText;
}
