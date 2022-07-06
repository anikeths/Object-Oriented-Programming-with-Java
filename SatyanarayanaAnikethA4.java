public class SatyanarayanaAnikethA4 {
    private double length;
    private double height;
    private double width;
    private double weight;

    SatyanarayanaAnikethA4(double l, double w, double h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    public void rearrangeDim(double l, double w, double h) {
        double largest = l;
        if (w > l) largest = w;
        if (height > width) largest = h;
        length = largest;

        if (length == l) {
            width = w;
            height = h;
        } else if (length == w) {
            width = l;
            height = h;
        } else {
            height = l;
            width = w;
        }
    }

    public double calculateGirth() {
        return 2 * (width + height);
    }

    public int validatePackage() {
        boolean acceptableW = false, acceptableS = false;
        if (weight < 70) acceptableW = true;
        if ((length + calculateGirth()) < 100) acceptableS = true;
        if (!acceptableW && !acceptableS) return 1;
        if (!acceptableW && acceptableS) return 2;
        if (acceptableW && !acceptableS) return 3;
        else return 4;
    }

    public void print() {
        if (validatePackage() == 1) {
            System.out.println("The package is too large and too heavy.");
            System.out.println("The length of package: " + this.length + " inches ");
            System.out.println("The girth of package :  " + calculateGirth() + " inches");
            System.out.println("The weight of package :  " + weight + " pounds.");
        } else if (validatePackage() == 2) {
            System.out.println("The package is too heavy.");
            System.out.println("The weight of package :  " + weight + " pounds.");
        } else if (validatePackage() == 3) {
            System.out.println("The package is too large.");
            System.out.println("The length of package: " + this.length + " inches");
            System.out.println("The girth of package : " + calculateGirth() + "inches");
        } else
            System.out.println("The package is acceptable.");
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        SatyanarayanaAnikethA4 obj1 = new SatyanarayanaAnikethA4(5, 13.5, 2);
        SatyanarayanaAnikethA4 obj2 = new SatyanarayanaAnikethA4(15.7, 25, 54);
        SatyanarayanaAnikethA4 obj3 = new SatyanarayanaAnikethA4(13, 10.9, 21);
        SatyanarayanaAnikethA4 obj4 = new SatyanarayanaAnikethA4(43, 45, 10.8);

        double[] w = new double[4];
        try {
            for (int i = 0; i < 4; i++) w[i] = Double.parseDouble(args[i]);
            obj1.setWeight(w[0]);
            obj1.rearrangeDim(5, 13.5, 2);
            obj1.calculateGirth();
            obj1.validatePackage();
            obj1.print();
            System.out.println();

            obj2.setWeight(w[1]);
            obj2.rearrangeDim(15.7, 25, 54);
            obj2.calculateGirth();
            obj2.validatePackage();
            obj2.print();
            System.out.println();

            obj3.setWeight(w[2]);
            obj3.rearrangeDim(13, 10.9, 21);
            obj3.calculateGirth();
            obj3.validatePackage();
            obj3.print();
            System.out.println();

            obj4.setWeight(w[3]);
            obj4.rearrangeDim(43, 45, 10.8);
            obj4.calculateGirth();
            obj4.validatePackage();
            obj4.print();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Enter 4 arguments as weight in the command-line.");
        } finally {
            System.out.println("Program completed.");
        }
    }
}
