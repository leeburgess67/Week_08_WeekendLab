package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    private int id;
    private String name;
    private List<Player> players;
    private Manager manager;
    private List<Competition> competitions;
    private int currentPoints;

    public Team() {
    }

    public Team(String name, int currentPoints) {
        this.id = id;
        this.name = name;
        this.currentPoints = currentPoints;
        this.competitions = new ArrayList<Competition>();
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @OneToOne(mappedBy = "team", fetch = FetchType.LAZY)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "teams_competitions",
            joinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "competition_id", nullable = false, updatable = false)})
    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    @Column(name = "current_points")
    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public void addCompetition(Competition competition){
        this.competitions.add(competition);

    }


}
