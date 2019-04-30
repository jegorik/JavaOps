import model.*;
import storage.MapResumeStorage;
import storage.Storage;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    private final static Storage ARRAY_STORAGE = new MapResumeStorage();

    /*  PERSONAL("PERSONAL SKILLS"),
        OBJECTIVE("PREFERRED JOB"),
        ACHIEVEMENT("ACHIEVEMENT"),
        QUALIFICATION("QUALIFICATION"),
        EXPERIENCE("WORK EXPERIENCE"),
        EDUCATION("EDUCATION AND TRAINING");
    */
    public static void main(String[] args) throws ParseException {
        Resume resume = new Resume("Григорий Кислин");

        Map<ContactsType, String> contacts = resume.getContacts();
        contacts.put(ContactsType.PHONE_NUMBER, "+7(921) 855-0482");
        contacts.put(ContactsType.SKYPE, "grigory.kislin");
        contacts.put(ContactsType.E_MAIL, "gkislin@yandex.ru");
        contacts.put(ContactsType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        contacts.put(ContactsType.GITHUB, "https://github.com/gkislin");
        contacts.put(ContactsType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/gkislin");
        contacts.put(ContactsType.WEB_PAGE, "http://gkislin.ru/");

        Map<SectionType, AbstractSection> sectionType = resume.getSectionType();
        sectionType.put(SectionType.OBJECTIVE, new SimpleTextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям."));
        sectionType.put(SectionType.PERSONAL, new SimpleTextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        List<String> achievements = new ArrayList<>();
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников. ");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk. ");
        achievements.add("\n" +
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера. ");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга. ");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django). ");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        sectionType.put(SectionType.ACHIEVEMENT, new BilletedTextListSection(achievements));

        List<String> qualification = new ArrayList<>();
        qualification.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 ");
        qualification.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualification.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,\n" +
                "MySQL, SQLite, MS SQL, HSQLDB ");
        qualification.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,\n" +
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,\n" +
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).\n" +
                "Python: Django.\n" +
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js\n" +
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka ");
        qualification.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualification.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,\n" +
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer. ");
        qualification.add("\n" +
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов\n" +
                "проектрирования, архитектурных шаблонов, UML, функционального\n" +
                "программирования ");
        qualification.add("Родной русский, английский \"upper intermediate\"");
        sectionType.put(SectionType.QUALIFICATION, new BilletedTextListSection(qualification));


        String date = "October 1, 2013";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, y");
        LocalDate startDate = LocalDate.parse(date, formatter);
        date = "April 25, 2019";
        LocalDate endDate = LocalDate.parse(date, formatter);
        Company JAVA_ONLINE_PROJECTS = new Company("Java Online Projects", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.", startDate, endDate);

        date = "October 1, 2014";
        startDate = LocalDate.parse(date, formatter);
        date = "January 1, 2016";
        endDate = LocalDate.parse(date, formatter);
        Company WRIKE = new Company("Wrike", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.", startDate, endDate);


        List<Company> workExperience = new ArrayList<>();
        workExperience.add(JAVA_ONLINE_PROJECTS);
        workExperience.add(WRIKE);
        sectionType.put(SectionType.EXPERIENCE, new CompaniesSection(workExperience));

        date = "March 1, 2013";
        startDate = LocalDate.parse(date, formatter);
        date = "May 1, 2013";
        endDate = LocalDate.parse(date, formatter);
        Company COURSERA = new Company("Coursera", "\"Functional Programming Principles in Scala\" by Martin Odersky", null, startDate, endDate);

        date = "March 1, 2011";
        startDate = LocalDate.parse(date, formatter);
        date = "April 1, 2011";
        endDate = LocalDate.parse(date, formatter);
        Company LUXOFT = new Company("Luxoft", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", null, startDate, endDate);

        List<Company> education = new ArrayList<>();
        education.add(COURSERA);
        education.add(LUXOFT);
        sectionType.put(SectionType.EDUCATION, new CompaniesSection(education));

        ARRAY_STORAGE.save(resume);
        System.out.println(ARRAY_STORAGE.size());
        System.out.println(ARRAY_STORAGE.getAllSorted());
        String resumeUUID = resume.getUuid();
        System.out.println(ARRAY_STORAGE.get(resumeUUID));
        System.out.println(resume.getContacts());
        System.out.println(resume.getSectionType());
        resume = new Resume(resumeUUID, "TestName");
        ARRAY_STORAGE.update(resume);
        System.out.println(resume);

    }
}
