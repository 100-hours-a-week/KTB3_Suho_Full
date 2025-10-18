package com.example.spring_community.dto.common;

public class Pagination {
    private int size;
    private boolean hasNext;
    private Long NextCursor;

    public Pagination(int size, boolean hasNext, Long nextCursor) {
        this.size = size;
        this.hasNext = hasNext;
        NextCursor = nextCursor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Long getNextCursor() {
        return NextCursor;
    }

    public void setNextCursor(Long nextCursor) {
        NextCursor = nextCursor;
    }
}
