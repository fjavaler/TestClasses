package Manager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



@SuppressWarnings("serial")
public class ContactsList  
{

	public static ArrayList<BusinessContacts> businessList = new ArrayList<BusinessContacts>();
	public static ArrayList<FriendContacts> friendList = new ArrayList<FriendContacts>();
	public static ArrayList<FamilyContacts> familyList = new ArrayList<FamilyContacts>();
	
	public static boolean readBusinessFile()
	{
		// set success to true if file read successfully
		boolean success = false;
		/*
		 * try statement to open, write and close the file one or more catch
		 * blocks to handle exceptions optional finally
		 */
		try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(ContactGui.bFile)))
		{
			businessList = (ArrayList<BusinessContacts>) input.readObject();

		}
		catch(IOException | ClassNotFoundException ex)
		{
			System.out.printf("Problem occured during Deserialztion: %s%n", "acounts.ser");
			System.out.println(ex.getMessage());
			
		}
		if(businessList!=null)
		{
			success =true;
		}
		else
		{
			success = false;
		}
		return success;
	}// end ReadAccountList()

	/** 
	 * writes the account list to businessAccounts.ser as default
	 * And to the openFileName when utilized by the save as button.
	 * 
	 */
	public static void writeBusinessFile()
	{
		/*
		 * try statement to open, write and close the file one or more catch
		 * blocks to handle exceptions optional finally
		 */
		try(ObjectOutputStream output =  
				new ObjectOutputStream(new FileOutputStream(ContactGui.bFile)))
		{
			output.writeObject(businessList);
		}
		catch(IOException ex)
		{
			System.out.println("Problem occured during Serialization");
			System.out.println(ex.getMessage());
		}
	}// end writeAccountList()
	
//	public static void writeBusinessFile()
//	{
//		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(bFile)))
//		{
//			out.writeObject(businessContact);
//		}
//		
//		catch (IOException ex)
//		{
//			System.out.println("Something went wrong with serialization");
//			System.out.println(ex.getMessage());
//		}
//		
//	}
//	
//	public static List<BusinessContacts> readBusinessFile(String business)
//	{
//		businessContact
//		List<BusinessContacts> people = null;
//		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(bFile)))
//		{
//			bList = (ArrayList<BusinessContacts>) in.readObject();
//			
//		}
//		catch(IOException | ClassNotFoundException ex)
//		{
//			System.out.printf("A problem happened during desiralization of %s%n",business);
//			System.out.println(ex.getMessage());
//		}
//		return people;
//	}
//	
//	public void writeFamilyFile(List<FamilyContacts> contacts, String family)
//	{
//		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(family)))
//		{
//			out.writeObject(contacts);
//		}
//		
//		catch (IOException ex)
//		{
//			System.out.println("Something went wrong with serialization");
//			System.out.println(ex.getMessage());
//		}
//		
//	}
//	
//	public List<FamilyContacts> readFamilyFile(String family)
//	{
//		List<FamilyContacts> people = null;
//		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(family)))
//		{
//			people = (List<FamilyContacts>) in.readObject();
//			
//		}
//		catch(IOException | ClassNotFoundException ex)
//		{
//			System.out.printf("A problem happened during desiralization of %s%n",family);
//			System.out.println(ex.getMessage());
//		}
//		return people;
//	}
//	
//	public void serializeFriends(List<FriendContacts> contacts, String friends)
//	{
//		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(friends)))
//		{
//			out.writeObject(contacts);
//		}
//		
//		catch (IOException ex)
//		{
//			System.out.println("Something went wrong with serialization");
//			System.out.println(ex.getMessage());
//		}
//		
//	}
//	
//	public List<FriendContacts> deserializeFriends(String friends)
//	{
//		List<FriendContacts> people = null;
//		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(friends)))
//		{
//			people = (List<FriendContacts>) in.readObject();
//			
//		}
//		catch(IOException | ClassNotFoundException ex)
//		{
//			System.out.printf("A problem happened during desiralization of %s%n",friends);
//			System.out.println(ex.getMessage());
//		}
//		return people;
//	}

}
