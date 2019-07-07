package dto;

public class Person {
	private String name;
	private Person creditor;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getCreditor() {
		return creditor;
	}
	public void setCreditor(Person creditor) {
		this.creditor = creditor;
	}
	@Override
	public String toString() {
		return name + ", " + creditor.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditor.name == null) ? 0 : creditor.name.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (creditor == null) {
			if (other.creditor != null)
				return false;
		} else if (!creditor.equals(other.creditor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
*/
}
