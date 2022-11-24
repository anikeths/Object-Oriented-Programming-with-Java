class ADeadlock {
    synchronized void foo(BDeadlock b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("A interrupted.");
        }
        System.out.println(name + "trying to call B.last()");
        b.last();
    }
        synchronized void last()
        {
            System.out.println("Inside A.last");
        }
    }

class BDeadlock
{
synchronized void bar(ADeadlock a)
{
    String name = Thread.currentThread().getName();
    System.out.println(name + " entered B.bar");
try {
Thread.sleep(1000);
}catch(InterruptedException e)
{
    System.out.println("B interrupted.");
}
    System.out.println(name + " trying to call A.last()");
    a.last();
}
synchronized void last()
{
    System.out.println("Inside A.last");
}

}


class Deadlock implements Runnable
{
    ADeadlock a= new ADeadlock();
    BDeadlock b= new BDeadlock();

    Deadlock() {
        Thread.currentThread().setName("Main Thread");
        Thread t = new Thread(this, "Racing Thread");
        t.start();

        a.foo(b);
        System.out.println("Back in main thread.");
    }

        public void run()
        {
         b.bar(a);
            System.out.println("Back in other thread.");
        }

    public static void main(String[] args) {
        new Deadlock();
    }
    }

