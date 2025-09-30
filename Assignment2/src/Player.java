public class Player {
    public int numPlayers;
    private int[][] data; // holds the array from PlayerData
    public SeLinkedList head; // Task 7 will use this head more

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
}
