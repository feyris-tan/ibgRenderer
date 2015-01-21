package com.dyndns_server.yo3explorer.ibgRender;

/**
 * Created by schiemas on 15.01.2015.
 */
public class GraphDataVerify
{
    GraphDataVerify()
    {
    }

    double SpeedStart;
    double SpeedEnd;
    double SpeedAverage;
    double SpeedMax;
    long timeTaken;

    public double getSpeedStart() {
        return SpeedStart;
    }

    public double getSpeedEnd() {
        return SpeedEnd;
    }

    public double getSpeedAverage() {
        return SpeedAverage;
    }

    public double getSpeedMax() {
        return SpeedMax;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    void setSpeedStart(double speedStart) {
        SpeedStart = speedStart;
    }

    void setSpeedEnd(double speedEnd) {
        SpeedEnd = speedEnd;
    }

    void setSpeedAverage(double speedAverage) {
        SpeedAverage = speedAverage;
    }

    void setSpeedMax(double speedMax) {
        SpeedMax = speedMax;
    }

    void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }
}
