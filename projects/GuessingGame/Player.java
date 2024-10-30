package projects.GuessingGame;

public class Player {
    int number;

    void guess()
    {
       int n = (int) Math.random() * 10;
       setNumber(n);
    }


    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
