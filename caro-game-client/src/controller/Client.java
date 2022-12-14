/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javax.swing.JFrame;
import model.User;
import view.CompetitorInfoFrm;
import view.giulai.CreateRoomPasswordFrm;
import view.giulai.FindRoomFrm;
import view.FriendListFrm;
import view.FriendRequestFrm;
import view.giulai.GameClientFrm;
import view.giulai.GameNoticeFrm;
import view.giulai.GameAIFrm;
import view.giulai.HomePageFrm;
import view.giulai.JoinRoomPasswordFrm;
import view.giulai.LoginFrm;
import view.RankFrm;
import view.giulai.RegisterFrm;
import view.giulai.RoomListFrm;
import view.giulai.RoomNameFrm;
import view.giulai.WaitingRoomFrm;

/**
 *
 * @author Admin
 */
public class Client {
    //liệt kê các view
    //có một danh sách các view
    public enum View{
        LOGIN,
        REGISTER,
        HOMEPAGE,
        ROOMLIST,
        FRIENDLIST,
        FINDROOM,
        WAITINGROOM,
        GAMECLIENT,
        CREATEROOMPASSWORD,
        JOINROOMPASSWORD,
        COMPETITORINFO,
        RANK,
        GAMENOTICE,
        FRIENDREQUEST,
        GAMEAI,
        ROOMNAMEFRM
    }
    //có một ông user
    public static User user;

    public static LoginFrm loginFrm;
    public static RegisterFrm registerFrm;
    public static HomePageFrm homePageFrm;
    public static RoomListFrm roomListFrm;
//    public static FriendListFrm friendListFrm;
    public static FindRoomFrm findRoomFrm;
    public static WaitingRoomFrm waitingRoomFrm;
    public static GameClientFrm gameClientFrm;
    public static CreateRoomPasswordFrm createRoomPasswordFrm;
    public static JoinRoomPasswordFrm joinRoomPasswordFrm;
//    public static CompetitorInfoFrm competitorInfoFrm;
//    public static RankFrm rankFrm;
    public static GameNoticeFrm gameNoticeFrm;
//    public static FriendRequestFrm friendRequestFrm;
    public static GameAIFrm gameAIFrm;
    public static RoomNameFrm roomNameFrm;
    //Thiết lập socket để gửi dữ liệu qua cho server
    public static SocketHandle socketHandle;
    //constructor
    public Client() {
    }

    public static JFrame getVisibleJFrame(){
        //isVisible: hiển thị view đến người dùng
        if(roomListFrm!=null&&roomListFrm.isVisible())
            return roomListFrm;
//        if(friendListFrm!=null&&friendListFrm.isVisible()){
//            return friendListFrm;
//        }
        if(createRoomPasswordFrm!=null&&createRoomPasswordFrm.isVisible()){
            return createRoomPasswordFrm;
        }
        if(joinRoomPasswordFrm!=null&&joinRoomPasswordFrm.isVisible()){
            return joinRoomPasswordFrm;
        }
//        if(rankFrm!=null&&rankFrm.isVisible()){
//            return rankFrm;
//        }
        return homePageFrm;
    }
    //khởi tạo view login, mở socket xử lí, chạy socket
    public void initView(){
        
        loginFrm = new LoginFrm();
        loginFrm.setVisible(true);
        socketHandle = new SocketHandle();
        socketHandle.run();
    }
    //mở view
    public static void openView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm = new LoginFrm();
                    loginFrm.setVisible(true);
                    break;
                case REGISTER:
                    registerFrm = new RegisterFrm();
                    registerFrm.setVisible(true);
                    break;
                case HOMEPAGE:
                    //tạo mới một view HomePage
                    //bật nó lên
                    homePageFrm = new HomePageFrm();
                    homePageFrm.setVisible(true);
                    break;
                case ROOMLIST:
                    roomListFrm = new RoomListFrm();
                    roomListFrm.setVisible(true);
                    break;
//                case FRIENDLIST:
//                    friendListFrm = new FriendListFrm();
//                    friendListFrm.setVisible(true);
//                    break;
                case FINDROOM:
                    findRoomFrm = new FindRoomFrm();
                    findRoomFrm.setVisible(true);
                    break;
                case WAITINGROOM:
                    waitingRoomFrm = new WaitingRoomFrm();
                    waitingRoomFrm.setVisible(true);
                    break;
                
                case CREATEROOMPASSWORD:
                    createRoomPasswordFrm = new CreateRoomPasswordFrm();
                    createRoomPasswordFrm.setVisible(true);
                    break;
//                case RANK:
//                    rankFrm = new RankFrm();
//                    rankFrm.setVisible(true);
//                    break;
                case GAMEAI:
                    gameAIFrm = new GameAIFrm();
                    gameAIFrm.setVisible(true);
                    break;
                case ROOMNAMEFRM:
                    roomNameFrm = new RoomNameFrm();
                    roomNameFrm.setVisible(true);
            }
        }
    }
    public static void openView(View viewName, int arg1, String arg2){
        if(viewName != null){
            switch(viewName){
                case JOINROOMPASSWORD:
                    joinRoomPasswordFrm = new JoinRoomPasswordFrm(arg1, arg2);
                    joinRoomPasswordFrm.setVisible(true);
                    break;
//                case FRIENDREQUEST:
//                    friendRequestFrm = new FriendRequestFrm(arg1, arg2);
//                    friendRequestFrm.setVisible(true);
            }
        }
    }
    public static void openView(View viewName, User competitor, int room_ID, int isStart, String competitorIP){
        if(viewName != null){
            switch(viewName){
                case GAMECLIENT:
                    gameClientFrm = new GameClientFrm(competitor, room_ID, isStart, competitorIP);
                    gameClientFrm.setVisible(true);
                    break;
            }
        }
    }
    public static void openView(View viewName, User user){
        if(viewName != null){
            switch(viewName){
//                case COMPETITORINFO:
//                    competitorInfoFrm = new CompetitorInfoFrm(user);
//                    competitorInfoFrm.setVisible(true);
//                    break;
            }
        }
    }
    public static void openView(View viewName, String arg1, String arg2){
        if(viewName != null){
            switch(viewName){
                case GAMENOTICE:
                    gameNoticeFrm = new GameNoticeFrm(arg1, arg2);
                    gameNoticeFrm.setVisible(true);
                    break;
                case LOGIN:
                    loginFrm = new LoginFrm(arg1, arg2);
                    loginFrm.setVisible(true);
            }
        }
    }
    public static void closeView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm.dispose();
                    break;
                case REGISTER:
                    registerFrm.dispose();
                    break;
                case HOMEPAGE:
                    homePageFrm.dispose();
                    break;
                case ROOMLIST:
                    roomListFrm.dispose();
                    break;
//                case FRIENDLIST:
//                    friendListFrm.stopAllThread();
//                    friendListFrm.dispose();
//                    break;
                case FINDROOM:
                    findRoomFrm.stopAllThread();
                    findRoomFrm.dispose();
                    break;
                case WAITINGROOM:
                    waitingRoomFrm.dispose();
                    break;
                case GAMECLIENT:
                    gameClientFrm.stopAllThread();
                    gameClientFrm.dispose();
                    break;
                case CREATEROOMPASSWORD:
                    createRoomPasswordFrm.dispose();
                    break;
                case JOINROOMPASSWORD:
                    joinRoomPasswordFrm.dispose();
                    break;
//                case COMPETITORINFO:
//                    competitorInfoFrm.dispose();
//                    break;
//                case RANK:
//                    rankFrm.dispose();
//                    break;
                case GAMENOTICE:
                    //hủy bỏ view này
                    gameNoticeFrm.dispose();
                    break;
//                case FRIENDREQUEST:
//                    friendRequestFrm.dispose();
//                    break;
                case GAMEAI:
                    gameAIFrm.dispose();
                    break;
                case ROOMNAMEFRM:
                    roomNameFrm.dispose();
                    break;
            }
            
        }
    }
    
    public static void closeAllViews(){
        if(loginFrm!=null) loginFrm.dispose();
        if(registerFrm!=null) registerFrm.dispose();
        if(homePageFrm!=null) homePageFrm.dispose();
        if(roomListFrm!=null) roomListFrm.dispose();
//        if(friendListFrm!=null){
//            friendListFrm.stopAllThread();
//            friendListFrm.dispose();
//        } 
        if(findRoomFrm!=null){
            findRoomFrm.stopAllThread();
            findRoomFrm.dispose();
        } 
        if(waitingRoomFrm!=null) waitingRoomFrm.dispose();
        if(gameClientFrm!=null){
            gameClientFrm.stopAllThread();
            gameClientFrm.dispose();
        } 
        if(createRoomPasswordFrm!=null) createRoomPasswordFrm.dispose();
        if(joinRoomPasswordFrm!=null) joinRoomPasswordFrm.dispose();
//        if(competitorInfoFrm!=null) competitorInfoFrm.dispose();
//        if(rankFrm!=null) rankFrm.dispose();
//        if(gameNoticeFrm!=null) gameNoticeFrm.dispose();
//        if(friendRequestFrm!=null) friendRequestFrm.dispose();
//        if(gameAIFrm!=null) gameAIFrm.dispose();
        if(roomNameFrm!=null) roomNameFrm.dispose();
    }
    public static void main(String[] args) {
        new Client().initView();
    }
}
