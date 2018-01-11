/**
 * 
 */
package com.revature.ers.model;

/**
 * @author Mohamed
 *
 */
public class Reqtype {
	
	
	private int id;
	private String name;

	/**
	 * 
	 */
	public Reqtype() {
		
	}

	/**
	 * @param id
	 * @param name
	 */
	public Reqtype(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reqtype [id=" + id + ", name=" + name + "]";
	}

	

	
	
}
