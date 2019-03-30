package openwebinar.marvel.app.dto;

public class AvengerDTO {

    private Long id;

    private String lang;

    private String name;

    private String actor;

    private String description;

    private String urlimage;

    private Long color_1;

    private Long color_2;

    private Long color_3;

    private Long color_4;

    private Long color_5;


    public AvengerDTO() {}

    public AvengerDTO(Long id, String lang, String name, String actor, String description, String urlimage, Long color_1, Long color_2, Long color_3, Long color_4, Long color_5) {
        this.id = id;
        this.lang = lang;
        this.name = name;
        this.actor = actor;
        this.description = description;
        this.urlimage = urlimage;
        this.color_1 = color_1;
        this.color_2 = color_2;
        this.color_3 = color_3;
        this.color_4 = color_4;
        this.color_5 = color_5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public Long getColor_1() {
        return color_1;
    }

    public void setColor_1(Long color_1) {
        this.color_1 = color_1;
    }

    public Long getColor_2() {
        return color_2;
    }

    public void setColor_2(Long color_2) {
        this.color_2 = color_2;
    }

    public Long getColor_3() {
        return color_3;
    }

    public void setColor_3(Long color_3) {
        this.color_3 = color_3;
    }

    public Long getColor_4() {
        return color_4;
    }

    public void setColor_4(Long color_4) {
        this.color_4 = color_4;
    }

    public Long getColor_5() {
        return color_5;
    }

    public void setColor_5(Long color_5) {
        this.color_5 = color_5;
    }
}
