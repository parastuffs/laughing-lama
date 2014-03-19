package softarch.portal.db.flatfile;

import java.util.List;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import softarch.portal.data.Article;
import softarch.portal.data.Book;
import softarch.portal.data.Conference;
import softarch.portal.data.InterestingWebsite;
import softarch.portal.data.RawData;
import softarch.portal.data.RegularData;
import softarch.portal.data.Report;
import softarch.portal.data.SoftwareRepository;
import softarch.portal.db.DatabaseException;
import softarch.portal.db.RawDatabase;

import java.sql.SQLException;

/**
 * This class encapsulates the portal's raw database.
 * @author Niels Joncheere
 */
public class RawDatabaseCSV extends DatabaseCSV implements RawDatabase {
	/**
	 * Creates a new raw database.
	 */
	public RawDatabaseCSV(String dbUser, String dbPassword, String dbUrl)throws DatabaseException{
		super(dbUser, dbPassword, dbUrl);

	}

	/**
	 * Returns a list of all raw data.
	 */
	public List getRawData()throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}

	public int getNewId()throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}

	/**
	 * Returns a specific raw data object.
	 */
	public RawData getRawData(int id)throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}

	public void addRawData(RegularData regularData)throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}

	/**
	 * Deletes a raw data object.
	 */
	public void deleteRawData(RawData rd)throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}

	/**
	 * Updates a raw data object.
	 */
	public void updateRawData(RawData rd)throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}

	/**
	 * Returns the number of records in the raw database.
	 */
	public int getNumberOfRawRecords()throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}
}
