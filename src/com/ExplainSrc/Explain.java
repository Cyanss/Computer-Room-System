package com.ExplainSrc;
public class Explain {
	final String nations1[]={"第一周","第二周","第三周","第四周","第五周","第六周","第七周","第八周","第九周","第十周","第十一周","第十二周","第十三周","第十四周","第十五周","第十六周","第十七周","第十八周","第十九周","第二十周" };
	final String nations2[]={"星期一","星期二","星期三","星期四","星期五","星期六","星期日" };
	final String nations3[]={"第一大节","第二大节","  中  午  ","第三大节","第四大节","  晚  上  " };
	final String nations4[]={"一号机房","二号机房","三号机房","四号机房","五号机房","六号机房","七号机房" };
	final String nations5[]={"08:30-10:05 ","10:35-12:10","12:20-13:40 ","14:00-10:35 ","16:05-17:40","18:30-20:00" };	
	final String nations6[]={"外  语  系","机械工程系","会  计  系","信息技术系","商  学  系","政法传媒系" };
	//转译周次
	public int explainTime(String string){
		int temp=0;
		for(int i=0;i<20;i++){
			if(string==nations1[i])
				temp=i+1;
		}
		return temp;
	}
	public 	String explainTimes(int a){
			String temp=null;
		for(int i=0;i<20;i++){
			if(a==i+1)
				temp=nations1[i];
		}
		return temp;
	}
	//转译期次
	public int explainWeek(String string){
		int temp=0;
		for(int i=0;i<7;i++){
			if(string==nations2[i])
				temp=i+1;
		}
		return temp;
	}
	public 	String explainWeeks(int a){
		String temp=null;
	for(int i=0;i<7;i++){
		if(a==i+1)
			temp=nations2[i];
	}
	return temp;
}
	//转译节次
	public int explainDate(String string){
		int temp=0;
		for(int i=0;i<6;i++){
			if(string==nations3[i])
				temp=i+1;
		}
		return temp;
	}
	public 	String explainDates(int a){
		String temp=null;
	for(int i=0;i<6;i++){
		if(a==i+1)
			temp=nations3[i];
	}
	return temp;
}
	//转译机房
	public int explainRoom(String string){
		int temp=0;
		for(int i=0;i<7;i++){
			if(string==nations4[i])
				temp=i+1;
		}
		return temp;
	}
	public 	String explainRooms(int a){
		String temp=null;
	for(int i=0;i<7;i++){
		if(a==i+1)
			temp=nations4[i];
	}
	return temp;
}
}

