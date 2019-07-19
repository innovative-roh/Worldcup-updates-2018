package worldcup.fifa2018.worldcupupdates.Model;

public class pointTableModel {

    private String group;
    private String team_name;
    private String Img_url;
    private String MP;
    private String W;
    private String D;
    private String L;
    private String GF;
    private String GA;
    private String GD;
    private String PTS;


    public pointTableModel(String group, String team_name, String img_url, String MP, String w, String d, String l, String GF, String GA, String GD, String PTS) {
        this.group = group;
        this.team_name = team_name;
        Img_url = img_url;
        this.MP = MP;
        W = w;
        D = d;
        L = l;
        this.GF = GF;
        this.GA = GA;
        this.GD = GD;
        this.PTS = PTS;
    }

    public String getGroup() {
        return group;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getImg_url() {
        return Img_url;
    }

    public String getMP() {
        return MP;
    }

    public String getW() {
        return W;
    }

    public String getD() {
        return D;
    }

    public String getL() {
        return L;
    }

    public String getGF() {
        return GF;
    }

    public String getGA() {
        return GA;
    }

    public String getGD() {
        return GD;
    }

    public String getPTS() {
        return PTS;
    }
}
