package com.jon.etcheck;

import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LessonCheck {

    public String getHtmlResponse(){
        String url = "http://m.jd100.com/authFreeLesson/index/?lession=all";
        GetMethod method = new GetMethod(url);
        org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
        try {
            httpClient.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String response = method.getResponseBodyAsString();
            System.out.println(response);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取所有免费课列表
     * @return
     */
    public List getLessonList(){
        String response = getHtmlResponse();
        response = response.replace("\n"," ");
        int start = response.indexOf("<ul class=\"table-view\" id=\"table-view\">");
        response = response.substring(start,response.indexOf("</ul>",start));
        String pattern = "<\\s*a\\s.*?href\\s*=\"http://m.jd100.com/auth\\s*[^>]*\\s*>\\s*(.*?)\\s*<\\s*/\\s*a\\s*>";
        List<String> list = new ArrayList<String>();
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(response);
        List<Map<String,String>> matchRegexList = new ArrayList<Map<String,String>>();

        while(m.find()){
            Map<String,String> map = new HashMap<String, String>();
            String url = m.group().substring("<a href=\"".length(),m.group().indexOf("\">"));
            //System.out.println(m.group()+","+m.group().indexOf("\">")+">>>"+url);

            String name = m.group().substring(m.group().indexOf("<h4>")+4,m.group().indexOf("</h4>"));
            map.put("LessonURL",url);
            map.put("LessonName",name);
            matchRegexList.add(map);
            System.out.println(name+url);
        }
        return matchRegexList;
    }

    /**
     * 检查免费课列表返还值
     */
    public void checkLesson(){
        List<Map<String,String>> lessonList = getLessonList();
        List<Map> resultLesson = new ArrayList<Map>();
        GetMethod method;
        for (int i = 0;i<lessonList.size();i++) {
            Map<String,String> map = new HashMap<String, String>();
            map = lessonList.get(i);
            method = new GetMethod((String) map.get("LessonURL"));
            //method = new GetMethod("http://m.jd100.com/authFreeLesson/getauthfreelessoninfo?lessonid=1167&teacher_id=b0a2c045e0c647d7afd0c57c0a216e86&course_guid=d9999");
            //method = new GetMethod("http://m.jd100.com/authFreeLesson/getauthfreelessoninfo?lessonid=854&teacher_id=ad7e8b93461943c8a51433f3979ef4d3&course_guid=d11796");
            org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
            try {
                httpClient.executeMethod(method);
                //System.out.println((String) map.get("LessonURL")+","+method.getStatusCode());

                //"Whoops, looks like something went wrong."
                if (method.getStatusCode() != 200){
                    resultLesson.add(map);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("异常数据："+resultLesson.size());
        for(Map map:resultLesson){
            System.out.println(map.get("LessonName")+","+map.get("LessonURL"));
        }
    }
}
