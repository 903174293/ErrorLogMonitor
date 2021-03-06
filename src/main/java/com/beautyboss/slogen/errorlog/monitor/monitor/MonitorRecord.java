package com.beautyboss.slogen.errorlog.monitor.monitor;

import com.beautyboss.slogen.errorlog.monitor.utils.DateTimeUtils;
import com.beautyboss.slogen.errorlog.monitor.utils.MachineUtils;
import lombok.Data;

/**
 * Author : Slogen
 * Date   : 2020-02-05 13:40
 */
@Data
public class MonitorRecord {

    private String appName;

    private String ip;

    private String hostName;

    private String env;

    private String userLoggedMsg; // 格式化之后的消息

    private String stackMessage; // 异常堆栈消息

    private String message; //  格式化之前的消息

    private String time; // 日志产生的时间


    @Override
    public String toString() {
        return "appName:[" + appName + "]\n" +
                "env:[" +  env + "]\n" +
                "ip:[" + ip + "]\n"+
                "hostName:[" + hostName + "]\n" +
                "userLoggedMsg:[" + userLoggedMsg + "]\n" +
                "time:[" + time + "]\n" +
                "stackMessage:[\n" + stackMessage + "]";
    }


    public static MonitorRecord buildRecord(String stackTrackInfo,String userLoggedMessage,
                                            String appName,String env) {
        MonitorRecord record = new MonitorRecord();
        record.setAppName(appName);
        MachineUtils.Machine machine = MachineUtils.getMachineInfo();
        record.setIp(machine.ip);
        record.setHostName(machine.hostName);
        record.setUserLoggedMsg(userLoggedMessage);
        record.setStackMessage(stackTrackInfo);
        record.setEnv(env);
        record.setTime(DateTimeUtils.now());
        return record;
    }


}
