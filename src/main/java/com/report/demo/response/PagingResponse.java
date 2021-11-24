package com.report.demo.response;

import org.springframework.data.domain.Page;

public class PagingResponse {
	private Paging paging;
	
	private Object data;

	public PagingResponse(Page paging, Object data) {
		this.paging = new Paging(paging);
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
