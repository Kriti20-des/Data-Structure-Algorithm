class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {

        long value = val;

        if (stack.isEmpty()) {
            stack.push(value);
            min = value;
        }
        else if (value < min) {

            long encoded = 2 * value - min;

            stack.push(encoded);
            min = value;
        }
        else {
            stack.push(value);
        }
    }

    public void pop() {

        long top = stack.pop();

        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {

        long top = stack.peek();

        if (top < min) {
            return (int) min;
        }

        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */