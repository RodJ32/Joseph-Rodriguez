public class Player {
    public int numPlayers;
    private int[][] data;
    public SeLinkedList head;

    public Player() {
        this.numPlayers = 0;
        this.head = null;
    }

    public void loadDataFromPlayerData() {
        PlayerData pd = new PlayerData();
        this.data = pd.getMyData();
        System.out.println("Player.loadDataFromPlayerData(): loaded " + (data == null ? 0 : data.length) + " rows.");
    }

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
        System.out.println("addPlayer(): added " + node + " weight=" + node.weight());
        return node;
    }

    public void initializeList() {
        if (this.data == null) loadDataFromPlayerData();
        if (this.data == null) {
            System.out.println("initializeList(): no data");
            return;
        }
        for (int[] row : data) addPlayer(row[0], row[1], row[2]);
        System.out.println("initializeList(): finished, numPlayers=" + numPlayers);
    }

    public SeLinkedList findMaxWeight() {
        if (head == null) {
            System.out.println("findMaxWeight(): list empty");
            return null;
        }
        SeLinkedList max = head;
        int maxW = head.weight();
        SeLinkedList cur = head.next;
        while (cur != null) {
            int w = cur.weight();
            if (w > maxW) { max = cur; maxW = w; }
            cur = cur.next;
        }
        System.out.println("Max weight player >> " + max + " and its weight=" + maxW);
        return max;
    }

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
    }
}
