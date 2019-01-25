package base.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by ivalue on 2017/9/26.
 */
public class UDPReceive extends Thread {

    private DatagramSocket datagramSocket;

    public UDPReceive(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1000];
            //DatagramPacket的 实例化new参数(byte[],length)
            //DatagramPacket的 实例化new参数(byte[],length,address,port)
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(dp);
            String ip = dp.getAddress().getHostName();
            String data = new String(dp.getData(),0, dp.getLength());
            System.out.println(ip + ":" + data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}
