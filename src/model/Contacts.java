package model;

public enum Contacts {
    PHONE_NUMBER("Phone number"),
    SKYPE("Skype name"),
    E_MAIL("E-mail address"),
    LINKEDIN("LinkedIn profile"),
    GITHUB("GitHub profile"),
    STACKOVERFLOW("StackOverFlow profile"),
    WEB_PAGE("Web page");

    private String title;

    public String getTitle() {
        return title;
    }

    Contacts(String title) {
        this.title = title;
    }
}
