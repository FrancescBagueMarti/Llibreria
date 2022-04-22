/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package llibreria.threads;

public class MyThread extends Thread {
    private setOnThreadRun onThreadRun;
    public MyThread(){}
    
    public void run() {
        if (onThreadRun != null){
            onThreadRun.onThread();
            onThreadRun = null;
        } else {
            for (int i=0; i<5;i++){
                System.out.println("Thread"+i);
            }
        }
    }
    
    public void startThread(setOnThreadRun onThreadRun) {
        this.onThreadRun = onThreadRun;
        this.start();
    }
    
    public static interface setOnThreadRun{
        public abstract void onThread();
    }
}
