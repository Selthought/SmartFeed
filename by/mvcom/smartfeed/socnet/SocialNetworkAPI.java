package by.mvcom.smartfeed.socnet;

import by.mvcom.smartfeed.entity.News;

import java.util.List;

/**
 * Created by puma on 22.06.16.
 */
public interface SocialNetworkAPI {

    void avtorization(String login, String password) throws SocNetApiException;

    List<News> getNews() throws SocNetApiException;

    void setTime(long time);

    List<News> getNewNews() throws SocNetApiException;
}
