/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test;

/**
 *
 * @author Jack
 */
public class Shape {

    private String color;
    private int size;

    public Shape(String color, int size) {
        this.color = color;
        this.size = size;

    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.getColor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object shape) {
        
        return this.getSize()==((Shape)shape).getSize();
}

}
