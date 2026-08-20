package com.demoorangehrm.drivers;

public enum Browser {
    CHROME {
        @Override
        public AbstractDriver getDriverFactory() {
            return new ChromeFactory();
        }
    };

    public abstract AbstractDriver getDriverFactory();
}