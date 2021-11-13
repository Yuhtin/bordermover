public class Test {

    public static void main(String[] args) {
        System.out.println("bordas:");
        int number = 10000;
        int base = 16;
        for (int i = 0; i < 99; i++) {
            int hun =  i * 100;
            int blocks = number - hun;

            System.out.println("  " + (i + 1) + ":");
            System.out.println("    tempoDepois: " + (base * i));
            System.out.println("    tempoMovimento: " + base);
            System.out.println("    blocos: " + blocks);
            System.out.println("    mundo: 'world'");
        }
    }

}
