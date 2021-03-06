package softarch.portal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Iterator;

import softarch.portal.db.DatabaseException;

/**
 * This abstract class implements the behaviour that is to be shared
 * by all databases.
 * @author Niels Joncheere
 */
public abstract class Database {
	protected String dbUser;
	protected String dbPassword;
	protected String dbUrl;

	/**
	 * Creates a new database.
	 */
	public Database(String dbUser, String dbPassword, String dbUrl) {
		this.dbUser	= dbUser;
		this.dbPassword	= dbPassword;
		this.dbUrl	= dbUrl;
	}

}
