package controller;

import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    public void keyTyped(java.awt.event.KeyEvent keyEvent) {

    }

    public void keyPressed(java.awt.event.KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE){
            System.out.println("Escape key pressed");
        }

        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_A || keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT){
            System.out.println("Left key pressed");
        }
        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_W || keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_UP){
            System.out.println("Up key pressed");
        }
        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_D || keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT){
            System.out.println("Right key pressed");
        }
        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S|| keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
            System.out.println("Down key pressed");
        }

    }

    public void keyReleased(java.awt.event.KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_A || keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT){
            System.out.println("Left key released");
        }
        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_W || keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_UP){
            System.out.println("Up key released");
        }
        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_D || keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT){
            System.out.println("Right key released");
        }
        if(keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S|| keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN){
            System.out.println("Down key released");
        }
    }
}
