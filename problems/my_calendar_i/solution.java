class MyCalendar {
    private TreeMap<Integer, Integer> bookings = new TreeMap<>();
    
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
    	Integer lastStartTime = bookings.floorKey(start);
    	Integer nextStartTime = bookings.ceilingKey(start);
    	
    	if( ( lastStartTime == null || bookings.get(lastStartTime) <= start ) && (nextStartTime == null || nextStartTime >= end) ){
			bookings.put(start, end);
			return true;
    	}
    	return false;
    }
    
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */