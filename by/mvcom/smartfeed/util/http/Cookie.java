package by.mvcom.smartfeed.util.http;

/**
 *
 * Класс куков. хранит пару ключ - значение
 * Created by puma on 01.07.16.
 *
 */
public class Cookie {

    private String key;
    private String value;

    public Cookie(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Cookie(){}

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
}
