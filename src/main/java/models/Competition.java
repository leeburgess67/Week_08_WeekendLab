package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "competitions")
public class Competition {

    private int id;
    private CompetitionType competitionType;
    private List<Team> teams;

    public Competition(CompetitionType competitionType, List<Team> teams) {
        this.competitionType = competitionType;
        this.teams = teams;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "competition_type")
    public CompetitionType getCompetition() {
        return competitionType;
    }

    public void setCompetition(CompetitionType competition) {
        this.competitionType = competition;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "teams_competitions",
            joinColumns = {@JoinColumn(name = "competition_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)})
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public int randomResult() {
        Random rand = new Random();
        int n = rand.nextInt(3) + 1;
        return n;
    }

    public void playGame(Team team1, Team team2) {
        int result = randomResult();
        switch (result) {
            // Team 1 wins - 3 points to team 2 - no points to team 2
            case 1:
                int
                        winPoints = team1.getCurrentPoints();
                team1.setCurrentPoints(winPoints += 3);
                break;

            case 2:
                //Draw - 1 point each team
                int
                        drawPoints1 = team1.getCurrentPoints();
                team1.setCurrentPoints(drawPoints1 += 1);

                int drawPoints2 = team2.getCurrentPoints();
                team2.setCurrentPoints(drawPoints2 += 1);


                break;

            case 3:
                // Team 2 wins - 3 points to team 2 - 0 to team 1
                int
                        winPoints2 = team2.getCurrentPoints();
                team2.setCurrentPoints(winPoints2 += 1);

                break;

        }

    }
}


