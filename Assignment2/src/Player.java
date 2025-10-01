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
    public void printArraySnapshot() {
        if (data == null) {
            System.out.println("No data loaded.");
            return;
        }
        System.out.println("Data snapshot (first up to 3 rows):");
        for (int i = 0; i < data.length && i < 3; i++) {
            int[] t = data[i];
            System.out.println("  [" + i + "] a=" + t[0] + " b=" + t[1] + " c=" + t[2]);
        }
    }

    public SeLinkedList addPlayer(int a, int b, int c) {
        SeLinkedList node = new SeLinkedList(a, b, c);
        if (head == null) {
            head = node;
        } else {
            SeLinkedList cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
        numPlayers++;
        System.out.println("addPlayer(): added " + node);
        return node;
    }
}
