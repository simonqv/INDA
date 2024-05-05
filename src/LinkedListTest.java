public class LinkedListTest extends StackTest {

    @Override
    protected Stack<Integer> getIntegerStack() {
        return new LinkedList<>();
    }
}
