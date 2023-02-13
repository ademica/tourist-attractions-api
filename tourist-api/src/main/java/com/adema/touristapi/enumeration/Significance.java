package com.adema.touristapi.enumeration;

public enum Significance {
    SIGNIFICANT("SIGNIFICANT"),
    VERY_SIGNIFICANT("VERY_SIGNIFICANT"),
    INEVITABLE("INEVITABLE");
    private final String significance;

    Significance(String significance) {
        this.significance = significance;
    }

    public String getSignificance() {
        return this.significance;
    }
}
