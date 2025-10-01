public class SeLinkedList {
    public SeLinkedList next;
    public int a, b, c;
    public int index;

    public SeLinkedList(int index, int a, int b, int c) {
        this.index = index;
        this.a = a; this.b = b; this.c = c;
    }

    public int weight() { return a + b + c; }

    @Override
    public String toString() {
        return "Node (" + index + "," + a + "," + b + "," + c + ")";
    }
}
