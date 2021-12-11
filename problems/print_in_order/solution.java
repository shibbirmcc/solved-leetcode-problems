class Foo {

    private AtomicBoolean ranFirst = new AtomicBoolean(false);
    private AtomicBoolean ranSecond = new AtomicBoolean(false);
    
    
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        ranFirst.set(true);
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(!ranFirst.get()){ try{Thread.sleep(10);}catch(Exception e){} }
        ranSecond.set(true);
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(!ranFirst.get() || !ranSecond.get()){ try{Thread.sleep(10);}catch(Exception e){} }
        printThird.run();
    }
}