package com.safebrosing;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class GoogleSafeBrowsing {

    String key="";
    RestTemplate restTemplate;
    String requestFormat = "{\"client\":{\"clientId\":\"yourcompanyname\",\"clientVersion\":\"1.5.2\"},\"threatInfo\":{\"threatTypes\":[\"MALWARE\",\"SOCIAL_ENGINEERING\",\"POTENTIALLY_HARMFUL_APPLICATION\",\"UNWANTED_SOFTWARE\"],\"platformTypes\":[\"ALL_PLATFORMS\",\"ANY_PLATFORM\"],\"threatEntryTypes\":[\"URL\"],\"threatEntries\":[{\"url\":\"%s\"}]}}";
    HttpHeaders headers;
    String requestUrl = "https://safebrowsing.googleapis.com/v4/threatMatches:find?key="+key;

    public GoogleSafeBrowsing() {
        this.restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public boolean isSafe(String url){
        HttpEntity<String> request = new HttpEntity<String>(String.format(requestFormat,url), headers);
        String personResultAsJsonStr = restTemplate.postForObject(requestUrl, request, String.class);
        return personResultAsJsonStr.trim().equals("{}");
    }

}
