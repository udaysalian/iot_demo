package domain;

public interface PlatformSensorData {
    public String getName();
    public void setName(String name);
    public long getReadSendTime(); // epock value
    public void setReadSendTime(long epochTime);
    public long getReadReceiveTime(); // epock value
    public void setReadReceiveTime(long epochTime);
    public int getNumberOfSensors(); // number of sensors with same read value
    public void setNumberOfSensors(int sensors);
    public int getValue();
    public void setValue(int value);
    public long getFlightTime(); // get the difference of received time and send time
}
