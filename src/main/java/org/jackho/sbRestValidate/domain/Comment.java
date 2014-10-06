/**
 * 
 */
package org.jackho.sbRestValidate.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author jackho
 *
 */
public class Comment {
	@NotEmpty(message = "{error.comment.text.empty}")
    @Length(max = 15 , message = "{error.comment.text.length}")
    private String text;
	
	@NotNull(message = "{error.comment.number.null}")
	@Min(value = 18, message = "{error.comment.number.min}")
	private Integer number;

    public Comment() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
    
    
}
