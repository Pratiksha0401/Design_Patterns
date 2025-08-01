package org.example.Structural;

//Target Class
interface USBPort{
    void readData();
}

//Adaptee (Legacy class)
class MicroSDCard{
    void fetchData(){
        System.out.println("I am reading data from MicroSDCard");
    }
}

//Adapter
class CardReader implements USBPort{
    private MicroSDCard microSDC;

    public CardReader(MicroSDCard microSD){
        this.microSDC= microSD;
    }

    public void readData(){
        microSDC.fetchData();
    }
}

//client
public class AdapterClientLaptop {
    public static void main(String[] args) {
        MicroSDCard sd = new MicroSDCard();
        CardReader reader = new CardReader(sd);
        reader.readData();
    }
}

