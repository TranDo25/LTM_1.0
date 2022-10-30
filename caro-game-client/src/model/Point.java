/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//tọa độ điểm (x, y)
public class Point {
	public int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//
	public Point findStartXPoint() {
            //khởi tạo điểm bắt đầu x. kích thước ô là 15
		int startX = x - 5 < 0 ? 0 : x - 5;
		return new Point(startX, y);
	}
	public Point findEndXPoint() {
		int endX = x + 5 > 19 ? 19 : x + 5;
		return new Point(endX, y);
	}
	public Point findStartYPoint() {
		int startY = y - 5 < 0 ? 0 : y - 5;
		return new Point(x, startY);
	}
	public Point findEndYPoint() {
		int endY = y + 5 > 19 ? 19 : y + 5;
		return new Point(x, endY);
	}
	public Point findLeftTopPoint() {
		int startX = x - 5 < 0 ? 0 : x - 5;
		int startY = y - 5 < 0 ? 0 : y - 5;
		return new Point(startX, startY);
	}
	public Point findRightTopPoint() {
		int endX = x + 5 > 19 ? 19 : x + 5;
		int startY = y - 5 < 0 ? 0 : y - 5;
		return new Point(endX, startY);
	}
	public Point findLeftBottomPoint() {
		int startX = x - 5 < 0 ? 0 : x - 5;
		int endY = y + 5 > 19 ? 19 : y + 5;
		return new Point(startX, endY);
	}
	public Point findRightBottomPoint() {
		int endX = x + 5 > 19 ? 19 : x + 5;
		int endY = y + 5 > 19 ? 19 : y + 5;
		return new Point(endX, endY);
	}
	
	public void log() {
                System.out.println("đây là tọa độ của điểm vừa bấm");
		System.out.println("x: "+ this.x + "| y: " + this.y);
	}
}

