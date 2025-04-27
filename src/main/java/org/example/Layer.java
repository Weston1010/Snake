package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (Room.game == null) return;
        int width = Room.game.getWidth() * 10;
        int height = Room.game.getHeight() * 10;

        g.setColor(Color.DARK_GRAY);
        g.fillRect(width, 0, 10, width + 10);
        g.fillRect(0, height, height + 10, 10);

        g.setColor(Color.PINK);
        g.fillRect(Room.game.getMouse().getX() * 10, Room.game.getMouse().getY() * 10, 10, 10);

        List<SnakeSection> getSection = Room.game.getSnake().getSections();
        for (int i = 0; i < getSection.size(); i++) {
            if (i == 0) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.GREEN);
            }
            g.fillRect(getSection.get(i).getX() * 10, getSection.get(i).getY() * 10, 10, 10);
        }
    }
}
