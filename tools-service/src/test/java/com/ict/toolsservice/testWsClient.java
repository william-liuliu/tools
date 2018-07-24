package com.ict.toolsservice;


import com.ict.toolsmodel.IotEdgeMessage;

/**
 * @author liuwei
 * @Title: testWsClient
 * @ProjectName tools
 * @Description: TODO
 * @date 2018/7/23下午4:46
 */
public class testWsClient {

    public static void main(String[] args) {

        String url = "wss://wdflbmd15873.wdf.sap.corp:6443/ws";  //Srinath
        String  protocols = "com.sap.dep.protocolplugin.http.inputandaction";

        String  token = "71AA540962F382D7E5EFD6DA84142F2D";  //Srinath
        String  deviceId = "Device1";
        String  deviceTag = "";
        String  sensorProfileId = "6e9b053d-05df-4486-b342-12b9fd39ab64";
        String  sensorId = "Sensor1";
        String  sensorTag = "";
        double  readingValue = 70.14;


        IotEdgeMessage msg = new IotEdgeMessage(token,deviceId,deviceTag);
        msg.setReadings(sensorProfileId,sensorId,sensorTag,readingValue);

        SimpleWSClient wsClient = new SimpleWSClient(msg,url);

        wsClient.sendMessage(msg);



    }


}
