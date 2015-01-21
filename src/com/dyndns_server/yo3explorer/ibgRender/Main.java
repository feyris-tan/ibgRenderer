package com.dyndns_server.yo3explorer.ibgRender;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
	    if (args.length != 1)
        {
            System.out.println("usage: java -jar ibgRender.jar myfile.ibg");
            return;
        }
        String ibgFile = args[0];
        File theIbgFile = new File(ibgFile);
        File theIbgDirectory = theIbgFile.getParentFile();
        GraphData ibgd = new GraphData(theIbgFile);
        IbgImage image = new IbgImage(ibgd);
        ImageIO.write(image,"png",new File("saved.png"));
    }
}
