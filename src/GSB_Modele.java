import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GSB_Modele {
	private static Connection connexion;
	private static Statement Statement;
	private static ResultSet rs;

	
	//Test commentaire Git
	//test 2
	public static boolean connexion(){
		boolean rep= false;
		try{
			
			Class.forName("com.mysql.jdbc.Driver") ;
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsbmvc", "root", "");
			Statement = connexion.createStatement(); 
			System.out.println("ok");
		rep = true;
		}
		catch  (ClassNotFoundException e) {
			
			System.out.println("driveur non chargé");
		}
		catch (SQLException e){
			
		}
		
	return rep;
	}
	
	public static void connection(String unLogin, String unMdp){

	
	    
	 
	    String sql = ("SELECT count(*) login,mdp FROM visiteur WHERE login ='" + unLogin+ "' AND mdp='"+ unMdp+ "';" );
	   int count= 0;
		try{
			
			rs = Statement.executeQuery(sql);
			if(rs.next()){
			count=rs.getInt(1);
			
			}
			if(count!=0){
			System.out.println("yataaaa");
			}
			else{
				System.out.println("Erreur de connexion Login ou Mots de passe incorecte");
			}
			rs.close();
		}
		catch(SQLException e){
			System.out.println("problème sql" + e);
		}
	}
	
}
