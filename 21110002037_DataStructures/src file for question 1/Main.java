import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM");
        StringBuffer[] Buffer1 = new StringBuffer[12];
        for (int i = 0; i < Buffer1.length; i++) {
            Buffer1[i] = new StringBuffer();
        }
        StringBuffer[] Buffer2 = new StringBuffer[2];
        StringBuffer sb = new StringBuffer();
        sb.append("MIS 2202");
        String course = sb.toString();
        System.out.println(course);
        for (int i = 0; i < Buffer1.length; i++) {
            Date date = new Date(0, i, 1);
            Buffer1[i].append("Index " + i + ": " + formatter.format(date));
            System.out.println(Buffer1[i]);
        }
        System.out.println();
        Buffer2[0] = new StringBuffer();
        Buffer2[0].append("Ali Burak");
        Buffer2[1] = new StringBuffer();
        Buffer2[1].append("Cansu Deniz");
        for (int i = 0; i < Buffer2.length; i++) {
            System.out.println(Buffer2[i]);
        }
    }
}