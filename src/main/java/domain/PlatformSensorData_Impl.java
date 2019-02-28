package domain;

public class PlatformSensorData_Impl implements PlatformSensorData {
    private String _name; //Platform name
    private long _readSendTime; //Reading send time in seconds since Epoch
    private long _readReceiveTime; //Reading receive time in seconds since Epoch
    private int _numberOfSensors; //Number of sensors with the same reading
    private int _value; //Reading value

    public PlatformSensorData_Impl() {

    }

    public PlatformSensorData_Impl(String name, long readSendTime, long readReceiveTime, int numberOfSensors, int value) {
        this._name = name;
        this._readSendTime = readSendTime;
        this._readReceiveTime = readReceiveTime;
        this._numberOfSensors = numberOfSensors;
        this._value = value;
    }


    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public long getReadSendTime() {
        return _readSendTime;
    }

    public void setReadSendTime(long sendEpochTime) {
        _readSendTime = sendEpochTime;
    }

    public long getReadReceiveTime() {
        return _readReceiveTime;
    }

    public void setReadReceiveTime(long receiveEpochTime) {
        _readReceiveTime = receiveEpochTime;
    }

    public int getNumberOfSensors() {
        return _numberOfSensors;
    }

    public void setNumberOfSensors(int sensors) {
        _numberOfSensors = sensors;
    }

    public int getValue() {
        return _value;
    }

    public void setValue(int value) {
        _value = value;
    }

    @Override
    public long getFlightTime() {
        return getReadReceiveTime() - getReadSendTime();
    }
}
