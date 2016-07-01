package by.mvcom.smartfeed.util.http;

/**
 * Created by puma on 01.07.16.
 */
public class HttpParam {

    private String key;
    private String value;

    public HttpParam(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public HttpParam(){}

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
