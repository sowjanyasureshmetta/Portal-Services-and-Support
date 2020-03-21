package org.gelm.portal.dcrep.batch.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class CustomDateEditor extends PropertyEditorSupport{

	 @Override
	    public void setAsText(String value) {
	        try {
	            setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
	        } catch (Exception ex) {
	            setValue(null);
	        }
	    }

	    @Override
	    public String getAsText() {
	        String stringDate = "";
	        try {
	            stringDate= new SimpleDateFormat("yyyy-MM-dd").format((Date)getValue());  
	        } catch(Exception ex) {
	            //
	        } 
	        return stringDate;
	    }
	
}
