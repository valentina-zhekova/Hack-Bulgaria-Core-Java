import java.io.*;
import java.net.*;

public class DownloadFile {

    public static void main(String[] args) throws Exception {
        URL fileToDownload = new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
        String fileName = "/home/neila/downloadedFile.txt"; 

        // Code to download
        InputStream in = new BufferedInputStream(fileToDownload.openStream());
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //byte[] buf = new byte[1024];
        //int n = 0;
        //while (-1 != (n = in.read(buf))) {
        //    out.write(buf, 0, n);
        //}
        //out.close();
        //in.close();
        //byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(fileName);
        int n;
        while ((n = in.read()) != -1) {
            fos.write(n);
        }

        fos.close();
        // End download code

        System.out.println("Finished");

    }
}
