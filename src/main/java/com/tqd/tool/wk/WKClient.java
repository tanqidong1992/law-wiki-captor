package com.tqd.tool.wk;

import java.io.IOException;

import com.tqd.tool.ResponseUtils;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.io.entity.StringEntity;

public class WKClient {
	
    public static HttpRequestInterceptor newRequestInterceptor(){
    	
        return new WKHttpRequestInterceptor();
    }
    public static WKClient newInstance() {
    	HttpClient client= HttpClientBuilder.create()
                .addRequestInterceptorFirst(newRequestInterceptor())
                .build();
    	return new WKClient(client);
    }
    private HttpClient client;
    private String baseUrl="https://law.wkinfo.com.cn/csi";
    
    public WKClient(HttpClient client) {
    	this.client=client;;
    }
    public String login(String userName,String password) throws IOException{
        String LOGIN_URL=baseUrl+"/account/validate/ex";
    	HttpPost post=new HttpPost(LOGIN_URL);
        String json=String.format("""
        		{
                   "username": "%s",
                   "password": "%s"
                }
        		""", userName,password);
        HttpEntity entity=new StringEntity(json);
        post.setEntity(entity);
        ClassicHttpResponse response= (ClassicHttpResponse) client.execute(post);
        String content= ResponseUtils.readContentAsString(response.getEntity());
        return content;
    }
    
    public String getDocumentAbstract(String docId) throws IOException{
    	String url=String
    		.format(baseUrl+"/document/%s?indexId=law.legislation", docId);
    	HttpGet get=new HttpGet(url);
    	 ClassicHttpResponse response= (ClassicHttpResponse) client.execute(get);
         String content=ResponseUtils.readContentAsString(response.getEntity());
         return content;
    }
    
    public String getDocumentContent(String docId) throws IOException{
    	//https://law.wkinfo.com.cn/csi/document/MTAwMTQwMTA1OTQ=/html?indexId=law.legislation&print=false&fromType=null&useBalance=true&module=
    	String url=String
    		.format(baseUrl+"/document/%s/html?indexId=law.legislation&print=false&fromType=null&useBalance=true&module=", docId);
    	HttpGet get=new HttpGet(url);
    	 ClassicHttpResponse response= (ClassicHttpResponse) client.execute(get);
         String content=ResponseUtils.readContentAsString(response.getEntity());
         return content;
    }
    
    public String search() throws IOException{
        String url=baseUrl+"/search";
        HttpPost post=new HttpPost(url);
        String json= """
{
	"indexId": "law.legislation",
	"query": {
		"queryString": "*:*",
		"filterQueries": [
			"defaultRangeDoc:1"
		],
		"filterDates": []
	},
	"searchScope": {
		"treeNodeIds": [
			"levelEffectǁ001ǁǂ"
			 
		]
	},
	"relatedIndexQueries": [],
	"sortOrderList": [
		{
			"sortKey": "important",
			"sortDirection": "ASC"
		},
		{
			"sortKey": "promulgatingDate",
			"sortDirection": "DESC"
		}
	],
	"pageInfo": {
		"limit": 25,
		"offset": 0
	},
	"otherOptions": {
		"requireLanguage": "cn",
		"relatedIndexEnabled": true,
		"groupEnabled": false,
		"smartEnabled": true,
		"buy": false,
		"summaryLengthLimit": 100,
		"advanced": false,
		"synonymEnabled": true,
		"isHideBigLib": 0,
		"relatedIndexFetchRows": 5,
		"proximateCourtID": "",
		"module": ""
	},
	"chargingInfo": {
		"useBalance": true
	}
}
                """;
        post.setEntity(new StringEntity(json));
        ClassicHttpResponse response= (ClassicHttpResponse) client.execute(post);
        String content=ResponseUtils.readContentAsString(response.getEntity());
        return content;
    
    }
}
