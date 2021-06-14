package sample;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SatyanarayanaAnikethA7 extends Application {
    Label fnamelabel;
    Label getFname;
    Label getLname;
    Label getName;
    Label lnamelabel;
    Label phnolabel;
    Label getphno;
    Label gender;
    Label getGender;
    Label title;
    Label getTitle;
    Label getTitlea;
    Label uniname;
    Label getUniname;
    Label skills;
    Label getSkills;
    Label thanksmsg;
    Label congo;
    TextField fname;
    TextField lname;
    TextField phno;
    Button review;
    Button back;
    Button submit;
    RadioButton rbmale;
    RadioButton rbfemale;
    RadioButton rbother;
    ComboBox university;

    public static void main(String[] args) {
         launch(args);
    }
    public void start(Stage myStage) {      //Overriding the start method().
        ScrollPane pane1 = new ScrollPane();
        pane1.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        ScrollPane pane2 = new ScrollPane();
        pane2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        myStage.setTitle("New Grad Application");   //Giving the stage a title.
        GridPane gridPane = new GridPane(); //Setting size for the pane
        gridPane.setMinSize(400, 200); //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10)); //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);               //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);  //centering the controls.
        Scene myScene = new Scene(gridPane, 440, 730);

        uniname = new Label("University");      //label creation
        fnamelabel = new Label("First Name");
        lnamelabel = new Label("Last Name");
        phnolabel  = new Label("Phone number");
        gender = new Label("Gender");
        getphno= new Label();
        getGender = new Label();
        getFname = new Label();
        getLname= new Label();
        getName = new Label();
        getUniname = new Label();
        getSkills = new Label();
        thanksmsg = new Label("Thank you for applying. Please review your details");
        skills = new Label("Skills");
        title = new Label("Titles");
        getTitle = new Label();
        getTitlea = new Label("");
        congo = new Label("Congratulations! Application Sent.");
        review =  new Button("Review");
        back=new Button("< Back");
        submit = new Button("Submit");
        ToggleGroup group1 = new ToggleGroup();
        rbmale = new RadioButton("Male");
        rbfemale = new RadioButton("Female");
        rbother=new RadioButton("Other");
        rbmale.setToggleGroup(group1);
        rbfemale.setToggleGroup(group1);
        rbother.setToggleGroup(group1);
        fname=new TextField();
        fname.setPrefColumnCount(4);
        fname.setPromptText("Enter your first name");
        fname.setPrefSize(150,30);      //textfield dimension
        lname = new TextField();
        lname.setPromptText("Enter your last name");
        lname.setPrefSize(150,30);      //textfield dimension
        phno = new TextField();
        phno.setPrefSize(150,30);       //textfield dimension
        phno.setPromptText("Enter your phone number");
        university = new ComboBox(FXCollections.observableArrayList("Santa Clara University","San Jose State University","CSU LongBeach","CSU Fullerton","UT Dallas"));
        university.setEditable(true);
        university.setPrefSize(150,30);

        FlowPane reviewfp = new FlowPane(Orientation.VERTICAL);   //Flowpane for screen-2 i.e. after click of review button
        reviewfp.setAlignment(Pos.CENTER_LEFT);
        reviewfp.setVgap(5.00);
        reviewfp.setPadding(new Insets(0, 0, 0, 20));
        FlowPane submitfp = new FlowPane();                      //Flowpane for screen-3 .i.e. after click of submit button
        Scene scene2 = new Scene(reviewfp,440,730);        //Creating scene for the second screen.
        Scene scene3= new Scene(submitfp,440,730);          //creating scene for the third screen.

        ObservableList<String> titles = FXCollections.observableArrayList("Mr.", "Mrs.", "Dr.", "Ms.", "Master", "Madam", "Mx", "Sir");
        ListView<String> lvtitles = new ListView<>(titles);         //list view for titles
        lvtitles.setPrefSize(100, 60);
        lvtitles.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);  //single selection
        lvtitles.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> getTitle.setText(t1));
        pane1.setContent(lvtitles);                                   //add scrollpane to titles list view.
        if(lvtitles.getSelectionModel().getSelectedItems().isEmpty())  getTitle.setText("Select a title for"); //validation

        ObservableList<String>  skillsset = FXCollections.observableArrayList("Java" ,"Python","HTML","Javascript","ReactJS","C","AngularJS","Matlab","C++");
        ListView<String> lvskills = new ListView<>(skillsset);    //list view for skils
        lvskills.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //multiple selection
        lvskills.setPrefSize(100,60);
        lvskills.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) ->
        { ObservableList<String> selectedItems = lvskills.getSelectionModel().getSelectedItems();
        { StringBuilder builder = new StringBuilder("Skills selected are :");  //listener for skills selected with the display message
        for (String name : selectedItems) { builder.append(name).append("    ");}
        getSkills.setText(builder.toString());
        } });

        EventHandler<ActionEvent> event3 = actionEvent ->                 //event handler for the review button
        { thanksmsg.setText("Thank you for applying. Please review your details");
        if(lvskills.getSelectionModel().getSelectedItems().isEmpty())     //input validation for skills list view .
        { getSkills.setText("Please select one or more skills.");         //error message
        submit.setDisable(true);                                          //submit button disabled.
        } else submit.setDisable(false);                                  //submit button enabled.

        if(fname.getText().equals("") || lname.getText().equals("")) { submit.setDisable(true);  //input validation for first name and last name fileds.
             getName.setText("Filed is empty. Enter both your first name and last name"); }
        else { if (!fname.getText().matches("[a-zA-z]+") || !lname.getText().matches("[a-zA-Z]+")) //regex check for non-alphabetic characters.
            getName.setText("Please enter only letters for first name and last name");
        //input validation for first and last name fields-error message is diplayed and submit button is disabled for blank or incorrect input format.
        else {
            submit.setDisable(false);              //submit button enabled.
            getFname.setText(fname.getText());
            getLname.setText(lname.getText());
            //to display title + first name + last name
            getName.setText(getTitle.getText() + " " + getFname.getText() + " " + getLname.getText());
        }}
        if (phno.getText().equals("")) {        //input validation for ph no field
            submit.setDisable(true);            //disabling the submit button until proper entry is made.
            getphno.setText("Phone number field is empty. Enter your phone number.");} //error message
        else if (phno.getText().matches("(\\d{10})")) {    //regex check for 10 numeric characters.
            getphno.setText("Phone number : " + phno.getText());  //validation for phno field
            submit.setDisable(false); }
        else {
            getphno.setText("Enter 10 digits for phone number."); //error message
            submit.setDisable(true);}
        if (university.getValue() == null)  {           //university selection
            getUniname.setText("Select a University. "); //error message and validation if no university is selected.
        submit.setDisable(true); }
        else {
            getUniname.setText("University : " + university.getValue());
            submit.setDisable(false); }
        if (rbmale.isSelected()) getGender.setText("Gender : Male"); //gender selection -male
        else if (rbfemale.isSelected()) getGender.setText("Gender : Female"); //gender selection-female
        else if (rbother.isSelected()) getGender.setText("Gender : Other"); //gender selection-other
        else {getGender.setText("Please select a gender."); submit.setDisable(true);} //input validation if gender is not selected.
             myStage.setScene(scene2);                                 //set the scene on the stage.
        reviewfp.getChildren().addAll(back, thanksmsg,getTitlea,getName, getGender, getUniname, getphno, getSkills, submit); };
        review.setOnAction(event3);
        EventHandler<ActionEvent> eventback = actionEvent -> myStage.setScene(myScene); //event handler for back button
        back.setOnAction(eventback);

        EventHandler<ActionEvent> eventsubmit = actionEvent -> {     //eventhandler on click of submit button
            myStage.setScene(scene3);                                //set the scene on the stage
            submitfp.getChildren().addAll(congo);
            submitfp.setAlignment(Pos.CENTER);
            };
        submit.setOnAction(eventsubmit);
        myStage.setScene(myScene);
        Separator separator = new Separator();
        separator.setPrefWidth(200);
        gridPane.add(title, 0, 0);                          //adding to the gridpane using coordinates.
        gridPane.add(lvtitles, 0, 1);
        gridPane.add(fnamelabel, 0, 2);
        gridPane.add(fname, 0, 3);
        gridPane.add(gender, 0, 4);
        gridPane.add(rbmale, 0, 5);
        gridPane.add(rbfemale, 0, 6);
        gridPane.add(rbother, 0, 7);
        gridPane.add(uniname, 0, 8);
        gridPane.add(university, 0, 9);
        gridPane.add(skills, 0, 10);
        gridPane.add(lvskills, 0, 11);
        gridPane.add(review, 0, 12);
        gridPane.add(lnamelabel, 1, 2);
        gridPane.add(lname, 1, 3);
        gridPane.add(phnolabel, 1, 4);
        gridPane.add(phno, 1, 5);
        myStage.show();
        } }

        /*This program does not let the user to click submit until some of the required fields are filled. Eg: First Name,
        Last Name, Gender, PhNo, University etc.and displays appropriate error messages.
        Basic input validations for text field are handled. The ph no field accepts a 10-digit number sequence only.

        GridPane is used for  screen-1, followed by Flowpanes for the rest.

        This program is executed on this local machine/system and it is giving expected output. The project setup instructions
          as mentioned on https://openjfx.io/openjfx-docs/ are followed. (non-modular from IDE) */

