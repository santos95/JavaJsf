package com.sortiz.datajpa.app.springdatajpa.app.model.entity;

import jakarta.persistence.*;
import org.primefaces.component.galleria.GalleriaRenderer;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "superheroes")
public class SuperHeroe implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "real_name")
    private String realName;
    @Column(name = "heroe_name")
    private String heroeName;

    @Column(name = "super_heroe_group")
//    @Enumerated(EnumType.ORDINAL)
    private Integer superHeroeGroup;
    @Column(name = "heroe_since")
    @Temporal(TemporalType.DATE)
    private Date heroeSince;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "state")
    private Boolean state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeroeName() {
        return heroeName;
    }

    public void setHeroeName(String heroeName) {
        this.heroeName = heroeName;
    }

    public Date getHeroeSince() {
        return heroeSince;
    }

    public void setHeroeSince(Date heroeSince) {
        this.heroeSince = heroeSince;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getSuperHeroeGroup() {
        return superHeroeGroup;
    }

    public void setSuperHeroeGroup(Integer superHeroeGroup) {
        superHeroeGroup = superHeroeGroup;
    }

    public String getGroup(){

        Group heroGroup;

        if (1 == this.superHeroeGroup) {

            heroGroup = Group.AVENGERS;

        } else {

            heroGroup = Group.XMEN;

        }

        return heroGroup.getGroupName(this.superHeroeGroup);
    }
}
