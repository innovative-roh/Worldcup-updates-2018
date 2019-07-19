package worldcup.fifa2018.worldcupupdates.Model;

public class MatchModel {

    private String date;
    private String time;
    private String group;
    private String stadium;
    private String venue;
    private String team1;
    private int img1;
    private String team2;
    private int img2;


    public MatchModel(String date, String time, String group, String stadium, String venue, String team1, int img1, String team2, int img2) {
        this.date = date;
        this.time = time;
        this.group = group;
        this.stadium = stadium;
        this.venue = venue;
        this.team1 = team1;
        this.img1 = img1;
        this.team2 = team2;
        this.img2 = img2;
    }


    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getGroup() {
        return group;
    }

    public String getStadium() {
        return stadium;
    }

    public String getVenue() {
        return venue;
    }

    public String getTeam1() {
        return team1;
    }

    public int getImg1() {
        return img1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getImg2() {
        return img2;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

