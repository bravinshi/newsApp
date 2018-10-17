package com.bravin.shi.news.enumerate;

public enum VerifiedState {
    NO(0),
    YES(1);

    private int state;

    VerifiedState(int state) {
        this.state = state;
    }

    public int getValue() {
        return state;
    }
}
