/**
 * 
 */
package org.jackho.sbRestValidate.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author jackho
 *
 */
public class Person {
	
	@NotEmpty
    @Length(max = 10)
    private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
