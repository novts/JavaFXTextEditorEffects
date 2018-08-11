package com.novts;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


public class JavaFXTextEditorEffects extends Application {
        
    StackPane stack;
    Stage primaryStage;
    
    VBox vboxR;
    
   Label lb;
    
    Slider sliderBloom;
    Slider sliderGlow;
    Slider sliderRadiusDShadow;
    Slider sliderSpreadDShadow;
    Slider sliderOffsetXDShadow;
     Slider sliderOffsetYDShadow;
    ChoiceBox<String> choiceD;
    ChoiceBox<String> choiceIn;
    Slider sliderRadiusInShadow;
    Slider sliderChokeInShadow;
    Slider sliderOffsetXInShadow;
    Slider sliderOffsetYInShadow;
    Slider  sliderWidthBBlur;
    Slider sliderHeightBBlur;
    Slider  sliderRadiusMBlur;
    Slider sliderAngleMBlur;
    Slider  sliderRadiusGBlur;
    Slider  sliderHueCA;
    Slider  sliderSaturationCA;      
    Slider  sliderBrightnessCA;  
    Slider  sliderContrastCA;  
    Slider  sliderllxPT; 
    Slider  sliderllyPT; 
    Slider  sliderlrxPT; 
    Slider  sliderlryPT; 
    Slider  sliderulxPT; 
    Slider  sliderulyPT; 
     Slider  sliderurxPT; 
    Slider  slideruryPT; 
     Slider  sliderST; 
    Slider slidertopOpacityRef;
    Slider sliderbottomOpacityRef;
    Slider slidertopOffsetRef;
    Slider sliderfractionRef;    
     Color cB=Color.WHITE;
    Color cT=Color.BLACK;
    String font_size="8pt";
    String font_fam="Georgia";
    String font_style="normal";
    String font_weight="normal";
    
    String text;

    WebView wv;
    Group stackG =new Group();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        primaryStage=stage;
        primaryStage.setTitle("JavaFXTextEditor");
         Group root = new Group();
         Scene scene = new Scene(root, 1300, 700, Color.WHITE);

        wv = new WebView();
        wv.getEngine().load("http://ru.novts.com/adspage");
        
         FileChooser fileChooser=new FileChooser();          
        fileChooser.setInitialDirectory(new java.io.File("C:/")); 
        fileChooser.setTitle("Select image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg, png, bmp, gif", "*.jpg", "*.png", "*.bmp", "*.gif"));
       
      vboxR = new VBox();
      vboxR.setPadding(new Insets(10));
      vboxR.setSpacing(10);
      vboxR.setLayoutX(920);
      vboxR.setLayoutY(0);     
           
        ScrollPane sp=new ScrollPane();
       sp.setPrefSize(350, 400);
      
       vboxR.getChildren().addAll(sp);
        
         VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,20));
        vbox.setSpacing(10);  
       
        sp.setContent(vbox);   
        //
         Bloom bloom=new Bloom();
        Label labelBloom=new Label("Bloom");
        sliderBloom=new Slider();
        sliderBloom.setValue(1.0);
        sliderBloom.setPrefWidth(300); 
        sliderBloom.setMin(0.0);
        sliderBloom.setMax(1.0);
        sliderBloom.setShowTickMarks(true);
        sliderBloom.setMajorTickUnit(0.1);
        sliderBloom.setShowTickLabels(true);
        sliderBloom.setMinorTickCount(3);        
        bloom.thresholdProperty().bind(sliderBloom.valueProperty());  
        vbox.getChildren().addAll(labelBloom, sliderBloom);
        
         Glow glow=new Glow();
        bloom.setInput(glow);
        Label labelGlow=new Label("Glow");
        sliderGlow=new Slider();
        sliderGlow.setValue(0);
        sliderGlow.setPrefWidth(300); 
        sliderGlow.setMin(0.0);
        sliderGlow.setMax(1.0);
        sliderGlow.setShowTickMarks(true);
        sliderGlow.setMajorTickUnit(0.1);
        sliderGlow.setShowTickLabels(true);
        sliderGlow.setMinorTickCount(3);        
        glow.levelProperty().bind(sliderGlow.valueProperty());  
        vbox.getChildren().addAll(labelGlow, sliderGlow);
        
        DropShadow dshadow=new DropShadow();
       glow.setInput(dshadow);
        CheckBox labelDropShadow=new CheckBox("DropShadow");
       labelDropShadow.selectedProperty().addListener(
               (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val)-> {
    if(new_val==true){        
       lb.setMaxWidth(640);
       lb.setMaxHeight(480);
       dshadow.radiusProperty().bind(sliderRadiusDShadow.valueProperty());  
       dshadow.spreadProperty().bind(sliderSpreadDShadow.valueProperty());  
       dshadow.offsetXProperty().bind(sliderOffsetXDShadow.valueProperty());  
       dshadow.offsetYProperty().bind(sliderOffsetYDShadow.valueProperty());      
    }else{       
       lb.setMaxWidth(800);
      lb.setMaxHeight(600);      
        sliderRadiusDShadow.setValue(0);
       sliderSpreadDShadow.setValue(0.0);
       sliderOffsetXDShadow.setValue(0.0);
       sliderOffsetYDShadow.setValue(0.0);
       choiceD.getSelectionModel().selectFirst();  
       dshadow.radiusProperty().unbind();  
       dshadow.spreadProperty().unbind();  
       dshadow.offsetXProperty().unbind();  
       dshadow.offsetYProperty().unbind();       
    }
  });

        ScrollPane spDSh=new ScrollPane();
        spDSh.setPrefSize(300, 100);        
         VBox vboxDSh = new VBox();
        vboxDSh.setPadding(new Insets(10,10,10,20));
        vboxDSh.setSpacing(10);         
        spDSh.setContent(vboxDSh);   
        Label labelRadiusDShadow=new Label("Radius");
        sliderRadiusDShadow=new Slider();
        sliderRadiusDShadow.setValue(0);
        sliderRadiusDShadow.setPrefWidth(250); 
        sliderRadiusDShadow.setMin(0.0);
        sliderRadiusDShadow.setMax(127.0);
        sliderRadiusDShadow.setShowTickMarks(true);
        sliderRadiusDShadow.setMajorTickUnit(10);
        sliderRadiusDShadow.setShowTickLabels(true);
        sliderRadiusDShadow.setMinorTickCount(3); 
      
       Label labelSpreadDShadow=new Label("Spread");
        sliderSpreadDShadow=new Slider();
        sliderSpreadDShadow.setValue(0.0);
        sliderSpreadDShadow.setPrefWidth(250); 
        sliderSpreadDShadow.setMin(0.0);
        sliderSpreadDShadow.setMax(1.0);
        sliderSpreadDShadow.setShowTickMarks(true);
        sliderSpreadDShadow.setMajorTickUnit(0.1);
        sliderSpreadDShadow.setShowTickLabels(true);
        sliderSpreadDShadow.setMinorTickCount(3); 
       
        Label labelOffsetXDShadow=new Label("The shift of the axis Х");
        sliderOffsetXDShadow=new Slider();
        sliderOffsetXDShadow.setValue(0.0);
        sliderOffsetXDShadow.setPrefWidth(250); 
        sliderOffsetXDShadow.setMin(0.0);
        sliderOffsetXDShadow.setMax(50.0);
        sliderOffsetXDShadow.setShowTickMarks(true);
        sliderOffsetXDShadow.setMajorTickUnit(5);
        sliderOffsetXDShadow.setShowTickLabels(true);
        sliderOffsetXDShadow.setMinorTickCount(3); 
       
       Label labelOffsetYDShadow=new Label("The shift of the axis Y");
        sliderOffsetYDShadow=new Slider();
        sliderOffsetYDShadow.setValue(0.0);
        sliderOffsetYDShadow.setPrefWidth(250); 
        sliderOffsetYDShadow.setMin(0.0);
        sliderOffsetYDShadow.setMax(50.0);
        sliderOffsetYDShadow.setShowTickMarks(true);
        sliderOffsetYDShadow.setMajorTickUnit(5);
        sliderOffsetYDShadow.setShowTickLabels(true);
        sliderOffsetYDShadow.setMinorTickCount(3); 
        if(labelDropShadow.selectedProperty().getValue()==true){            
       dshadow.radiusProperty().bind(sliderRadiusDShadow.valueProperty());  
       dshadow.spreadProperty().bind(sliderSpreadDShadow.valueProperty());  
       dshadow.offsetXProperty().bind(sliderOffsetXDShadow.valueProperty());  
       dshadow.offsetYProperty().bind(sliderOffsetYDShadow.valueProperty()); 
        }
       Label labelColorDShadow=new Label("Shadow color");
       ObservableList<String> color = FXCollections.observableArrayList(
       "BLACK","ALICEBLUE","ANTIQUEWHITE","AQUA","AQUAMARINE","AZURE","BEIGE","BISQUE","BLANCHEDALMOND",
       "BLUE", "BLUEVIOLET", "BROWN", "BURLYWOOD", "CADETBLUE","CHARTREUSE", "CHOCOLATE", "CORAL","CORNFLOWERBLUE",
       "CORNSILK","CRIMSON","CYAN","DARKBLUE","DARKCYAN","DARKGOLDENROD","DARKGRAY","DARKGREEN","DARKGREY",
       "DARKKHAKI","DARKMAGENTA","DARKOLIVEGREEN","DARKORANGE","DARKORCHID","DARKRED","DARKSALMON",
       "DARKSEAGREEN","DARKSLATEBLUE","DARKSLATEGRAY","DARKSLATEGREY","DARKTURQUOISE","DARKVIOLET","DEEPPINK",
       "DEEPSKYBLUE","DIMGRAY","DIMGREY","DODGERBLUE","FIREBRICK","FLORALWHITE","FORESTGREEN","FUCHSIA",
       "GAINSBORO","GHOSTWHITE","GOLD","GOLDENROD","GRAY","GREEN","GREENYELLOW","GREY","HONEYDEW","HOTPINK",
       "INDIANRED","INDIGO","IVORY","KHAKI","LAVENDER","LAVENDERBLUSH","LAWNGREEN","LEMONCHIFFON","LIGHTBLUE",
       "LIGHTCORAL","LIGHTCYAN","LIGHTGOLDENRODYELLOW","LIGHTGRAY","LIGHTGREEN","LIGHTGREY","LIGHTPINK","LIGHTSALMON",
       "LIGHTSEAGREEN","LIGHTSKYBLUE","LIGHTSLATEGRAY","LIGHTSLATEGREY","LIGHTSTEELBLUE","LIGHTYELLOW","LIME",
       "LIMEGREEN","LINEN","MAGENTA","MAROON","MEDIUMAQUAMARINE","MEDIUMBLUE","MEDIUMORCHID","MEDIUMPURPLE",
       "MEDIUMSEAGREEN","MEDIUMSLATEBLUE","MEDIUMSPRINGGREEN","MEDIUMTURQUOISE","MEDIUMVIOLETRED","MIDNIGHTBLUE",
       "MINTCREAM","MISTYROSE","MOCCASIN","NAVAJOWHITE","NAVY","OLDLACE","OLIVE","OLIVEDRAB","ORANGE","ORANGERED",
       "ORCHID","PALEGOLDENROD","PALEGREEN","PALETURQUOISE","PALEVIOLETRED","PAPAYAWHIP","PEACHPUFF","PERU",
       "PINK","PLUM","POWDERBLUE","PURPLE","RED","ROSYBROWN","ROYALBLUE","SADDLEBROWN","SALMON","SANDYBROWN","SEAGREEN",
       "SEASHELL","SIENNA","SILVER","SKYBLUE","SLATEBLUE","SLATEGRAY","SLATEGREY","SNOW","SPRINGGREEN","STEELBLUE",
       "TAN","TEAL","THISTLE","TOMATO","TURQUOISE"," VIOLET","WHEAT","WHITE","WHITESMOKE","YELLOW","YELLOWGREEN");
        choiceD = new ChoiceBox<String>(color); 
choiceD.getSelectionModel().selectFirst();    
choiceD.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
        dshadow.setColor(Color.web((newValue)));
    }
);

       
        vboxDSh.getChildren().addAll(labelRadiusDShadow, sliderRadiusDShadow, labelSpreadDShadow, sliderSpreadDShadow, labelOffsetXDShadow, sliderOffsetXDShadow,labelOffsetYDShadow, sliderOffsetYDShadow, labelColorDShadow, choiceD);
         vbox.getChildren().addAll(labelDropShadow, spDSh);
         
      InnerShadow inshadow=new InnerShadow();
      dshadow.setInput(inshadow);     
        Label labelInnerShadow=new Label("InnerShadow");
       
        ScrollPane spInSh=new ScrollPane();
        spInSh.setPrefSize(300, 100);        
         VBox vboxInSh = new VBox();
        vboxInSh.setPadding(new Insets(10,10,10,20));
        vboxInSh.setSpacing(10);         
        spInSh.setContent(vboxInSh);   
        Label labelRadiusInShadow=new Label("Radius");
        sliderRadiusInShadow=new Slider();
        sliderRadiusInShadow.setValue(0);
        sliderRadiusInShadow.setPrefWidth(250); 
        sliderRadiusInShadow.setMin(0.0);
        sliderRadiusInShadow.setMax(127.0);
        sliderRadiusInShadow.setShowTickMarks(true);
        sliderRadiusInShadow.setMajorTickUnit(10);
        sliderRadiusInShadow.setShowTickLabels(true);
        sliderRadiusInShadow.setMinorTickCount(3); 
      
       Label labelChokeInShadow=new Label("Choke");
        sliderChokeInShadow=new Slider();
        sliderChokeInShadow.setValue(0.0);
        sliderChokeInShadow.setPrefWidth(250); 
        sliderChokeInShadow.setMin(0.0);
        sliderChokeInShadow.setMax(1.0);
        sliderChokeInShadow.setShowTickMarks(true);
        sliderChokeInShadow.setMajorTickUnit(0.1);
        sliderChokeInShadow.setShowTickLabels(true);
        sliderChokeInShadow.setMinorTickCount(3); 
       
        Label labelOffsetXInShadow=new Label("The shift of the axis Х");
        sliderOffsetXInShadow=new Slider();
        sliderOffsetXInShadow.setValue(0.0);
        sliderOffsetXInShadow.setPrefWidth(250); 
        sliderOffsetXInShadow.setMin(0.0);
        sliderOffsetXInShadow.setMax(50.0);
        sliderOffsetXInShadow.setShowTickMarks(true);
        sliderOffsetXInShadow.setMajorTickUnit(5);
        sliderOffsetXInShadow.setShowTickLabels(true);
        sliderOffsetXInShadow.setMinorTickCount(3); 
       
       Label labelOffsetYInShadow=new Label("The shift of the axis Y");
        sliderOffsetYInShadow=new Slider();
        sliderOffsetYInShadow.setValue(0.0);
        sliderOffsetYInShadow.setPrefWidth(250); 
        sliderOffsetYInShadow.setMin(0.0);
        sliderOffsetYInShadow.setMax(50.0);
        sliderOffsetYInShadow.setShowTickMarks(true);
        sliderOffsetYInShadow.setMajorTickUnit(5);
        sliderOffsetYInShadow.setShowTickLabels(true);
        sliderOffsetYInShadow.setMinorTickCount(3); 
                 
      inshadow.radiusProperty().bind(sliderRadiusInShadow.valueProperty());  
     inshadow.chokeProperty().bind(sliderChokeInShadow.valueProperty());  
      inshadow.offsetXProperty().bind(sliderOffsetXInShadow.valueProperty());  
     inshadow.offsetYProperty().bind(sliderOffsetYInShadow.valueProperty()); 
        
       Label labelColorInShadow=new Label("Shadow color");       
        choiceIn = new ChoiceBox<String>(color); 
choiceIn.getSelectionModel().selectFirst();    
choiceIn.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue<? extends String> ov, String old_val, String new_val)-> {
    inshadow.setColor(Color.web(new_val));
       });

       
        vboxInSh.getChildren().addAll(labelRadiusInShadow, sliderRadiusInShadow, labelChokeInShadow, sliderChokeInShadow, labelOffsetXInShadow, sliderOffsetXInShadow,labelOffsetYInShadow, sliderOffsetYInShadow, labelColorInShadow, choiceIn);
         vbox.getChildren().addAll(labelInnerShadow, spInSh); 
         
        BoxBlur bblur = new BoxBlur();
        inshadow.setInput(bblur); 
        ScrollPane spBBlur=new ScrollPane();
        spBBlur.setPrefSize(300, 100);        
         VBox vboxBBlur = new VBox();
        vboxBBlur.setPadding(new Insets(10,10,10,20));
        vboxBBlur.setSpacing(10);         
        spBBlur.setContent(vboxBBlur);   
        Label labelBBlur=new Label("BoxBlur");
        Label labelWidthBBlur=new Label("The width of the blur");
        sliderWidthBBlur=new Slider();
        sliderWidthBBlur.setValue(0.0);
        sliderWidthBBlur.setPrefWidth(250); 
        sliderWidthBBlur.setMin(0.0);
        sliderWidthBBlur.setMax(50.0);
        sliderWidthBBlur.setShowTickMarks(true);
        sliderWidthBBlur.setMajorTickUnit(5);
        sliderWidthBBlur.setShowTickLabels(true);
        sliderWidthBBlur.setMinorTickCount(3); 
       
       Label labelHeightBBlur=new Label("The height of the blur");
        sliderHeightBBlur=new Slider();
        sliderHeightBBlur.setValue(0.0);
        sliderHeightBBlur.setPrefWidth(250); 
        sliderHeightBBlur.setMin(0.0);
        sliderHeightBBlur.setMax(50.0);
        sliderHeightBBlur.setShowTickMarks(true);
        sliderHeightBBlur.setMajorTickUnit(5);
        sliderHeightBBlur.setShowTickLabels(true);
        sliderHeightBBlur.setMinorTickCount(3); 
        
        bblur.heightProperty().bind(sliderHeightBBlur.valueProperty());  
         bblur.widthProperty().bind(sliderWidthBBlur.valueProperty());  
         vboxBBlur.getChildren().addAll(labelWidthBBlur,   sliderWidthBBlur, labelHeightBBlur,  sliderHeightBBlur);
         vbox.getChildren().addAll(labelBBlur, spBBlur); 
         
       MotionBlur mblur = new MotionBlur();
       bblur.setInput(mblur); 
        ScrollPane spMBlur=new ScrollPane();
        spMBlur.setPrefSize(300, 100);        
         VBox vboxMBlur = new VBox();
        vboxMBlur.setPadding(new Insets(10,10,10,20));
        vboxMBlur.setSpacing(10);         
        spMBlur.setContent(vboxMBlur);   
        Label labelMBlur=new Label("MotionBlur");
        Label labelRadiusMBlur=new Label("Blur radius");
        sliderRadiusMBlur=new Slider();
        sliderRadiusMBlur.setValue(0.0);
        sliderRadiusMBlur.setPrefWidth(250); 
        sliderRadiusMBlur.setMin(0.0);
        sliderRadiusMBlur.setMax(63.0);
        sliderRadiusMBlur.setShowTickMarks(true);
        sliderRadiusMBlur.setMajorTickUnit(5);
        sliderRadiusMBlur.setShowTickLabels(true);
       sliderRadiusMBlur.setMinorTickCount(3); 
       
       Label labelAngleMBlur=new Label("The angle of the blur");
        sliderAngleMBlur=new Slider();
        sliderAngleMBlur.setValue(0.0);
        sliderAngleMBlur.setPrefWidth(250); 
        sliderAngleMBlur.setMin(0.0);
        sliderAngleMBlur.setMax(180.0);
        sliderAngleMBlur.setShowTickMarks(true);
        sliderAngleMBlur.setMajorTickUnit(10);
        sliderAngleMBlur.setShowTickLabels(true);
        sliderAngleMBlur.setMinorTickCount(5); 
        
        mblur.radiusProperty().bind(sliderRadiusMBlur.valueProperty());  
         mblur.angleProperty().bind(sliderAngleMBlur.valueProperty());  
         vboxMBlur.getChildren().addAll(labelRadiusMBlur,   sliderRadiusMBlur,labelAngleMBlur,   sliderAngleMBlur);
         vbox.getChildren().addAll(labelMBlur, spMBlur); 
         
        GaussianBlur gblur = new GaussianBlur();
         mblur.setInput(gblur); 
        Label labelGBlur=new Label("GaussianBlur");      
        sliderRadiusGBlur=new Slider();
        sliderRadiusGBlur.setValue(0.0);
        sliderRadiusGBlur.setPrefWidth(250); 
        sliderRadiusGBlur.setMin(0.0);
        sliderRadiusGBlur.setMax(63.0);
        sliderRadiusGBlur.setShowTickMarks(true);
        sliderRadiusGBlur.setMajorTickUnit(5);
        sliderRadiusGBlur.setShowTickLabels(true);
       sliderRadiusGBlur.setMinorTickCount(3);    
      gblur.radiusProperty().bind(sliderRadiusGBlur.valueProperty());  
      vbox.getChildren().addAll(labelGBlur, sliderRadiusGBlur);
      
      SepiaTone st = new SepiaTone();
     gblur.setInput(st);
      Label labelST=new Label("SepiaTone");      
        sliderST=new Slider();
        sliderST.setValue(0.0);
        sliderST.setPrefWidth(250); 
        sliderST.setMin(0.0);
        sliderST.setMax(1.0);
        sliderST.setShowTickMarks(true);
        sliderST.setMajorTickUnit(0.1);
        sliderST.setShowTickLabels(true);
       sliderST.setMinorTickCount(3);    
      st.levelProperty().bind(sliderST.valueProperty());  
      vbox.getChildren().addAll(labelST, sliderST);
      
        ColorAdjust colorAdjust = new ColorAdjust();
       st.setInput(colorAdjust); 
       ScrollPane spCA=new ScrollPane();
       spCA.setPrefSize(300, 100);        
       VBox vboxCA = new VBox();
       vboxCA.setPadding(new Insets(10,10,10,20));
       vboxCA.setSpacing(10);         
       spCA.setContent(vboxCA);   
       Label labelCA=new Label("ColorAdjust");
        Label labelHueCA=new Label("Hue");
        sliderHueCA=new Slider();
        sliderHueCA.setValue(0.0);
        sliderHueCA.setPrefWidth(250); 
        sliderHueCA.setMin(-1.0);
        sliderHueCA.setMax(1.0);
        sliderHueCA.setShowTickMarks(true);
        sliderHueCA.setMajorTickUnit(0.1);
        sliderHueCA.setShowTickLabels(true);
        sliderHueCA.setMinorTickCount(3); 
       
       Label labelSaturationCA=new Label("Saturation");
        sliderSaturationCA=new Slider();
        sliderSaturationCA.setValue(0.0);
        sliderSaturationCA.setPrefWidth(250); 
        sliderSaturationCA.setMin(-1.0);
        sliderSaturationCA.setMax(1.0);
        sliderSaturationCA.setShowTickMarks(true);
        sliderSaturationCA.setMajorTickUnit(0.1);
        sliderSaturationCA.setShowTickLabels(true);
        sliderSaturationCA.setMinorTickCount(3); 
        
        Label labelBrightnessCA=new Label("Brightness");
        sliderBrightnessCA=new Slider();
        sliderBrightnessCA.setValue(0.0);
        sliderBrightnessCA.setPrefWidth(250); 
        sliderBrightnessCA.setMin(-1.0);
        sliderBrightnessCA.setMax(1.0);
        sliderBrightnessCA.setShowTickMarks(true);
        sliderBrightnessCA.setMajorTickUnit(0.1);
        sliderBrightnessCA.setShowTickLabels(true);
        sliderBrightnessCA.setMinorTickCount(3); 
        
         Label labelContrastCA=new Label("Contrast");
        sliderContrastCA=new Slider();
        sliderContrastCA.setValue(0.0);
        sliderContrastCA.setPrefWidth(250); 
        sliderContrastCA.setMin(-1.0);
        sliderContrastCA.setMax(1.0);
        sliderContrastCA.setShowTickMarks(true);
        sliderContrastCA.setMajorTickUnit(0.1);
        sliderContrastCA.setShowTickLabels(true);
        sliderContrastCA.setMinorTickCount(3); 
        
        colorAdjust.hueProperty().bind( sliderHueCA.valueProperty());  
        colorAdjust.saturationProperty().bind(sliderSaturationCA.valueProperty());  
         colorAdjust.brightnessProperty().bind(sliderBrightnessCA.valueProperty()); 
          colorAdjust.contrastProperty().bind(sliderContrastCA.valueProperty()); 
        vboxCA.getChildren().addAll(labelHueCA,  sliderHueCA,labelSaturationCA,  sliderSaturationCA,labelBrightnessCA,  sliderBrightnessCA, labelContrastCA,  sliderContrastCA);
        vbox.getChildren().addAll(labelCA, spCA); 
        
     PerspectiveTransform pt = new PerspectiveTransform();
     
       ScrollPane spPT=new ScrollPane();
       spPT.setPrefSize(300, 100);        
       VBox vboxPT = new VBox();
       vboxPT.setPadding(new Insets(10,10,10,20));
       vboxPT.setSpacing(10);         
       spPT.setContent(vboxPT);   
       CheckBox  labelPT=new CheckBox ("Perspective");    
      
        Label labelllxPT=new Label("Lower left corner of the axis Х");
        sliderllxPT=new Slider();
        sliderllxPT.setValue(0.0);
        sliderllxPT.setPrefWidth(250); 
        sliderllxPT.setMin(0.0);
        sliderllxPT.setMax(50.0);
        sliderllxPT.setShowTickMarks(true);
        sliderllxPT.setMajorTickUnit(5);
        sliderllxPT.setShowTickLabels(true);
        sliderllxPT.setMinorTickCount(3); 
       
       Label labelllyPT=new Label("Lower left corner of the axis Y");
        sliderllyPT=new Slider();
        sliderllyPT.setValue(0.0);
        sliderllyPT.setPrefWidth(250); 
        sliderllyPT.setMin(0.0);
        sliderllyPT.setMax(50.0);
        sliderllyPT.setShowTickMarks(true);
        sliderllyPT.setMajorTickUnit(5);
        sliderllyPT.setShowTickLabels(true);
        sliderllyPT.setMinorTickCount(3); 
        
        Label labellrxPT=new Label("Lower right corner of the axis Х");
        sliderlrxPT=new Slider();
        sliderlrxPT.setValue(0.0);
        sliderlrxPT.setPrefWidth(250); 
        sliderlrxPT.setMin(0.0);
        sliderlrxPT.setMax(50.0);
        sliderlrxPT.setShowTickMarks(true);
        sliderlrxPT.setMajorTickUnit(5);
        sliderlrxPT.setShowTickLabels(true);
        sliderlrxPT.setMinorTickCount(3); 
        
        Label labellryPT=new Label("Lower right corner of the axis Y");
        sliderlryPT=new Slider();
        sliderlryPT.setValue(0.0);
        sliderlryPT.setPrefWidth(250); 
        sliderlryPT.setMin(0.0);
        sliderlryPT.setMax(50.0);
        sliderlryPT.setShowTickMarks(true);
        sliderlryPT.setMajorTickUnit(5);
        sliderlryPT.setShowTickLabels(true);
        sliderlryPT.setMinorTickCount(3); 
        
        Label labelulxPT=new Label("Upper left corner of the axis Х");
        sliderulxPT=new Slider();
        sliderulxPT.setValue(0.0);
        sliderulxPT.setPrefWidth(250); 
        sliderulxPT.setMin(0.0);
        sliderulxPT.setMax(50.0);
        sliderulxPT.setShowTickMarks(true);
        sliderulxPT.setMajorTickUnit(5);
        sliderulxPT.setShowTickLabels(true);
        sliderulxPT.setMinorTickCount(3); 
        
        Label labelulyPT=new Label("Upper left corner of the axis Y");
        sliderulyPT=new Slider();
        sliderulyPT.setValue(0.0);
        sliderulyPT.setPrefWidth(250); 
        sliderulyPT.setMin(0.0);
        sliderulyPT.setMax(50.0);
        sliderulyPT.setShowTickMarks(true);
        sliderulyPT.setMajorTickUnit(5);
        sliderulyPT.setShowTickLabels(true);
        sliderulyPT.setMinorTickCount(3); 
        
        Label labelurxPT=new Label("Upper right corner on the axis X");
        sliderurxPT=new Slider();
        sliderurxPT.setValue(0.0);
        sliderurxPT.setPrefWidth(250); 
        sliderurxPT.setMin(0.0);
        sliderurxPT.setMax(50.0);
        sliderurxPT.setShowTickMarks(true);
        sliderurxPT.setMajorTickUnit(5);
        sliderurxPT.setShowTickLabels(true);
        sliderurxPT.setMinorTickCount(3); 
        
         Label labeluryPT=new Label("Upper right corner on the axis Y");
        slideruryPT=new Slider();
        slideruryPT.setValue(0.0);
        slideruryPT.setPrefWidth(250); 
        slideruryPT.setMin(0.0);
        slideruryPT.setMax(50.0);
        slideruryPT.setShowTickMarks(true);
        slideruryPT.setMajorTickUnit(5);
        slideruryPT.setShowTickLabels(true);
        slideruryPT.setMinorTickCount(3);         
     
        vboxPT.getChildren().addAll(labelllxPT,  sliderllxPT,labelllyPT,  sliderllyPT,labellrxPT,  sliderlrxPT, labellryPT,  sliderlryPT,labelulxPT,  sliderulxPT, labelulyPT,  sliderulyPT, labelurxPT,  sliderurxPT, labeluryPT,  slideruryPT);
        vbox.getChildren().addAll(labelPT, spPT); 
        
         Reflection reflection = new Reflection();
        ScrollPane spRef=new ScrollPane();
       spRef.setPrefSize(300, 100);        
       VBox vboxRef = new VBox();
       vboxRef.setPadding(new Insets(10,10,10,20));
       vboxRef.setSpacing(10);         
       spRef.setContent(vboxRef);   
       CheckBox  labelRef=new CheckBox ("Reflection");    
      
        Label labeltopOpacityRef =new Label("Transparency of the top of the reflection");
        slidertopOpacityRef=new Slider();
        slidertopOpacityRef.setValue(0.0);
        slidertopOpacityRef.setPrefWidth(250); 
        slidertopOpacityRef.setMin(0.0);
        slidertopOpacityRef.setMax(1.0);
        slidertopOpacityRef.setShowTickMarks(true);
        slidertopOpacityRef.setMajorTickUnit(0.1);
        slidertopOpacityRef.setShowTickLabels(true);
        slidertopOpacityRef.setMinorTickCount(3); 
        
        Label labelbottomOpacityRef =new Label("Transparency of the lower edge of the reflection");
        sliderbottomOpacityRef =new Slider();
        sliderbottomOpacityRef.setValue(0.0);
        sliderbottomOpacityRef.setPrefWidth(250); 
        sliderbottomOpacityRef.setMin(0.0);
        sliderbottomOpacityRef.setMax(1.0);
        sliderbottomOpacityRef.setShowTickMarks(true);
        sliderbottomOpacityRef.setMajorTickUnit(0.1);
        sliderbottomOpacityRef.setShowTickLabels(true);
        sliderbottomOpacityRef.setMinorTickCount(3); 
        
        Label labeltopOffsetRef =new Label("The shift between the image and reflection");
        slidertopOffsetRef=new Slider();
        slidertopOffsetRef.setValue(0.0);
        slidertopOffsetRef.setPrefWidth(250); 
        slidertopOffsetRef.setMin(0.0);
        slidertopOffsetRef.setMax(50.0);
        slidertopOffsetRef.setShowTickMarks(true);
        slidertopOffsetRef.setMajorTickUnit(5);
        slidertopOffsetRef.setShowTickLabels(true);
        slidertopOffsetRef.setMinorTickCount(3); 
        
        Label labelfractionRef =new Label("Image share in reflection");
        sliderfractionRef=new Slider();
        sliderfractionRef.setValue(0.0);
        sliderfractionRef.setPrefWidth(250); 
        sliderfractionRef.setMin(0.0);
        sliderfractionRef.setMax(1.0);
        sliderfractionRef.setShowTickMarks(true);
        sliderfractionRef.setMajorTickUnit(0.1);
        sliderfractionRef.setShowTickLabels(true);
        sliderfractionRef.setMinorTickCount(3); 
        
       if(labelRef.selectedProperty().getValue()==true){ 
       if(labelPT.selectedProperty().getValue()==true){ 
           colorAdjust.setInput(null); 
            colorAdjust.setInput(reflection); 
          reflection.setInput(pt); 
       }  else{
            colorAdjust.setInput(null);   
           colorAdjust.setInput(reflection); 
       }       
       reflection.topOpacityProperty().bind( slidertopOpacityRef.valueProperty());  
       reflection.bottomOpacityProperty().bind( sliderbottomOpacityRef.valueProperty());
       reflection.topOffsetProperty().bind(  slidertopOffsetRef.valueProperty());
       reflection.fractionProperty().bind(  sliderfractionRef.valueProperty());
        }
            
 labelRef.selectedProperty().addListener(
         (ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val)-> {
    if(new_val==true){
         if(labelPT.selectedProperty().getValue()==true){ 
       lb.setMaxWidth(448);
       lb.setMaxHeight(336);
            colorAdjust.setInput(null); 
            colorAdjust.setInput(reflection); 
          reflection.setInput(pt); 
       }  else{
           colorAdjust.setInput(null);   
           colorAdjust.setInput(reflection); 
       lb.setMaxWidth(448);
       lb.setMaxHeight(336);
       }      
       
     reflection.topOpacityProperty().bind( slidertopOpacityRef.valueProperty());  
       reflection.bottomOpacityProperty().bind( sliderbottomOpacityRef.valueProperty());
       reflection.topOffsetProperty().bind(  slidertopOffsetRef.valueProperty());
       reflection.fractionProperty().bind(  sliderfractionRef.valueProperty());
    }else{
         if(labelPT.selectedProperty().getValue()==true){ 
           colorAdjust.setInput(null);   
          colorAdjust.setInput(pt); 
          lb.setMaxWidth(640);
        lb.setMaxHeight(480); 
       }  else{
           colorAdjust.setInput(null); 
        lb.setMaxWidth(800);
        lb.setMaxHeight(600);
       }      
       
sliderfractionRef.setValue(0.0);
slidertopOpacityRef.setValue(0.0);
sliderbottomOpacityRef.setValue(0.0);
slidertopOffsetRef.setValue(0.0); 
     reflection.topOpacityProperty().unbind();  
     reflection.bottomOpacityProperty().unbind();  
      reflection.topOffsetProperty().unbind();  
       reflection.fractionProperty().unbind(); 
    }
  });
        
        vboxRef.getChildren().addAll(labeltopOpacityRef, slidertopOpacityRef,labelbottomOpacityRef,  sliderbottomOpacityRef,labeltopOffsetRef, slidertopOffsetRef, labelfractionRef,  sliderfractionRef);
        vbox.getChildren().addAll(labelRef, spRef); 
         
        //        
         Button btnR= new Button();          
       
        btnR.setText("Reset");
        btnR.setStyle("-fx-font: bold 16pt Georgia;" );          
        btnR.setOnMouseClicked((MouseEvent event)-> {
      initR();
});
        
        Button btnS= new Button();        
        Label labelOP =new Label("Enter the text:");
        TextArea areaOp= new TextArea();
       areaOp.setPrefSize(250, 50);
       HBox hboxT=new HBox();
       hboxT.setSpacing(10);
       hboxT.getChildren().addAll(labelOP, areaOp);
       
        ColorPicker colorPickerB = new ColorPicker();
 colorPickerB.setOnAction((ActionEvent t)->{
         cB = colorPickerB.getValue();        
     }
 );
 colorPickerB.setValue(Color.WHITE);
 
  ColorPicker colorPickerT = new ColorPicker();
 colorPickerT.setOnAction((ActionEvent t)-> {
         cT = colorPickerT.getValue();        
     }
 );
 colorPickerT.setValue(Color.BLACK);
 
  ObservableList<String> fontSize = FXCollections.observableArrayList(
          "8pt","10pt","12pt","14pt","16pt","18pt","20pt","22pt","24pt","26pt","28pt","30pt",
          "32pt","34pt","36pt","38pt","40pt","42pt","44pt","46pt","48pt","50pt","52pt","54pt","56pt",
          "58pt","60pt","62pt","64pt","66pt","68pt","70pt","72pt","74pt","76pt","78pt","80pt"
          );
 ChoiceBox choiceFS = new ChoiceBox<String>(fontSize); 
choiceFS.getSelectionModel().selectFirst();    
choiceFS.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue observable, Object oldValue, Object newValue)-> {
   font_size=newValue.toString();
      });


  ObservableList<String> fontFamily = FXCollections.observableArrayList(
          "Georgia","Arial","Comic Sans MS","Impact","Lucida Console",
         "Tahoma","Times New Roman","Verdana","MS Serif"
          );
 ChoiceBox choiceFF = new ChoiceBox<String>(fontFamily); 
choiceFF.getSelectionModel().selectFirst();    
choiceFF.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue observable, Object oldValue, Object newValue)-> {
   font_fam=newValue.toString();
       });

ObservableList<String> fontStyle = FXCollections.observableArrayList(
          "normal","italic"
          );
 ChoiceBox choiceFSt = new ChoiceBox<String>(fontStyle); 
choiceFSt.getSelectionModel().selectFirst();    
choiceFSt.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue observable, Object oldValue, Object newValue)-> {
   font_style=newValue.toString();
       });

ObservableList<String> fontWeight = FXCollections.observableArrayList(
          "normal","bold"
          );
 ChoiceBox choiceFW = new ChoiceBox<String>(fontWeight); 
choiceFW.getSelectionModel().selectFirst();    
choiceFW.getSelectionModel().selectedItemProperty().addListener(
        (ObservableValue observable, Object oldValue, Object newValue)-> {
   font_weight=newValue.toString();
       });
 
  HBox hboxCB=new HBox();
       hboxCB.setSpacing(10);
       hboxCB.getChildren().addAll(colorPickerB,new Label(":Background color"),choiceFS,new Label(":Font size"));
       
 HBox hboxCT=new HBox();
       hboxCT.setSpacing(10);
       hboxCT.getChildren().addAll(colorPickerT,new Label(":Text color"),choiceFF,new Label(":Font") );
       
HBox hboxF=new HBox();
       hboxF.setSpacing(10);
       hboxF.getChildren().addAll(choiceFSt,new Label(":Text style"),choiceFW,new Label(":Font width") );       
              
        Button btnOp= new Button(); 
       HBox hboxB=new HBox();
       hboxB.setSpacing(10);
       hboxB.getChildren().addAll(btnOp,btnR, btnS);
       vboxR.getChildren().addAll(hboxT,hboxCB,hboxCT, hboxF,hboxB);    
        
        btnOp.setText("Download");
        btnOp.setStyle("-fx-font: bold 16pt Georgia;" );         
        btnOp.setOnMouseClicked((MouseEvent event)-> {
                try { 
        text=areaOp.getText();
        lb=new Label(text);
        lb.setWrapText(true);
        lb.setMaxSize(800,600);
        String colorB=cB.toString();
        colorB=colorB.replace("0x", "#");
        String colorT=cT.toString();
        colorT=colorT.replace("0x", "#");
        lb.setStyle("-fx-font-weight:"+font_weight+";-fx-font-style:"+font_style+";-fx-font-family:"+font_fam+";-fx-font-size:"+font_size+";-fx-background-color:"+colorB+";-fx-text-fill:"+colorT+"; -fx-padding: 25px;" );
        lb.setEffect(bloom);
        stack = new StackPane();         
        stack.getChildren().add(lb);       
        stack.setPadding(new Insets(5,5,5,5));        
        stack.setLayoutX(5);
                    stack.setLayoutX(5);
                    stack.setLayoutY(110);

                    wv.setPrefHeight(100);
        
         if(labelDropShadow.selectedProperty().getValue()==true){ 
        lb.setMaxWidth(640);
       lb.setMaxHeight(480); 
        dshadow.radiusProperty().bind(sliderRadiusDShadow.valueProperty());  
       dshadow.spreadProperty().bind(sliderSpreadDShadow.valueProperty());  
       dshadow.offsetXProperty().bind(sliderOffsetXDShadow.valueProperty());  
       dshadow.offsetYProperty().bind(sliderOffsetYDShadow.valueProperty()); 
         }
         
        if(labelPT.selectedProperty().getValue()==true){ 
             if(labelRef.selectedProperty().getValue()==true){             
           reflection.setInput(pt); 
       }  else{
            colorAdjust.setInput(pt);
        lb.setMaxWidth(640);
        lb.setMaxHeight(480); 
       }          
      
       pt.lrxProperty().bind( sliderlrxPT.valueProperty().add(lb.layoutXProperty()).add(lb.widthProperty()));     
       pt.urxProperty().bind( sliderurxPT.valueProperty().add(lb.layoutXProperty()).add(lb.widthProperty()));     
           pt.llyProperty().bind( sliderllyPT.valueProperty().add(lb.layoutYProperty()).add(lb.heightProperty())); 
           pt.lryProperty().bind( sliderlryPT.valueProperty().add(lb.layoutYProperty()).add(lb.heightProperty()));       
     pt.llxProperty().bind( sliderllxPT.valueProperty().add(lb.layoutXProperty()));     
     pt.ulxProperty().bind( sliderulxPT.valueProperty().add(lb.layoutXProperty())); 
     pt.ulyProperty().bind( sliderulyPT.valueProperty().add(lb.layoutYProperty()));     
     pt.uryProperty().bind( slideruryPT.valueProperty().add(lb.layoutYProperty()));  
         }  
        
 if(labelRef.selectedProperty().getValue()==true){ 
       if(labelPT.selectedProperty().getValue()==true){ 
          colorAdjust.setInput(null); 
          colorAdjust.setInput(reflection); 
          reflection.setInput(pt); 
      lb.setMaxWidth(448);
        lb.setMaxHeight(336);
       }  else{
           colorAdjust.setInput(null); 
           colorAdjust.setInput(reflection); 
       lb.setMaxWidth(448);
       lb.setMaxHeight(336);
       }       
       reflection.topOpacityProperty().bind( slidertopOpacityRef.valueProperty());  
       reflection.bottomOpacityProperty().bind( sliderbottomOpacityRef.valueProperty());
       reflection.topOffsetProperty().bind(  slidertopOffsetRef.valueProperty());
       reflection.fractionProperty().bind(  sliderfractionRef.valueProperty());
        }        
         
       labelPT.selectedProperty().addListener(new ChangeListener<Boolean>() {
        public void changed(ObservableValue<? extends Boolean> ov,
            Boolean old_val, Boolean new_val) {
    if(new_val==true){
        if(labelRef.selectedProperty().getValue()==true){          
           reflection.setInput(pt); 
       }  else{
            colorAdjust.setInput(pt); 
        lb.setMaxWidth(640);
        lb.setMaxHeight(480);
       }       
       pt.lrxProperty().bind( sliderlrxPT.valueProperty().add(lb.layoutXProperty()).add(lb.widthProperty()));     
       pt.urxProperty().bind( sliderurxPT.valueProperty().add(lb.layoutXProperty()).add(lb.widthProperty()));      
           pt.llyProperty().bind( sliderllyPT.valueProperty().add(lb.layoutYProperty()).add(lb.heightProperty())); 
           pt.lryProperty().bind( sliderlryPT.valueProperty().add(lb.layoutYProperty()).add(lb.heightProperty()));       
     pt.llxProperty().bind( sliderllxPT.valueProperty().add(lb.layoutXProperty()));     
     pt.ulxProperty().bind( sliderulxPT.valueProperty().add(lb.layoutXProperty())); 
     pt.ulyProperty().bind( sliderulyPT.valueProperty().add(lb.layoutYProperty()));     
     pt.uryProperty().bind( slideruryPT.valueProperty().add(lb.layoutYProperty()));  
    }else{
         if(labelRef.selectedProperty().getValue()==true){ 
           reflection.setInput(null); 
       }  else{
            colorAdjust.setInput(null); 
        lb.setMaxWidth(800);
        lb.setMaxHeight(600);
       }      
       
      sliderllxPT.setValue(0.0);
   sliderllyPT.setValue(0.0);
    sliderlrxPT.setValue(0.0);
     sliderlryPT.setValue(0.0);
      sliderulxPT.setValue(0.0);
       sliderulyPT.setValue(0.0);
        sliderurxPT.setValue(0.0);
         slideruryPT.setValue(0.0);
        pt.llyProperty().unbind();  
         pt.lryProperty().unbind();  
       pt.lrxProperty().unbind();  
       pt.urxProperty().unbind(); 
       pt.llxProperty().unbind();
        pt.ulxProperty().unbind();
        pt.ulyProperty().unbind();
         pt.uryProperty().unbind();
    }
 } });
   
        root.getChildren().clear();
        root.getChildren().addAll(vboxR);
                    stackG.getChildren().clear();
                    stackG.getChildren().addAll(wv, stack) ;
                    root.getChildren().add(stackG);
       
        } catch (Exception ex) {                
                }
});
       
       
        btnS.setText("Save");
        btnS.setStyle("-fx-font: bold 16pt Georgia;" );          
        btnS.setOnMouseClicked((MouseEvent event)-> {
         
  root.getChildren().clear();
  Button btnSIn= new Button();
  btnSIn.setText("Save Image");
        btnSIn.setStyle("-fx-font: bold 16pt Georgia;" );
        btnSIn.setOnMouseClicked((MouseEvent e)-> {
    try {
        WritableImage wimg = stack.snapshot(new SnapshotParameters(), null);
        BufferedImage screenShot = SwingFXUtils.fromFXImage(wimg, null);
FileChooser fileChooserIn=new FileChooser();
fileChooserIn.setInitialDirectory(new java.io.File("C:/users"));
fileChooserIn.setTitle("Save Image");
fileChooserIn.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg, png, bmp, gif", "*.jpg", "*.png", "*.bmp", "*.gif"));
java.io.File file=fileChooserIn.showSaveDialog(primaryStage);
int extIndex=file.getPath().lastIndexOf(".");
String ext=file.getPath().substring(extIndex+1);
ImageIO.write(screenShot, ext, file);   
 root.getChildren().clear();
 stack.setPadding(new Insets(5,5,5,5));        
 stack.setLayoutX(5);
 stack.setLayoutY(110);
 root.getChildren().addAll(vboxR);
        stackG.getChildren().clear();
        stackG.getChildren().addAll(wv, stack);
        root.getChildren().add(stackG);
 
       } catch (Exception ex) {
                   
                }      
            });

Button btnB= new Button();  
btnB.setText("Back");
btnB.setStyle("-fx-font: bold 16pt Georgia;" );          
btnB.setOnMouseClicked((MouseEvent ev)-> {
   root.getChildren().clear();
stack.setPadding(new Insets(5,5,5,5));        
 stack.setLayoutX(5);
 stack.setLayoutY(110);
 root.getChildren().addAll(vboxR);
                stackG.getChildren().clear();
                stackG.getChildren().addAll(wv, stack);
                root.getChildren().add(stackG);
            });
      
VBox vboxIn=new VBox();
vboxIn.setPadding(new Insets(10));
vboxIn.setSpacing(30);
vboxIn.setLayoutX(1050);
vboxIn.setLayoutY(20);
vboxIn.getChildren().addAll(btnSIn,btnB) ;
 if((labelDropShadow.selectedProperty().getValue()==true)||(labelPT.selectedProperty().getValue()==true)||(labelRef.selectedProperty().getValue()==true)){
stack.setPadding(new Insets(50,200,150,50)); 
 }
  if(labelRef.selectedProperty().getValue()==true){
stack.setPadding(new Insets(50,200,300,50)); 
 }
stack.setLayoutX(5);
stack.setLayoutY(110);
            stackG.getChildren().clear();
            stackG.getChildren().addAll(wv, stack);
            root.getChildren().addAll(stackG, vboxIn);
});


        stackG.getChildren().addAll(wv) ;
        root.getChildren().addAll(stackG, vboxR);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void initR(){      
        sliderBloom.setValue(1.0);
       sliderGlow.setValue(0);
       sliderRadiusDShadow.setValue(0);
       sliderSpreadDShadow.setValue(0.0);
       sliderOffsetXDShadow.setValue(0.0);
       sliderOffsetYDShadow.setValue(0.0);
       choiceD.getSelectionModel().selectFirst(); 
        sliderRadiusInShadow.setValue(0);
       sliderChokeInShadow.setValue(0.0);
       sliderOffsetXInShadow.setValue(0.0);
       sliderOffsetYInShadow.setValue(0.0);
       choiceIn.getSelectionModel().selectFirst();  
        sliderWidthBBlur.setValue(0.0);
       sliderHeightBBlur.setValue(0.0);
        sliderRadiusMBlur.setValue(0.0);
         sliderAngleMBlur.setValue(0.0);
        sliderRadiusGBlur.setValue(0.0);  
         sliderHueCA.setValue(0.0);
 sliderSaturationCA.setValue(0.0);
 sliderBrightnessCA.setValue(0.0);
 sliderContrastCA.setValue(0.0);
  sliderllxPT.setValue(0.0);
   sliderllyPT.setValue(0.0);
    sliderlrxPT.setValue(0.0);
     sliderlryPT.setValue(0.0);
      sliderulxPT.setValue(0.0);
       sliderulyPT.setValue(0.0);
        sliderurxPT.setValue(0.0);
         slideruryPT.setValue(0.0);
          sliderST.setValue(0.0);
           sliderfractionRef.setValue(0.0);
            slidertopOpacityRef.setValue(0.0);
sliderbottomOpacityRef.setValue(0.0);
 slidertopOffsetRef.setValue(0.0);

    }
}
