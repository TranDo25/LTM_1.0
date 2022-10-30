/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class XOButton extends JButton {
    //icon X
	private ImageIcon X;
//icon O
        private ImageIcon O;
//tọa độ
	public Point point;
	public static boolean isXMove = true;
	public int value = 0;
	
	public XOButton(int x, int y) {
            //sử dụng ảnh để đánh dấu X O
		X = new ImageIcon("assets/image/x3.jpg");
		O = new ImageIcon("assets/image/o3.jpg");
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		this.setIcon(new ImageIcon("assets/image/blank.jpg"));
		this.point = new Point(x, y);
                XOButton _this = this;
		this.addMouseListener( new MouseListener() {
                    //xử lí khi chuột được nhấn trên một thành phần
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }
                    //khi con trỏ chuột không trỏ vào đối tượng nữa, lập tức chuyển thành 
                    //ô trống
                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(_this.isEnabled()){
                            _this.setBackground(null);
                            //nếu chuột thoát ra khỏi phạm vi ô, chuyển ô về blank
                            _this.setIcon(new ImageIcon("assets/image/blank.jpg"));
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(_this.isEnabled()) {
                            _this.setBackground(Color.GREEN);
                            //đánh dấu x
                            _this.setIcon(new ImageIcon("assets/image/x3.jpg"));
                        }
                    }
                    //xử lí khi click chuột
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }
                });
	}
	//kiểm tra trạng thái đánh là X hay O
	public void setState(Boolean isXMove) {
		if (isXMove) {
			setIcon(X);
			value = 2;
			XOButton.isXMove = false;
                        this.setDisabledIcon(X);
		} else {
			setIcon(O);
			value = 1;
                        this.setDisabledIcon(O);
			XOButton.isXMove = true;
		}
	}
        //trả lại các trạng thái 
        public void resetState(){
            value = 0;
            this.setEnabled(true);
            this.setIcon(new ImageIcon("assets/image/blank.jpg"));
            this.setDisabledIcon(new ImageIcon("assets/image/blank.jpg"));
        }
	
	
}