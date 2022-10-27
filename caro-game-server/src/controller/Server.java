/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Admin;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Admin
 */
//đây là core của server
public class Server {

    public static volatile ServerThreadBus serverThreadBus;
    public static Socket socketOfServer;
    public static int ID_room;
    public static volatile Admin admin;

    public static void main(String[] args) {
        //lắng nghe luồng 
        ServerSocket listener = null;
        //tạo bus 
        serverThreadBus = new ServerThreadBus();
        System.out.println("Server is waiting to accept user...");
        int clientNumber = 0;
        ID_room = 100;  
        
        try {
            //tạo server socket tại cổng 7777
            listener = new ServerSocket(7777);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        //cần nghiên cứu thêm về cái này
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, // corePoolSize
                100, // maximumPoolSize
                10, // thread timeout
                TimeUnit.SECONDS,
                //nghiên cứu thêm về ArrayBlockingQueue
                new ArrayBlockingQueue<>(8) // queueCapacity
        );
        //khởi tạo view Admin
        admin = new Admin();
        //chạy view Admin
        admin.run();
        try {
            //mỗi lần có một người đăng nhập, sẽ tạo ra một luồng mới và add vào bus
            while (true) {
                // Chấp nhận một yêu cầu kết nối từ phía Client.
                // Đồng thời nhận được một đối tượng Socket tại server.
                // lắng nghe  tín hiệu kết nối
                socketOfServer = listener.accept();
                //lấy địa chỉ IP và địa chi host, in ra console
                System.out.println(socketOfServer.getInetAddress().getHostAddress());
                //nạp thêm  luồng vào máy, sau đó tăng số client lên
                ServerThread serverThread = new ServerThread(socketOfServer, clientNumber++);
                //bus sẽ add thêm luồng nữa vào list
                serverThreadBus.add(serverThread);
                //in ra số luồng đang chạy
                System.out.println("Số thread đang chạy là: "+serverThreadBus.getLength());
                //pool sẽ chạy luồng này
                executor.execute(serverThread);  
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                listener.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
