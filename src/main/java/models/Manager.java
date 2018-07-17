package models;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {

    private int id;
    private String name;
    private Team team;

    public Manager(){}


    public Manager(String name, Team team){
        this.name = name;
        this.team = team;}

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
