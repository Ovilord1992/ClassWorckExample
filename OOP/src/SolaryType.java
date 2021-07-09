public enum SolaryType {

    /**
     * Ставка
     */
    rate("Ставка   "),

    /**
     * Почасовая
     */
    hourly("Почасовая"),

    /**
     * Сдельная
     */
    piecework("Сдельная");

    private final String name;

    private SolaryType(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

}
