package javafxapplication7;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.*;
import javafx.geometry.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class JavaFXApplication7 extends Application
{   
    
    PreparedStatement preparedStatement;
    Connection con;
    Integer a = 0;
    Integer kl = 0;
    int kolumny;
    int ks;
    int ts;
    int ps;
    int s;
    int sl;
    int k;
    int p;
    int l;
    int pl;    
    int kp;
    int kk;
    int w;
    
    @Override
    public void start(Stage stage) throws Exception
    {         
        
        GridPane okno = new GridPane();
        okno.setId("okno");
        okno.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 

         Label fail = new Label("Blad sterownika");
         Label failPolaczenie = new Label("Blad polaczenia");
       
         
         Label blad_logowania = new Label("Haslo Niepoprawne");
         blad_logowania.setId("log_error");
         blad_logowania.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());


         FileInputStream i1 = new FileInputStream("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\JavaFXApplication7\\src\\javafxapplication7/ico3.png");
         Image ic1 = new Image(i1); 
         ImageView ico1 = new ImageView(ic1); 
         ico1.setFitHeight(60);
         ico1.setFitWidth(60);
         
         FileInputStream i2 = new FileInputStream("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\JavaFXApplication7\\src\\javafxapplication7/icon_add.png");
         Image ic2 = new Image(i2); 
         ImageView ico2 = new ImageView(ic2); 
         ico2.setFitHeight(60);
         ico2.setFitWidth(60);
         
         FileInputStream i3 = new FileInputStream("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\JavaFXApplication7\\src\\javafxapplication7/icon_del.png");
         Image ic3 = new Image(i3); 
         ImageView ico3 = new ImageView(ic3); 
         ico3.setFitHeight(60);
         ico3.setFitWidth(60);
         
         FileInputStream i4 = new FileInputStream("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\JavaFXApplication7\\src\\javafxapplication7/icon_edit.png");
         Image ic4 = new Image(i4); 
         ImageView ico4 = new ImageView(ic4); 
         ico4.setFitHeight(60);
         ico4.setFitWidth(60);
         
         FileInputStream i5 = new FileInputStream("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\JavaFXApplication7\\src\\javafxapplication7/icon_all.png");
         Image ic5 = new Image(i5); 
         ImageView ico5 = new ImageView(ic5); 
         ico5.setFitHeight(60);
         ico5.setFitWidth(60);
         
         FileInputStream i6 = new FileInputStream("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\JavaFXApplication7\\src\\javafxapplication7/icon_log.png");
         Image ic6 = new Image(i6); 
         ImageView ico6 = new ImageView(ic6); 
         ico6.setFitHeight(60);
         ico6.setFitWidth(60);
         
         Label naglowek_apka = new Label("System Lotniczy");
         naglowek_apka.setId("NAG_ADMIN");
         naglowek_apka.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_panel_log = new Label("Wpisz Dane");
         naglowek_panel_log.setId("naglowek_admin_napis");
         naglowek_panel_log.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_dodaj = new Label("ADD USER");
         naglowek_dodaj.setId("naglowek_admin_napis");
         naglowek_dodaj.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_usun = new Label("DELETE USER");
         naglowek_usun.setId("naglowek_admin_napis");
         naglowek_usun.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_edit = new Label("EDIT USER");
         naglowek_edit.setId("naglowek_admin_napis");
         naglowek_edit.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_users = new Label("ALL USERS");
         naglowek_users.setId("naglowek_admin_napis");
         naglowek_users.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label log_read = new Label("LOGI");
         log_read.setId("naglowek_admin_napis");
         log_read.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_admin_panel = new Label("Witaj Administratorze!");
         naglowek_admin_panel.setId("NAG_ADMIN");
         naglowek_admin_panel.setAlignment(Pos.CENTER);
         naglowek_admin_panel.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_user_panel = new Label("Zalogowany jako ");
         naglowek_user_panel.setId("NAG_ADMIN");
         naglowek_user_panel.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label tab = new Label("Tabela ");
         tab.setId("a_user");
         tab.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
        stage.initStyle(StageStyle.UNDECORATED);

        HBox gorny_panel = new HBox(); 

        gorny_panel.setMinSize(800,100);       
        gorny_panel.getChildren().addAll(naglowek_apka);
        gorny_panel.setAlignment(Pos.CENTER);
        okno.add(gorny_panel, 0, 0, 1, 1);
                   
        
        Button log_button=new Button("");
        log_button.setMinSize(159,38);
        log_button.setId("log_button");
        log_button.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
       
 
        HBox kontener= new HBox();
        kontener.setMinWidth(200);
        kontener.setMinHeight(200);
        kontener.setAlignment(Pos.CENTER);     
        
        okno.add(kontener, 0, 2, 1, 4);
        
        
        VBox dane= new VBox();
        dane.setMinSize(500,400);
        dane.setAlignment(Pos.CENTER);
        dane.setId("panel_dane");
        dane.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        HBox ds= new HBox();
        ds.setMinSize(500,300);
       ds.setId("tabels");
        ds.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        ds.setAlignment(Pos.CENTER);
        
        HBox panel_login = new HBox();
        panel_login.setMinWidth(200);
         panel_login.setAlignment(Pos.CENTER);
         panel_login.setSpacing(15);
         panel_login.setMinHeight(80);

         TextField loginField = new TextField();
         loginField.setMinWidth(220);
         loginField.setPromptText("Wpisz swój Login");
      
         HBox panel_haslo = new HBox();
         panel_haslo.setMinWidth(200);
         panel_haslo.setAlignment(Pos.CENTER);
         panel_haslo.setSpacing(15);
         panel_haslo.setMinHeight(80);
                
         PasswordField hasloField = new PasswordField();
         hasloField.setMinWidth(220);
         hasloField.setPromptText("Wpisz swoje haslo");
        
         dane.getChildren().addAll(ico1,naglowek_panel_log,panel_login, panel_haslo, log_button);
         
         panel_login.getChildren().addAll(loginField);
         panel_haslo.getChildren().addAll(hasloField);
         
         kontener.getChildren().addAll( dane);
        
         HBox stopka=new HBox();
         stopka.setMinSize(800,100);
         stopka.setSpacing(30);
         stopka.setAlignment(Pos.CENTER);
         stopka.setId("stopka");
         //stopka.setAlignment(Pos.CENTER_RIGHT);
         stopka.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
         okno.add(stopka,0,6,1,1);
       
        Button a_dodaj=new Button("");
        a_dodaj.setMinSize(100,38);
        a_dodaj.setId("a_dodaj_button");
        a_dodaj.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        Button a_usun=new Button("");
        a_usun.setMinSize(100,38);
        a_usun.setId("a_usun_button");
        a_usun.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button a_edytuj=new Button("");
        a_edytuj.setMinSize(100,38);
        a_edytuj.setId("a_edytuj_button");
        a_edytuj.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button a_odczyt=new Button("");
        a_odczyt.setMinSize(100,38);
        a_odczyt.setId("a_odczyt_button");
        a_odczyt.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button a_users=new Button("");
        a_users.setMinSize(100,38);
        a_users.setId("a_users_button");
        a_users.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button wyloguj=new Button("");
        wyloguj.setMinSize(100,38);
        wyloguj.setId("wyloguj_button");
        wyloguj.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());   
        
        Button k_tabela=new Button("");
        k_tabela.setMinSize(100,38);
        k_tabela.setId("b_tab_button");
        k_tabela.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        Button k_kwerenda=new Button("");
        k_kwerenda.setMinSize(100,38);
        k_kwerenda.setId("b_kw_button");
        k_kwerenda.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button k_procedura=new Button("");
        k_procedura.setMinSize(100,38);
        k_procedura.setId("b_proc_button");
        k_procedura.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button k_wyzwalacz=new Button("");
        k_wyzwalacz.setMinSize(100,38);
        k_wyzwalacz.setId("b_wyz_button");
        k_wyzwalacz.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button wyjdz=new Button("");
        wyjdz.setMinSize(100,38);
        wyjdz.setId("b_wyj_button");
        wyjdz.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        Button inne=new Button("");
        inne.setMinSize(100,38);
        inne.setId("b_poz_button");
        inne.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         log_button.setOnAction(e->{ 
                         
             Label loginWynik=new Label();
              loginWynik.setText(loginField.getText());
              String loginString=loginWynik.getText();
              loginField.clear();
              
              Label hasloWynik=new Label();
              hasloWynik.setText(hasloField.getText());
              String hasloString=hasloWynik.getText();
              hasloField.clear();

             try{
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                 con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                String sql = "select login from administrator where login='"+loginString+"' and haslo='"+hasloString+"';";
                preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
               if (rs != null && !rs.isClosed() && rs.next())
                {
                a=1;
                }                            
            }
             catch(SQLException error_polaczenie) {
                dane.getChildren().add(failPolaczenie);}
             catch(ClassNotFoundException error_sterownik) {
                dane.getChildren().add(fail);}
             
             
              if(a == 0){  
              try{
             
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                String sql2 = "select login from uzytkownik where login='"+loginString+"' and haslo='"+hasloString+"';";
                preparedStatement = con.prepareStatement(sql2);
                ResultSet rs2 = preparedStatement.executeQuery();
                 if (rs2 != null && !rs2.isClosed() && rs2.next())
                {
                kl=1;
                }
              }
              catch(SQLException error_polaczenie) {
                dane.getChildren().add(failPolaczenie);}
             catch(ClassNotFoundException error_sterownik) {
                dane.getChildren().add(fail);}
                
              }
            
             if(a == 0 & kl == 0){
                loginField.clear();
                hasloField.clear();
                dane.getChildren().clear();
                dane.getChildren().addAll(ico1,naglowek_panel_log,panel_login, panel_haslo, log_button);
                
                dane.getChildren().add(blad_logowania);
                
             }
             else if( a == 1){
             
             gorny_panel.getChildren().clear();
             gorny_panel.getChildren().add(naglowek_admin_panel);
             dane.getChildren().clear();
             
             loginField.clear();
             hasloField.clear();
             
             stopka.getChildren().addAll( a_dodaj, a_usun, a_edytuj, a_odczyt,a_users, wyloguj);
             
             }
             else if( kl == 1){
    
              try{

                  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                                               
                        Statement query = con.createStatement();
                        String sql = "select id_uzytkownik from uzytkownik where login='"+loginString+"';";
                        
                        ResultSet rs = query.executeQuery(sql);
                        int userId = 0;
                        while(rs.next()) {
                        userId = Integer.valueOf(rs.getString(1));
                        }
                        
                         System.out.println("userId = " + userId);
                         
                        Statement query2 = con.createStatement();
                        String sql2 = "insert into logs values ( '"+loginString+"', getdate(), '"+userId+"');";
                        naglowek_user_panel.setText("Zalogowany jako " + loginString);    
                        query2.executeUpdate(sql2);

                        con.close();
                        }
                    catch(SQLException error_polaczenie) {
                    dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                    dane.getChildren().add(fail);}   
                 
             gorny_panel.getChildren().clear();
             gorny_panel.getChildren().add(naglowek_user_panel);
             dane.getChildren().clear();
             
             loginField.clear();
             hasloField.clear();
             
             stopka.getChildren().addAll( k_tabela, k_kwerenda, k_procedura, k_wyzwalacz, wyloguj);
                       
             }    
         });
         
         
         
      wyloguj.setOnAction(e->{
             stopka.getChildren().clear();
             gorny_panel.getChildren().clear();
             gorny_panel.getChildren().add(naglowek_panel_log);

             loginField.clear();
             hasloField.clear();
             
             dane.getChildren().clear();
             dane.getChildren().addAll(ico1,naglowek_panel_log,panel_login, panel_haslo, log_button);
             
             panel_login.getChildren().clear();
             panel_haslo.getChildren().clear();
             panel_login.getChildren().add(loginField);
             panel_haslo.getChildren().add(hasloField);
             
             a=0;
             kl=0;
         });
      
      HBox panel_tabele = new HBox();
            panel_tabele.setMinSize(600,50);
            panel_tabele.setSpacing(15);
            panel_tabele.setAlignment(Pos.CENTER);
            panel_tabele.setId("panel_tabele");
            panel_tabele.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
    
            HBox panel_tabele2 = new HBox();           
            panel_tabele2.setMinSize(600,50);
            panel_tabele2.setSpacing(15);
            panel_tabele2.setAlignment(Pos.CENTER);
            panel_tabele2.setId("panel_tabele");
            panel_tabele2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            Button u_klasa_samolotowa=new Button("");
            u_klasa_samolotowa.setMinSize(100,38);
            u_klasa_samolotowa.setId("ks");
            u_klasa_samolotowa.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            Button u_typ_samolotu=new Button("");
            u_typ_samolotu.setMinSize(100,38);
            u_typ_samolotu.setId("ts");
            u_typ_samolotu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
      
            Button u_producent_samolotu=new Button("");
            u_producent_samolotu.setMinSize(100,38);
            u_producent_samolotu.setId("ps");
            u_producent_samolotu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            Button u_samolot=new Button("");
            u_samolot.setMinSize(100,38);
            u_samolot.setId("s");
            u_samolot.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            Button u_status_lotu=new Button("");
            u_status_lotu.setMinSize(100,38);
            u_status_lotu.setId("sl");
            u_status_lotu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
                
            Button u_kraj=new Button("");
            u_kraj.setMinSize(100,38);
            u_kraj.setId("k");
            u_kraj.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
                
            Button u_pasazer=new Button("");
            u_pasazer.setMinSize(100,38);
            u_pasazer.setId("p");
            u_pasazer.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            Button u_lotnisko=new Button("");
            u_lotnisko.setMinSize(100,38);
            u_lotnisko.setId("l");
            u_lotnisko.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            Button u_plan_lotu=new Button("");
            u_plan_lotu.setMinSize(100,38);
            u_plan_lotu.setId("pl");
            u_plan_lotu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
            
           
              try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_klient="select * from klasa_samolotowa";
                ResultSet wynik_zapyt_klasa_samolotowa = zapyt.executeQuery(sql_klient);          
                ResultSetMetaData wynik_kol_klasa_samolotowa = wynik_zapyt_klasa_samolotowa.getMetaData();
                ks = wynik_kol_klasa_samolotowa.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_klasa_samolotowa[] = new VBox[ks]; 
            for (int i = 0; i < boxes_klasa_samolotowa.length; i++) 
                {
                    boxes_klasa_samolotowa[i] = new VBox();
                    boxes_klasa_samolotowa[i].setMinWidth(80);
                }

            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_lekarz="select * from typ_samolotu";
                ResultSet wynik_zapyt_typ_samolotu = zapyt.executeQuery(sql_lekarz);          
                ResultSetMetaData wynik_kol_typ_samolotu = wynik_zapyt_typ_samolotu.getMetaData();
                ts = wynik_kol_typ_samolotu.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_typ_samolotu[] = new VBox[ts]; 
            for (int i = 0; i < boxes_typ_samolotu.length; i++) 
                {
                    boxes_typ_samolotu[i] = new VBox();
                    boxes_typ_samolotu[i].setMinWidth(80);
                }
            
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_recepta="select * from producent_samolotu";
                ResultSet wynik_zapyt_producent_samolotu = zapyt.executeQuery(sql_recepta);          
                ResultSetMetaData wynik_kol_producent_samolotu = wynik_zapyt_producent_samolotu.getMetaData();
                ps = wynik_kol_producent_samolotu.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_producent_samolotu[] = new VBox[ps]; 
            for (int i = 0; i < boxes_producent_samolotu.length; i++) 
                {
                    boxes_producent_samolotu[i] = new VBox();
                    boxes_producent_samolotu[i].setMinWidth(80);
                }
            
            
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_wizyta="select * from samolot";
                ResultSet wynik_zapyt_samolot = zapyt.executeQuery(sql_wizyta);          
                ResultSetMetaData wynik_kol_samolot = wynik_zapyt_samolot.getMetaData();
                s = wynik_kol_samolot.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_samolot[] = new VBox[s]; 
            for (int i = 0; i < boxes_samolot.length; i++) 
                {
                    boxes_samolot[i] = new VBox();
                    boxes_samolot[i].setMinWidth(80);
                }
                   try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
        
                Statement zapyt = con.createStatement(); 
                String sql_wizyta="select * from status_lotu";
                ResultSet wynik_zapyt_status_lotu = zapyt.executeQuery(sql_wizyta);          
                ResultSetMetaData wynik_kol_status_lotu = wynik_zapyt_status_lotu.getMetaData();
                sl= wynik_kol_status_lotu.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_status_lotu[] = new VBox[sl]; 
            for (int i = 0; i < boxes_status_lotu.length; i++) 
                {
                    boxes_status_lotu[i] = new VBox();
                    boxes_status_lotu[i].setMinWidth(80);
                }
                  try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_wizyta="select * from kraj";
                ResultSet wynik_zapyt_kraj = zapyt.executeQuery(sql_wizyta);          
                ResultSetMetaData wynik_kol_kraj = wynik_zapyt_kraj.getMetaData();
                k = wynik_kol_kraj.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
            System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
            System.out.println("Brak sterownika");} 
        
            VBox boxes_kraj[] = new VBox[k]; 
            for (int i = 0; i < boxes_kraj.length; i++) 
                {
                    boxes_kraj[i] = new VBox();
                    boxes_kraj[i].setMinWidth(80);
                }
                  try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
      
                Statement zapyt = con.createStatement(); 
                String sql_wizyta="select * from pasazer";
                ResultSet wynik_zapyt_pasazer = zapyt.executeQuery(sql_wizyta);          
                ResultSetMetaData wynik_kol_pasazer = wynik_zapyt_pasazer.getMetaData();
                p = wynik_kol_pasazer.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_pasazer[] = new VBox[p]; 
            for (int i = 0; i < boxes_pasazer.length; i++) 
                {
                    boxes_pasazer[i] = new VBox();
                    boxes_pasazer[i].setMinWidth(80);
                }
               try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_wizyta="select * from lotnisko";
                ResultSet wynik_zapyt_lotnisko = zapyt.executeQuery(sql_wizyta);          
                ResultSetMetaData wynik_kol_lotnisko = wynik_zapyt_lotnisko.getMetaData();
                l = wynik_kol_lotnisko.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_lotnisko[] = new VBox[l]; 
            for (int i = 0; i < boxes_lotnisko.length; i++) 
                {
                    boxes_lotnisko[i] = new VBox();
                    boxes_lotnisko[i].setMinWidth(50);
                }
                try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_wizyta="select * from plan_lotu";
                ResultSet wynik_zapyt_plan_lotu = zapyt.executeQuery(sql_wizyta);          
                ResultSetMetaData wynik_kol_plan_lotu = wynik_zapyt_plan_lotu.getMetaData();
                pl = wynik_kol_plan_lotu.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_plan_lotu[] = new VBox[pl]; 
            for (int i = 0; i < boxes_plan_lotu.length; i++) 
                {
                    boxes_plan_lotu[i] = new VBox();
                    boxes_plan_lotu[i].setMinWidth(80);
                }
            
             wyjdz.setOnAction(e->{
                  stopka.getChildren().clear();
                  ds.getChildren().clear();
                  panel_tabele.getChildren().clear();
                  panel_tabele2.getChildren().clear();
                  dane.getChildren().clear();
                  stopka.getChildren().addAll( k_tabela, k_kwerenda, k_procedura, k_wyzwalacz, wyloguj);
             });
             inne.setOnAction(e->{
                  stopka.getChildren().clear();
                  stopka.getChildren().addAll( u_plan_lotu, u_pasazer, u_kraj, u_lotnisko, wyjdz);
             });
            
              k_tabela.setOnAction(e->{
                  stopka.getChildren().clear();
                  ds.getChildren().clear();
                  dane.getChildren().clear();
                  dane.getChildren().addAll(tab, ds);
                  stopka.getChildren().addAll(u_klasa_samolotowa, u_typ_samolotu, u_samolot, u_status_lotu, u_producent_samolotu, inne);               
                  
                  u_klasa_samolotowa.setOnAction(ks->{
                        tab.setText("Tabela Klasa Samolotowa");
                         for (int i = 0; i < boxes_klasa_samolotowa.length; i++) 
                        {
                            boxes_klasa_samolotowa[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_klasa_samolotowa);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from klasa_samolotowa";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_klasa_samolotowa.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                     boxes_klasa_samolotowa[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                   
                  });
                  u_typ_samolotu.setOnAction(ts->{
                      tab.setText("Tabela Typ Samolotu");
                         for (int i = 0; i < boxes_typ_samolotu.length; i++) 
                        {
                            boxes_typ_samolotu[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_typ_samolotu);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from typ_samolotu";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_typ_samolotu.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_typ_samolotu[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
     
                  });
                  u_producent_samolotu.setOnAction(ps->{
                      tab.setText("Tabela Producent");
                         for (int i = 0; i < boxes_producent_samolotu.length; i++) 
                        {
                            boxes_producent_samolotu[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_producent_samolotu);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from producent_samolotu";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_producent_samolotu.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_producent_samolotu[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        } 
                  });
                   u_samolot.setOnAction(s->{
                      tab.setText("Tabela Samolot");
                         for (int i = 0; i < boxes_samolot.length; i++) 
                        {
                            boxes_samolot[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_samolot);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from samolot";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_samolot.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_samolot[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }                 
                  });
                       u_status_lotu.setOnAction(sl->{
                      tab.setText("Tabela Status Lotu");
                         for (int i = 0; i < boxes_status_lotu.length; i++) 
                        {
                            boxes_status_lotu[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_status_lotu);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from status_lotu";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_status_lotu.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                     boxes_status_lotu[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }                 
                  });
                       u_kraj.setOnAction(k->{
                        tab.setText("Tabela Kraj");
                         for (int i = 0; i < boxes_kraj.length; i++) 
                        {
                            boxes_kraj[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_kraj);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from kraj";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_kraj.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_kraj[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }

                  });
                       //plan_lotu
                        u_plan_lotu.setOnAction(pl->{
                        tab.setText("Tabela Plan Lotu");
                         for (int i = 0; i < boxes_plan_lotu.length; i++) 
                        {
                            boxes_plan_lotu[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_plan_lotu);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from plan_lotu";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_plan_lotu.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                     boxes_plan_lotu[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }                 
                  });
                             u_lotnisko.setOnAction(l->{
                      tab.setText("Tabela Lotnisko");
                         for (int i = 0; i < boxes_lotnisko.length; i++) 
                        {
                            boxes_lotnisko[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_lotnisko);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from lotnisko";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_lotnisko.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                     boxes_lotnisko[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }            
                  });
                             u_pasazer.setOnAction(p->{
                      tab.setText("Tabela Pasazer");
                         for (int i = 0; i < boxes_pasazer.length; i++) 
                        {
                            boxes_pasazer[i].getChildren().clear();
                        }
                        ds.getChildren().clear();
                        ds.getChildren().addAll(boxes_pasazer);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from pasazer";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_pasazer.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                     boxes_pasazer[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }                                
                  });                      
              });
                           
               Label proc_read = new Label("Odczytaj procedurę");
         proc_read.setId("a_user");
         proc_read.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
            
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_recepta="EXEC obniżka_opłat_dla_najczesciej_podrozujacych 500;";
                ResultSet wynik_zapyt_recepta = zapyt.executeQuery(sql_recepta);          
                ResultSetMetaData wynik_kol_recepta = wynik_zapyt_recepta.getMetaData();
                kp = wynik_kol_recepta.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_procedura[] = new VBox[kp]; 
            for (int i = 0; i < boxes_procedura.length; i++) 
                {
                    boxes_procedura[i] = new VBox();
                    boxes_procedura[i].setMinWidth(50);
                }
     
              k_procedura.setOnAction(e->{
                  
                   dane.getChildren().clear();
                   dane.getChildren().addAll(proc_read, ds);
                
                for (int i = 0; i < boxes_procedura.length; i++) 
            {
                boxes_procedura[i].getChildren().clear();
            }
                ds.getChildren().clear();
             ds.getChildren().addAll(boxes_procedura);
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                Statement zapytanie = con.createStatement(); 
                String sql="EXEC obniżka_opłat_dla_najczesciej_podrozujacych 500;";
                ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                while(wynik_zapytania.next())
                {
                    int i=1,j;
                    for (j=0;j<boxes_procedura.length;j++)
                    {
                        Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                        boxes_procedura[j].getChildren().addAll(kolumna);                       
                        i++;
                    }
                } 
                con.close();
            }
            catch(SQLException con1) {
                System.out.println("Błąd połączenia");
            }
            catch(ClassNotFoundException ster1) {
                System.out.println("Brak sterownika");
            }   
              });  
               Label kwer_read = new Label("Odczytaj kwerendę");
                kwer_read.setId("a_user");
                kwer_read.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());   
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql="SELECT * FROM pasazer_informacje GROUP BY id_pasazer,imie, nazwisko,nazwa, ilosc_rez,nazwa,czy_kupowal  HAVING ilosc_rez>(SELECT AVG(ilosc_rez) FROM pasazer_informacje WHERE czy_kupowal = 'TAK')";
                ResultSet wynik_zapyt_recepta = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol_k = wynik_zapyt_recepta.getMetaData();
                kk = wynik_kol_k.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_kwerenda[] = new VBox[kk]; 
            for (int i = 0; i < boxes_kwerenda.length; i++) 
                {
                    boxes_kwerenda[i] = new VBox();
                    boxes_kwerenda[i].setMinWidth(50);
                }
             
              k_kwerenda.setOnAction(e->{
                  
                   dane.getChildren().clear();
                   dane.getChildren().addAll(kwer_read, ds);

                for (int i = 0; i < boxes_kwerenda.length; i++) 
            {
                boxes_kwerenda[i].getChildren().clear();
            }
                ds.getChildren().clear();
             ds.getChildren().addAll(boxes_kwerenda);
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                Statement zapytanie = con.createStatement(); 
                String sql="SELECT * FROM pasazer_informacje GROUP BY id_pasazer,imie, nazwisko,nazwa, ilosc_rez,nazwa,czy_kupowal  HAVING ilosc_rez>(SELECT AVG(ilosc_rez) FROM pasazer_informacje WHERE czy_kupowal = 'TAK')";
                ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                while(wynik_zapytania.next())
                {
                    int i=1,j;
                    for (j=0;j<boxes_kwerenda.length;j++)
                    {
                        Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                        boxes_kwerenda[j].getChildren().addAll(kolumna);                       
                        i++;
                    }
                } 
                con.close();
            }
            catch(SQLException con1) {
                System.out.println("Błąd połączenia");
            }
            catch(ClassNotFoundException ster1) {
                System.out.println("Brak sterownika");
            }   
              });    
               Label trigg_read = new Label("Odczytaj wynik wyzwalacza");
                trigg_read.setId("a_user");
                trigg_read.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
                 TextField numer = new PasswordField();
                 numer.setMinWidth(220);
                 numer.setPromptText("Wpisz swoje haslo");
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                Statement zapyt = con.createStatement(); 
                String sql_recepta="SELECT * FROM producent_samolotu";
                ResultSet wynik_zapyt_recepta = zapyt.executeQuery(sql_recepta);          
                ResultSetMetaData wynik_kol_recepta = wynik_zapyt_recepta.getMetaData();
                w = wynik_kol_recepta.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_wyzwalacz[] = new VBox[w]; 
            for (int i = 0; i < boxes_wyzwalacz.length; i++) 
                {
                    boxes_wyzwalacz[i] = new VBox();
                    boxes_wyzwalacz[i].setMinWidth(80);
                }
        
              
              k_wyzwalacz.setOnAction(e->{
                  
                   dane.getChildren().clear();
                   dane.getChildren().addAll(trigg_read, ds);
                
                for (int i = 0; i < boxes_wyzwalacz.length; i++) 
            {
                boxes_wyzwalacz[i].getChildren().clear();
            }
                ds.getChildren().clear();
             ds.getChildren().addAll(boxes_wyzwalacz);
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                Statement zapytanie = con.createStatement(); 
                String sql="SELECT * FROM producent_samolotu";
                ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                while(wynik_zapytania.next())
                {
                    int i=1,j;
                    for (j=0;j<boxes_wyzwalacz.length;j++)
                    {
                        Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                        boxes_wyzwalacz[j].getChildren().addAll(kolumna);                       
                        i++;
                    }
                } 
                con.close();
            }
            catch(SQLException con1) {
                System.out.println("Błąd połączenia");
            }
            catch(ClassNotFoundException ster1) {
                System.out.println("Brak sterownika");
            }   
              });
      
         Label string = new Label("");
         
         Label user_added = new Label("Dodano uzytkownika o nazwie: ");
         user_added.setId("user_succes");
         user_added.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label user_null= new Label("Pola nie moga byc puste");
         user_null.setId("user_error");
         user_null.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Button add_user=new Button("");
         add_user.setMinSize(100,38);
         add_user.setId("a_dodaj_button");
         add_user.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
         Label user_exist = new Label("Istnieje już taka nazwa konta, spróbuj ponownie.");
         user_exist.setId("user_error");
         user_exist.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
            a_dodaj.setOnAction(e->{
                dane.getChildren().clear();
                dane.getChildren().addAll(ico2,naglowek_dodaj,panel_login, panel_haslo, add_user);
                loginField.setPromptText("Wpisz Login Dla Uzytkownika");
                hasloField.setPromptText("Wpisz Haslo dla Uzytkownika");
                panel_login.getChildren().clear();
                panel_haslo.getChildren().clear();
                panel_login.getChildren().add(loginField );
                panel_haslo.getChildren().add(hasloField );
                
                add_user.setOnAction(w->{
                    Label loginWynik=new Label();
                    loginWynik.setText(loginField.getText());
                    String loginString=loginWynik.getText();
                    loginField.clear();
              
                    Label hasloWynik=new Label();
                    hasloWynik.setText(hasloField.getText());
                    String hasloString=hasloWynik.getText();
                    hasloField.clear();
                    
                    
                    dane.getChildren().clear();
                dane.getChildren().addAll(ico2,naglowek_dodaj,panel_login, panel_haslo, add_user);
                loginField.setPromptText("Wpisz Login Dla Uzytkownika");
                hasloField.setPromptText("Wpisz Haslo dla Uzytkownika");
                panel_login.getChildren().clear();
                panel_haslo.getChildren().clear();
                panel_login.getChildren().add(loginField );
                panel_haslo.getChildren().add(hasloField );
                    
                    
                    try{
             
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                        String sql = "select login from uzytkownik where login='"+loginString+"';";
                        preparedStatement = con.prepareStatement(sql);
                        ResultSet rs = preparedStatement.executeQuery();
                        if (rs != null && !rs.isClosed() && rs.next())
                        {
                            dane.getChildren().add(user_exist);
                        }
                        else if (loginString == "" || hasloString == "") {
                            dane.getChildren().add(user_null);
                        }
                       
                        else{
                            String sql2 = "insert into uzytkownik values ('"+loginString+"', '"+hasloString+"');";
                            Statement query = con.createStatement();
                            query.executeUpdate(sql2);
                            user_added.setText("Dodano uzytkownika o naazwie " +loginString);
                            dane.getChildren().add(user_added);
                        }
                        con.close();
                        }
                    
                    catch(SQLException error_polaczenie) {
                    dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                    dane.getChildren().add(fail);}
                });               
            });           
         Label user_deleted = new Label("Usunięto użytkownika.");
         user_deleted.setId("user_succes");
         user_deleted.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Button delete_user=new Button("");
        delete_user.setMinSize(100,39);
        delete_user.setId("a_usun_button");
        delete_user.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
         Label user_not_exist = new Label("Nie istnieje taka nazwa konta, spróbuj ponownie.");
         user_not_exist.setId("user_error");
         user_not_exist.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
            a_usun.setOnAction(e->{

                dane.getChildren().clear();
                dane.getChildren().addAll(ico3,naglowek_usun,panel_login, delete_user);
                loginField.setPromptText("Wpisz Login Dla Uzytkownika");
                panel_login.getChildren().clear();
                panel_login.getChildren().add(loginField );
                
                delete_user.setOnAction(w->{
                
                    Label loginWynik=new Label();
                    loginWynik.setText(loginField.getText());
                    String loginString=loginWynik.getText();
                    loginField.clear();
 
                    dane.getChildren().clear();
                    dane.getChildren().addAll(ico3,naglowek_usun,panel_login, delete_user);
                    loginField.setPromptText("Wpisz Login Dla Uzytkownika");
                    panel_login.getChildren().clear();
                    panel_login.getChildren().add(loginField );
                  
                    try{
             
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                        String sql = "select login from uzytkownik where login='"+loginString+"';";
                        preparedStatement = con.prepareStatement(sql);
                        ResultSet rs = preparedStatement.executeQuery();
                        if (rs != null && !rs.isClosed() && rs.next())
                        {   
                            String sql2 = "delete from uzytkownik where login =('"+loginString+"');";
                            Statement query = con.createStatement();
                            query.executeUpdate(sql2);
                            dane.getChildren().add(user_deleted);
                            string.setText("Usunieto uzytkownika o loginie: " + loginString);
                            dane.getChildren().add(string);
                        }
                        else{
                            dane.getChildren().add(user_not_exist);
                            
                        }
                        con.close();
                        }
                    catch(SQLException error_polaczenie) {
                    dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                    dane.getChildren().add(fail);}    
                });       
            });
         //EDYCJA
         Label user_edited = new Label("Użytkownik edytowany.");
         user_edited.setId("user_succes");
         user_edited.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         //button do edycji
         Button edit_user=new Button("");
         edit_user.setMinSize(100,39);
         edit_user.setId("a_edytuj_button");
         edit_user.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
         //panel dla nowego loginu
         HBox panel_login2 = new HBox();
         panel_login2.setMinWidth(230);
         panel_login2.setAlignment(Pos.CENTER);
         panel_login2.setSpacing(15);
         panel_login2.setMinHeight(80);
         
         //nowy login
         TextField loginField2 = new TextField();
         loginField2.setMinWidth(220);
         
         //nowe haslo
         PasswordField hasloField2 = new PasswordField();
         hasloField2.setMinWidth(220);
         
            a_edytuj.setOnAction(e->{
                               
                dane.getChildren().clear();
                dane.getChildren().addAll(ico4,naglowek_edit,panel_login,panel_login2,panel_haslo, edit_user);
                loginField.setPromptText("Wpisz Login Dla Uzytkownika");
                loginField2.setPromptText("Wpisz Nowy Login Dla Uzytkownika");
                hasloField2.setPromptText("Wpisz Nowe Haslo Dla Uzytkownika");
                panel_login.getChildren().clear();
                panel_login2.getChildren().clear();
                panel_haslo.getChildren().clear();
                               
                panel_login.getChildren().addAll(loginField);
                panel_login2.getChildren().addAll(loginField2);
                panel_haslo.getChildren().addAll(hasloField2);
  
                edit_user.setOnAction(w->{
                
                    Label loginWynik=new Label();
                    loginWynik.setText(loginField.getText());
                    String loginString=loginWynik.getText();
                    
                    Label loginWynik2=new Label();
                    loginWynik2.setText(loginField2.getText());
                    String loginString2=loginWynik2.getText();
                    
                    Label hasloWynik2=new Label();
                    hasloWynik2.setText(hasloField2.getText());
                    String hasloString2=hasloWynik2.getText();
                    
                    loginField.clear();
                    loginField2.clear();
                    hasloField.clear();
                    hasloField2.clear();
 
                    dane.getChildren().clear();
                    dane.getChildren().addAll(ico4,naglowek_edit,panel_login,panel_login2,panel_haslo, edit_user);
                    loginField.setPromptText("Wpisz Login Dla Uzytkownika");
                    loginField2.setPromptText("Wpisz Nowy Login Dla Uzytkownika");
                    hasloField2.setPromptText("Wpisz Nowe Haslo Dla Uzytkownika");
                    panel_login.getChildren().clear();
                    panel_login2.getChildren().clear();
                    panel_haslo.getChildren().clear();                
                
                    panel_login.getChildren().addAll(loginField);
                    panel_login2.getChildren().addAll(loginField2);
                    panel_haslo.getChildren().addAll(hasloField2);
       
                    try{             
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                        String sql = "select login from uzytkownik where login='"+loginString+"';";
                        preparedStatement = con.prepareStatement(sql);
                        ResultSet rs = preparedStatement.executeQuery();
                        if (rs != null && !rs.isClosed() && rs.next())
                        {                           
                            String sql2 = "update uzytkownik set login='"+loginString2+"', haslo='"+hasloString2+"' where login =('"+loginString+"');";
                            Statement query = con.createStatement();
                            query.executeUpdate(sql2);
                            dane.getChildren().add(user_edited);               
                        }
                        else{
                            dane.getChildren().add(user_not_exist);         
                        }
                        con.close();        
                        }
                    catch(SQLException error_polaczenie) {
                    dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                    dane.getChildren().add(fail);}             
                });                
            });

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(600,300);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setStyle("-fx-background-color: green;");        
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

        Statement zapyt = con.createStatement(); 
        String sql="select id_logs, DATEFROMPARTS(YEAR(data_logowania),MONTH(data_logowania),DAY(data_logowania)), SUBSTRING(Convert(varchar,data_logowania,100),12,12), nazwa_uzytkownika  from logs";
        ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
        ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
        kolumny = wynik_kol.getColumnCount();
        zapyt.close();
        con.close();            
        }
        catch(SQLException sqle) {
        System.out.println("Błąd połączenia");}
        catch(ClassNotFoundException e) {
        System.out.println("Brak sterownika");} 
        
        VBox boxes[] = new VBox[kolumny]; 
        for (int i = 0; i < boxes.length; i++) 
        {
            boxes[i] = new VBox();
            boxes[i].setMinWidth(80);
        }
         
            a_odczyt.setOnAction(e->{
                
                dane.getChildren().clear();
                dane.getChildren().addAll(ico6,log_read, ds);
                
                for (int i = 0; i < boxes.length; i++) 
            {
                boxes[i].getChildren().clear();
            }
                ds.getChildren().clear();
             ds.getChildren().addAll(boxes);
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");
                
                Statement zapytanie = con.createStatement(); 
                String sql="select id_logs, DATEFROMPARTS(YEAR(data_logowania),MONTH(data_logowania),DAY(data_logowania)), SUBSTRING(Convert(varchar,data_logowania,100),12,12), nazwa_uzytkownika  from logs";
                ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                while(wynik_zapytania.next())
                {
                    int i=1,j;
                    for (j=0;j<boxes.length;j++)
                    {
                        Label przerwa=new Label("|");
                        Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                 
                        boxes[j].getChildren().addAll(kolumna);                       
                        i++;
                    }
                } 
                con.close();
            }
            catch(SQLException con1) {
                System.out.println("Błąd połączenia");
            }
            catch(ClassNotFoundException ster1) {
                System.out.println("Brak sterownika");
            }   
            
            });
            
            a_users.setOnAction(e->{
                
                dane.getChildren().clear();
                dane.getChildren().addAll(ico5,naglowek_users);
                
             try{             
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Baza;user=admin2;password=haslo;");

                        String sql = "Select * from users";
                        preparedStatement = con.prepareStatement(sql);
                        ResultSet rs = preparedStatement.executeQuery();
                       while(rs.next()) {
                           Label users= new Label(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
                           users.setId("users");
                           users.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
                           dane.getChildren().add(users);    
                           
                       }
                        con.close();        
                        }
                    catch(SQLException error_polaczenie) {
                    dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                    dane.getChildren().add(fail);}    
            
            });
            
           
              
              
        Scene scena = new Scene(okno, 800, 600);
        
        stage.setScene(scena); 
        stage.show();
    }
    //--------------------------------------
    public static void main(String[] args) {
        launch(args);
    }  
}

