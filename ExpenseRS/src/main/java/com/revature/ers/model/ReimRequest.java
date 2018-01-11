/**
 * 
 */
package com.revature.ers.model;


import java.io.File;
import java.sql.Blob;
import java.sql.Date;

/**
 * @author Mohamed
 *
 */
public class ReimRequest {
	
	
	private int rId; 
	private double rAmount;
	private String rDescription;
	private Blob rReceipt;
	private Date rSubmitted;
	private Date rResolved;
	private int authorId; 
	private int resolverId; 
	private int rType; 
	private int rStatus; 

	/**
	 * 
	 */
	public ReimRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * For user to request
	 * @param rAmount
	 * @param rDescription
	 * @param rSubmitted
	 * @param authorId
	 * @param rType
	 * @param rStatus
	 */
	public ReimRequest(double rAmount, String rDescription, Date rSubmitted, int authorId, int rType, int rStatus) {
		super();
		this.rId = 0;
		this.rAmount = rAmount;
		this.rDescription = rDescription;
		this.rReceipt = null;
		this.rSubmitted = rSubmitted;
		this.rResolved = new Date(0);
		this.authorId = authorId;
		this.resolverId = 0;
		this.rType = rType;
		this.rStatus = rStatus;
	}

	
	/**
	 * @param rAmount
	 * @param rDescription
	 * @param authorId
	 * @param rType
	 */
	public ReimRequest(double rAmount, String rDescription, int authorId, int rType) {
		super();
		this.rAmount = rAmount;
		this.rDescription = rDescription;
		this.authorId = authorId;
		this.rType = rType;
	}

	/**
	 * @param rId
	 * @param rAmount
	 * @param rDescription
	 * @param rReceipt
	 * @param rSubmitted
	 * @param rResolved
	 * @param authorId
	 * @param resolverId
	 * @param rType
	 * @param rStatus
	 */
	public ReimRequest(int rId, double rAmount, String rDescription, Blob rReceipt, Date rSubmitted, Date rResolved,
			int authorId, int resolverId, int rType, int rStatus) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		this.rDescription = rDescription;
		this.rReceipt = rReceipt;
		this.rSubmitted = rSubmitted;
		this.rResolved = rResolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.rType = rType;
		this.rStatus = rStatus;
	}

	/**
	 * @return the rId
	 */
	public int getrId() {
		return rId;
	}

	/**
	 * @param rId the rId to set
	 */
	public void setrId(int rId) {
		this.rId = rId;
	}

	/**
	 * @return the rAmount
	 */
	public double getrAmount() {
		return rAmount;
	}

	/**
	 * @param rAmount the rAmount to set
	 */
	public void setrAmount(double rAmount) {
		this.rAmount = rAmount;
	}

	/**
	 * @return the rDescription
	 */
	public String getrDescription() {
		return rDescription;
	}

	/**
	 * @param rDescription the rDescription to set
	 */
	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	/**
	 * @return the rReceipt
	 */
	public Blob getrReceipt() {
		return rReceipt;
	}

	/**
	 * @param rReceipt the rReceipt to set
	 */
	public void setrReceipt(Blob rReceipt) {
		this.rReceipt = rReceipt;
	}

	/**
	 * @return the rSubmitted
	 */
	public Date getrSubmitted() {
		return rSubmitted;
	}

	/**
	 * @param rSubmitted the rSubmitted to set
	 */
	public void setrSubmitted(Date rSubmitted) {
		this.rSubmitted = rSubmitted;
	}

	/**
	 * @return the rResolved
	 */
	public Date getrResolved() {
		return rResolved;
	}

	/**
	 * @param rResolved the rResolved to set
	 */
	public void setrResolved(Date rResolved) {
		this.rResolved = rResolved;
	}

	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the resolverId
	 */
	public int getResolverId() {
		return resolverId;
	}

	/**
	 * @param resolverId the resolverId to set
	 */
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	/**
	 * @return the rType
	 */
	public int getrType() {
		return rType;
	}

	/**
	 * @param rType the rType to set
	 */
	public void setrType(int rType) {
		this.rType = rType;
	}

	/**
	 * @return the rStatus
	 */
	public int getrStatus() {
		return rStatus;
	}

	/**
	 * @param rStatus the rStatus to set
	 */
	public void setrStatus(int rStatus) {
		this.rStatus = rStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReimRequest [rId=" + rId + ", rAmount=" + rAmount + ", rDescription=" + rDescription + ", rSubmitted="
				+ rSubmitted + ", rResolved=" + rResolved + ", authorId=" + authorId + ", resolverId=" + resolverId
				+ ", rType=" + rType + ", rStatus=" + rStatus + "]";
	}
	
	

}
