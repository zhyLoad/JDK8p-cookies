package com.test.parse;



//import android.content.res.AXMLResource;
//import android.content.res.AXmlResourceParser;
//import android.util.TypedValue;
//
//import org.xmlpull.v1.XmlPullParser;
//import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import android.content.res.AXMLResource;

/**
 * Created by dell on 2017/7/25.
 * 瑙ｆ瀽璇诲彇APK鍖呬腑鐨勪俊鎭伐鍏风被
 */
public class ParseApkInfoUtils {

    private static final float RADIX_MULTS[] = { 0.00390625F, 3.051758E-005F, 1.192093E-007F, 4.656613E-010F };
    private static final String DIMENSION_UNITS[] = { "px", "dip", "sp", "pt", "in", "mm", "", "" };
    private static final String FRACTION_UNITS[] = { "%", "%p", "", "", "", "", "", "" };
    private static final String ANDROID_MANIFEST_FILE = "androidmanifest.xml";
    private static final String ANDROID_MANIFEST_KEYWORDS = "manifest";
    public static final String APK_INFO_PACKAGE_NAME = "package";
    public static final String APK_INFO_VERSION_NAME = "versionName";
    public static final String APK_INFO_VERSION_CODE = "versionCode";


    /**
     * 鏍规嵁浼犲叆鐨凙PK鏂囦欢瀵硅薄锛岃В鏋怉PK淇℃伅锛岃繑鍥炲寘鍚嶃�佺増鏈悕銆佺増鏈彿
     * @param apkFile
     * @return
     */
    public static void checkAppInfo(File apkFile) throws Exception {
//        ApkInfo apkInfo = new ApkInfo();
          ZipFile zipFile = null;
          ZipEntry zipEntry = null;
//         if(apkFile!=null){
//             apkInfo.setSize(apkFile.length());
//         }
        try {
            //鑾峰彇ZipFile瀹炰緥
            zipFile = new ZipFile(apkFile);
            Enumeration<?> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                //杩唬鍑篫ipEntry
                zipEntry = (ZipEntry) enumeration.nextElement();
                if (!zipEntry.isDirectory()) {
                    //鎵惧埌AndroidManifest.xml鏂囦欢
                    if (ANDROID_MANIFEST_FILE.equals(zipEntry.getName().toLowerCase())) {
                        //瑙ｆ瀽XML涓殑鑺傜偣鍊�
//                        AXmlResourceParser parser = new AXmlResourceParser();
//                        parser.open(zipFile.getInputStream(zipEntry));
                        AXMLResource axmlResource = new AXMLResource();
                        axmlResource.read(zipFile.getInputStream(zipEntry));
                        axmlResource.print();
//                        while (true) {
//                            int type = parser.next();
//                            if (type == XmlPullParser.END_DOCUMENT) {
//                                break;
//                            }
//                            String name = parser.getName();
//                            if(null != name && name.toLowerCase().equals(ANDROID_MANIFEST_KEYWORDS)){
//                                for (int i = 0; i < parser.getAttributeCount(); i++) {
//                                       //鐗堟湰鍚嶇О
//                                    if (APK_INFO_VERSION_NAME.equals(parser.getAttributeName(i))) {
//                                        apkInfo.setVersionName(getAttributeValue(parser, i));
//                                        //鍖呭悕
//                                    } else if (APK_INFO_PACKAGE_NAME.equals(parser.getAttributeName(i))) {
//                                        apkInfo.setPackageName(getAttributeValue(parser, i));
//                                        //鐗堟湰鍙�
//                                    } else if(APK_INFO_VERSION_CODE.equals(parser.getAttributeName(i))){
//                                        apkInfo.setVersionCode(Integer.parseInt(getAttributeValue(parser, i)));
//                                    }
//                                }
//                                break;
//                            }
//                        }
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(zipFile!=null){
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//    return apkInfo;
}

//    /**
//     * 宸ュ叿鏂规硶锛氳皟鐢ㄧ涓夋柟渚濊禆鏂规硶鑾峰彇灞炴�х殑鍊�
//     * @param parser
//     * @param index
//     * @return
//     */
//    private static String getAttributeValue(AXmlResourceParser parser, int index) {
//        int type = parser.getAttributeValueType(index);
//        int data = parser.getAttributeValueData(index);
//        if (type == TypedValue.TYPE_STRING) {
//            return parser.getAttributeValue(index);
//        }
//        if (type == TypedValue.TYPE_ATTRIBUTE) {
//            return String.format("?%s%08X", getPackage(data), data);
//        }
//        if (type == TypedValue.TYPE_REFERENCE) {
//            return String.format("@%s%08X", getPackage(data), data);
//        }
//        if (type == TypedValue.TYPE_FLOAT) {
//            return String.valueOf(Float.intBitsToFloat(data));
//        }
//        if (type == TypedValue.TYPE_INT_HEX) {
//            return String.format("0x%08X", data);
//        }
//        if (type == TypedValue.TYPE_INT_BOOLEAN) {
//            return data != 0 ? "true" : "false";
//        }
//        if (type == TypedValue.TYPE_DIMENSION) {
//            return Float.toString(complexToFloat(data)) + DIMENSION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
//        }
//        if (type == TypedValue.TYPE_FRACTION) {
//            return Float.toString(complexToFloat(data)) + FRACTION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
//        }
//        if (type >= TypedValue.TYPE_FIRST_COLOR_INT && type <= TypedValue.TYPE_LAST_COLOR_INT) {
//            return String.format("#%08X", data);
//        }
//        if (type >= TypedValue.TYPE_FIRST_INT && type <= TypedValue.TYPE_LAST_INT) {
//            return String.valueOf(data);
//        }
//        return String.format("<0x%X, type 0x%02X>", data, type);
//    }

    private static String getPackage(int id) {
        if (id >>> 24 == 1) {
            return "android:";
        }
        return "";
    }


    public static float complexToFloat(int complex) {
        return (float) (complex & 0xFFFFFF00) * RADIX_MULTS[(complex >> 4) & 3];
    }
    
    
    
    public static void main(String[] args){
    	File apk = new File("D:\\ParseAPK\\pro999.apk");
    	try {
			checkAppInfo(apk);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
