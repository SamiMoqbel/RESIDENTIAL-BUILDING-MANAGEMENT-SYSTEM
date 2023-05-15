package com.example.database1;

import java.lang.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Controller {
    @FXML
    private TextField usernamelog;
    @FXML
    private TextField password;
    @FXML
    private Label warningLabel;
    @FXML
    private TextField signupconpass;
    @FXML
    private TextField signuppass;
    @FXML
    private TextField signupuser;
    @FXML
    private Label submitwar;
    @FXML
    private TextField signupname;
    @FXML
    private TextField signupemail;
    @FXML
    private TextField signupphone;
    @FXML
    private BorderPane bpane;
    @FXML
    private AnchorPane apane;
    @FXML
    private Label updname;
    @FXML
    private Label updemail;
    @FXML
    private Label updphone;
    @FXML
    private Label updudegree;
    @FXML
    private TextField updusername;
    @FXML
    private VBox vpane;
    @FXML
    private Button updatestat;
    @FXML
    private HBox hpane;
    @FXML
    private TextField newname;
    @FXML
    private TextField newemail;
    @FXML
    private TextField newphone;
    @FXML
    private TextField newdegree;
    @FXML
    private TextField addusername;
    @FXML
    private TextField addemail;
    @FXML
    private TextField addname;
    @FXML
    private TextField addphone;
    @FXML
    private TextField addpass;
    @FXML
    private TextField addcpass;
    @FXML
    private Label addwarn;
    @FXML
    private TextField addudegree;
    @FXML
    private TextField addsalary;
    @FXML
    private BorderPane bpane2;
    @FXML
    private TextField addresusername;

    @FXML
    private Label congrats1;
    @FXML
    private Label congrats2;
    @FXML
    private Button addresbut;
    @FXML
    private VBox vbox2;
    @FXML
    private TextField addrname;
    @FXML
    private TextField addremail;
    @FXML
    private TextField addradress;
    @FXML
    private TextField addrnflats;
    @FXML
    private TextField addrphone;
    @FXML
    private TextField addrybuilt;
    @FXML
    private TextField updateResusename;
    @FXML
    private VBox vbox3;
    @FXML
    private VBox vbox4;
    @FXML
    private TextField updRDID;
    @FXML
    private TextField updatername;
    @FXML
    private TextField updateremail;
    @FXML
    private TextField updateraddress;
    @FXML
    private TextField updaternflats;
    @FXML
    private TextField updaterphone;
    @FXML
    private TextField updateryBuilt;
    @FXML
    private Button updateR;
    @FXML
    private TextField delrdid;
    @FXML
    private TextField delusername;
    @FXML
    private Label delwarn;

    @FXML
    private BorderPane bpane3;
    @FXML
    private TextField checkusername;
    @FXML
    private TextField checkrbid;
    @FXML
    private Label custactlb;
    @FXML
    private TextArea custactta;
    @FXML
    private Label actlb;
    @FXML
    private VBox vbox5;
    @FXML
    private VBox vbox6;
    @FXML
    private Button addflat;
    @FXML
    private TextField rflatid;
    @FXML
    private TextField rflatname;
    @FXML
    private TextField rflatcount;
    @FXML
    private TextField rflatarea;
    @FXML
    private TextField rflatpmonth;
    @FXML
    private TextField sflatid;
    @FXML
    private TextField sflatname;
    @FXML
    private TextField sflatcount;
    @FXML
    private TextField sflatarea;
    @FXML
    private TextField sflatprice;
    @FXML
    private TextField addusernamef;
    @FXML
    private TextField rbidaddflat;
    @FXML
    private Label warnaddconf;
    @FXML
    private Button rentb;
    @FXML
    private Button sellb;
    @FXML
    private Label checkerl;
    @FXML
    private TextField updateusernamef;
    @FXML
    private TextField rbidupdate;
    @FXML
    private TextField flatidupdate;
    @FXML
    private Label confirmuplb;
    @FXML
    private Label findfidupdate;
    @FXML
    private TextField newnameupd;
    @FXML
    private TextField newrcupd;
    @FXML
    private TextField newareaupd;
    @FXML
    private TextField newpriceupdate;
    @FXML
    private HBox hbox1;
    @FXML
    private HBox hbox2;
    @FXML
    private Button getdatab;
    @FXML
    private Button updateb;
    @FXML
    private HBox hbox3;
    @FXML
    private Button getdatadelete;
    @FXML
    private TextField deleteusenamef;
    @FXML
    private TextField deleterbidf;
    @FXML
    private TextField deleteflatid;
    @FXML
    private Label rbwarn;
    @FXML
    private Label flatidwarn;

    @FXML
    private TextArea usersTextArea;



    private Stage stage;
    private Scene scene;
    private Parent root;

    Users user;

    private ArrayList<Users> usersdata=new ArrayList<Users>();;


    DataBaseConnector connectNow=new DataBaseConnector();
    Connection connectDB =connectNow.getConnection();

    public String username="";

    @FXML
    private ImageView homeImageViewer = new ImageView();

    @FXML
    private ImageView adminHomeImageViewer = new ImageView();

    public static String tempUserID="";

    public void LoginButton(ActionEvent event){


        String getdata= "Select username,pass_word,typeu from users";
        //usersdata=new ArrayList<Users>();

        try {
            Statement getusers= connectDB.createStatement();
            ResultSet rs= getusers.executeQuery((getdata));

            while (rs.next())
            {
                usersdata.add(new Users(rs.getString(1), rs.getString(2),rs.getString(3) ));
            }

            //usersdata.forEach(users -> System.out.print(users.getPassword() +"\n"));

            username=usernamelog.getText();
            String pass=password.getText();
            String type="";


            int index=0;
            user=new Users(username,pass,type);
            boolean checker=false;

            for(int i =0 ;i<usersdata.size();i++)
            {
                if(username.equals(usersdata.get(i).getEmail()) )
                    if(pass.equals(usersdata.get(i).getPassword()))
                    {
                        checker=true;
                        index=i;
                        break;
                    }

            }

            //System.out.print(checker);

            if(checker){
                type=usersdata.get(index).getType();

                if(type.equals("a"))
                {
                    usersdata.removeAll(usersdata);
                    usersdata.add(new Users(username,pass,"c"));
                    root =FXMLLoader.load((getClass().getResource("AdminScene.fxml")));
                    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else if(type.equals("c"))
                {
                    tempUserID=username;
                    root =FXMLLoader.load((getClass().getResource("CustomerScene.fxml")));
                    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
            }else {
                warningLabel.setText("Something Went Wrong- ReLogin Again");
                usernamelog.setText("");
                password.setText("");

            }


        }catch(Exception e){
            e.printStackTrace();
        }
        //System.out.print(username);
    }

    public void SubmitButton(ActionEvent event) {
        String getdata= "Select username,pass_word,typeu from users";
        usersdata=new ArrayList<Users>();

        try {
            Statement getusers= connectDB.createStatement();
            ResultSet rs= getusers.executeQuery((getdata));

            while (rs.next())
            {
                usersdata.add(new Users(rs.getString(1), rs.getString(2),rs.getString(3) ));
            }
            String username=signupuser.getText();
            String pass=signuppass.getText();
            String name=signupname.getText();
            String phone=signupphone.getText();
            String email=signupemail.getText();
            boolean checker=false;

            for(int i=0;i<usersdata.size();i++)
            {
                if(username.equals(usersdata.get(i).getEmail()))
                    checker=true;

            }
            //System.out.print(checker);
            if(!checker)
            {
                if(signupconpass.getText().equals(signuppass.getText())) {

                    String submitquery = "insert into  Users (username,pass_word,typeu) values ('" + username + "','" + pass + "','c')";
                    String submitcustquery="Insert into Customers (CUST_Email,CUST_Name,CUST_ID,CUST_phone) values ('" +email+ "','" +name+ "','"+username+"','"+phone+"')";
                    try {
                        Statement sumbitst = connectDB.createStatement();
                        Statement sumbcust=connectDB.createStatement();
                        sumbcust.executeUpdate(submitcustquery);
                        sumbitst.executeUpdate(submitquery);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    submitwar.setText("Submited Successfully!");


                    root =FXMLLoader.load((getClass().getResource("Login.fxml")));
                    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    //TimeUnit.SECONDS.sleep(3);

                }else
                {
                    submitwar.setText("The Passwords does not match!");
                    signupconpass.setText("");
                    signuppass.setText("");
                }
            }else {
                submitwar.setText("Email Already Exists!");
                signupuser.setText("");

            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void ModRes_Scene(ActionEvent event)throws  IOException{
        root =FXMLLoader.load((getClass().getResource("ModResidental.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addRes(ActionEvent event)throws IOException{
        root =FXMLLoader.load((getClass().getResource("AddResident.fxml")));
        bpane2.setCenter(root);
    }
    public void confirmadd(ActionEvent event)throws IOException{
        addresbut.setVisible(true);
        vbox2.setVisible(true);
    }
    public void confirmaddR(ActionEvent event)throws  IOException{
        username=addresusername.getText();
        String id=addrname.getText()+addrybuilt.getText();
        String addQ="insert into Residental_Building(Rb_id,rb_name,RB_SupportEmail,RB_Address,RB_NumberOfFlats,RB_PhoneNumber,Built_year,emp_id) values ('"+id+"','"+addrname.getText()+"','"+addremail.getText()+"','"+addradress.getText()+"','"+Integer.parseInt(addrnflats.getText())+"','"+Integer.parseInt(addrphone.getText())+"','"+addrybuilt.getText()+"','"+username+"')";
        //System.out.print(addQ);
        try {
            Statement st=connectDB.createStatement();
            st.executeUpdate(addQ);

        }catch (Exception e){
            e.printStackTrace();
        }
        congrats1.setText("Congratulation "+username);
        congrats2.setText(addrname.getText()+" Added to your properties!");

    }

    public void updateRes(ActionEvent event)throws IOException{
        root =FXMLLoader.load((getClass().getResource("UpdateRes.fxml")));
        bpane2.setCenter(root);
    }
    public void updateCB(ActionEvent event)throws IOException{
        vbox3.setVisible(true);
        vbox4.setVisible(true);
        updateR.setVisible(true);
        username=updateResusename.getText();
        String id=updRDID.getText();

        String getQ="Select rb_name,RB_SupportEmail,RB_Address,RB_NumberOfFlats,RB_PhoneNumber,Built_year from Residental_Building where RB_ID='"+id+"' AND emp_id='"+username+"';";

        try {
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(getQ);

            rs.next();
            //System.out.print(rs.getString(1));
            updatername.setText(rs.getString(1));
            updateremail.setText(rs.getString(2));
            updateraddress.setText(rs.getString(3));
            updaternflats.setText(rs.getString(4));
            updaterphone.setText((rs.getString(5)));
            updateryBuilt.setText(rs.getString(6));


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateR(ActionEvent event)throws IOException{
        String id=updRDID.getText();
        username=updateResusename.getText();
        String updQ="update Residental_Building set RB_Name='"+ updatername.getText()+"',RB_SupportEmail='"+updateremail.getText()+"',RB_NumberOfFlats='"+Integer.parseInt(updaternflats.getText())+"',RB_Address='"+updateraddress.getText()+"',RB_PhoneNumber='"+Integer.parseInt(updaterphone.getText())+"',Built_year='"+updateryBuilt.getText() +"' where emp_id='"+username+"' AND RB_ID='"+id+"';";

        try {
            Statement st=connectDB.createStatement();
            st.executeUpdate(updQ);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteRes(ActionEvent event)throws IOException{
        root =FXMLLoader.load((getClass().getResource("DeleteRes.fxml")));
        bpane2.setCenter(root);
    }



    public void ModFlats_Scene(ActionEvent event)throws  IOException{
        root =FXMLLoader.load((getClass().getResource("ModFlats.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AddFlatScene(ActionEvent event)throws  IOException{
        root=FXMLLoader.load((getClass().getResource("AddFlatsScene.fxml")));
        bpane3.setCenter(root);

    }

    public void VisibleitemRent(ActionEvent event)throws IOException{
        vbox5.setVisible(true);
        vbox6.setVisible(false);
        addflat.setVisible(true);
    }
    public void VisibleitemSell(ActionEvent event)throws IOException{
        vbox5.setVisible(false);
        vbox6.setVisible(true);
        addflat.setVisible(true);
    }

    public void ConfirmAddf(ActionEvent event)throws IOException{
        warnaddconf.setText("");
        String sQuery="Select count(RB_Name) as Checker from Residental_Building where RB_ID='"+rbidaddflat.getText()+"' AND Emp_id='"+addusernamef.getText()+"'";
        try {
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(sQuery);
            rs.next();
            if(rs.getInt("Checker")==0){
                warnaddconf.setText("You Do Not Own This Building!");
            }else {
                rentb.setVisible(true);
                sellb.setVisible(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void AddFlatB(ActionEvent event)throws IOException{
        if(vbox5.isVisible()){
            String checkidQ="Select count(Flat_id) as Checker from Flats_RB where flat_id='"+rflatid.getText()+"'";

            try {
                Statement st=connectDB.createStatement();
                ResultSet rs=st.executeQuery(checkidQ);
                rs.next();
                if(rs.getInt("Checker")==0){
                    String addflatrQ="insert into Flats_RB(flat_id,room_count,flat_name,area,Rb_id) values('"+Integer.parseInt(rflatid.getText())+"','"+Integer.parseInt(rflatcount.getText())+"','"+rflatname.getText()+"','"+Double.parseDouble(rflatarea.getText())+"','"+rbidaddflat.getText()+"');";
                    String addrentQ="insert into Rent_flats(RF_id,price_month) values('"+Integer.parseInt(rflatid.getText())+"','"+Double.parseDouble(rflatpmonth.getText())+"')";

                    Statement st1=connectDB.createStatement();
                    st1.addBatch(addflatrQ);
                    st1.addBatch(addrentQ);

                    st1.executeBatch();
                    checkerl.setText("Added Succesfully!");

                }else {
                    checkerl.setText("Flat ID Already In use!");
                }


            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(vbox6.isVisible())
        {
            String checkidQ="Select count(Flat_id) as Checker from Flats_RB where flat_id='"+sflatid.getText()+"'";
            try {
                Statement st2=connectDB.createStatement();
                ResultSet rs2=st2.executeQuery(checkidQ);
                rs2.next();
                if(rs2.getInt("Checker")==0){
                    String addflatsQ="insert into Flats_RB(flat_id,room_count,flat_name,area,Rb_id) values('"+Integer.parseInt(sflatid.getText())+"','"+Integer.parseInt(sflatcount.getText())+"','"+sflatname.getText()+"','"+Double.parseDouble(sflatarea.getText())+"','"+rbidaddflat.getText()+"');";
                    String addsellQ="insert into Sell_flats(sf_id,price) values('"+Integer.parseInt(sflatid.getText())+"','"+Double.parseDouble(sflatprice.getText())+"')";
                    Statement st3=connectDB.createStatement();
                    st3.addBatch(addflatsQ);
                    st3.addBatch(addsellQ);
                    st3.executeBatch();
                    checkerl.setText("Added Succesfully!");
                }else {
                    checkerl.setText("Flat ID Already In use!");
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


    public void UpdateFlatScene(ActionEvent event)throws IOException{
        root=FXMLLoader.load(getClass().getResource("UpdateFlatScene.fxml"));
        bpane3.setCenter(root);
    }
    public void confirmcheckUpdateflat(ActionEvent event)throws IOException{
        confirmuplb.setText("");
        String sQuery="Select count(RB_Name) as Checker from Residental_Building where RB_ID='"+rbidupdate.getText()+"' AND Emp_id='"+updateusernamef.getText()+"'";
        try {
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(sQuery);
            rs.next();
            if(rs.getInt("Checker")==0){
                confirmuplb.setText("You Do Not Own This Building!");
            }else {
                hbox1.setVisible(true);
                getdatab.setVisible(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getflatdataupdate(ActionEvent event)throws IOException{
        findfidupdate.setText("");
        String gQuery="select count(flat_id) as checker from Flats_RB where Flat_id='"+Integer.parseInt(flatidupdate.getText())+"'";
        String sQuery="select count(RF_id) as checker from Rent_flats where RF_id='"+Integer.parseInt(flatidupdate.getText())+"'";
        try {
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(gQuery);
            rs.next();
            if(rs.getInt("checker")==1){
                hbox2.setVisible(true);
                updateb.setVisible(true);

                Statement st1=connectDB.createStatement();
                ResultSet rs1=st1.executeQuery(sQuery);
                rs1.next();
                if(rs1.getInt("checker")==1){//flat in rent table
                    String sfQ="Select price_month from Rent_flats where RF_id='"+Integer.parseInt(flatidupdate.getText())+"'";
                    Statement st2=connectDB.createStatement();
                    ResultSet rs2= st2.executeQuery(sfQ);
                    rs2.next();
                    newpriceupdate.setText(rs2.getString(1));


                    String fQ="select flat_name,room_count,area from Flats_RB where Flat_id='"+Integer.parseInt(flatidupdate.getText())+"'";
                    Statement st3=connectDB.createStatement();
                    ResultSet rs3=st3.executeQuery(fQ);
                    rs3.next();
                    newnameupd.setText(rs3.getString(1));
                    newrcupd.setText(rs3.getString(2));
                    newareaupd.setText(rs3.getString(3));

                }else{//flat in sell table
                    String sfQ="Select price from Sell_flats where SF_id='"+Integer.parseInt(flatidupdate.getText())+"'";
                    Statement st2=connectDB.createStatement();
                    ResultSet rs2= st2.executeQuery(sfQ);
                    rs2.next();
                    newpriceupdate.setText(rs2.getString(1));

                    String fQ="select flat_name,room_count,area from Flats_RB where Flat_id='"+Integer.parseInt(flatidupdate.getText())+"'";
                    Statement st3=connectDB.createStatement();
                    ResultSet rs3=st3.executeQuery(fQ);
                    rs3.next();
                    newnameupd.setText(rs3.getString(1));
                    newrcupd.setText(rs3.getString(2));
                    newareaupd.setText(rs3.getString(3));
                }
            }else {
                findfidupdate.setText("Flat Not Found!");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void UpdateFlatsB(ActionEvent event)throws  IOException{
        String uQuery="update Flats_RB set flat_name='"+newnameupd.getText()+"',room_count='"+Integer.parseInt(newrcupd.getText())+"',area='"+Double.parseDouble(newareaupd.getText())+"' where Flat_id='"+Integer.parseInt(flatidupdate.getText())+"'";
        String sQuery="select count(RF_id) as checker from Rent_flats where RF_id='"+Integer.parseInt(flatidupdate.getText())+"'";

        try {
            Statement st=connectDB.createStatement();
            st.executeUpdate(uQuery);
            Statement st2=connectDB.createStatement();
            ResultSet rs=st2.executeQuery(sQuery);
            rs.next();
            if(rs.getInt("checker")==1){//update rent
                String uQ2="update Rent_flats set price_month='"+Double.parseDouble(newpriceupdate.getText())+"' where RF_id='"+Integer.parseInt(flatidupdate.getText())+"'";
                Statement st3=connectDB.createStatement();
                st3.executeUpdate(uQ2);
            }else{
                String uQ2="update Sell_flats set price='"+Double.parseDouble(newpriceupdate.getText())+"' where SF_id='"+Integer.parseInt(flatidupdate.getText())+"'";
                Statement st3=connectDB.createStatement();
                st3.executeUpdate(uQ2);
            }

            findfidupdate.setText("Updated Successfully!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DeleteFlatScene(ActionEvent event)throws IOException{
        root=FXMLLoader.load(getClass().getResource("DeleteFlatScene.fxml"));
        bpane3.setCenter(root);
    }
    public void deleteconfirmrb(ActionEvent event)throws IOException{
        rbwarn.setText("");
        String sQuery="Select count(RB_Name) as Checker from Residental_Building where RB_ID='"+deleterbidf.getText()+"' AND Emp_id='"+deleteusenamef.getText()+"'";
        try {
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(sQuery);
            rs.next();
            if(rs.getInt("Checker")==0){
                rbwarn.setText("You Do Not Own This Building!");
            }else {
                hbox3.setVisible(true);
                getdatadelete.setVisible(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteF(ActionEvent event)throws IOException{
        String gQuery="select count(flat_id) as checker from Flats_RB where Flat_id='"+deleteflatid.getText()+"'";
        String dQuery="delete from Flats_RB where Flat_id='"+deleteflatid.getText()+"'";
        try {

            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(gQuery);
            rs.next();
            if(rs.getInt("checker")==1) {

                Statement st2 = connectDB.createStatement();
                st2.executeUpdate(dQuery);
                flatidwarn.setText("Deleted Successfully!");

            }else{
                flatidwarn.setText("Flat Not Found!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //*******************
    public void CheckUsers_Scene(ActionEvent event)throws  IOException, NullPointerException{
        root =FXMLLoader.load((getClass().getResource("Check Users.fxml")));
        bpane.setCenter(root);
        String query="Select username,typeu from users";

        try {
            String outputActiveUsers="";
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(query);

            while (rs.next())
            {
                if(rs.getString(2).equals("a")) {
                    System.out.println("User " + rs.getString(1) + " As admin\n");
                    String tempUser =  "User " + rs.getString(1) + " As admin\n";
                    outputActiveUsers=outputActiveUsers + tempUser;

                }else
                {
                    System.out.print("User " + rs.getString(1) + " As Customer\n");
                    String tempUser ="User " + rs.getString(1) + " As Customer\n";
                    outputActiveUsers=outputActiveUsers + tempUser;
                }
            }
            System.out.println("===========\n");
            System.out.println(outputActiveUsers);
            usersTextArea.setText(outputActiveUsers);


        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    //******************
    public void CheckC(ActionEvent event)throws IOException, SQLException {//Check users scene
        custactlb.setVisible(true);
        custactta.setVisible(true);
        int activity=0;
        String sQuery="Select count(RB_Name) as Checker from Residental_Building where RB_ID='"+checkrbid.getText()+"' AND Emp_id='"+checkusername.getText()+"'";
        String rQuery="select cust_id,rf_id from rent_flats where cust_id IS NOT NULL AND rf_id=any(select flat_id from flats_rb where RB_ID='"+checkrbid.getText()+"')";
        String eQuery="select cust_id,sf_id from sell_flats where cust_id IS NOT NULL AND sf_id=any(select flat_id from flats_rb where RB_ID='"+checkrbid.getText()+"')";
        //System.out.print(sQuery);
        try {
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(sQuery);
            String usersOutput = "";
            rs.next();

            if(rs.getInt("Checker")==0){
                System.out.print("You Dont Own this Building");
                custactta.setText("You Dont Own this Building");
            }else{
                Statement st1=connectDB.createStatement();
                ResultSet rs1=st1.executeQuery(rQuery);
                while(rs1.next())
                {
                    System.out.print("User: "+rs1.getString(1)+" Rented Flat number: "+rs1.getString(2)+"\n");
                    String tempUser ="User: "+rs1.getString(1)+" Rented Flat number: "+rs1.getString(2)+"\n";
                    usersOutput=usersOutput+tempUser;
                    //custactta.appendText("User: "+rs1.getString(1)+" Rented Flat number: "+rs1.getString(2));
                    activity++;
                }
                Statement st2=connectDB.createStatement();
                ResultSet rs2=st2.executeQuery(eQuery);
                while(rs2.next()){
                    System.out.print("User: "+rs2.getString(1)+" Bought Flat number: "+rs2.getString(2)+"\n");
                    String tempUser ="User: "+rs2.getString(1)+" Bought Flat number: "+rs2.getString(2)+"\n";
                    usersOutput=usersOutput+tempUser;
                    //custactta.appendText("User: "+rs2.getString(1)+" Bought Flat number: "+rs2.getString(2));
                    activity++;

                }
                custactta.setText(usersOutput);
            }
            actlb.setText(Integer.toString(activity)+" Recent Activites:");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void AddAdmin_Scene(ActionEvent event)throws  IOException{
        root =FXMLLoader.load((getClass().getResource("AddAdmin.fxml")));
        bpane.setCenter(root);
    }
    public void addadmin(ActionEvent event)throws  IOException{
        if(addpass.getText().equals(addcpass.getText()))
        {
            String addQ1="insert into users(username,pass_word,typeu) values('"+addusername.getText()+"','"+addpass.getText()+"','a')" ;
            String addQ2="insert into Employee(Emp_id,Emp_email,Emp_name,emp_phone,emp_salary,EMP_UniverstyDegree) values ('"+addusername.getText()+"','"+addemail.getText()+"','"+addname.getText()+"','"+Integer.parseInt(addphone.getText())+"','"+Double.parseDouble(addsalary.getText())+"','"+addudegree.getText()+"');";

            //System.out.print(addQ);
            try {
                Statement st=connectDB.createStatement();
                st.addBatch(addQ1);
                st.addBatch(addQ2);

                st.executeBatch();

            }catch (Exception e){
                e.printStackTrace();
            }


            addwarn.setText("Added Successfully!");
        }else
        {
            addwarn.setText("Passwords Does not match!");
        }
    }


    public void UpdateStat_Scene(ActionEvent event)throws  IOException{
        root =FXMLLoader.load((getClass().getResource("UpdateStat.fxml")));
        bpane.setCenter(root);
    }

    public void confirmupdate(ActionEvent event)throws IOException{
        username=updusername.getText();
        vpane.setVisible(true);
        updatestat.setVisible(true);
        hpane.setVisible(true);
        String getdata="Select EMP_Name,EMP_Email,EMP_phone,EMP_UniverstyDegree from Employee where emp_id='"+username+"';";
        //System.out.print(getdata);
        try {
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(getdata);
            while (rs.next()) {
                updname.setText(rs.getString("EMP_Name"));
                updemail.setText(rs.getString("EMP_Email"));
                updphone.setText(rs.getString("EMP_phone"));
                updudegree.setText(rs.getString("EMP_UniverstyDegree"));

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        newname.setText(updname.getText());
        newemail.setText(updemail.getText());
        newphone.setText(updphone.getText());
        newdegree.setText(updudegree.getText());

    }

    public void update(ActionEvent e) throws IOException{
        username=updusername.getText();
        if(!newname.getText().equals("") && !newemail.getText().equals("") && !newphone.getText().equals("") && !newdegree.getText().equals("")) {
            String updQ = "update Employee set EMP_Name='" + newname.getText() + "',EMP_Email='" + newemail.getText() + "',EMP_phone='" + Integer.parseInt(newphone.getText()) + "',EMP_UniverstyDegree='" + newdegree.getText() + "' where emp_id='" + username + "';";

            try {
                Statement st = connectDB.createStatement();
                st.executeUpdate(updQ);

            } catch (Exception w) {
                w.printStackTrace();
            }
        }
    }


    public void deleteR(ActionEvent e)throws IOException{
        username=delusername.getText();
        String id=delrdid.getText();
        String delQ="Delete from Residental_Building where RB_ID='"+id+"' AND emp_id='"+username+"';";

        try {
            Statement st=connectDB.createStatement();
            st.executeUpdate(delQ);
            delwarn.setText("Deleted Successfully!");
        }catch (Exception c){
            c.printStackTrace();
        }
    }

    public void Switch_to_AdminScene(ActionEvent event) throws IOException {
        root =FXMLLoader.load((getClass().getResource("AdminScene.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Switch_to_LoginScene(ActionEvent event)throws  IOException{
        root =FXMLLoader.load((getClass().getResource("Login.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Switch_to_SignUpScene(ActionEvent event)throws  IOException{
        root =FXMLLoader.load((getClass().getResource("SignUpScene.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Switch_to_CustomerScene(ActionEvent event)throws IOException{
        root =FXMLLoader.load((getClass().getResource("CustomerScene.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onHomeButtonClicked(ActionEvent event)throws IOException{
        root =FXMLLoader.load((getClass().getResource("CustomerScene.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ComboBox<String> resBox=new ComboBox<>();

    @FXML
    private Button checkButton=new Button();

    public void onServicesButtonClicked(ActionEvent event)throws IOException{
        root =FXMLLoader.load((getClass().getResource("CustomerServices.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void onAboutUsButtonClicked(ActionEvent event)throws IOException{
        root =FXMLLoader.load((getClass().getResource("CustomerAboutUs.fxml")));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static String rbTempName="";
    public void onResButtonClicked(ActionEvent event) throws IOException, SQLException {
        resBox.getItems().clear();
        resBox.setVisible(true);
        soldBox.setVisible(false);
        checkSold.setVisible(false);
        rentedFlatsBox.setVisible(false);
        rentedSeeButton.setVisible(false);
        checkButton.setVisible(true);
        labelsBox3.setVisible(false);
        outputBox3.setVisible(false);
        labelsBox4.setVisible(false);
        outputBox4.setVisible(false);
        String rQuery="SELECT * FROM real_estate.residental_building;";
        Statement st=connectDB.createStatement();
        ResultSet rs=st.executeQuery(rQuery);

        while (rs.next()){
           // System.out.println(rs.getString("RB_Name"));
            resBox.getItems().add(rs.getString("RB_Name"));
        }
    }
    @FXML
    private Label wrongChoice;

    public static String rbTempID="";
    public void onCheckButtonClicked(ActionEvent event) throws IOException, SQLException {
        if(resBox.getValue()==null){
            //System.out.println("please choose sth\n");
            wrongChoice.setVisible(true);
        }else{
            rbTempName=resBox.getValue();

            String rQuery="SELECT * FROM real_estate.residental_building where RB_Name='"+rbTempName+"';";
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(rQuery);
            while(rs.next()){
                rbTempID=rs.getString("RB_ID");
            }

            root =FXMLLoader.load((getClass().getResource("ResidentialScene.fxml")));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    VBox labelsBox=new VBox();
    @FXML
    VBox outputBox=new VBox();

    @FXML
    Button buildingInfoButton=new Button();

    @FXML
    Label resName;

    @FXML
    Label resAddress;

    @FXML
    Label resPhone;

    @FXML
    Label resEmail;

    @FXML
    Label resNumberOfFlats;

    @FXML
    Label resBuiltYear;
    public void onBuildingInfoButtonClicked(ActionEvent event) throws IOException, SQLException {
        //System.out.println(rbTempName);
        sellFlatsBox.setVisible(false);
        rentFlatsBox.setVisible(false);
        sellFlatsCheckButton.setVisible(false);
        rentFlatsCheckButton.setVisible(false);
        outputBox1.setVisible(false);
        labelsBox1.setVisible(false);
        outputBox2.setVisible(false);
        labelsBox2.setVisible(false);
        rentChoice.setVisible(false);
        sellReserveButton.setVisible(false);
        rentReserveButton.setVisible(false);
        String rQuery="SELECT * FROM real_estate.residental_building where RB_Name='"+rbTempName+"';";
        Statement st=connectDB.createStatement();
        ResultSet rs=st.executeQuery(rQuery);

        while (rs.next()){
           // System.out.println("test");
            // System.out.println(rs.getString("RB_SupportEmail"));
            resName.setText(rs.getString("RB_Name"));
            resAddress.setText(rs.getString("RB_Address"));
            resBuiltYear.setText((rs.getString("Built_year")));
            resEmail.setText(rs.getString(("RB_SupportEmail")));
            resNumberOfFlats.setText(rs.getString("RB_NumberOfFlats"));
            resPhone.setText(rs.getString("RB_PhoneNumber"));
        }
        labelsBox.setVisible(true);
        outputBox.setVisible(true);
    }

    @FXML
    private ComboBox<String> sellFlatsBox=new ComboBox<>();
    @FXML
    private Button sellFlatsCheckButton=new Button();

    public static String tempSellFlatID;
    public static String tempSellFlatName;
    public void onForSellButtonClicked(ActionEvent event) throws IOException,SQLException{
        sellFlatsBox.getItems().clear();
        labelsBox.setVisible(false);
        rentChoice.setVisible(false);
        outputBox.setVisible(false);
        rentFlatsCheckButton.setVisible(false);
        sellFlatsBox.setVisible(true);
        sellFlatsCheckButton.setVisible(true);
        outputBox1.setVisible(false);
        labelsBox1.setVisible(false);
        rentFlatsBox.setVisible(false);
        outputBox2.setVisible(false);
        labelsBox2.setVisible(false);
        sellReserveButton.setVisible(false);
        rentReserveButton.setVisible(false);
        //System.out.println(rbTempID);

        String sQuery="SELECT * FROM real_estate.sell_flats, real_estate.flats_rb WHERE SF_id = Flat_id AND cust_id IS NULL ;";
        Statement st=connectDB.createStatement();
        ResultSet rs=st.executeQuery(sQuery);
        while(rs.next()){
            //System.out.println(rs.getString("flat_name"));
            sellFlatsBox.getItems().add(rs.getString("flat_name"));
        }

    }

    @FXML
    Label sellFlatName;

    @FXML
    Label sellFlatNo;

    @FXML
    Label sellFlatRoomCount;

    @FXML
    Label sellFlatPrice;

    @FXML
    Label sellFlatArea;

    @FXML
    VBox labelsBox1=new VBox();

    @FXML
    VBox outputBox1=new VBox();
    public void onSellFlatsCheckButtonClicked(ActionEvent event) throws IOException, SQLException {
        sellFlatsBox.setVisible(false);
        sellFlatsCheckButton.setVisible(false);
        outputBox1.setVisible(true);
        labelsBox1.setVisible(true);
        rentFlatsBox.setVisible(false);
        outputBox2.setVisible(false);
        labelsBox2.setVisible(false);


        if(sellFlatsBox.getValue()==null){
            System.out.println("please choose sth\n");
        }else{
            tempSellFlatName=sellFlatsBox.getValue();

            String fQuery="SELECT * FROM real_estate.flats_rb where flat_name='"+tempSellFlatName+"';";
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(fQuery);
            rs.next();

            tempSellFlatID=rs.getString("Flat_id");
            sellFlatName.setText(rs.getString("flat_name"));
            sellFlatArea.setText(rs.getString("area"));
            sellFlatNo.setText(rs.getString("Flat_id"));
            sellFlatRoomCount.setText(rs.getString("room_count"));
            String sQuery="SELECT * FROM real_estate.sell_flats where SF_id='"+tempSellFlatID+"';";
            Statement st1=connectDB.createStatement();
            ResultSet rs1=st1.executeQuery(sQuery);
            rs1.next();
            sellFlatPrice.setText(rs1.getString("price"));
            sellReserveButton.setVisible(true);


        }
    }
    @FXML
    private ComboBox<String> rentFlatsBox=new ComboBox<>();
    @FXML
    private Button rentFlatsCheckButton;

    @FXML
    VBox labelsBox2=new VBox();
    @FXML
    VBox outputBox2=new VBox();

    public static String tempRentFlatID;
    public static String tempRentFlatName;

    @FXML
    Label rentFlatName;

    @FXML
    Label rentFlatNo;

    @FXML
    Label rentFlatRoomCount;

    @FXML
    Label rentFlatPrice;

    @FXML
    Label rentFlatArea;
    @FXML
    private ComboBox<String> rentChoice=new ComboBox<>();
    public void onForRentButtonClicked(ActionEvent event) throws IOException,SQLException{
        rentFlatsBox.getItems().clear();
        labelsBox.setVisible(false);
        outputBox.setVisible(false);
        rentFlatsBox.setVisible(true);
        sellFlatsBox.setVisible(false);
        outputBox1.setVisible(false);
        labelsBox1.setVisible(false);
        sellFlatsCheckButton.setVisible(false);
        rentFlatsCheckButton.setVisible(true);
        outputBox2.setVisible(false);
        labelsBox2.setVisible(false);
        sellReserveButton.setVisible(false);
        rentReserveButton.setVisible(false);
        rentChoice.setVisible(false);

        rentChoice.getItems().add("1");
        rentChoice.getItems().add("2");
        rentChoice.getItems().add("3");
        rentChoice.getItems().add("4");
        rentChoice.getItems().add("5");
        //System.out.println(rbTempID);

        String sQuery="SELECT * FROM real_estate.rent_flats, real_estate.flats_rb WHERE RF_id = Flat_id AND cust_id IS NULL ;";
        Statement st=connectDB.createStatement();
        ResultSet rs=st.executeQuery(sQuery);
        while(rs.next()){
           // System.out.println(rs.getString("flat_name"));
            rentFlatsBox.getItems().add(rs.getString("flat_name"));
        }

    }

    public void onRentFlatsCheckButtonClicked(ActionEvent event) throws IOException, SQLException {
        sellFlatsBox.setVisible(false);
        sellFlatsCheckButton.setVisible(false);
        outputBox2.setVisible(true);
        labelsBox2.setVisible(true);
        rentFlatsBox.setVisible(false);
        rentFlatsCheckButton.setVisible(false);
        outputBox1.setVisible(false);
        labelsBox1.setVisible(false);
        rentChoice.setVisible(true);



        if(rentFlatsBox.getValue()==null){
            System.out.println("please choose sth\n");
        }else{
            tempRentFlatName=rentFlatsBox.getValue();

            String fQuery="SELECT * FROM real_estate.flats_rb where flat_name='"+tempRentFlatName+"';";
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(fQuery);
            rs.next();

            tempRentFlatID=rs.getString("Flat_id");
            rentFlatName.setText(rs.getString("flat_name"));
            rentFlatArea.setText(rs.getString("area"));
            rentFlatNo.setText(rs.getString("Flat_id"));
            rentFlatRoomCount.setText(rs.getString("room_count"));
            String sQuery="SELECT * FROM real_estate.rent_flats where RF_id='"+tempRentFlatID+"';";
            Statement st1=connectDB.createStatement();
            ResultSet rs1=st1.executeQuery(sQuery);
            rs1.next();
            rentFlatPrice.setText(rs1.getString("price_month"));
            rentReserveButton.setVisible(true);
        }
    }

    @FXML
    Button rentReserveButton;

    @FXML
    Button sellReserveButton;


    public void onRentReserveButtonClicked(ActionEvent event) throws IOException, SQLException {
        String update="UPDATE `real_estate`.`rent_flats` SET cust_id = ?, duration=? WHERE RF_id = ?;";
        PreparedStatement statement =connectDB.prepareStatement(update);
        statement.setString(3,tempRentFlatID);
        statement.setString(1,tempUserID);
        statement.setString(2,rentChoice.getValue());
        int rowsAffected = statement.executeUpdate();
        rentReserveButton.setVisible(false);
        rentChoice.setVisible(false);
    }

    public void onSellReserveButtonClicked(ActionEvent event) throws IOException, SQLException {
        String update="UPDATE `real_estate`.`sell_flats` SET `cust_id` = ? WHERE `SF_id` = ?;";
        PreparedStatement statement =connectDB.prepareStatement(update);
        statement.setString(2,tempSellFlatID);
        statement.setString(1,tempUserID);
        int rowsAffected = statement.executeUpdate();
        sellReserveButton.setVisible(false);
    }

    @FXML
    private ComboBox<String> rentedFlatsBox;
    public void onRentedButtonClicked(ActionEvent event)throws IOException,SQLException{
        rentedFlatsBox.getItems().clear();
        rentedFlatsBox.setVisible(true);
        rentedSeeButton.setVisible(true);
        resBox.setVisible(false);
        checkButton.setVisible(false);
        labelsBox3.setVisible(false);
        outputBox3.setVisible(false);
        soldBox.setVisible(false);
        checkSold.setVisible(false);
        labelsBox4.setVisible(false);
        outputBox4.setVisible(false);



        String sQuery="SELECT * FROM real_estate.rent_flats, real_estate.flats_rb WHERE RF_id = Flat_id AND cust_id='"+tempUserID+"' ;";
        Statement st=connectDB.createStatement();
        ResultSet rs=st.executeQuery(sQuery);
        while(rs.next()){
            // System.out.println(rs.getString("flat_name"));
            rentedFlatsBox.getItems().add(rs.getString("flat_name"));
        }
    }

    public static String tempRentFlatID1;
    public static String tempRentFlatName1;

    @FXML
    private Button rentedSeeButton;

    @FXML
    Label rentFlatName1;

    @FXML
    Label rentFlatNo1;

    @FXML
    Label rentFlatRoomCount1;

    @FXML
    Label rentFlatPrice1;

    @FXML
    Label rentFlatArea1;

    @FXML
    VBox labelsBox3;

    @FXML
    VBox outputBox3;
    public void onRentedCheckButtonClicked(ActionEvent event)throws IOException,SQLException{
        if(rentedFlatsBox.getValue()==null){
            System.out.println("please choose sth\n");
        }else{
            tempRentFlatName1=rentedFlatsBox.getValue();

            String fQuery="SELECT * FROM real_estate.flats_rb where flat_name='"+tempRentFlatName1+"';";
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(fQuery);
            rs.next();

            tempRentFlatID1=rs.getString("Flat_id");
            rentFlatName1.setText(rs.getString("flat_name"));
            rentFlatArea1.setText(rs.getString("area"));
            rentFlatNo1.setText(rs.getString("Flat_id"));
            rentFlatRoomCount1.setText(rs.getString("room_count"));
            String sQuery="SELECT * FROM real_estate.rent_flats where RF_id='"+tempRentFlatID1+"';";
            Statement st1=connectDB.createStatement();
            ResultSet rs1=st1.executeQuery(sQuery);
            rs1.next();
            //System.out.println(rs1.getString("price_month"));
            rentFlatPrice1.setText(rs1.getString("price_month"));
            rentedSeeButton.setVisible(false);
            rentedFlatsBox.setVisible(false);
            labelsBox3.setVisible(true);
            outputBox3.setVisible(true);
        }
    }

    @FXML
    ComboBox<String> soldBox;
    @FXML
    Button checkSold;

    public static String tempRentFlatID2;
    public static String tempRentFlatName2;


    @FXML
    Label rentFlatName2;

    @FXML
    Label rentFlatNo2;

    @FXML
    Label rentFlatRoomCount2;

    @FXML
    Label rentFlatPrice2;

    @FXML
    Label rentFlatArea2;

    @FXML
    VBox labelsBox4;

    @FXML
    VBox outputBox4;
    public void onOwnedButtonClicked(ActionEvent event)throws IOException,SQLException{
        soldBox.getItems().clear();
        resBox.setVisible(false);
        rentedFlatsBox.setVisible(false);
        rentedSeeButton.setVisible(false);
        checkButton.setVisible(false);
        labelsBox3.setVisible(false);
        outputBox3.setVisible(false);
        soldBox.setVisible(true);
        checkSold.setVisible(true);
        labelsBox4.setVisible(false);
        outputBox4.setVisible(false);

        String sQuery="SELECT * FROM real_estate.sell_flats, real_estate.flats_rb WHERE SF_id = Flat_id AND cust_id='"+tempUserID+"' ;";
        Statement st=connectDB.createStatement();
        ResultSet rs=st.executeQuery(sQuery);
        while(rs.next()){
            // System.out.println(rs.getString("flat_name"));
            soldBox.getItems().add(rs.getString("flat_name"));
        }

    }

    public void onCheckSoldButtonClicked(ActionEvent event)throws  IOException,SQLException{
        if(soldBox.getValue()==null){
            System.out.println("please choose sth\n");
        }else{
            tempRentFlatName2=soldBox.getValue();

            String fQuery="SELECT * FROM real_estate.flats_rb where flat_name='"+tempRentFlatName2+"';";
            Statement st=connectDB.createStatement();
            ResultSet rs=st.executeQuery(fQuery);
            rs.next();

            tempRentFlatID2=rs.getString("Flat_id");
            rentFlatName2.setText(rs.getString("flat_name"));
            rentFlatArea2.setText(rs.getString("area"));
            rentFlatNo2.setText(rs.getString("Flat_id"));
            rentFlatRoomCount2.setText(rs.getString("room_count"));
            String sQuery="SELECT * FROM real_estate.sell_flats where SF_id='"+tempRentFlatID2+"';";
            Statement st1=connectDB.createStatement();
            ResultSet rs1=st1.executeQuery(sQuery);
            rs1.next();
            //System.out.println(rs1.getString("price_month"));
            rentFlatPrice2.setText(rs1.getString("price"));
            checkSold.setVisible(false);
            soldBox.setVisible(false);
            labelsBox4.setVisible(true);
            outputBox4.setVisible(true);
        }


    }


}