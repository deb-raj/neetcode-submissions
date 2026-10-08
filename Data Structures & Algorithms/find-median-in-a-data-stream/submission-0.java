class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (!right.isEmpty() && num >= right.peek()) {
            right.add(num);
        } else {
            left.add(num);
        }
        if (left.size() > right.size()) {
            right.add(left.poll());
        } else if (right.size() > left.size() + 1) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return ((long) left.peek() + right.peek()) / 2.0;
        } else {
            return right.peek();
        }
    }
}
