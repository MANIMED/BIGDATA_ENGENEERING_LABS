package edu.supmti.hadoop;

import java.io.IOException;
 import org.apache.hadoop.conf.*;
 import org.apache.hadoop.fs.*;

public class HadoopFileWrite {
    public static void write(String filename, String chaine) throws IOException
    {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            Path nomcomplet = new Path(filename);
            if (! fs.exists(nomcomplet)) {
            FSDataOutputStream outStream = fs.create(nomcomplet);
            outStream.writeUTF("Bonjour tout le monde !");
            outStream.writeUTF(chaine);
            outStream.close();
            }
            fs.close();
    }
}
