package config.xml.collections;

import java.util.List;
import java.util.Properties;
import java.util.Set;

public class BankService {
	private List<Object> elementList;
	
	private Set <Element> elementSet;
	
	private java.util.Properties properties;

	public java.util.Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	

	public List<Object> getElementList() {
		return elementList;
	}

	public void setElementList(List<Object> elementList) {
		this.elementList = elementList;
	}

	public Set<Element> getElementSet() {
		return elementSet;
	}

	public void setElementSet(Set<Element> elementSet) {
		this.elementSet = elementSet;
	}
	
	
	
	
	

}
