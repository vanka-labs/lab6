package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;

public class Window extends JFrame {
   public JFrame Frame1() {
       JFrame frame=new JFrame();
       frame.setResizable(false);
       frame.setSize(400,400);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel infoPanel = new JPanel();
        JLabel text = new JLabel();
        infoPanel.add(text);
        frame.add(infoPanel, BorderLayout.SOUTH);
        JPanel buttonPanel = new JPanel(null);
        JButton button = new JButton("Button");
        button.setLocation(100, 100);
        button.setSize(200, 30);
        buttonPanel.add(button);
        frame.add(buttonPanel, BorderLayout.CENTER);
       frame.setVisible(true);

        buttonPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point point = e.getPoint();
                int x = point.x;
                int y = point.y;
                int h=  frame.getSize().height;
                int w=frame.getSize().width;
                if(x>h || y<0 || x<0 || y>=w)
                    text.setText("-");
                    else
                text.setText("x: " + x + " y: " + y);

            }
        });
        buttonPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Point point = e.getPoint();
                int x = point.x;
                int y = point.y;
                button.setLocation(x - 50, y - 15);
                button.setFocusPainted(false);
            }
        });
        button.addActionListener(e -> button.setFocusPainted(!button.isFocusPainted()));
        Key k = new Key(button);
        button.addKeyListener(k);
        button.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point buttonPoint = new Point();
                button.getLocation(buttonPoint);
                Point point = e.getPoint();
                int x = point.x + buttonPoint.x;
                int y = point.y + buttonPoint.y;
                int h=  frame.getSize().height;
                int w=frame.getSize().width;
                if(x>h || y<0 || x<0 || y>w)
                    text.setText("-");
                else
                text.setText("x: " + x + " y: " + y);
                if (k.getFlag()) {
                    button.setLocation(x - 50, y - 15);
                    button.setFocusPainted(false);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point buttonPoint = new Point();
                button.getLocation(buttonPoint);
                Point point = e.getPoint();
                int x = point.x + buttonPoint.x;
                int y = point.y + buttonPoint.y;
                int h=  frame.getSize().height;
                int w=frame.getSize().width;
                if(x>h || y<0 || x<0 || y>w)
                    text.setText("-");
                else
                text.setText("x: " + x + " y: " + y);
            }
        });

        return this;
    }



    public JFrame Frame2()
    {
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(550, 190));
        JLabel question = new JLabel("Довольны ли Вы стипендией?");
        JPanel questionPanel = new JPanel();
        questionPanel.add(question);
        add(questionPanel, BorderLayout.NORTH);

        JButton yesButton = new JButton("Да");
        yesButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Нет!", "", JOptionPane.INFORMATION_MESSAGE));
        yesButton.setSize(100, 30);
        yesButton.setLocation(100, 25);
        yesButton.setFocusPainted(false);
        JButton noButton = new JButton("Нет");
        noButton.setSize(100, 30);
        noButton.setLocation(300, 25);
        noButton.addMouseListener(new MouseAdapter() {
            private int xPos = 1;
            private int yPos = 1;

            @Override
            public void mouseEntered(MouseEvent e) {
                Point nowPoint = new Point();
                noButton.getLocation(nowPoint);
                nowPoint.x += xPos * 120;
                xPos *= -1;
                nowPoint.y += yPos ;
                yPos *= -1;
                noButton.setLocation(nowPoint);
            }
        });
        JPanel buttonsPanel = new JPanel(null);

        buttonsPanel.add(yesButton);
        buttonsPanel.add(noButton);
        add(buttonsPanel, BorderLayout.CENTER);
        return this;
    }



    }




