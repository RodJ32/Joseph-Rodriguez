public class Main {
    public static void main(String[] args) {
        System.out.println("Main: Task 12 - removeNode test");
        Player p = new Player();
        p.initializeList();
        SeLinkedList max = p.findMaxWeight();
        p.removeNode(max);
        System.out.println("Completed");
    }
}
