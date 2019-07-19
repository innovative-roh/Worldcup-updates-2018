package worldcup.fifa2018.worldcupupdates.Model;

public class SadiumModel {
    private String description;
    private String image;

    public SadiumModel(String description, String image) {
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
