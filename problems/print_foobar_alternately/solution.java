class FooBar {
    private int n;
    private AtomicBoolean ran = new AtomicBoolean(false);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        	while(ran.get())try{Thread.sleep(1);}catch(Exception e){}
        	printFoo.run();
            ran.set(true);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!ran.get())try{Thread.sleep(1);}catch(Exception e){}
        	printBar.run();
            ran.set(false);
        }
    }
}