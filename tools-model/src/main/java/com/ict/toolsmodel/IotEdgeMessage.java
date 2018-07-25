package com.ict.toolsmodel;

import java.text.SimpleDateFormat;
import java.time.Instant;
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

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    //private String  token ;
    private String timestamp;
    private String  deviceId ;
    private String  deviceTag ;
    private List<SensorReadings> readings ;

    public IotEdgeMessage( String deviceId, String deviceTag) {

        this.timestamp = Instant.now().toString();
        this.deviceId = deviceId;
        this.deviceTag = deviceTag;
        this.readings = new ArrayList();
    }

    private class SensorReadings {
        private String  sensorProfileName ;  //TODO: CHANGE THIS!!
        private String  sensorId ;
        private String  sensorTag ;
        private double  readingValue ;

        public SensorReadings(String sensorProfileId, String sensorId, String sensorTag, double readingValue) {
            this.sensorProfileName = sensorProfileId;
            this.sensorId = sensorId;
            this.sensorTag = sensorTag;
            this.readingValue = readingValue;
        }

        public String getSensorProfileName() {
            return sensorProfileName;
        }

        public void setSensorProfileName(String sensorProfileName) {
            this.sensorProfileName = sensorProfileName;
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

    public void setReadings(String sensorProfileName,String sensorId,String sensorTag,double readingValue) {

        this.readings.add(new SensorReadings(sensorProfileName,sensorId,sensorTag,readingValue));

    }

}
