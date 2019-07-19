package worldcup.fifa2018.worldcupupdates.Model;

public class SquadModel {

    private String team;
    private int IMG;
    private String SHORT;

    public SquadModel(String team, int IMG, String SHORT) {
        this.team = team;
        this.IMG = IMG;
        this.SHORT = SHORT;
    }

    public String getTeam() {
        return team;
    }

    public int getIMG() {
        return IMG;
    }

    public String getSHORT() {
        return SHORT;
    }
}
