package com.report.demo.response;

import org.springframework.data.domain.Page;

public class Paging {
	
	private long totalItems;
	
	private int totalPages;
	
	private int currentPage;
	
	private int nextPage;
	
	private int prevousPage;
	
	private boolean hasNext;
	
	private boolean hasPrevous;

	public Paging(Page page) {
		totalItems = page.getTotalElements();
		totalPages = page.getTotalPages();
		currentPage = page.getNumber();
		hasNext = page.hasNext();
		hasPrevous = page.hasPrevious();
		nextPage = hasNext ? currentPage + 1 : 0;
		prevousPage = hasPrevous ? currentPage - 1 : currentPage;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevousPage() {
		return prevousPage;
	}

	public void setPrevousPage(int prevousPages) {
		this.prevousPage = prevousPages;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isHasPrevous() {
		return hasPrevous;
	}

	public void setHasPrevous(boolean hasPrevous) {
		this.hasPrevous = hasPrevous;
	}
}
