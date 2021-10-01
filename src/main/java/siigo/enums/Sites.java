package siigo.enums;

public enum Sites {

    INVOICES_SALES("invoices sales"),
    INVOICES_PURCHASE("invoices purchase"),
    DEBIT_NOTE_SALES("debit note purchase"),
    DEBIT_NOTE_PURCHASE("debit note purchase")
    ;

    private final String text;

    Sites(String text) {
        this.text = text;
    }

    public String asString() {
        return text;
    }
}
