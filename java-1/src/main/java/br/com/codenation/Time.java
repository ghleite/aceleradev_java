package br.com.codenation;

import java.time.LocalDate;

public class Time {

    private Long id;
    private String name;
    private LocalDate creationDate;
    private String principalColor;
    private String secondColor;
    private Jogador captain;

    public Time(Long id, String name, LocalDate creationDate, String principalColor, String secondColor) {
        setId(id);
        setName(name);
        setCreationDate(creationDate);
        setPrincipalColor(principalColor);
        setSecondColor(secondColor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getPrincipalColor() {
        return principalColor;
    }

    public void setPrincipalColor(String principalColor) {
        this.principalColor = principalColor;
    }

    public String getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(String secondColor) {
        this.secondColor = secondColor;
    }

    public Jogador getCaptain() {
        return captain;
    }

    public void setCaptain(Jogador jCaptain) {
        this.captain = jCaptain;
    }
}
