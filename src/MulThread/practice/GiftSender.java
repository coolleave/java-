package MulThread.practice;

import java.security.spec.RSAOtherPrimeInfo;

public class GiftSender extends Thread{
    public static int giftCount = 100;
    @Override
    public void run() {
        while(true){
            synchronized (GiftSender.class) {
                if (giftCount > 10) {
                    giftCount--;
                    System.out.println(getName() + "送出礼物,还剩" + giftCount);
                } else {
                    System.out.println(getName() + "礼物小于10份");
                    break;
                }
            }
        }
    }
}
