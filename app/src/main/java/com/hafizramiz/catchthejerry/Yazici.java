package com.hafizramiz.catchthejerry;

public class Yazici {
   int numberOfPage;
   Yazici(int numberOfPage){
      this.numberOfPage=numberOfPage;
   }
   public   synchronized void yazdir( String computerName){
      for(int i=0; i<=numberOfPage;i++){
         System.out.println(computerName+" Yazdirilan Sayfa Numarasi "+i);
      }
   }
}

class Computer1 extends Thread{
   Yazici yazici;
   public Computer1(Yazici yazici, String name){
      super(name);
      this.yazici=yazici;
   }

   @Override
   public void run() {
      super.run();
      yazici.yazdir("Computer 1");
   }
}
class Computer2 extends Thread{
   Yazici yazici;
  public Computer2(Yazici yazici, String name){
      super(name);
      this.yazici=yazici;
   }

   @Override
   public void run() {
      super.run();
      yazici.yazdir("Computer 2");
   }
}


