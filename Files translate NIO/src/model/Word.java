package model;

public class Word {
    private String key;
    private String value;
    private boolean isShowed;

    public Word(String key, String value) {
        this.key = key.toLowerCase();
        this.value = value.toLowerCase();
        this.isShowed = false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isShowed() {
        return isShowed;
    }

    public void setShowed(boolean showed) {
        isShowed = showed;
    }
    public String getKeyValue(){
        return key + " - " + value + "\n";
    }

}
