import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class DownloadAFile {
    // fix catching the exception
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
        BufferedInputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();

        byte[] content = out.toByteArray();
        FileOutputStream file = new FileOutputStream("photo.jpg");
        file.write(content);
        file.close();
    }
}
