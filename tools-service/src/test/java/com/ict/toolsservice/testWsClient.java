package com.ict.toolsservice;


import com.ict.toolsmodel.IotEdgeMessage;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;

/**
 * @author liuwei
 * @Title: testWsClient
 * @ProjectName tools
 * @Description: TODO
 * @date 2018/7/23下午4:46
 */
public class testWsClient {

    public static void main(String[] args) {

        String url = "ws://localhost:6437/ws";  //Srinath
        String  protocols = "com.sap.dep.protocolplugin.http.inputandaction";

        String  token = "7AgypQyxu7spVCO13QhsGRFoQIIOjoXH";  //huawei-demo
        String  deviceId = "PCSimulator-WS-Client";
        String  deviceTag = "WSClient";
        String  sensorProfileName = "Huawei-demo2";
        String  sensorId = "Sensor1";
        String  sensorTag = "";
        double  readingValue = 9.77;

        IotEdgeMessage msg = new IotEdgeMessage(deviceId,deviceTag);
        msg.setReadings(sensorProfileName,sensorId,sensorTag,readingValue);

        SimpleWSClient wsClient = new SimpleWSClient(msg,url);

        wsClient.sendMessage(msg);



    }


}
