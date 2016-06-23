package by.mvcom.smartfeed.socnet.vkapi;

import by.mvcom.smartfeed.entity.News;
import by.mvcom.smartfeed.socnet.SocNetApiException;
import by.mvcom.smartfeed.socnet.SocialNetworkAPI;

import java.util.List;

/**
 * Created by puma on 22.06.16.
 */
public class VKApi implements SocialNetworkAPI {

    private String token;


    @Override
    public void avtorization(String login, String password) throws SocNetApiException {

    }

    @Override
    public List<News> getNews() throws SocNetApiException {
        return null;
    }

    @Override
    public void setTime(long time) {

    }

    @Override
    public List<News> getNewNews() throws SocNetApiException {
        return null;
    }
}
