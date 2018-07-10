import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //try-with-resource 덕분에 try문을 벗어나면서 반드시 close된다.
        try(Socket socket = new ServerSocket(8383).accept()){
            BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write("hello client?\n");
            out.flush();
            Thread.sleep(10);
            System.out.println("closing server..");
            //서버도 active close가 가능하다. active open은 클라이언트만 가능하지만..
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("err! msg:"+e.getMessage());
        }
    }
}
