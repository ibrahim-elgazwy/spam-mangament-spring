package com.report.demo.exceptions;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.report.demo.reportEnum.ReportException;

public class ReportExceptionSerializer extends StdSerializer<ReportException> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5982666095055661704L;

	public ReportExceptionSerializer() {
		this(null);
	}
	
	public ReportExceptionSerializer(Class<ReportException> t) {
		super(t);
	}
	
	protected ReportExceptionSerializer(Class<ReportException> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(ReportException reportException, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonGenerationException {
		System.out.println(reportException.toString());
		jgen.writeStartObject();
        jgen.writeStringField("errorCode", reportException.getErrorCode() == null ? "" : reportException.getErrorCode());
        jgen.writeStringField("errorDescription", reportException.getErrorDescription() == null ? "" : reportException.getErrorDescription());

        jgen.writeEndObject();
	}
}
