package cn.showcon.boot.config;

import java.util.List;

public class PageRequest {

    private int page;

    private int size;

    private List<SortItem> sortItem;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<SortItem> getSortItem() {
        return sortItem;
    }

    public void setSortItem(List<SortItem> sortItem) {
        this.sortItem = sortItem;
    }

    public static class SortItem {
        private String name;
        private boolean isAsc;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isAsc() {
            return isAsc;
        }

        public void setAsc(boolean asc) {
            isAsc = asc;
        }
    }
}


