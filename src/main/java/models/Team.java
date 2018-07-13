package models;

import javax.persistence.*;
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

    public Team(){}

    public Team(String name, List<Player> players, Manager manager, List<Competition> competitions, int currentPoints) {
        this.id = id;
        this.name = name;
        this.players = players;
        this.manager = manager;
        this.competitions = competitions;
        this.currentPoints = currentPoints;
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

    @OneToMany(mappedBy = "team")
    @Column(name = "players")
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @OneToOne
    @JoinColumn(name = "manager_id", nullable = false)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Column(name = "competitions")
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
}
