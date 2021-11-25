package com.report.demo.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import com.report.demo.reportEnum.ReportStateEnum;

@Convert
public class ReportStateAttributeConverter implements AttributeConverter<ReportStateEnum, String> {

	@Override
	public String convertToDatabaseColumn(ReportStateEnum attribute) {
        if (attribute == null)
            return null;
 
        switch (attribute) {
        
        case OPEN:
            return "Open";
            
        case CLOSED:
        	return "Closed";
            
		default:
			throw new IllegalArgumentException(attribute + " not supported.");
        }
	}

	@Override
	public ReportStateEnum convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;
 
        switch (dbData) {
        
        case "Open":
            return ReportStateEnum.OPEN;
            
        case "Closed":
        	return ReportStateEnum.CLOSED;
            
		default:
			throw new IllegalArgumentException(dbData + " not supported.");
        }
	}

}
