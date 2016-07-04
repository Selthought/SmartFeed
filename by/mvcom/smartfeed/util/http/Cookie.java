package by.mvcom.smartfeed.util.http;

import java.nio.file.Path;

/**
 *
 * Класс куков. хранит пару ключ - значение
 * Created by puma on 01.07.16.
 *
 */
public class Cookie {

    private String key;
    private String value;
    private String expires;
    private String path;
    private String domain;


    public Cookie(String key, String value, String expires, String path, String domain) {
        this.key = key;
        this.value = value;
        this.expires = expires;
        this.path = path;
        this.domain = domain;
    }

    public Cookie(){}


    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(key);
        builder.append("=");
        builder.append(value);
        builder.append("; ");
        builder.append("expires=");
        builder.append(expires);
        builder.append("; ");
        builder.append("path=");
        builder.append(path);
        builder.append("; ");
        builder.append("domain=");
        builder.append(domain);
        return builder.toString();
    }
}
