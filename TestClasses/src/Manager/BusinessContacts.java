package Manager;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BusinessContacts extends Contacts 
{
	private String company;
	private String workPhone;
	private String eMail;

	public BusinessContacts(String fName, String lName, String strtAdrs, String cty, String st, String zip, String mNum,
			String hNum, String cmpny, String wkPhone, String email) 
	{
		super(fName, lName, strtAdrs, cty, st, zip, mNum, hNum);

		this.company = cmpny;
		this.workPhone = wkPhone;
		this.eMail = email;
				
	}
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		double result = 1;

		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((workPhone == null) ? 0 : workPhone.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		return (int) result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		BusinessContacts other = (BusinessContacts) obj;
		
		//test of company field
		if(company != other.company)
			return false;
		
		if(company == null)
		{
			if(other.company != null)
				return  false;
		}
		else if(!company.equals(other.company))
			return false;
		
		//test of workphone
		if(workPhone != other.workPhone)
			return false;
		
		if(workPhone == null)
		{
			if(other.workPhone != null)
				return false;
		}
		else if(!workPhone.equals(other.workPhone))
			return false;
		
		//test email
		if(eMail != other.eMail)
			return false;
		
		if(eMail == null)
		{
			if(other.eMail != null)
				return false;
		}
		else if(!eMail.equals(other.eMail))
			return false;
		
		return true;
	}


	/**
	 * @return the company
	 */
	public String getCompany() 
	{
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) 
	{
		this.company = company;
	}

	/**
	 * @return the workPhone
	 */
	public String getWorkPhone() 
	{
		return workPhone;
	}

	/**
	 * @param workPhone the workPhone to set
	 */
	public void setWorkPhone(String workPhone) 
	{
		this.workPhone = workPhone;
	}

	/**
	 * @return the eMail
	 */
	public String geteMail() 
	{
		return eMail;
	}

	/**
	 * @param eMail 
	 * Passing the new email parameter sets the field of email
	 */
	public void seteMail(String eMail) 
	{
		this.eMail = eMail;
	}
	
	/**
	 * @param field
	 * validates the field entry
	 */
	public int validBusInfo(BusinessContacts contact)
	{
		int result = 1;
		if(contact.validInfo()>0)
		{
			if(!company.matches("[A-Z]([a-zA-Z0-9 ]+)*([ '-][a-zA-Z]+)*(Inc)*(LLC)*(Corp)*(\\.)*"))
			{
				result  = -10;
			}
			if(!workPhone.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}"))
			{
				result = -11;
			}
			if(!eMail.matches("[a-zA-Z0-9\\.\\-_!#$%*/?^`{|}~]+@[a-z]+\\.[a-z]{2,3}"))
			{
				result = -12;
			}
			switch(result)
			{		
			case -10: JOptionPane.showMessageDialog(null, "Error: Re-enter Company Name","WARNING", JOptionPane.ERROR_MESSAGE);
				break;
			case -11: JOptionPane.showMessageDialog(null, "Error: Re-enter Work Phone","WARNING", JOptionPane.ERROR_MESSAGE);
				break;
			case -12: JOptionPane.showMessageDialog(null, "Error: Re-enter First Name","WARNING", JOptionPane.ERROR_MESSAGE);
			default: result = -13;
				break;
			}
		
	
		}
		return result;
	}	
}

