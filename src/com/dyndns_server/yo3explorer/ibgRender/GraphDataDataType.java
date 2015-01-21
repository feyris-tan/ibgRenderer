package com.dyndns_server.yo3explorer.ibgRender;

/**
 * Created by schiemas on 15.01.2015.
 */
public class GraphDataDataType
{
    byte Mode;
    byte Form;
    int SectorLength;
    boolean error;
    boolean isCd;

    GraphDataDataType() {

    }

    static GraphDataDataType parse(String s) {
        GraphDataDataType result = new GraphDataDataType();
        s = s.replace("MODE", "");
        s = s.replace("FORM", "");
        String[] params = s.split("/");
        if (params.length == 2) {
            //for DVD & BD
            result.Mode = Byte.parseByte(params[0]);
            result.SectorLength = Integer.parseInt(params[1]);
        } else {
            //for CD
            result.Mode = Byte.parseByte(params[0]);
            result.Form = Byte.parseByte(params[1]);
            result.SectorLength = Integer.parseInt(params[2]);
            result.isCd = true;
        }
        return result;
    }

    public byte getMode() {
        return Mode;
    }

    public byte getForm() {
        return Form;
    }

    public int getSectorLength() {
        return SectorLength;
    }

    public boolean isValid() {
        return !error;
    }

    @Override
    public String toString()
    {
        if (isCd) {
            return String.format("MODE%d/FORM%d/%d", Mode, Form, SectorLength);
        } else {
            return String.format("MODE%d/%d", Mode, SectorLength);
        }
    }
}
