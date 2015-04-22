
public class DatabaseCorruptedException extends RuntimeException {
    private String databaseField;
    private String value;
    
    public DatabaseCorruptedException(String databaseField, String value) {
        this.databaseField = databaseField;
        this.value = value;
    }
    
    public String message() {
        return String.format("The value %s is not appropriate for the field %s", value, databaseField);
    }
    
}
