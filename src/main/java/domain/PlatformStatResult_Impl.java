package domain;

public class PlatformStatResult_Impl implements PlatformStatResult {
    private  String name;
    private  long    totalGapTime;
    private  long avgFlightTime;
    private  int  maxValue;
    private  long minGapTime;

    public PlatformStatResult_Impl() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTotalGapTime() {
        return totalGapTime;
    }

    public void setTotalGapTime(long totalGapTime) {
        this.totalGapTime = totalGapTime;
    }

    public long getAvgFlightTime() {
        return avgFlightTime;
    }

    public void setAvgFlightTime(long avgFlightTime) {
        this.avgFlightTime = avgFlightTime;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public long getMinGapTime() {
        return minGapTime;
    }

    public void setMinGapTime(long minGapTime) {
        this.minGapTime = minGapTime;
    }




}
