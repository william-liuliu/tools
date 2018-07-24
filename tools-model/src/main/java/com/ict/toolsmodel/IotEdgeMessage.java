package com.ict.toolsmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwei
 * @Title: IotEdgeMessage
 * @ProjectName tools
 * @Description: IoT Edge message content
 * @date 2018/7/22下午5:15
 */
public class IotEdgeMessage extends AbstractMessage {

    private String  token ;
    private String  deviceId ;
    private String  deviceTag ;
    private List<SensorReadings> readings ;

    public IotEdgeMessage(String token, String deviceId, String deviceTag) {
        this.token = token;
        this.deviceId = deviceId;
        this.deviceTag = deviceTag;
        this.readings = new ArrayList();
    }

    private class SensorReadings {
        private String  sensorProfileId ;  //TODO: CHANGE THIS!!
        private String  sensorId ;
        private String  sensorTag ;
        private double  readingValue ;

        public SensorReadings(String sensorProfileId, String sensorId, String sensorTag, double readingValue) {
            this.sensorProfileId = sensorProfileId;
            this.sensorId = sensorId;
            this.sensorTag = sensorTag;
            this.readingValue = readingValue;
        }

        public String getSensorProfileId() {
            return sensorProfileId;
        }

        public void setSensorProfileId(String sensorProfileId) {
            this.sensorProfileId = sensorProfileId;
        }

        public String getSensorId() {
            return sensorId;
        }

        public void setSensorId(String sensorId) {
            this.sensorId = sensorId;
        }

        public String getSensorTag() {
            return sensorTag;
        }

        public void setSensorTag(String sensorTag) {
            this.sensorTag = sensorTag;
        }

        public double getReadingValue() {
            return readingValue;
        }

        public void setReadingValue(double readingValue) {
            this.readingValue = readingValue;
        }
    }

    public void setReadings(String sensorProfileId,String sensorId,String sensorTag,double readingValue) {

        this.readings.add(new SensorReadings(sensorProfileId,sensorId,sensorTag,readingValue));

    }
}
