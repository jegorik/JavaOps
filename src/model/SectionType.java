package model;

public enum SectionType {
    PERSONAL("PERSONAL SKILLS"),
    OBJECTIVE("PREFERRED JOB"),
    ACHIEVEMENT("ACHIEVEMENT"),
    QUALIFICATION("QUALIFICATION"),
    EXPERIENCE("WORK EXPERIENCE"),
    EDUCATION("EDUCATION AND TRAINING");

    private String title;

    public String getTitle() {
        return title;
    }

    SectionType(String title) {
        this.title = title;
    }

}
