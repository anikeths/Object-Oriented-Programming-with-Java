public class Player {
    protected String Name;
    protected int Age;
    protected int TotalPoints;

    public Player(String name, int age) {             //constructor
        Name = name;
        Age = age;
    }

    void printInfo()                                //method
    {
        System.out.println("Name : " + Name + " Age : " + Age);
    }

    boolean isLeading(int a, int b)                //method
    {
        if (a > b) return true;
        else return false;
    }
}



