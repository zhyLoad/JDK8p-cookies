

package com.test.enums;

/**
 * @Author: zhanghy
 * @Description:
 * @Date: Created in 8:46 2017/11/29.
 * @Modified by:
 */
public enum ConfigKey implements IDataBaseValue{

    //缁堢鍨嬪彿
    MODEL(0,"MODEL"),
    //璁惧搴忓垪鍙�
    DEVICE_SERIAL_NUMBER (1,"DEVICE_SERIAL_NUMBER "),
    //鐢ㄦ埛缂栫爜
    USER(2,"USER"),
    //瀹夊崜绯荤粺鐗堟湰
    ANDROID_VERSION(3,"ANDROID_VERSION"),
    //婧愰暅鍍忕増鏈�
    IMAGE_VERSION(4,"IMAGE_VERSION");


    private int dbNumber;
    private String name;

    private ConfigKey(int dbNumber, String name) {
        this.dbNumber = dbNumber;
        this.name = name;
    }

    public static ConfigKey valueofByName(String name) {
        ConfigKey[] values = ConfigKey.values();
        for (ConfigKey type : values) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

    public static ConfigKey valueofByDBNumber(int dbNumber) {
        ConfigKey[] values = ConfigKey.values();
        for (ConfigKey type : values) {
            if (type.dbNumber == dbNumber) {
                return type;
            }
        }
        return null;
    }


    @Override
    public int getDbNumber() {
        return this.dbNumber;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
