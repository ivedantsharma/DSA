import java.util.*;

public class stackandqueue {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(19);
        queue.add(1);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(89);
        deque.add(50);
        deque.addLast(29);
        deque.add(2);
        deque.addFirst(79);
        deque.add(98);
        System.out.println(deque);
        System.out.println(deque.pop());
        System.out.println(deque);
        System.out.println(deque.peek());
        System.out.println(deque.contains(29));
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        deque.offerFirst(3);
        System.out.println(deque);
        System.out.println(deque.removeLast());
    }
}