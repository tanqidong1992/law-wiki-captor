package com.tqd.tool.wk;

import java.io.IOException;
 

import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WKHttpRequestInterceptor implements HttpRequestInterceptor {
    
	private static final Logger logger=LoggerFactory.getLogger(WKHttpRequestInterceptor.class);
	
	@Override
	public void process(HttpRequest httpRequest, EntityDetails entity, HttpContext context)
			throws HttpException, IOException {
		logger.info("{} to {}",httpRequest.getMethod(),httpRequest.getRequestUri());
		httpRequest.setHeader("Accept","application/json, text/plain, */*");
        httpRequest.setHeader("Accept-Encoding","gzip, deflate, br");
        httpRequest.setHeader("Content-Type","application/json;charset=utf-8");
        httpRequest.setHeader("Host","law.wkinfo.com.cn");
        httpRequest.setHeader("Identification","_b1857ce0f50111ebbb8191eca6d402f5");
        httpRequest.setHeader("Origin","https://law.wkinfo.com.cn");
        //httpRequest.setHeader("Referer","https://law.wkinfo.com.cn/?logout=");
        httpRequest.setHeader("Referer","https://law.wkinfo.com.cn/legislation/list?fq=levelEffectǁ0001ǁǂ法律&tip=");
        
        httpRequest.setHeader("Sec-Fetch-Dest","empty");
        httpRequest.setHeader("Sec-Fetch-Mode","cors");
        httpRequest.setHeader("Sec-Fetch-Site","same-origin");
        httpRequest.setHeader("User-Agent","Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:90.0) Gecko/20100101 Firefox/90.0");
        httpRequest.setHeader("X-Tingyun-Id","tN6Win9ZeY4;r=44463207");

	}

}
