class MovingAverage {
    int size;
    Deque window = new ArrayDeque<Integer>();
    int sum=0;
    public MovingAverage(int size) {
        this.size = size;  
    }
    public double next(int val) {
        window.add(val);
        int first = window.size() > size ? (int)window.poll() : 0;
        sum += val - first;
        return 1.0 * sum / window.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */