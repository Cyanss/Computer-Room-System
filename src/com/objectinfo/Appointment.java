package com.objectinfo;
public class Appointment {
		private  int Time;    								//周次
		private  int Week;  								//期次
		private  int Date;   								//节次
		private  int Room; 								//机房
		private  String Name;							//预约人
		private  String PhoneNumber;				//电话号码
		private  String School;							//院系
		private  String Classes;							//班级
		private  int State;									//预约状态
		public  int getTime() {
			return Time;
		}
		public  void setTime(int time) {
			Time = time;
		}
		public  int getWeek() {
			return Week;
		}
		public  void setWeek(int week) {
			Week = week;
		}
		public  int getDate() {
			return Date;
		}
		public  void setDate(int date) {
			Date = date;
		}
		public  int getRoom() {
			return Room;
		}
		public  void setRoom(int Room1) {
			Room = Room1;
		}
		public  String getName() {
			return Name;
		}
		public  void setName(String name) {
			Name = name;
		}
		public  String getPhoneNumber() {
			return PhoneNumber;
		}
		public  void setPhoneNumber(String phoneNumber) {
			PhoneNumber = phoneNumber;
		}
		public  String getSchool() {
			return School;
		}
		public  void setSchool(String school) {
			School = school;
		}
		public  String getClasses() {
			return Classes;
		}
		public  void setClasses(String class1) {
			Classes = class1;
		}
		public  int getState() {
			return State;
		}
		public  void setState(int state) {
			State = state;
		}		
}
