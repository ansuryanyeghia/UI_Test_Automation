package vlume.provider.urlPrividers.welcomeUrl;

public enum WelcomeUrl {

    WELCOME_PAGE_URL("https://dev.vlume.com/"),
    SIGN_IN_PAGE_URL("https://dev.vlume.com/sign-in");

    private final String url;

    WelcomeUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
