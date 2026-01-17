package vlume.provider.urlPrividers.homeUrl;

public enum HomePageUrl {

    RECENTLY_ADDED_URL("https://dev.vlume.com/stack/STK_SITE_RECENT?mode=tail"),
    SEARCH_PAGE_URL("https://dev.vlume.com/search?type=title&search_text=&Audiobook=1&Ebook=1&Animation=1&Language=hy,en&Dialect=&Spelling="),
    BOOK_PAGE_URL("https://dev.vlume.com/item/EB-1579");

    private final String url;

    HomePageUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
