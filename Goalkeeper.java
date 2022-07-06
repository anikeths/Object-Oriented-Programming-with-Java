class Goalkeeper extends Player {
    int GoalsSaved;
    int GoalsConceded;

    public Goalkeeper(String name, int age, int saved, int conceded) { //constructor
        super(name, age);
        GoalsSaved = saved;
        GoalsConceded = conceded;
        TotalPoints = saved + conceded * (-1);
        if (TotalPoints<0) TotalPoints=0;
    }

    public void printInfo()                                             //method
    {
        System.out.println("Name : " + super.Name + "\nAge : "+ super.Age + "\nType : Goalkeeper" +  "\nGoals Saved : " + GoalsSaved+ "\nGoals Conceded : " + GoalsConceded+ "\nTotal Points: " + TotalPoints );
    }
}
