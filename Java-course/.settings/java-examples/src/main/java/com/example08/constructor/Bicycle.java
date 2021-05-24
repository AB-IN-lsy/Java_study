package com.example08.constructor;

public class Bicycle {
	//在类的开头写私有的属性
	private int speed;
	private int gear;
	private int cadence;
	private boolean moving;

	public Bicycle() {
	}//自己加上无参量构造函数

	public Bicycle(int gear) {
		this.gear = gear;
	}

	public Bicycle(int gear, int cadence) {
		this.gear = gear;
		this.cadence = cadence;
	}

	public Bicycle(int speed, int gear, int cadence) {
		this.speed = speed;
		this.gear = gear;
		this.cadence = cadence;
	}

	public Bicycle(int speed, int gear, int cadence, boolean moving) { // 通过构造函数，把参数传进去
		this.speed = speed;
		this.gear = gear;
		this.cadence = cadence;
		this.moving = moving;
	}
	//getter,setter均public
	public void setCadence(int cadence) {
		this.cadence = cadence;
	}
	public int getCadence() {
		return cadence;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getGear() {
		return gear;
	}
	public void setGear(int gear) {
		this.gear = gear;
	}
	public boolean isMoving() {
		return moving;
	}// bool型的getter前缀改为is
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public void applyBrakes(int decrement) {
		Bicycle.this.speed = Bicycle.this.speed - decrement;
	}
	/*等效
	public void applyBrakes(int decrement) {
		speed = speed - decrement;
	}*/
	/*等效
	public void applyBrakes(int decrement) {
		this.speed = this.speed - decrement;
	}*/

}
