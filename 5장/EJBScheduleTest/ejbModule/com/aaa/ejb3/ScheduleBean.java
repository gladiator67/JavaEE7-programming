package com.aaa.ejb3;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;

@Stateless
public class ScheduleBean implements ISchedulePort {

   @Schedules({
     @Schedule(year="2016", month="Apr", dayOfMonth="17", hour = "10", minute = "17", second="0"), // -- ¨ç
     @Schedule(dayOfWeek = "Sun", hour = "18-19", minute = "*", second="*/5")  
     }) // -- ¨è
   @Override
   public void getSignal() {
      // TODO Auto-generated method stub
      System.out.println("½Ã°£Àº : " + new Date()); 
   }
}
