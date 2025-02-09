public class PrestupnyRok2 {

    // Vlastní nekontrolovaná výjimka
    public static class NeplatnyRokException extends RuntimeException {
        public NeplatnyRokException(String zprava) {
            super(zprava);
        }
    }

    public static boolean jePrestupnyRok(int rok) {
        // Kontrola rozsahu let
        if (rok < 1900 || rok > 2100) {
            throw new NeplatnyRokException("Rok musí být v rozmezí 1900-2100");
        }

        // Kontrola přestupného roku
        return (rok % 4 == 0 && rok % 100 != 0) || (rok % 400 == 0);
    }

    public static void main(String[] args) {
        // Testování metody
        try {
            System.out.println("2000 je přestupný rok: " + jePrestupnyRok(2000));
            System.out.println("2100 je přestupný rok: " + jePrestupnyRok(2100));
            System.out.println("2024 je přestupný rok: " + jePrestupnyRok(2024));
            System.out.println("1900 je přestupný rok: " + jePrestupnyRok(1900));

            // Rok mimo zadání
            System.out.println("2101 je přestupný rok: " + jePrestupnyRok(2101));
        } catch (NeplatnyRokException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }
}
