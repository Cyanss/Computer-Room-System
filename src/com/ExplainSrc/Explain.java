package com.ExplainSrc;
public class Explain {
	final String nations1[]={"��һ��","�ڶ���","������","������","������","������","������","�ڰ���","�ھ���","��ʮ��","��ʮһ��","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","��ʮ����","�ڶ�ʮ��" };
	final String nations2[]={"����һ","���ڶ�","������","������","������","������","������" };
	final String nations3[]={"��һ���","�ڶ����","  ��  ��  ","�������","���Ĵ��","  ��  ��  " };
	final String nations4[]={"һ�Ż���","���Ż���","���Ż���","�ĺŻ���","��Ż���","���Ż���","�ߺŻ���" };
	final String nations5[]={"08:30-10:05 ","10:35-12:10","12:20-13:40 ","14:00-10:35 ","16:05-17:40","18:30-20:00" };	
	final String nations6[]={"��  ��  ϵ","��е����ϵ","��  ��  ϵ","��Ϣ����ϵ","��  ѧ  ϵ","������ýϵ" };
	//ת���ܴ�
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
	//ת���ڴ�
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
	//ת��ڴ�
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
	//ת�����
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

