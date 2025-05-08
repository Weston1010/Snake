# 🐍 The Snake

![Gameplay Screenshot](assets%2Fimages%2Fgameplay.png)

The classic Snake game, implemented in Java using the Swing library.

## 📌 Features

- 🎮 Classic gameplay with a growing snake
- 🖥 Simple and intuitive operation
- 🎨 Customizable colors and sizes
- ⚡️ Smooth motion with acceleration
- 📊 Support for different difficulty levels

## 🛠 Technical requirements

- Java JDK 11 or later
- Maven 3.6+ (for build)

## 🚀 Quick start

### Build and run from the IDE

1. Clone a repository:
   ```bash
   git clone https://github.com/Weston1010/snake.git
   ```

2. Open the project in IntelliJ IDEA/Eclipse

3. Launch: `src/main/java/org/example/Room.java`

## 🎮 Control

| Buttons | Action        |
|---------|---------------|
| ← ↑ → ↓ | Snake Control |
| Q or q  | Exit the game |

## ⚙️ Game Settings

You can change the parameters in the Room.java class:

#### The size of the playing field (in cells)

```java
private int width;
private int height;
```

> Note: For optimal play, it is recommended to use a 20x20 cell field.

#### Game speed (in milliseconds, the less, the faster)
```java
private int initialDelay = 520; // Initial speed
private int delayStep = 5; // Increasing the speed
private int minDelay = 110; // Maximum speed
```

### Setting up colors (Layer.java)

#### The snake's head
```java
g.setColor(new Color(0, 0, 255));  // Blue
```

#### Snake's body
```java
g.setColor(new Color(0, 255, 0));  // Green
```

#### Mouse (food)
```java
g.setColor(new Color(255, 175, 175));  // Pink
```

#### Boundaries of the playing field
```java
g.setColor(new Color(64, 64, 64));  // Dark Grey
```

> Note: You can change the colors to create your own unique color scheme
> 
## 🛠 Development

### Recommendations for improvement:
1. Adding a pause during the game
2. Implementing the settings menu
3. Saving game recordings

## 📜 License

This project is distributed under the MIT license. For more information, see the [LICENSE](LICENSE.md) file.