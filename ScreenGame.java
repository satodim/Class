package com.mygdx.game;


import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;



public class ScreenGame implements Screen {
    public  int getCountToCheck() {
        return count;
    }
    public void setsetscreenshop(boolean newsetscreenshop) {
        setscreenshop = newsetscreenshop;
    }
    private Music music;
    private Stage stage;
    private BitmapFont font;
    private TextureAtlas buttonsAtlas;
    boolean isTouchDownLeft;
    boolean isTouchDownRight;

    private Skin buttonSkin;
    private TextButton button;
    private BitmapFont font2;
    private TextureAtlas buttonsAtlas2;
    private Skin buttonSkin2;
    private TextButton button2;
    private BitmapFont font3;
    private TextureAtlas buttonsAtlas3;
    private Skin buttonSkin3;
    private TextButton button3;
    boolean setscreenshop = false;
    ScreenGame shopScreen;
    int count;
    int points = 1;
    PointCounter pointCounter;
    public Character character;
    public Monster monster;
    Texture characterTexture;
    Texture monsterTexture;
    Texture menuExitTexture;

    Texture backgroundTexture;
    Texture[] texturesAttacking1;
    Texture[] texturesAttacking2;
    Texture[] texturesAttacking3;
    private BitmapFont font4;
    private TextureAtlas buttonsAtlas4;
    private Skin buttonSkin4;
    private TextButton button4;
    private BitmapFont font5;
    Dealer dealer;
    Texture dealerTexture;
    Paper paper;
    Texture paperTexture;
    private TextureAtlas buttonsAtlas5;
    private Skin buttonSkin5;
    private TextButton button5;
    private BitmapFont font6;
    private TextureAtlas buttonsAtlas6;
    private Skin buttonSkin6;
    private TextButton button6;
    MenuExit menuExit;

    private final MyGdxGame myGdxGame;
    int widthSword  = 0, heightSword = 0;
    Sword sword;
    int currentTextureIndexToRight = 0;
    int currentTextureIndexLeft = 0;

    final int pointCounterMarginRight = 400;
    final int pointCounterMarginTop = 60;

    ScreenGame(MyGdxGame myGdxGame) {
        new Music() {
            @Override
            public void play() {

            }

            @Override
            public void pause() {

            }

            @Override
            public void stop() {

            }

            @Override
            public boolean isPlaying() {
                return false;
            }

            @Override
            public void setLooping(boolean isLooping) {

            }

            @Override
            public boolean isLooping() {
                return false;
            }

            @Override
            public void setVolume(float volume) {

            }

            @Override
            public float getVolume() {
                return 0;
            }

            @Override
            public void setPan(float pan, float volume) {

            }

            @Override
            public void setPosition(float position) {

            }

            @Override
            public float getPosition() {
                return 0;
            }

            @Override
            public void dispose() {

            }

            @Override
            public void setOnCompletionListener(OnCompletionListener listener) {

            }
        };




        //массив текстур передвижения вправо
        Texture textureToRight1 = new Texture("R_An05_F00.png");
        Texture textureToRight2 = new Texture("R_An05_F01.png");
        Texture textureToRight3 = new Texture("R_An05_F02.png");
        Texture textureToRight4 = new Texture("R_An05_F03.png");
        Texture textureToRight5 = new Texture("R_An05_F04.png");
        Texture textureToRight6 = new Texture("R_An05_F05.png");
        Texture textureToRight7 = new Texture("R_An05_F06.png");
        Texture textureToRight8 = new Texture("R_An05_F07.png");
        Texture textureToRight9 = new Texture("R_An05_F08.png");
        Texture textureToRight10 = new Texture("R_An05_F09.png");
        Texture[] texturesToRight = new Texture[]{textureToRight1, textureToRight2, textureToRight3,textureToRight4, textureToRight5, textureToRight6,textureToRight7, textureToRight8, textureToRight9,textureToRight10};

        // массив текстур передвижения влево
        Texture textureToLeft1 = new Texture("L_An05_F00.png");
        Texture textureToLeft2 = new Texture("L_An05_F01.png");
        Texture textureToLeft3 = new Texture("L_An05_F02.png");
        Texture textureToLeft4 = new Texture("L_An05_F03.png");
        Texture textureToLeft5 = new Texture("L_An05_F04.png");
        Texture textureToLeft6 = new Texture("L_An05_F05.png");
        Texture textureToLeft7 = new Texture("L_An05_F06.png");
        Texture textureToLeft8 = new Texture("L_An05_F07.png");
        Texture textureToLeft9 = new Texture("L_An05_F08.png");
        Texture textureToLeft10 = new Texture("L_An05_F09.png");
        Texture[] texturesToLeft = new Texture[]{textureToLeft1, textureToLeft2, textureToLeft3,textureToLeft4, textureToLeft5, textureToLeft6,textureToLeft7, textureToLeft8, textureToLeft9,textureToLeft10};

        Texture textureAttacking1 = new Texture("R_An03_F00.png");
        Texture textureAttacking2 = new Texture("R_An03_F01.png");
        Texture textureAttacking3 = new Texture("R_An03_F02.png");
        Texture textureAttacking4 = new Texture("R_An03_F03.png");
        Texture textureAttacking5 = new Texture("R_An03_F04.png");
        Texture textureAttacking6 = new Texture("R_An03_F05.png");
        Texture textureAttacking7 = new Texture("R_An03_F06.png");
        Texture textureAttacking8 = new Texture("R_An03_F07.png");
        Texture textureAttacking9 = new Texture("R_An03_F08.png");
        Texture textureAttacking10 = new Texture("R_An03_F09.png");
        texturesAttacking1 = new Texture[]{textureAttacking1, textureAttacking2, textureAttacking3,textureAttacking4,textureAttacking5,textureAttacking6,textureAttacking7,textureAttacking8,textureAttacking9,textureAttacking10};

        Texture textureAttacking_2_1 = new Texture("R_An02_F00.png");
        Texture textureAttacking_2_2 = new Texture("R_An02_F01.png");
        Texture textureAttacking_2_3 = new Texture("R_An02_F02.png");
        Texture textureAttacking_2_4 = new Texture("R_An02_F03.png");
        Texture textureAttacking_2_5 = new Texture("R_An02_F04.png");
        Texture textureAttacking_2_6 = new Texture("R_An02_F05.png");
        Texture textureAttacking_2_7 = new Texture("R_An02_F06.png");
        Texture textureAttacking_2_8 = new Texture("R_An02_F07.png");
        Texture textureAttacking_2_9 = new Texture("R_An02_F08.png");
        Texture textureAttacking_2_10 = new Texture("R_An02_F09.png");
        Texture textureAttacking_2_11 = new Texture("R_An02_F10.png");
        Texture textureAttacking_2_12 = new Texture("R_An02_F11.png");
        Texture textureAttacking_2_13 = new Texture("R_An02_F12.png");
        texturesAttacking2 = new Texture[]{textureAttacking_2_1, textureAttacking_2_2, textureAttacking_2_3,textureAttacking_2_4,textureAttacking_2_5,textureAttacking_2_6,textureAttacking_2_7,textureAttacking_2_8,textureAttacking_2_9,textureAttacking_2_10,textureAttacking_2_11,textureAttacking_2_12,textureAttacking_2_13};

        Texture textureAttacking_3_1 = new Texture("R_An04_F00.png");
        Texture textureAttacking_3_2 = new Texture("R_An04_F01.png");
        Texture textureAttacking_3_3 = new Texture("R_An04_F02.png");
        Texture textureAttacking_3_4 = new Texture("R_An04_F03.png");
        Texture textureAttacking_3_5 = new Texture("R_An04_F04.png");
        Texture textureAttacking_3_6 = new Texture("R_An04_F05.png");
        Texture textureAttacking_3_7 = new Texture("R_An04_F06.png");
        Texture textureAttacking_3_8 = new Texture("R_An04_F07.png");
        Texture textureAttacking_3_9 = new Texture("R_An04_F08.png");
        Texture textureAttacking_3_10 = new Texture("R_An04_F09.png");
        Texture textureAttacking_3_11 = new Texture("R_An04_F10.png");
        Texture textureAttacking_3_12 = new Texture("R_An04_F11.png");
        Texture textureAttacking_3_13 = new Texture("R_An04_F12.png");
        Texture textureAttacking_3_14 = new Texture("R_An04_F13.png");
        texturesAttacking3 = new Texture[]{textureAttacking_3_1, textureAttacking_3_2, textureAttacking_3_3,textureAttacking_3_4,textureAttacking_3_5,textureAttacking_3_6,textureAttacking_3_7,textureAttacking_3_8,textureAttacking_3_9,textureAttacking_3_10,textureAttacking_3_11,textureAttacking_3_12,textureAttacking_3_13,textureAttacking_3_14};

        this.myGdxGame = myGdxGame;
        music = Gdx.audio.newMusic(Gdx.files.internal("game.mp3"));
        music.setLooping(true);
        music.setVolume(0.3f);



        // текстура персонажа, заднего фона и создание счетчика
        character = new Character(100, -10, characterTexture, 0, 600, 600);
        menuExit = new MenuExit(50,890,menuExitTexture,0,120,120);
        paper = new Paper(450,400,paperTexture,0,300,100);
        paperTexture = new Texture("imageCost.png");
        menuExitTexture = new Texture("kjol_.png");
        dealer = new Dealer(500,70, dealerTexture,0,400,400);
        dealerTexture = new Texture("MonsterIdle_F0.png");
        sword = new Sword(character.x, character.y,widthSword,heightSword);
        characterTexture = new Texture("R_An00_F00.png");
        monster = new Monster(980, 20, monsterTexture, 0, 520, 520);
        monsterTexture = new Texture("MonsterIdle_F0.png");
        pointCounter = new PointCounter(SCR_WIDTH - pointCounterMarginRight, SCR_HEIGHT - pointCounterMarginTop);
        backgroundTexture = new TextureRegion(new Texture("Sprite-0004.png"), 0, 0, 2048, 563).getTexture();



        // кнопка передвижения вправо
        buttonsAtlas = new TextureAtlas("buttons.pack");
        buttonSkin = new Skin();
        buttonSkin.addRegions(buttonsAtlas);
        font = new BitmapFont();
        font.getData().scale(5f);
        font.setColor(Color.WHITE);
        stage = new Stage();
        stage.clear();


        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = buttonSkin.getDrawable("ButtonOff");
        style.down = buttonSkin.getDrawable("ButtonOn");
        style.font = font;

        button = new TextButton("", style);
        button.setPosition(350, 50);
        button.setHeight(100);
        button.setWidth(150);
        button.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                character.setisStanding(false);
                character.setisStandingToLeft(false);
                isTouchDownRight = true;
                new Thread(() -> {
                    while (isTouchDownRight) {
                        character.setrunToRight(true);
                        character.runningToRight();
                        character.setTexture(texturesToRight[currentTextureIndexToRight]);
                        characterTexture = texturesToRight[currentTextureIndexToRight];
                        currentTextureIndexToRight = ++currentTextureIndexToRight % texturesToRight.length;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
                return true;

            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isTouchDownRight = false;
                currentTextureIndexToRight = 0;
                character.setrunToRight(false);
                character.setisStanding(true);
                character.isCharacterStanding();

            }

        });

        // кнопка перендвижения влево

        buttonsAtlas2 = new TextureAtlas("buttons2.pack");
        buttonSkin2 = new Skin();
        buttonSkin2.addRegions(buttonsAtlas2);
        font2 = new BitmapFont();
        font2.getData().scale(5f);
        font2.setColor(Color.WHITE);



        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style2.up = buttonSkin2.getDrawable("ButtonOn");
        style2.down = buttonSkin2.getDrawable("ButtonOff");
        style2.font = font2;

        button2 = new TextButton("", style2);
        button2.setPosition(100, 50);
        button2.setHeight(100);
        button2.setWidth(150);
        button2.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                character.setisStanding(false);
                character.setisStandingToLeft(false);
                isTouchDownLeft = true;
                new Thread(() -> {
                    while (isTouchDownLeft) {
                        character.setrunToLeft(true);
                        character.runningToLeft();
                        character.setTexture(texturesToLeft[currentTextureIndexLeft]);
                        characterTexture = texturesToLeft[currentTextureIndexLeft];
                        currentTextureIndexLeft = ++currentTextureIndexLeft % texturesToLeft.length;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();

                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isTouchDownLeft = false;
                currentTextureIndexLeft = 0;
                character.setrunToLeft(false);
                character.setisStandingToLeft(true);
                character.isCharacterStandingToLeft();
            }

        });
        // кнопка добавления счетчика(enemy)

        buttonsAtlas3 = new TextureAtlas("buttons.pack2");
        buttonSkin3 = new Skin();
        buttonSkin3.addRegions(buttonsAtlas3);
        font3 = new BitmapFont();
        font3.getData().scale(5f);
        font3.setColor(Color.WHITE);


        TextButton.TextButtonStyle style3 = new TextButton.TextButtonStyle();
        style3.up = buttonSkin3.getDrawable("ButtonOff");
        style3.down = buttonSkin3.getDrawable("ButtonOn");
        style3.font = font2;

        button3 = new TextButton("", style3);
        button3.setPosition(1230, 65);
        button3.setHeight(400);
        button3.setWidth(400);
        button3.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int checkedX = character.getXToCheck();
                if (checkedX >= 600  && checkedX <=1100) {
                    character.setisStanding(false);
                    character.setisStandingToLeft(false);
                    character.setisAttacking(true);
                    character.isCharacterAttacking();
                    character.selectRandomTextureArray(texturesAttacking3);
                    widthSword = 200;
                    heightSword = 200;
                    monster.setisMonsterAttacking(true);
                    monster.setisStandingMonster(false);
                    count += points;
                    System.out.println(count);
                }
                else{

                }

                return true;

            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                character.setisAttacking(false);
                character.setisStanding(true);
                character.isCharacterStanding();
                monster.setisMonsterAttacking(false);
                monster.setisStandingMonster(true);
            }


        });
        buttonsAtlas4 = new TextureAtlas("buttons.pack2");
        buttonSkin4 = new Skin();
        buttonSkin4.addRegions(buttonsAtlas4);
        font4 = new BitmapFont();
        font4.getData().scale(5f);
        font4.setColor(Color.WHITE);

        TextButton.TextButtonStyle style4 = new TextButton.TextButtonStyle();
        style4.up = buttonSkin4.getDrawable("ButtonOn");
        style4.down = buttonSkin4.getDrawable("ButtonOff");
        style4.font = font4;

        button4 = new TextButton("", style4);
        button4.setPosition(700, 100);
        button4.setHeight(250);
        button4.setWidth(200);
        button4.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int checkedX = character.getXToCheck();
                if(checkedX >=300 && checkedX<= 800) {
                    if (count >= 10) {
                        count -= 10;
                        points *= 2;
                    } else {
                        count -= 0;
                    }
                }
                else{

                }

                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

        });

        buttonsAtlas5 = new TextureAtlas("buttons.pack2");
        buttonSkin5 = new Skin();
        buttonSkin5.addRegions(buttonsAtlas5);
        font5 = new BitmapFont();
        font5.getData().scale(5f);
        font5.setColor(Color.WHITE);
        stage = new Stage();
        stage.clear();


        TextButton.TextButtonStyle style5 = new TextButton.TextButtonStyle();
        style5.up = buttonSkin5.getDrawable("ButtonOff");
        style5.down = buttonSkin5.getDrawable("ButtonOn");
        style5.font = font5;

        button5 = new TextButton("", style5);
        button5.setPosition(50, 900);
        button5.setHeight(100);
        button5.setWidth(100);
        button5.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                myGdxGame.setScreen(myGdxGame.menu);
                return true;

            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

        });

        buttonsAtlas6 = new TextureAtlas("buttons2.pack");
        buttonSkin6 = new Skin();
        buttonSkin6.addRegions(buttonsAtlas6);
        font6 = new BitmapFont();
        font6.getData().scale(5f);
        font6.setColor(Color.WHITE);
        stage = new Stage();
        stage.clear();


        TextButton.TextButtonStyle style6 = new TextButton.TextButtonStyle();
        style6.up = buttonSkin6.getDrawable("ButtonOff");
        style6.down = buttonSkin6.getDrawable("ButtonOn");
        style6.font = font6;

        button6 = new TextButton("", style6);
        button6.setPosition(800, 100);
        button6.setHeight(100);
        button6.setWidth(100);
        button6.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                character.setJump(true);
                character.jumping();
                return true;

            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                character.setisStanding(true);
                character.isCharacterStanding();
            }

        });
        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(button5);
        stage.addActor(button6);


    }

    @Override
    public void show() {
        monster.setisStandingMonster(true);
        music.play();
        Gdx.input.setInputProcessor(stage);
        myGdxGame.shopScreen.setsetscreengame(false);
        if (setscreenshop){
            character.setX(1400);
        }



    }

    @Override
    public void render(float delta) {
        if(character.jump == false) {
            new Thread(() -> {
                while (character.y >= -10) {
                    character.speed = 10;
                    character.y -= character.speed;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
        System.out.println(character.jump);
        if(character.y <= -10){
            character.setY(-10);
        }

        if(character.getRunToright(true)){
            character.rect.x += character.speed;
            sword.rect.x += character.speed;
        }
        if(character.getrunToLeft(true)){
            character.rect.x -= character.speed;
            sword.rect.x -= character.speed;
        }
        if(sword.getCollisionRect().collidesWidth(monster.getCollisionRect())){
            count += 1;
        }
        if(sword.getCollisionRect().collidesWidth(monster.getCollisionRect())){
            count += 1;
        }
        int checkedX = character.getXToCheck();
        if (checkedX>= 1700){
            myGdxGame.setScreen(myGdxGame.shopScreen);
        }

        stage.act();

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        myGdxGame.batch.draw(backgroundTexture, 0, 0);
        myGdxGame.batch.draw(backgroundTexture, 0, Gdx.graphics.getHeight());
        pointCounter.draw(myGdxGame.batch,count);
        pointCounter.draw(myGdxGame.batch,count);
        menuExit.draw(myGdxGame.batch);
        monster.draw(myGdxGame.batch);
        paper.draw(myGdxGame.batch);
        dealer.draw(myGdxGame.batch);
        character.draw(myGdxGame.batch);
        stage.draw();
        myGdxGame.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        music.stop();
        Gdx.input.setInputProcessor(null);
        myGdxGame.shopScreen.setsetscreengame(true);

    }

    @Override
    public void dispose() {
        paper.dispose();
        dealer.dispose();
        menuExit.dispose();
        character.dispose();
        monster.dispose();
        buttonSkin.dispose();
        buttonsAtlas.dispose();
        font.dispose();
        stage.dispose();
        buttonSkin2.dispose();
        buttonsAtlas2.dispose();
        font2.dispose();
        buttonSkin3.dispose();
        buttonsAtlas3.dispose();
        font3.dispose();
        buttonSkin4.dispose();
        buttonsAtlas4.dispose();
        font4.dispose();
        buttonSkin5.dispose();
        buttonsAtlas5.dispose();
        font5.dispose();
        buttonSkin6.dispose();
        buttonsAtlas6.dispose();
        font6.dispose();
        pointCounter.dispose();
    }
}