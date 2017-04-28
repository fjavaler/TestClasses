package Manager;

import java.io.Serializable;

import javax.swing.JOptionPane;
/**
 * FileName: FinalProject_Team3
 * Class: CSIS 1410
 * 
 * Fields:
 * 
 * 	-firstName: String
 * 	-lastName: String
 * 	-streetAddress: String
 * 	-city: String
 * 	-state: String
 * 	-zip: String
 * 	-homePhone: String
 * 	-mobilePhone: String
 */

public class Contacts implements Serializable
{
	private String firstName; 
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String mobileNumber;
	private String homeNumber;
	
	public Contacts(String fName, String lName, String strtAdrs,String cty, String st,String zip, String mNum, String hNum)
	{
		this.firstName = new String(fName);
		this.lastName = new String(lName);
		this.streetAddress = new String(strtAdrs);
		this.city = new String(cty);
		this.state = new String(st);
		this.zip = new String(zip);
		this.mobileNumber = new String(mNum);
		this.homeNumber = new String(hNum);
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homeNumber == null) ? 0 : homeNumber.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacts other = (Contacts) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homeNumber == null) {
			if (other.homeNumber != null)
				return false;
		} else if (!homeNumber.equals(other.homeNumber))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	/**
	 * @return the street address
	 */
	public String getStreet() 
	{
		return streetAddress;
	}

	/**
	 * @param strt
	 * sets the street number/name
	 */
	public void setCity(String cty) 
	{
		this.city = cty;
	}
	/**
	 * @return city
	 */
	public String getCity() 
	{
		return city;
	}
	/**
	 * @param zip
	 * sets the postal zip
	 */
	public void setZip(String zip) 
	{
		this.zip = zip;
	}
	/**
	 * @return zip
	 */
	public String getZip() 
	{
		return zip;
	}

	/**
	 * @param strt
	 * sets the street number/name
	 */
	public void setStreet(String strt) 
	{
		this.streetAddress = strt;
	}
	
	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the cellNumber
	 */
	public String getMobileNumber() 
	{
		return mobileNumber;
	}

	/**
	 * @param cellNumber the cellNumber to set
	 */
	public void setMobileNumber(String cellNumber) 
	{
		this.mobileNumber = cellNumber;
	}

	/**
	 * @return the companyName
	 */
	public String getHomeNumber() 
	{
		return homeNumber;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setHomeNumber(String hNum) 
	{
		this.homeNumber = hNum;
	}
	
	/**
	 * 
	 * @return first and last name in single string.
	 */
	public String getFLName()
	{
		return getFirstName()+" "+getLastName();
	}

	public int validInfo()
	{
		int result = 1;
		if(!firstName.matches("[A-Z]([a-zA-Z ]+)*([ '-][a-zA-Z]+)*"))
		{
			result = -1;
		}
		if(!lastName.matches("[A-Z]([a-zA-Z ]+)*([ '-][a-zA-Z]+)*"))
		{
			result = -2;
		}
		if(!streetAddress.matches("[0-9]+ (S|N|W|E)[a-zA-Z]+ ([A-Z][a-zA-Z]+)?([0-9]+)? [A-Z][a-zA-Z]+( [A-Z][a-zA-Z]+)?"))//address
		{
			result = -3;
		}
		if(!city.matches("[A-Z][a-zA-Z]+( [A-Z][a-zA-Z]+)*( City)*"))
		{
			result = -4;
		}
		if(!state.matches("[A-Z]{2}"))
		{
			result = -5;
		}
		if(!zip.matches("\\d{5}"))
		{
			result = -6;
		}
		if(!homeNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}"))
		{
			result = -7;
		}
		if(!mobileNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}"))
		{
			result = -8;
		}
		 switch (result) 
		 {
         case -1:  JOptionPane.showMessageDialog(null, "Error: Re-enter First Name","WARNING", JOptionPane.ERROR_MESSAGE);
                  break;
         case -2:  JOptionPane.showMessageDialog(null, "Error: Re-enter Last Name","WARNING", JOptionPane.ERROR_MESSAGE);
                  break;
         case -3:  JOptionPane.showMessageDialog(null, "Error: Re-enter Address","WARNING", JOptionPane.ERROR_MESSAGE);
                  break;
         case -4:  JOptionPane.showMessageDialog(null, "Error: Re-enter City","WARNING", JOptionPane.ERROR_MESSAGE);
                  break;
         case -5:  JOptionPane.showMessageDialog(null, "Error: Re-enter State","WARNING", JOptionPane.ERROR_MESSAGE);
                  break;
         case -6:  JOptionPane.showMessageDialog(null, "Error: Re-enter Zip","WARNING", JOptionPane.ERROR_MESSAGE);
                  break;
         case -7:  JOptionPane.showMessageDialog(null, "Error: Re-enter Home Number","WARNING", JOptionPane.ERROR_MESSAGE);
                  break;
         case -8:  JOptionPane.showMessageDialog(null, "Error: Re-enter Mobile Number","WARNING", JOptionPane.ERROR_MESSAGE);
                  break;
         default: result = -9;
                  break;
		 }
		 return result;
			
	}
	
}
