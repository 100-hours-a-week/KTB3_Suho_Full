package com.example.spring_community.dto.common;

public class Pagination {
    private int size;
    private boolean hasNext;
    private Long nextCursor;

    public Pagination(int size, boolean hasNext, Long nextCursor) {
        this.size = size;
        this.hasNext = hasNext;
        this.nextCursor = nextCursor;
    }

    public int getSize() {
        return size;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public Long getNextCursor() {
        return nextCursor;
    }

}
