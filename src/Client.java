import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket server = new Socket("localhost", 8383)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            String fromServer;
            while((fromServer = in.readLine()) != null) {
                System.out.println(fromServer);
                Thread.sleep(Integer.MAX_VALUE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("err! msg:"+e.getMessage());
        }
    }
}
