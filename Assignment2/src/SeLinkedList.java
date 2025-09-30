public class SeLinkedList {
    public SeLinkedList next;
    public int a;
    public int b;
    public int c;

    public SeLinkedList(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int weight() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Node (a=" + a + ", b=" + b +", c=" + c +", w=" + weight() + ")";
    }
}
