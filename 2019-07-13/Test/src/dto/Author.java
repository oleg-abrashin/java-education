package dto;

import enumerations.AuthorLastName;
import enumerations.AuthorName;
import utils.Comparators;

public class Author implements Comparable<Author>{
		
	private String firstName;
	private String lastName;
	
	public Author() {}

	public Author(AuthorName firstName, AuthorLastName lastName) {
		this.firstName = firstName.toString();
		this.lastName = lastName.toString();
	}

	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return lastName + " " + firstName;
	}

	@Override
	public int compareTo(Author other) {
		return Comparators.authorComparator.compare(this, other);
	}
	
	
	
	
	
	
	
	
	

}
