public class AuthRecord {
    private String name;
    private Document document;
    private boolean accessGranted;

    public AuthRecord(String name, Document document, boolean accessGranted) {
        this.name = name;
        this.document = document;
        this.accessGranted = accessGranted;
    }
}
