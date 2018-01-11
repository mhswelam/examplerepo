/**
 * 
 */
package com.revature.ers.dto;

/**
 * @author Mohamed
 *
 */
public class ReceviedString {
	
	private String id1;
	private String id2;
	private String id3;
	
	public ReceviedString() {
	
	}
	
	

	/**
	 * @param id1
	 * @param id2
	 * @param id3
	 */
	public ReceviedString(String id1, String id2, String id3) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.id3 = id3;
	}



	/**
	 * @return the id1
	 */
	public String getId1() {
		return id1;
	}

	/**
	 * @param id1 the id1 to set
	 */
	public void setId1(String id1) {
		this.id1 = id1;
	}

	/**
	 * @return the id2
	 */
	public String getId2() {
		return id2;
	}

	/**
	 * @param id2 the id2 to set
	 */
	public void setId2(String id2) {
		this.id2 = id2;
	}

	/**
	 * @return the id3
	 */
	public String getId3() {
		return id3;
	}

	/**
	 * @param id3 the id3 to set
	 */
	public void setId3(String id3) {
		this.id3 = id3;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReceviedString [id1=" + id1 + ", id2=" + id2 + ", id3=" + id3 + "]";
	}

	
	
}
