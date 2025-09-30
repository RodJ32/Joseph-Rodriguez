public class Main {
    public static void main(String[] args) {
        System.out.println("Main: Task 4 - Loading PlayerData into Player");
        Player p = new Player();
        p.loadDataFromPlayerData();
        p.printArraySnapshot();
        System.out.println("Done Task 4.");
    }
}
