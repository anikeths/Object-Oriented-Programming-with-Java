public class SatyanarayanaAnikethA5 {
    public static void main(String[] args) {
        Attacker a = new Attacker("Lionel Messi",29,3,0);
        Goalkeeper g = new Goalkeeper("Petr Cech",34,5,1);

        a.printInfo();                                  //print the attackers info
        System.out.println();
        g.printInfo();                                  //print the goalkeepers info

        int lead= a.TotalPoints - g.TotalPoints;
        boolean x= a.isLeading(a.TotalPoints,g.TotalPoints);    //method call

        if(x) System.out.println(a.Name+  " leads " +  g.Name + " by " + lead + " points");
        else if(lead==0) System.out.println(a.Name + " and " + g.Name + " have equal scores.");
        else System.out.println(g.Name+  " leads " +  a.Name + " by " + (-lead) + " points");

        System.out.println("\nProgram completed.");
    }
}
