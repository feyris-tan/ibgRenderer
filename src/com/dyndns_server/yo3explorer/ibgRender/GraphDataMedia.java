package com.dyndns_server.yo3explorer.ibgRender;

/**
 * Created by FT on 15.01.15.
 * Taken from XY by Z
 * Original Source:
 */
public class GraphDataMedia
{
    GraphDataMedia()
    {

    }

    String Type;
    String BookType;
    String ID;
    String TrackPath;
    short[] Speeds;
    long Capacity;
    long LayerBreak;

    public String getType() {
        return Type;
    }

    void setType(String type) {
        Type = type;
    }

    public String getBookType() {
        return BookType;
    }

    void setBookType(String bookType) {
        BookType = bookType;
    }

    public String getID() {
        return ID;
    }

    void setID(String ID) {
        this.ID = ID;
    }

    public String getTrackPath() {
        return TrackPath;
    }

    void setTrackPath(String trackPath) {
        TrackPath = trackPath;
    }

    public short[] getSpeeds() {
        return Speeds;
    }

    void setSpeeds(String value)
    {
        value = value.replace("; ","");
        String[] params = value.split("x");
        Speeds = new short[params.length];
        for (int i = 0; i < params.length; i++)
        {
            Speeds[i] = Short.parseShort(params[i]);
        }
    }

    public long getCapacity() {
        return Capacity;
    }

    void setCapacity(long capacity) {
        Capacity = capacity;
    }

    public long getLayerBreak() {
        return LayerBreak;
    }

    void setLayerBreak(long layerBreak) {
        LayerBreak = layerBreak;
    }
}
