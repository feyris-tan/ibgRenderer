package com.dyndns_server.yo3explorer.ibgRenderer;

import java.io.*;

/**
 * Created by FT on 21.01.15.
 * Taken from XY by Z
 * Original Source:
 */
public class IbgFile
{
    public IbgFile(String s)
    {
        if(s.startsWith("IBGD"))
        {
            StringReader sr = new StringReader(s);
            br = new BufferedReader(sr);
        }
        else
        {
            File sFile = new File(s);
            try {
                FileInputStream fis = new FileInputStream(sFile.getPath());
                br = new BufferedReader(new InputStreamReader(fis));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public IbgFile(File f)
    {
    }

    public IbgFile(InputStream is)
    {
    }

    public IbgFile(Reader reader)
    {
    }

    public IbgFile(BufferedReader br)
    {
    }

    BufferedReader br;

    private void parseIbg()
    {

    }
}
