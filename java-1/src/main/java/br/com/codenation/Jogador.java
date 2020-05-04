package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

    Long id;
    Long teamId;
    String name;
    LocalDate birthDate;
    Integer skillLevel;
    BigDecimal salary;

    public Jogador(Long id, Long teamId, String name, LocalDate birthDate, Integer skillLevel, BigDecimal salary) {
        setId(id);
        setTeamId(teamId);
        setName(name);
        setBirthDate(birthDate);
        setSkillLevel(skillLevel);
        setSalary(salary);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
