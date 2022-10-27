# các bước chạy project:
* b1: khởi tạo database mysql bằng file sql create_db.sql
* b2: đổi địa chỉ IP và port về local host trong CaroServerNhom5/controller/ServerThread.java
* b3: đổi địa chỉ IP và port về local host trong CaroClientNhom5/controller/SocketHandler.java
* b4: run server
* b5: run client
# cách ping thông 2 máy tính với nhau để  chơi nhiều người:
* b1: đổi địa chỉ IP và port về local host trong CaroClientNhom5/controller/SocketHandler.java
* b2: (làm tại hai máy) vào control panel->network and internet-> network and sharing center-> changes advance sharing setting-> tại all network chọn như sau:
 ![image](https://user-images.githubusercontent.com/73243952/198181657-9f221454-32e3-48bd-9c0d-c00d907aa4fa.png)
* b3:  kiểm tra ping thông bằng cmd trên 2 máy
# các chức năng chính:
## client: 
* đăng nhập
* đăng kí
* xem thông  tin của người chơi
* chat tổng
* chat cá nhân và call với đối thủ
* chơi 2 người
* chơi với máy
* tạo phòng chơi 
* tìm phòng
* kết bạn
* xem xếp hạng
* xem danh sách bạn bè
## server:
* hiển thị thông tin luồng 
* xem danh sách phòng đang mở
* chat tổng
* phát thông báo
* cảnh cáo và ban
