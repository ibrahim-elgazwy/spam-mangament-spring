package com.report.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.report.demo.reportEnum.ReportStateEnum;
import com.report.demo.reportEnum.ReportTypeEnum;

@Entity
@Table(name = "report")
public class Report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3770436912528252327L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	private ReportStateEnum state;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private ReportTypeEnum type;
	
	@Version
    private int version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public ReportStateEnum getState() {
		return state;
	}

	public void setState(ReportStateEnum state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ReportTypeEnum getType() {
		return type;
	}

	public void setType(ReportTypeEnum type) {
		this.type = type;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) return true;

		if (other == null || !(other instanceof Report)) 
			return false;
		
		Report otherReport = (Report) other;

		return new EqualsBuilder()
					.appendSuper(super.equals(other))
					.append(id, otherReport.id)
					.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(31, 33)
					.append(id)
					.hashCode();	
	}
}
