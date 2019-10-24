import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;
import java.io.File;

public class Main extends Application {

    private ImageView imgBg;
    private Button btnJouer;
    private Button btnOption;
    private Button btnQuitter;
    private Button btnVideoSetting;
    private Button btnAudiSetting;
    private Button btnRetour;



    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
        int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
        /////////////// Audio ////////////////



        ////////////////////////////////////// Titre scene 1 /////////////////////////
        Group sign = new Group();
        sign.setTranslateX(150);
        sign.setTranslateY(200);
        Text titrePrincipal = new Text((screenWidth-600), 150, "LA MUERTE");
        titrePrincipal.setFont(new Font("Indie flower", 100));
        titrePrincipal.setFill(Color.WHITE);
///////////////////////////////////// Titre de la fenetre //////////////////////////
        primaryStage.setTitle("NOTRE INTERFACE");


//////////////////////////////////////////////////////// Scene1 /////////////////
        Group scenePrincipal = new Group();
        Scene scene = new Scene(scenePrincipal, screenWidth, screenHeight , Color.BLACK);
        btnJouer = initButton((screenWidth-1200), 100, "Jouer", 90, 30, "Indie flower", 20);
        btnOption = initButton((screenWidth-1000), 100, "Options", 90, 30, "Indie flower", 20);
        btnQuitter = initButton((screenWidth-800), 100, "Quitter", 90, 30, "Indie flower", 20);


        ///////////////////////////////////////////// Scene2 //////////////////////
        Group sceneOption = new Group();
        Scene scene2 = new Scene(sceneOption,  screenWidth, screenHeight , Color.BLACK);
        btnVideoSetting = initButton((screenWidth/3), 200, "Video reglage", 200, 30, "Indie flower", 20);
        btnAudiSetting = initButton((screenWidth/3), 400, "Audio reglage", 200, 30, "Indie flower", 20);
        btnRetour = initButton((screenWidth/3), 600, "Retour", 200, 30, "Indie flower", 20);


//////////////////////////////////////////////////////////////////////////
        btnJouer.setOnAction(event -> primaryStage.setScene(scene));
        btnOption.setOnAction(event -> primaryStage.setScene(scene2));
        btnQuitter.setOnAction(event -> primaryStage.close());
        btnVideoSetting.setOnAction(event -> primaryStage.setScene(scene));
        btnAudiSetting.setOnAction(event -> primaryStage.setScene(scene));
        btnRetour.setOnAction(event -> primaryStage.setScene(scene));

        initBackground();

        // composition des scènes

        // Taille image identique pour le primary stage les scene doivent etre de meme resolution a specifier/////
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);

        /////////////////////////////////////////////////////////////////
        String path = "C:\\Users\\goldrunner\\IdeaProjects\\Mon premier jeu\\src\\audio\\Game Music.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        scenePrincipal.getChildren().addAll(imgBg);

        scenePrincipal.getChildren().add(titrePrincipal);
        scenePrincipal.getChildren().add(btnJouer);
        scenePrincipal.getChildren().add(btnOption);
        scenePrincipal.getChildren().add(btnQuitter);
        //////// Scene Option ///////////////
        sceneOption.getChildren().add(btnVideoSetting);
        sceneOption.getChildren().add(btnAudiSetting);
        sceneOption.getChildren().add(btnRetour);

        // gestion de l'affichage au lancement
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //////////////// image de fond scene 1 //////////////////////////////////
    private void initBackground() {
        imgBg = new ImageView("assets/images/crane.jpeg");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        imgBg.setFitHeight((int) primaryScreenBounds.getHeight());
        imgBg.setFitWidth((int) primaryScreenBounds.getWidth());
    }
////////////////////////////// creation des  boutons ///////////////////////////
    private Button initButton(int posX, int posY, String texteBtn, int tailleBtnW, int tailleBtnH, String police, int taillePolice) {
        // Création d'un bouton
        Button b = new Button();
        b.setLayoutX(posX);
        b.setLayoutY(posY);
        b.setText(texteBtn);
        b.setFont(new Font(police, taillePolice));
        b.setFont(Font.font(police, FontWeight.BOLD, FontPosture.REGULAR, taillePolice));
        b.setPrefSize(tailleBtnW, tailleBtnH);
        return b;
    }




}