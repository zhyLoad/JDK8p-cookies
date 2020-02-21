package com.test.http;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class HttpRequestUtils {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String result = get("http://192.168.44.130/gateway/vgoverment/gds/programlist");

        System.out.println("result is : "+result+"******");
    }

    public static String get(String url){
        String result = "";
        HttpGet get = new HttpGet(url);
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpResponse response = httpClient.execute(get);
            result = getHttpEntityContent(response);

            if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
                result = "";
            }
        } catch (Exception e){
            e.printStackTrace();
            result = "";
         } finally{
            get.abort();
        }
        return result;
    }

    private static String getHttpEntityContent(HttpResponse response) throws UnsupportedOperationException, IOException{
        String result = "";
        HttpEntity entity = response.getEntity();
        if(entity != null){
            InputStream in = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder strber= new StringBuilder();
            String line = null;
            while((line = br.readLine())!=null){
                strber.append(line+'\n');
            }
            br.close();
            in.close();
            result = strber.toString();
        }
        return result;

    }
}
