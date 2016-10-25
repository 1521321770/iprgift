package com.inspur.gift.util;

import java.util.List;

/**
 * The Class PageListBean.
 * @param <T> the generic type
 * @author gzc
 */
public class PageBean<T> {

    private int total;
    
    final int defaltPageSize = 10;
    
    private int pageSize = defaltPageSize;
    
    final int page = 1;
    
    private int currentPage = page;
    
    private int totalPages;
    
    private String field;
    
    private String dir;

    private List<T> data;

    public PageBean(int currentPage, int pageSize, String dir, String field) {
    	this.currentPage = currentPage;
    	this.pageSize = pageSize;
    	this.dir = dir;
    	this.field = field;
    }
    /**
     * Instantiates a new page list bean.
     * @param total the total results
     * @param pageSize the page size
     * @param currentPage the current page
     * @param data the list
     */
    public PageBean(int total, int pageSize, int currentPage, List<T> data) {
        this.total = total;
        this.pageSize = pageSize;
        if (this.pageSize > 0) {
            this.currentPage = currentPage;
            this.totalPages = (int) Math.ceil(total / (double) pageSize);
        } else {
            this.currentPage = 1;
            this.totalPages = 1;
        }
        this.data = data;
    }

    /**
     * Gets the total results.
     * @return the total results
     */
    public int getTotal() {
        return total;
    }

    /**
     * Gets the page size.
     * @return the page size
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Gets the current page.
     * @return the current page
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Gets the total pages.
     * @return the total pages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Gets the list.
     * @return the list
     */
    public List<T> getData() {
        return data;
    }
    
    /**
     * get sort  column
     * @return sortColumn
     */
    public String getField() {
		return field;
	}

    /**
     * set sort column value
     * @param sortColumn
     */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * get sort order, asc or desc 
	 * @return sortord
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * set sort order value
	 * @param sortord
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "totalResults:" + this.total + " pageSize:" + pageSize + " currentPage:" + currentPage
                + " totalPages:" + totalPages + " list:" + data.toString();
    }

}
