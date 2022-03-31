/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClass;

/**
 *
 * @author ACER
 */
public class AuthorWrapperCB {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return name;
    }

    public void setPosition(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
