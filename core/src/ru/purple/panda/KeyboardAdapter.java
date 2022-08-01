package ru.purple.panda;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

public class KeyboardAdapter extends InputAdapter {

    private boolean leftPressed;
    private boolean rightPressed;
    private boolean upPressed;
    private boolean downPressed;
    private final Vector2 mousePosition = new Vector2();
    private final float speed = 5;

    private final Vector2 direction= new Vector2();
    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W) upPressed = true;
        if (keycode == Input.Keys.A) leftPressed = true;
        if (keycode == Input.Keys.S) downPressed = true;
        if (keycode == Input.Keys.D) rightPressed = true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.W) upPressed = false;
        if (keycode == Input.Keys.A) leftPressed = false;
        if (keycode == Input.Keys.S) downPressed = false;
        if (keycode == Input.Keys.D) rightPressed = false;
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mousePosition.set(screenX, Gdx.graphics.getHeight() - screenY);
        return false;
    }

    public Vector2 getDirection() {
        direction.set(0, 0);

        if (leftPressed) direction.add(-speed, 0);
        if (rightPressed) direction.add(speed, 0);
        if (upPressed) direction.add(0, speed);
        if (downPressed) direction.add(0, -speed);

        return direction;
    }

    public Vector2 getMousePosition() {
        return mousePosition;
    }
}
