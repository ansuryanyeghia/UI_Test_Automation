package provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UrlProvider {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = UrlProvider.class.getClassLoader().getResourceAsStream("data/url.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find url.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load url.properties", ex);
        }
    }

    public static String getUrl(String key) {
        return properties.getProperty(key);
    }

    public static String getRecentlyAddedUrl() {
        return getUrl("recently_added_url");
    }

    public static String getSearchPageUrl() {
        return getUrl("search_page_url");
    }

    public static String getBookPageUrl() {
        return getUrl("book_page_url");
    }

    public static String getWelcomePageUrl() {
        return getUrl("welcome_page_url");
    }

    public static String getSignInPageUrl() {
        return getUrl("sign_in_page_url");
    }
}

