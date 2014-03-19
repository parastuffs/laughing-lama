package softarch.portal.db;

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

import java.sql.SQLException;

/**
 * This class encapsulates the portal's raw database.
 * @author Niels Joncheere
 */
public interface RawDatabase {

	/**
	 * Returns a list of all raw data.
	 */
	public List getRawData()throws DatabaseException;

	public int getNewId()throws DatabaseException;

	/**
	 * Returns a specific raw data object.
	 */
	public RawData getRawData(int id)throws DatabaseException;

	public void addRawData(RegularData regularData) throws DatabaseException;

	/**
	 * Deletes a raw data object.
	 */
	public void deleteRawData(RawData rd)throws DatabaseException;

	/**
	 * Updates a raw data object.
	 */
	public void updateRawData(RawData rd)throws DatabaseException;

	/**
	 * Returns the number of records in the raw database.
	 */
	public int getNumberOfRawRecords()throws DatabaseException;
}
