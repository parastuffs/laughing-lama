package softarch.portal.db.flatfile;

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
import java.util.Date;
import java.util.Calendar;

import softarch.portal.db.UserDatabase;
import softarch.portal.db.DatabaseException;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class encapsulates the user database.
 * @author Niels Joncheere
 */
public class UserDatabaseCSV extends DatabaseCSV implements UserDatabase  {
	/**
	 * Creates a new user database.
	 */
	File freeUsers;
	File cheapUsers;
	File expUsers;


	public UserDatabaseCSV(String dbUser, String dbPassword, String dbUrl) {
		super(dbUser, dbPassword, dbUrl);

		//Create the files needed to store the users
		freeUsers = new File(dbUrl +"/freeUsers.csv");
		cheapUsers = new File(dbUrl +"/cheapUsers.csv");
		expUsers = new File(dbUrl + "/expUsers.csv");
		System.out.println(freeUsers.getPath());

	}

	/**
	 * Inserts a new user profile into the user database.
	 */
	public void insert(UserProfile profile)throws DatabaseException{
		String infos[] = profile.asCSV().split(":");
		//System.out.println(infos[1]);

		try{
			if(infos[0].equals("free")){
				BufferedWriter output = new BufferedWriter(new FileWriter(freeUsers));
				output.write(infos[1]);
				output.close();
			}
			else if(infos[0].equals("cheap")){
				BufferedWriter output = new BufferedWriter(new FileWriter(cheapUsers));
				output.write(infos[1]);
				output.close();
			}
			else if(infos[0].equals("expensive")){
				BufferedWriter output = new BufferedWriter(new FileWriter(expUsers));
				output.write(infos[1]);
				output.close();
			}
			else{
				throw new DatabaseException("Not implemented");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	/**
	 * Updates an existing user profile in the user database.
	 */
	public void update(UserProfile profile)throws DatabaseException{
		throw new DatabaseException("Not implemented");
	}

	/**
	 * Returns the user with the specified username.
	 */
	public UserProfile findUser(String username)throws DatabaseException{
		UserProfile profile = null;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(cheapUsers));
			boolean found = false;
			String line = null;
			String splittedLine[] = null;

			while ((line = reader.readLine()) != null && !found){
				splittedLine = line.split(",");
				if(splittedLine[0].equals(username))
					found = true;
			}
			System.out.println(found + " " + splittedLine.length);
			reader.close();
			if(found && splittedLine.length == 6){
				return new CheapSubscription(splittedLine[0],splittedLine[1],splittedLine[2],splittedLine[3],splittedLine[4], Calendar.getInstance().getTime());
			}
			
			reader = new BufferedReader(new FileReader(freeUsers));
			while ((line = reader.readLine()) != null && !found){
				splittedLine = line.split(",");
				if(splittedLine[0].equals(username))
					found = true;
			}
			reader.close();
			if(found && splittedLine.length == 6){
				return new CheapSubscription(splittedLine[0],splittedLine[1],splittedLine[2],splittedLine[3],splittedLine[4], Calendar.getInstance().getTime());
			}
			
			reader = new BufferedReader(new FileReader(expUsers));
			while ((line = reader.readLine()) != null && !found){
				splittedLine = line.split(",");
				if(splittedLine[0].equals(username))
					found = true;
			}
			reader.close();
			if(found && splittedLine.length == 6){
				return new CheapSubscription(splittedLine[0],splittedLine[1],splittedLine[2],splittedLine[3],splittedLine[4], Calendar.getInstance().getTime());
			}

		}
		catch(IOException e){
			e.printStackTrace();
		}
		return profile;
	}

	/**
	 * Checks whether a user with the specified username exists.
	 */
	public boolean userExists(String username)throws DatabaseException{
		boolean found = false;
		try{
			//BufferedReader reader = new BufferedReader(new FileReader(cheapUsers));
			BufferedReader reader;

			String line;
			String splittedLine[] = null;
			reader = new BufferedReader(new FileReader(cheapUsers));
			while ((line = reader.readLine()) != null && !found){
				splittedLine = line.split(",");
				if(splittedLine[0].equals(username))
					found = true;
			}
			reader.close();
			reader = new BufferedReader(new FileReader(freeUsers));
			while ((line = reader.readLine()) != null && !found){
				splittedLine = line.split(",");
				if(splittedLine[0].equals(username))
					found = true;
			}
			reader.close();
			reader = new BufferedReader(new FileReader(expUsers));
			while ((line = reader.readLine()) != null && !found){
				splittedLine = line.split(",");
				if(splittedLine[0].equals(username))
					found = true;
			}
			reader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return found;
	}
}
