package pl.jasiek.app.aspect;

class Cleaner {
    private static final int LIMIT = 25;

    static void clean() {
        for (int i = 0; i < LIMIT; i++) {
            System.out.println("\n");
        }
    }
}
