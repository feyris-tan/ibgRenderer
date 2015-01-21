package com.dyndns_server.yo3explorer.ibgRender;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by FT on 15.01.15.
 * Taken from XY by Z
 * Original Source:
 */
public class GraphData
{
    boolean error;
    Exception whatHappen;
    int ibgdVersion;
    Date date;
    int sample_rate;
    GraphDataDevice device;
    GraphDataMedia media;
    GraphDataData data;
    GraphDataVerify verify;
    boolean hrpc;
    ArrayList<GraphDataSample> samples;
    public GraphData(File f)
    {
        try {
            read(new BufferedReader(new InputStreamReader((new FileInputStream(f.getAbsolutePath())))));
        }
        catch(FileNotFoundException fnfe)
        {
            whatHappen = fnfe;
            error = true;
        }
    }
    public GraphData(byte[] data)
    {
        this(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data))));
    }
    public GraphData(Reader r)
    {
        this(new BufferedReader(r));
    }
    public GraphData(BufferedReader br)
    {
        read(br);
    }

    void read(BufferedReader br)
    {
        try {
            String magic = br.readLine();
            if(!magic.equals("IBGD"))
            {
                throw new InvalidMagicException();
            }
            String temp;
            String[] params;
            while (true) {
                temp = br.readLine();
                if (temp.equals("[START_CONFIGURATION]"))
                {
                    break;
                }
            }
            while(true)
            {
                temp = br.readLine();
                if (temp.isEmpty())
                {
                    continue;
                }
                if (temp.equals("[END_CONFIGURATION]"))
                {
                    break;
                }
                params = temp.split("=");
                if (params[0].equals("IBGD_VERSION"))
                {
                    ibgdVersion = Integer.parseInt(params[1]);
                }
                else if (params[0].equals("DATE"))
                {
                    DateFormat format = new SimpleDateFormat("dd.MM.yyyy kk:m:s", Locale.ENGLISH);
                    date = (format.parse(params[1]));
                }

                else if (params[0].equals("SAMPLE_RATE"))
                {
                    sample_rate = Integer.parseInt(params[1]);
                }
                else if (params[0].equals("DEVICE"))
                {
                }
                else if (params[0].equals("DEVICE_ADDRESS"))
                {
                    getDevice().setAddress(params[1]);
                }
                else if (params[0].equals("DEVICE_MAKEMODEL"))
                {
                    getDevice().setMakeModel(params[1]);
                }
                else if (params[0].equals("DEVICE_FIRMWAREVERSION"))
                {
                    getDevice().setFirmwareVersion(params[1]);
                }
                else if (params[0].equals("DEVICE_DRIVELETTER"))
                {
                    getDevice().setDriveLetter(params[1]);
                }
                else if (params[0].equals("DEVICE_BUSTYPE"))
                {
                    getDevice().setBusType(params[1]);
                }

                else if (params[0].equals("MEDIA_TYPE"))
                {
                    getMedia().setType(params[1]);
                }
                else if (params[0].equals("MEDIA_BOOKTYPE"))
                {
                    getMedia().setBookType(params[1]);
                }
                else if (params[0].equals("MEDIA_ID"))
                {
                    getMedia().setID(params[1]);
                }
                else if (params[0].equals("MEDIA_TRACKPATH"))
                {
                    getMedia().setTrackPath(params[1]);
                }
                else if (params[0].equals("MEDIA_SPEEDS"))
                {
                    if (!params[1].equals("N/A")) {
                        getMedia().setSpeeds(params[1]);
                    }
                }
                else if (params[0].equals("MEDIA_CAPACITY"))
                {
                    getMedia().setCapacity(Long.parseLong(params[1]));
                }
                else if (params[0].equals("MEDIA_LAYER_BREAK"))
                {
                    getMedia().setLayerBreak(Long.parseLong(params[1]));
                }
                else if (params[0].equals("DATA_IMAGEFILE"))
                {
                    getData().setImageFile(params[1]);
                }
                else if (params[0].equals("DATA_SECTORS"))
                {
                    getData().setSectors(Long.parseLong(params[1]));
                }
                else if (params[0].equals("DATA_TYPE"))
                {
                    getData().setType(params[1]);
                }
                else if (params[0].equals("DATA_VOLUMEIDENTIFIER"))
                {
                    getData().setVolumeIdentifier(params[1]);
                }

                else if (params[0].equals("VERIFY_SPEED_START"))
                {
                    getVerify().setSpeedStart(Double.parseDouble(params[1]));
                }
                else if (params[0].equals("VERIFY_SPEED_END"))
                {
                    getVerify().setSpeedEnd(Double.parseDouble(params[1]));
                }
                else if (params[0].equals("VERIFY_SPEED_AVERAGE"))
                {
                    getVerify().setSpeedAverage(Double.parseDouble(params[1]));
                }
                else if (params[0].equals("VERIFY_SPEED_MAX"))
                {
                    getVerify().setSpeedMax(Double.parseDouble(params[1]));
                }
                else if (params[0].equals("VERIFY_TIME_TAKEN"))
                {
                    getVerify().setTimeTaken(Long.parseLong(params[1]));
                }
                else
                {
                    throw new Exception("don't know what to do with line: " + temp);
                }
            }

            while(!temp.equals("[START_VERIFY_GRAPH_VALUES]"))
            {
                temp = br.readLine();
                if (temp.startsWith("HRPC"))
                {
                    hrpc = Boolean.parseBoolean(temp.split("=")[1]);
                }
            }
            while (true)
            {
                temp = br.readLine();
                if (temp.equals("[END_VERIFY_GRAPH_VALUES]"))
                {
                    break;
                }
                params = temp.split(",");
                GraphDataSample newSample = new GraphDataSample();
                newSample.setReadSpeed(Float.parseFloat(params[0]));
                newSample.setSectorNo(Long.parseLong(params[1]));
                newSample.setSampleDistance(Integer.parseInt(params[2]));
                newSample.setCpuLoad(Float.parseFloat(params[3]));
                if (samples == null)
                {
                    samples = new ArrayList<GraphDataSample>();
                }
                samples.add(newSample);
            }

            br.close();

        } catch (Exception e)
        {
            whatHappen = e;
            error = true;
        }

    }

    public boolean isOk()
    {
        return !error;
    }

    public GraphDataDevice getDevice()
    {
        if (device == null)
        {
            device = new GraphDataDevice();
        }
        return device;
    }

    public GraphDataMedia getMedia()
    {
        if (media == null)
        {
            media = new GraphDataMedia();
        }
        return media;
    }

    public GraphDataData getData()
    {
        if (data == null)
        {
            data = new GraphDataData();
        }
        return data;
    }

    public GraphDataVerify getVerify()
    {
        if (verify == null)
        {
            verify = new GraphDataVerify();
        }
        return verify;
    }

    public int getNumberOfSamples()
    {
        return samples.size();
    }

    public GraphDataSample getSample(int no)
    {
        return samples.get(no);
    }

    public int getYSize()
    {
        int result = 0;
        for(GraphDataSample sample: samples)
        {
            if (sample.getCpuLoad() > result)
            {
                result = (int)sample.getCpuLoad();
            }
            if (sample.getReadSpeed() > result)
            {
                result = (int)sample.getReadSpeed();
            }
            if (sample.getSampleDistance() > result)
            {
                result = sample.getSampleDistance();
            }
        }
        return result;
    }
}
