package com.gzy.page.model;

import java.io.Serializable;
import java.util.List;

public class YouoneInfoPage<T> implements Serializable {
    private static final long serialVersionUID = 965088595793792016L;

    private int pageSize; //每页数据量
    private int currentPage; //当前是第几页
    private int totalRecords;//总共多少条数据
    private int totalPages; //总共多少页
    private List<T> dataList;

    public YouoneInfoPage(int pageNum, int pageSize, List<T> sourceList) {
        if (sourceList == null) {
            return;
        }
        //总记录条数
        this.totalRecords = sourceList.size();

        // 每页显示多少记录
        this.pageSize = pageSize;

        //获取总页数
        if (sourceList.size() % pageSize == 0) {
            this.totalPages = sourceList.size() / pageSize;
        } else {
            this.totalPages = (sourceList.size() / pageSize) + 1;
        }

        //获取当前页码
        if (this.totalPages < pageNum) {
            this.currentPage = this.totalPages;
        } else {
            this.currentPage = pageNum;
        }

        //起始索引
        int fromIndex = this.pageSize * (this.currentPage - 1);
        int toIndex;
        if (this.pageSize * this.currentPage > this.totalRecords) {
            toIndex = this.totalRecords;
        } else {
            toIndex = this.pageSize * this.currentPage;
        }
        this.dataList = sourceList.subList(fromIndex, toIndex);

    }

    public YouoneInfoPage() {
    }

    public YouoneInfoPage(int pageSize, int currentPage, int totalRecords, int totalPages, List<T> dataList) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
        this.dataList = dataList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
