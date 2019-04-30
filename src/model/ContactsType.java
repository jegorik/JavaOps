package model;

public enum ContactsType {
    PHONE_NUMBER("Phone number"),
    SKYPE("Skype name"),
    E_MAIL("E-mail address"),
    LINKEDIN("LinkedIn profile"),
    GITHUB("GitHub profile"),
    STACKOVERFLOW("StackOverFlow profile"),
    WEB_PAGE("Web page");

    private String title;

    ContactsType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
