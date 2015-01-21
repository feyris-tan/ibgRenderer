package com.dyndns_server.yo3explorer.ibgRender;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by FT on 15.01.15.
 * Taken from XY by Z
 * Original Source:
 */
public class IbgImage extends BufferedImage
{
    final int fontSize = 20;
    static final int scaleFactor = 10;

    public IbgImage(GraphData ibg)
    {
        super((ibg.getNumberOfSamples() * scaleFactor) + 100,(ibg.getYSize() * scaleFactor) + 100,BufferedImage.TYPE_INT_RGB);

        int tableWidth = ibg.getNumberOfSamples();
        int tableHeight = ibg.getYSize();
        Graphics g = this.getGraphics();
        g.setFont(new Font(Font.MONOSPACED,0,fontSize));
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        //Diagramm-Rand
        g.setColor(Color.black);
        g.drawLine(100,0,100,tableHeight * scaleFactor);
        g.drawLine(100,tableHeight * scaleFactor,(tableWidth * scaleFactor) + 100,tableHeight * scaleFactor);

        //Diagramm für ReadSpeed
        g.setColor(Color.red);
        for (int i = 0; i < ibg.getNumberOfSamples()-1; i++)
        {
            GraphDataSample p1 = ibg.getSample(i);
            GraphDataSample p2 = ibg.getSample(i + 1);
            int x1 = 100 + (i * scaleFactor);
            int x2 = 100 + ((i+1) * scaleFactor);
            int y1 = (tableHeight * scaleFactor) - (int)(p1.getReadSpeed() * scaleFactor);
            int y2 = (tableHeight * scaleFactor) - (int)(p2.getReadSpeed() * scaleFactor);
            g.drawLine(x1,y1,x2,y2);
        }

        //Diagramm für CPU Usage
        g.setColor(Color.blue);
        for (int i = 0; i < ibg.getNumberOfSamples()-1; i++)
        {
            GraphDataSample p1 = ibg.getSample(i);
            GraphDataSample p2 = ibg.getSample(i + 1);
            int x1 = 100 + (i * scaleFactor);
            int x2 = 100 + ((i+1) * scaleFactor);
            int y1 = (tableHeight * scaleFactor) - (int)(p1.getCpuLoad() * scaleFactor);
            int y2 = (tableHeight * scaleFactor) - (int)(p2.getCpuLoad() * scaleFactor);
            g.drawLine(x1,y1,x2,y2);
        }

        //Diagramm für Sampling Distance
        g.setColor(Color.green);
        for (int i = 0; i < ibg.getNumberOfSamples()-1; i++)
        {
            GraphDataSample p1 = ibg.getSample(i);
            GraphDataSample p2 = ibg.getSample(i + 1);
            int x1 = 100 + (i * scaleFactor);
            int x2 = 100 + ((i+1) * scaleFactor);
            int y1 = (tableHeight * scaleFactor) - (int)(p1.getSampleDistance() * scaleFactor);
            int y2 = (tableHeight * scaleFactor) - (int)(p2.getSampleDistance() * scaleFactor);
            g.drawLine(x1,y1,x2,y2);
        }


        g.setColor(Color.black);

        for (int i = 0; i < ibg.getNumberOfSamples(); i += (fontSize))
        {
            GraphDataSample sample = ibg.getSample(i);
            int x1 = 100 + (i * scaleFactor);
            int x2 = 100 + (i * scaleFactor);
            int y1 = (tableHeight * scaleFactor);
            int y2 = (tableHeight * scaleFactor) + fontSize;
            g.drawLine(x1,y1,x2,y2);
            g.drawString(String.valueOf(sample.getSectorNo()),x2,y2);
        }

    }
}
