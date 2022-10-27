/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ServerThreadBus {
    //danh sách luồng
    private List<ServerThread> listServerThreads;
//hàm lấy ra danh sách luồng
    public List<ServerThread> getListServerThreads() {
        return listServerThreads;
    }

    public ServerThreadBus() {
        listServerThreads = new ArrayList<>();
    }
//hàm add luồng vào list
    public void add(ServerThread serverThread){
        listServerThreads.add(serverThread);
    }
    // các thao tác liên quan đến bus
    //duyệt từng luồng, lần lượt gửi thông điệp đến tất cả các luồng
    public void mutilCastSend(String message){ //like sockets.emit in socket.io
        for(ServerThread serverThread : Server.serverThreadBus.getListServerThreads()){
            try {
                serverThread.write(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    //tương tự
    public void boardCast(int id, String message){
        for(ServerThread serverThread : Server.serverThreadBus.getListServerThreads()){
            if (serverThread.getClientNumber() == id) {
                continue;
            } else {
                try {
                    serverThread.write(message);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    //lấy ra độ dài danh sách luồng
    public int getLength(){
        return listServerThreads.size();
    }
    //gửi thông điệp đến luồng có IDUser chỉ định
    public void sendMessageToUserID(int id, String message){
        for(ServerThread serverThread : Server.serverThreadBus.getListServerThreads()){
            if(serverThread.getUser().getID()==id){
                try {
                    serverThread.write(message);
                    break;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    //lấy ra luồng theo user ID
    public ServerThread getServerThreadByUserID(int ID){
        for(int i=0; i<Server.serverThreadBus.getLength(); i++){
            if(Server.serverThreadBus.getListServerThreads().get(i).getUser().getID()==ID){
                return Server.serverThreadBus.listServerThreads.get(i);
            }
        }
        return null;
    }
    //loại bỏ luồng
    public void remove(int id){
        for(int i=0; i<Server.serverThreadBus.getLength(); i++){
            if(Server.serverThreadBus.getListServerThreads().get(i).getClientNumber()==id){
                Server.serverThreadBus.listServerThreads.remove(i);
            }
        }
    }
}
