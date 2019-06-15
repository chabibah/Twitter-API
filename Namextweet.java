import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Namextweet {
    private final static String CONSUMER_KEY = "bGUZOsWpLfajqKOHdm4gfeIkz";
    private final static String CONSUMER_KEY_SECRET = "VhWjKjwxPIwUYfSgagXBaCHa5Wmug1m89wv1JHroZvSEriFhy7";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hallo masa depan dunia");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "NztRCQxqhgX3pA8eAlMoyCM2kqHfJ3DzBKrVOcawN8GCw";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1139041825837072384-fncavGMV3Dx2rA0LnMZ7ZfEqnhNFQZ";
    }

    public static void main(String[] args) throws Exception {
	new Namextweet().start();
    }
}
