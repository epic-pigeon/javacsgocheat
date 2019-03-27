package org.xena.plugin.official;

import org.xena.plugin.Plugin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class ShowWeaponsWindow {
    private static final int WIDTH = 500;
    private static int HEIGHT = 400;

    private static Point mouseDownPoint;

    private ArrayList<JLabel> panels = new ArrayList<>();

    private JFrame frame;

    public static ShowWeaponsWindow open(ArrayList<String> args) {
        return new ShowWeaponsWindow(args);
    }

    private ShowWeaponsWindow(ArrayList<String> args) {
        init(args);
    }

    private void init(ArrayList<String> args) {
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setLayout(null);
        frame.setBackground(new Color(71, 71, 71, 253));
        frame.setBounds(350, 0, WIDTH, HEIGHT);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseDownPoint = e.getPoint();
            }
        });

        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point mousePos = e.getLocationOnScreen();
                frame.setLocation(mousePos.x - mouseDownPoint.x, mousePos.y - mouseDownPoint.y);
                repaint(args);
            }
        });

        int height = 0;
        JLabel title = new JLabel("Weapons", SwingConstants.CENTER);
        title.setFont(new Font("Sans Serif", Font.BOLD, 16));
        title.setOpaque(true);
        title.setBackground(new Color(61, 61, 61));
        title.setForeground(Color.WHITE);
        title.setBounds(0, height, frame.getWidth(), 40);

        height += 40;

        for (String string: args) {
            height += 20;
            JLabel label = new JLabel(string);
            label.setFont(new Font("Sans Serif", Font.BOLD, 14));
            label.setForeground(Color.GREEN);
            label.setBounds(10, height, frame.getWidth(), 20);
            frame.add(label);
            panels.add(label);
        }

        frame.add(title);
        frame.setVisible(true);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

    public void repaint(ArrayList<String> args) {
        for (var panel: panels) frame.remove(panel);
        panels = new ArrayList<>();
        int height = 40;
        for (String string: args) {
            height += 20;
            JLabel label = new JLabel(string);
            label.setFont(new Font("Sans Serif", Font.BOLD, 14));
            label.setForeground(Color.GREEN);
            label.setBounds(10, height, frame.getWidth(), 20);
            frame.add(label);
            panels.add(label);
        }
        frame.repaint();
    }
}
