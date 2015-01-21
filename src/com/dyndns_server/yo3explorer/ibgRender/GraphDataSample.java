package com.dyndns_server.yo3explorer.ibgRender;

/**
 * Created by schiemas on 16.01.2015.
 */
public class GraphDataSample
{
    GraphDataSample()
    {

    }

    float ReadSpeed;
    long SectorNo;
    int SampleDistance;
    float CpuLoad;

    public float getReadSpeed() {
        return ReadSpeed;
    }

    void setReadSpeed(float readSpeed) {
        ReadSpeed = readSpeed;
    }

    public long getSectorNo() {
        return SectorNo;
    }

    void setSectorNo(long sectorNo) {
        SectorNo = sectorNo;
    }

    public int getSampleDistance() {
        return SampleDistance;
    }

    void setSampleDistance(int sampleDistance) {
        SampleDistance = sampleDistance;
    }

    public float getCpuLoad() {
        return CpuLoad;
    }

    void setCpuLoad(float cpuLoad) {
        CpuLoad = cpuLoad;
    }
}
