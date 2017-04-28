package Manager;

public class FriendContacts extends Contacts
{

	// fields
	private String notes;

	/**
	 * Constructor
	 */
	public FriendContacts(String firstName, String lastName, String streetAddress, String city, String state,
			String zip, String mobileNumber, String homeNumber, String nts)
	{
		super(firstName, lastName, streetAddress, city, state, zip, mobileNumber, homeNumber);
		this.notes = nts;
	}

	/**
	 * Gets friend's notes.
	 * 
	 * @return the notes
	 */
	public String getNotes()
	{
		return this.notes;
	}

	/**
	 * Sets friend's notes.
	 * 
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String _notes)
	{
		this.notes = _notes;
	}

	/**
	 * Validate friend info message text box. On a result of less than zero, an
	 * invalid entry has been made. On a result greater than zero all entries
	 * are valid.
	 * 
	 * @param info
	 * @return int value indicating whether friend info is valid.
	 */
	public int validFriendInfo()
	{
		if (this.validInfo() > 0)
		{
			if (!notes.matches(".*"))
			{
				return -1;
			}
		}
		return 1;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendContacts other = (FriendContacts) obj;
		if (notes == null)
		{
			if (other.notes != null)
				return false;
		}
		else if (!notes.equals(other.notes))
			return false;
		return true;
	}
}