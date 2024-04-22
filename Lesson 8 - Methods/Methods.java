class Computer{

    public void playMusic()
    {
        System.out.println("Playing Music....");
    }

    public String musicType()
    {
        return "Bass";
    }

    public void buyMusic(int money)
    {
       System.out.println("Money Recived "+money+" Music returned");
    }
}

public class Methods {
    
    public static void main(String[] args) {
       
        Computer c = new Computer();

        c.playMusic();
        String str = c.musicType();
        c.buyMusic(700);

        System.out.println(str);
    
    }
}
