/**
 * 
 */
package com.test.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @author dell
 *
 */
public class GsonTest {

	public static class JSONHelper {
	    private Gson gson = new Gson();
	                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	    /**
	      * ��json����ת��Ϊmap���ϣ�ͨ���˷�����ȡ���map���ϼ���list����
	      * @param obj
	      * @return
	      */
	    public static List<Object> mapKeys(Map<?,?> map){
	         List<Object> keysList = new ArrayList<Object>();
	         String columnStr="column";
	         for(int i=0;i<map.keySet().size();i++){
	             keysList.add(columnStr+(i+1));
	         }
	         System.out.println(keysList.size());
	         return keysList;
	    }
	                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	    /**
	     * �������json�ַ���ת��ΪԪ��Ϊmap���ϵ�List����
	     * @param jsonArrStr
	     * @return
	     */
	    public static List<Map<String, Object>> jsonObjList(String jsonArrStr) {
	        List<Map<String, Object>> jsonObjList = new ArrayList<Map<String, Object>>();
	        List<?> jsonList = jsonToList(jsonArrStr);
	        Gson gson = new Gson();
	        for (Object object : jsonList) {
	            String jsonStr = gson.toJson(object);
	            Map<?, ?> json = jsonToMap(jsonStr);
	            jsonObjList.add((Map<String, Object>) json);
	        }
	        return jsonObjList;
	    }
	                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	    /**
	     * �������json�ַ�������ΪList����
	     * @param jsonStr
	     * @return
	     */
	    public static List<?> jsonToList(String jsonStr) {
	        List<?> ObjectList = null;
	        Gson gson = new Gson();
	        java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<?>>() {}.getType();
	        ObjectList = gson.fromJson(jsonStr, type);
	        return ObjectList;
	    }
	                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	    /**
	     * �������json�ַ�������ΪMap����
	     * @param jsonStr
	     * @return
	     */
	    public static Map<?, ?> jsonToMap(String jsonStr) {
	        Map<?, ?> ObjectMap = null;
	        Gson gson = new Gson();
	        java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<Map<?,?>>() {}.getType();
	        ObjectMap = gson.fromJson(jsonStr, type);
	        return ObjectMap;
	    }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
