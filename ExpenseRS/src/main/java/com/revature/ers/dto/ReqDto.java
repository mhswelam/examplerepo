/**
 * 
 */
package com.revature.ers.dto;


/**
 * @author Mohamed
 *
 */
public class ReqDto {
	
	
	private int rId; 
	private double rAmount;
	private String rDescription;
	private String rReceipt;
	private String rSubmittedDate;
	private String rResolvedDate;
	private String author; 
	private String resolver; 
	private String rType; 
	private String rStatus;

	/**
	 * 
	 */
	public ReqDto() {
		
	}

	/**
	 * @param rId
	 * @param rAmount
	 * @param rDescription
	 * @param rReceipt
	 * @param rSubmittedDate
	 * @param rResolvedDate
	 * @param author
	 * @param resolver
	 * @param rType
	 * @param rStatus
	 */
	public ReqDto(int rId, double rAmount, String rDescription, String rReceipt, String rSubmittedDate,
			String rResolvedDate, String author, String resolver, String rType, String rStatus) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		this.rDescription = rDescription;
		this.rReceipt = rReceipt;
		this.rSubmittedDate = rSubmittedDate;
		this.rResolvedDate = rResolvedDate;
		this.author = author;
		this.resolver = resolver;
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
	public String getrReceipt() {
		return rReceipt;
	}

	/**
	 * @param rReceipt the rReceipt to set
	 */
	public void setrReceipt(String rReceipt) {
		this.rReceipt = rReceipt;
	}

	/**
	 * @return the rSubmittedDate
	 */
	public String getrSubmittedDate() {
		return rSubmittedDate;
	}

	/**
	 * @param rSubmittedDate the rSubmittedDate to set
	 */
	public void setrSubmittedDate(String rSubmittedDate) {
		this.rSubmittedDate = rSubmittedDate;
	}

	/**
	 * @return the rResolvedDate
	 */
	public String getrResolvedDate() {
		return rResolvedDate;
	}

	/**
	 * @param rResolvedDate the rResolvedDate to set
	 */
	public void setrResolvedDate(String rResolvedDate) {
		this.rResolvedDate = rResolvedDate;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the resolver
	 */
	public String getResolver() {
		return resolver;
	}

	/**
	 * @param resolver the resolver to set
	 */
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	/**
	 * @return the rType
	 */
	public String getrType() {
		return rType;
	}

	/**
	 * @param rType the rType to set
	 */
	public void setrType(String rType) {
		this.rType = rType;
	}

	/**
	 * @return the rStatus
	 */
	public String getrStatus() {
		return rStatus;
	}

	/**
	 * @param rStatus the rStatus to set
	 */
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReqDto [rId=" + rId + ", rAmount=" + rAmount + ", rDescription=" + rDescription + ", rSubmittedDate="
				+ rSubmittedDate + ", rResolvedDate=" + rResolvedDate + ", author=" + author + ", resolver=" + resolver
				+ ", rType=" + rType + ", rStatus=" + rStatus + "]";
	}
	
	
	
	

}
