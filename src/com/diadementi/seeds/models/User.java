/**
 * 
 */
package com.diadementi.seeds.models;

/**
 * @author user pc
 *
 */
public class User {
	protected int id;
	protected String name;
	protected String email;
	private String password;
	protected String bio;
	protected String api_key;
	protected String joined;

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}


	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}
	

}
