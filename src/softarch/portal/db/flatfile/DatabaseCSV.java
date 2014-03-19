package softarch.portal.db.flatfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Iterator;
import java.io.File;


import softarch.portal.db.DatabaseException;
import softarch.portal.db.Database;

/**
 * This abstract class implements the behaviour that is to be shared
 * by all databases.
 * @author Niels Joncheere
 */
public class DatabaseCSV extends Database {
	protected String dbUser;
	protected String dbPassword;
	protected String dbUrl;

	/**
	 * Creates a new database.
	 */
	public DatabaseCSV(String dbUser, String dbPassword, String dbUrl) {
		super(dbUser, dbPassword, dbUrl);
		
		File db = new File (dbUrl);
		if (!(db.exists() && db.isDirectory())) {
			 System.out.println("Creating CSV database.");
		     db.mkdirs();
		} 
	}

}
