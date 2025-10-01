public class Player {
    public int numPlayers;
    private int[][] data;
    public SeLinkedList head;

    public Player() {
        this.numPlayers = 0;
        this.head = null;
    }

<<<<<<< HEAD
    public void loadDataFromPlayerData() { PlayerData pd = new PlayerData(); this.data = pd.getMyData(); }
=======
    public void loadDataFromPlayerData() {
        PlayerData pd = new PlayerData();
        this.data = pd.getMyData();
        System.out.println("Player.loadDataFromPlayerData(): loaded " + (data == null ? 0 : data.length) + " rows.");
    }
>>>>>>> doubleLink

    public SeLinkedList addPlayer(int a, int b, int c) {
        SeLinkedList node = new SeLinkedList(numPlayers, a, b, c);
        if (head == null) {
            head = node;
        } else {
            SeLinkedList cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
            node.prev = cur;
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

<<<<<<< HEAD
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
=======
    public void removeNode(SeLinkedList node) {
        if (node == null) return;

        SeLinkedList prev = node.prev;
        SeLinkedList next = node.next;

        if (prev == null) {
            // first node
            head = next;
            if (next != null) next.prev = null;
        } else if (next == null) {
            // last node
            prev.next = null;
        } else {
            // middle node
            prev.next = next;
            next.prev = prev;
        }

        node.prev = null;
        node.next = null;

        System.out.println("removeNode(): removed " + node + " (weight=" + node.weight() + ")");
>>>>>>> doubleLink
    }
}
