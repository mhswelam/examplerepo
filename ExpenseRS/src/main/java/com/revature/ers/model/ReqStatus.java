/**
 * 
 */
package com.revature.ers.model;

/**
 * @author Mohamed
 *
 */
public class ReqStatus {
	
	private int id;
	private String name;

	/**
	 * 
	 */
	public ReqStatus() {
		
	}

	/**
	 * @param id
	 * @param name
	 */
	public ReqStatus(int id, String name) {
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
		return "ReqStatus [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
