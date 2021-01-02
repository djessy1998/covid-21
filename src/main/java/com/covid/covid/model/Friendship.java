package com.covid.covid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friendship {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int idFriendship;

    private int idUserFriend;

    public void setIdFriendship(int idFriendship) {
        this.idFriendship = idFriendship;
    }

    public int getIdFriendship() {
        return idFriendship;
    }

    public int getIdUserFriend() {
        return idUserFriend;
    }

    public void setIdUserFriend(int idUserFriend) {
        this.idUserFriend = idUserFriend;
    }
}
