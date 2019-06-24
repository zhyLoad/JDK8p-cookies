package com.test.xml;



import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 *
 */
public class XmlUtils {

    /**
     * 灏嗗璞＄洿鎺ヨ浆鎹㈡垚String绫诲瀷鐨刋ML杈撳嚭
     * @param obj 鎸囧畾瀵硅薄
     * @return 杩斿洖XML
     */
    public static String convertObjectToXml(Object obj) {
        StringWriter sw = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    /**
     * 灏哠tring绫诲瀷鐨刋ml杞崲鎴愬璞�
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertXmlStrToT(Class<T> clazz, String xmlStr) {
        T xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = (T) unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 灏唂ile绫诲瀷鐨剎ml瑁呮崲鎴愬璞�
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertXmlFileToT(Class<T> clazz,String xmlPath) {
        T xmlObject = null;
        FileReader fr = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshal =  context.createUnmarshaller();
            fr = new FileReader(xmlPath);
            xmlObject = (T) unmarshal.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return xmlObject;
    }



    public static void main(String[] args){

        //test1: test object to xml string
        Employee employee = buildTestEmployee();
        String xmlStr = convertObjectToXml(employee);
        System.out.println("********** get xml info by object: ");
        System.out.print(xmlStr);
        System.out.println("********** get xml info end");

        //test2: test xml string to object
        Employee employee_0 = convertXmlStrToT(Employee.class,xmlStr);
        System.out.println("%%%%%%%%%%%% get object by xml string: ");
        System.out.println("object : "+employee_0.toString());
        System.out.println("%%%%%%%%%%%% get object by xml string end");

       //test3: test xml file to object
        Employee employee_1 = convertXmlFileToT(Employee.class, buildFilePath());
        System.out.println("########### get object by xml string: ");
        System.out.println("object : "+employee_1.toString());
        System.out.println("########### get object by xml string end");

    }


    private static Employee buildTestEmployee(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setCode("002");
        employee.setName("zhangzhang");
        employee.setSex(2);
        employee.setTelephone("15698499195");

        Dept dept = new Dept();
        dept.setId(UUID.randomUUID().toString());
        dept.setName("寮�鍙戦儴");
        employee.setDept(dept);

        List<Dept> list = new ArrayList<>();
        for(int i = 0;i < 5;i++) {
            Dept d = new Dept();
            d.setId(UUID.randomUUID().toString());
            d.setName("閮ㄩ棬0" + i);
            list.add(d);
        }
        employee.setDepts(list);
        return employee;
    }


    private static String buildFilePath(){
//        String rootPath  = XmlUtils.class.getClass().getResource("/").getPath();
//        String aPath = rootPath.substring(1,rootPath.indexOf("classes"));
//        String filePath = aPath+"resources/main/employee.xml";
    	File file = new File("D:\\temp\\employee.xml");
        return file.getAbsolutePath();
    }

}
