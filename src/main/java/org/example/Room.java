package org.example;

import java.awt.event.KeyEvent;

public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        if (width <= 4 || height <= 4) {
            throw new IllegalArgumentException(
                    "Error when creating a room. The values for the room must be greater then 4"
            );
        }
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void run() {
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        while (snake.isAlive()) {
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();

                if (event.getKeyChar()  == 'q' || event.getKeyChar() == 'Q'
                        || event.getKeyChar() == 'й' || event.getKeyChar() == 'Й') {
                    closeGame();
                    return;
                }

                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            snake.move();
            print();
            sleep();
        }

        int playerScore = snake.getSections().size() - 1;
        System.out.println("Game Over. Your score is " + playerScore);
    }

    public void closeGame() {
        if (KeyboardObserver.frame != null) {
            KeyboardObserver.frame.dispose();
        }
    }

    public void print() {
        if (KeyboardObserver.frame != null) {
            KeyboardObserver.frame.setContentPane(new Layer());
            KeyboardObserver.frame.revalidate();
        }
    }


    private int initialDelay = 520;
    private int delayStep = 5;
    private int minDelay = 110;

    public void sleep() {
        try {
            int level = snake.getSections().size();
            int delay = Math.max(minDelay, (initialDelay - delayStep * level));
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createMouse() {
        int totalCells = width * height;
        int occupiedCells = 0;
        int mouseX, mouseY;
        boolean isPositionValid;

        do {
            occupiedCells++;
            if (occupiedCells >= totalCells) {
                System.out.println("You Win! Your score is " + occupiedCells);
                closeGame();
                return;
            }

            mouseX = (int) (Math.random() * width);
            mouseY = (int) (Math.random() * height);
            isPositionValid = true;

            for (SnakeSection section : snake.getSections()) {
                if (section.getX() == mouseX && section.getY() == mouseY) {
                    isPositionValid = false;
                    break;
                }
            }
        } while (!isPositionValid);

        mouse = new Mouse(mouseX, mouseY);
    }

    public void eatMouse() {
        createMouse();
    }

    public static Room game;

    public static void main(String[] args) {
        int widthRoom = 20;
        int heightRoom = 20;
        game = new Room(widthRoom, heightRoom, new Snake(widthRoom / 2, heightRoom / 2));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }
}