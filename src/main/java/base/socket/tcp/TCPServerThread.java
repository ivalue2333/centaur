package base.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ivalue on 2017/9/25.
 */
public class TCPServerThread extends Thread{

    //服务器线程处理
//和本线程相关的socket
    Socket socket =null;
    //
    public TCPServerThread(Socket socket) throws IOException {
        this.socket = socket;
    }
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr =new InputStreamReader(is);
            BufferedReader br =new BufferedReader(isr);
            String info =null;
            while((info=br.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);
            }
            socket.shutdownInput();//关闭输入流
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =new ServerSocket(10086);
        Socket socket =null;
        int count =0;//记录客户端的数量
        while(true){
            socket = serverSocket.accept();
            TCPServerThread serverThread = new TCPServerThread(socket);
            serverThread.start();
            count++;
            System.out.println("客户端连接的数量："+count);
        }
    }
}






