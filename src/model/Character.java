package model;



import javafx.scene.image.Image;

public class Character {


    public Image avatar;
    public String color;
    public String gender;


    public Character(String gender, String color, Image avatar) {
        this.gender = gender;
        this.color = color;
        this.avatar = avatar;
    }



}
