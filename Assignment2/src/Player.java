public class Player {
    public int numPlayers;
    private int[][] data;
    public SeLinkedList head;

    public Player() {
        this.numPlayers = 0;
        this.head = null;
    }

    public void loadDataFromPlayerData() { PlayerData pd = new PlayerData(); this.data = pd.getMyData(); }

    public SeLinkedList addPlayer(int a, int b, int c) {
        SeLinkedList node = new SeLinkedList(numPlayers, a, b, c);
        if (head == null) head = node;
        else {
            SeLinkedList cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
        numPlayers++;
        return node;
    }

    public void initializeList() {
        if (this.data == null) loadDataFromPlayerData();
        if (this.data == null) return;
        for (int[] row : data) addPlayer(row[0], row[1], row[2]);
    }

    public SeLinkedList findMaxWeight() {
        if (head == null) return null;
        SeLinkedList max = head; int maxW = head.weight();
        for (SeLinkedList cur = head.next; cur != null; cur = cur.next) {
            int w = cur.weight();
            if (w > maxW) { max = cur; maxW = w; }
        }
        System.out.println("Max weight player >> " + max + " and its weight=" + maxW);
        return max;
    }

    public SeLinkedList findMinWeight() {
        if (head == null) return null;
        SeLinkedList min = head; int minW = head.weight();
        for (SeLinkedList cur = head.next; cur != null; cur = cur.next) {
            int w = cur.weight();
            if (w < minW) { min = cur; minW = w; }
        }
        System.out.println("Min weight player >> " + min + " and its weight=" + minW);
        return min;
    }

    public SeLinkedList[] findMinMaxWeight() {
        if (head == null) return new SeLinkedList[] { null, null };
        SeLinkedList min = head, max = head;
        int minW = head.weight(), maxW = head.weight();
        for (SeLinkedList cur = head.next; cur != null; cur = cur.next) {
            int w = cur.weight();
            if (w < minW) { min = cur; minW = w; }
            if (w > maxW) { max = cur; maxW = w; }
        }
        System.out.println("findMinMaxWeight(): min=" + min + " (" + minW + "), max=" + max + " (" + maxW + ")");
        return new SeLinkedList[] { min, max };
    }
}
