package com.ambmt.simulator.views.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class MenuScreen implements Screen {
    private final SpriteBatch batch;
    private final OrthographicCamera camera;
    private final Texture bg;

    private final FitViewport viewPort;

    public MenuScreen() {
        camera = new OrthographicCamera(1920,1080);
        camera.setToOrtho(false, 1920, 1080);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        batch = new SpriteBatch();
        bg = new Texture("bg.jpg");
        viewPort = new FitViewport(1920,1080,camera);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        System.out.println("Render called 1");
//        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        System.out.println("Before batch.draw");
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        System.out.println("After batch.draw");
        batch.end();
        // Handle input to transition to the next screen (e.g., game screen)
        if (Gdx.input.isTouched()) {
            System.out.println("Hello!");
        }
        System.out.println("After if statement");
    }

    @Override
    public void resize(int width, int height) {
        viewPort.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        bg.dispose();
    }
}
