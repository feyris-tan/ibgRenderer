package com.dyndns_server.yo3explorer.ibgRender;

/**
 * Created by schiemas on 15.01.2015.
 */
public class GraphDataData
{
    GraphDataData()
    {

    }

    String ImageFile;
    long Sectors;
    GraphDataDataType Type;
    String VolumeIdentifier;

    public String getImageFile() {
        return ImageFile;
    }

    public long getSectors() {
        return Sectors;
    }

    public GraphDataDataType getType() {
        return Type;
    }

    public String getVolumeIdentifier() {
        return VolumeIdentifier;
    }

    void setImageFile(String imageFile) {
        ImageFile = imageFile;
    }

    void setSectors(long sectors) {
        Sectors = sectors;
    }

    void setType(String type) {
        Type = GraphDataDataType.parse(type);
    }

    void setVolumeIdentifier(String volumeIdentifier) {
        VolumeIdentifier = volumeIdentifier;
    }
}
