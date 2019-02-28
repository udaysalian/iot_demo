package domain;

public interface PlatformStatResult {
    String getName();

    void setName(String name);

    long getTotalGapTime();

    void setTotalGapTime(long totalGapTime);

    long getAvgFlightTime();

    void setAvgFlightTime(long avgFlightTime);

    int getMaxValue();

    void setMaxValue(int maxValue);

    long getMinGapTime();

    void setMinGapTime(long minGapTime);
}
