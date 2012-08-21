/**
 * 
 */
package dev.test;

import java.sql.CallableStatement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author IKANE
 *
 */
public class TestProcedureStockee {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//Chargement du driver
		Class.forName("com.mysql.jdbc.Driver");
//		Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		
		//Connexion au SGBD
		java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		//Creation de la procedure
		Statement statement = connection.createStatement();
		statement.executeUpdate("DROP PROCEDURE IF EXISTS rechercherNom");
		statement.executeUpdate(
			    "CREATE PROCEDURE rechercherNom(IN leNom VARCHAR(50))\n"
			    + "BEGIN\n" 
			    + " SELECT * FROM Annuaire WHERE nom = leNom;\n"
			    + " SELECT COUNT(*) FROM Annuaire WHERE nom = leNom;\n"   
			    + "END\n");
		//Appel a la procedure stockee
		CallableStatement callableStatement = connection.prepareCall("{call rechercherNom(?)}");
		//Passage de kane comme valeur du premier parametre
		callableStatement.setString(1, "kane");
		boolean resultOK = callableStatement.execute();
		if(resultOK) {
			//Recuperation des ResultSet
			ResultSet resultSet1 = callableStatement.getResultSet();
			callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT);
			ResultSet resultSet2 = callableStatement.getResultSet();
			//Traitement des informations
			while(resultSet1.next()) {
				for (int i = 0; i < resultSet1.getMetaData().getColumnCount(); i++) {
					System.out.print(resultSet1.getObject(i+1)+" ,");
				}
				System.out.println("");
			}
			resultSet2.next();
			System.out.println("Nombre de lignes = " + resultSet2.getObject(1));
			resultSet1.close();
			resultSet2.close();
		}
	}
}
