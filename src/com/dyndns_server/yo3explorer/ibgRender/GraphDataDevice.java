package com.dyndns_server.yo3explorer.ibgRender;

/**
 * Created by FT on 15.01.15.
 * Taken from XY by Z
 * Original Source:
 */
public class GraphDataDevice
{
    GraphDataDevice()
    {

    }

    String address;
    String makeModel;
    String firmwareVersion;
    String driveLetter;
    String busType;

    public String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    public String getMakeModel() {
        return makeModel;
    }

    void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getDriveLetter() {
        return driveLetter;
    }

    void setDriveLetter(String driveLetter) {
        this.driveLetter = driveLetter;
    }

    public String getBusType() {
        return busType;
    }

    void setBusType(String busType) {
        this.busType = busType;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %s (%s:) (%s)",address,makeModel,firmwareVersion,driveLetter,busType);
    }
}
