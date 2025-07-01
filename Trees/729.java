// TC - O(logn), SC - O(n)
class MyCalendar {

    TreeSet<int[]> sortedSet;
    public MyCalendar() {
        sortedSet = new TreeSet<>((a, b) -> {
            // sort by start time
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });
    }
    
    public boolean book(int startTime, int endTime) {
        int[] newEvent = new int[]{startTime, endTime};

        int[] lower = sortedSet.floor(newEvent);
        int[] higher = sortedSet.ceiling(newEvent);
        
        if(lower != null && lower[1] > startTime) {
            return false;
        }

        if(higher != null && higher[0] < endTime) {
            return false;
        }

        sortedSet.add(newEvent);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */