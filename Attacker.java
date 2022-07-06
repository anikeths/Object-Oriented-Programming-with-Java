class Attacker extends Player
{
    int GoalsScored;
    int GoalsMissed;

    public Attacker(String name, int age, int scored, int missed)   //constructor
    {
        super(name,age);
        GoalsScored = scored;
        GoalsMissed= missed;
        TotalPoints = (scored)*(3) + (missed * (-1));
        if (TotalPoints<0) TotalPoints=0;
    }

    public void printInfo() {                                     //method
        System.out.println("Name : " + super.Name + "\nAge : " + super.Age+ "\nType : Attacker" + "\nGoals Scored : " + GoalsScored+ "\nGoals Missed : "+GoalsMissed + "\nTotal Points: " + TotalPoints);
    }
}
