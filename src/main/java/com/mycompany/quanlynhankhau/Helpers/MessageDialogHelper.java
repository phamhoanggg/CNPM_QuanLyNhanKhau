/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.Helpers;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author minhd
 */
public class MessageDialogHelper {
    public static void showMessageDialog(Component parent, String content, String title) {
        JLabel Content = new JLabel(content);
        Content.setFont(new Font("Verdana", Font.BOLD, 20));
        JOptionPane.showMessageDialog(parent, Content, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorDialog(Component parent, String content, String title) {

        JLabel Content = new JLabel(content);
        Content.setFont(new Font("Verdana", Font.BOLD, 20));
        JOptionPane.showMessageDialog(parent, Content, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static int showConfirmDialog(Component parent, String content, String title) {

        JLabel Content = new JLabel(content);
        Content.setFont(new Font("Verdana", Font.BOLD, 20));
        int choose = JOptionPane.showConfirmDialog(parent, Content, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
}
