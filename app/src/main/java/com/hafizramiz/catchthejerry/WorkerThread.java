package com.hafizramiz.catchthejerry;

public  class WorkerThread extends Thread{
    public WorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Worker Thread Calismaya basladi");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker Thread Calismayi Bitirdi");

    }
    public  void work(){
        System.out.println("Worker metotu calisiyor.");
    }
}
