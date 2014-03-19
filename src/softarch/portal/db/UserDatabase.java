package softarch.portal.db;

import softarch.portal.data.CheapSubscription;
import softarch.portal.data.ExpensiveSubscription;
import softarch.portal.data.ExpertAdministrator;
import softarch.portal.data.ExternalAdministrator;
import softarch.portal.data.FreeSubscription;
import softarch.portal.data.Operator;
import softarch.portal.data.RegularAdministrator;
import softarch.portal.data.UserProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * This class encapsulates the user database.
 * @author Niels Joncheere
 */
public interface UserDatabase {

	/**
	 * Inserts a new user profile into the user database.
	 */
	public void insert(UserProfile profile)throws DatabaseException;
	/**
	 * Updates an existing user profile in the user database.
	 */
	public void update(UserProfile profile)throws DatabaseException;

	/**
	 * Returns the user with the specified username.
	 */
	public UserProfile findUser(String username)throws DatabaseException;

	/**
	 * Checks whether a user with the specified username exists.
	 */
	public boolean userExists(String username)throws DatabaseException;
}
