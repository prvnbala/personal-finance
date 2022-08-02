package com.praveen.personalfinance;

import lombok.Getter;

@Getter
public enum NameConstants {
    PRAVEEN("bp", "Praveen");

    String alias;
    String name;

    NameConstants(String alias, String name) {
        this.alias = alias;
        this.name = name;
    }

    public static String getNameWithAlias(String alias) {
        for(NameConstants entry : NameConstants.values()) {
            if(entry.getAlias().equals(alias.toLowerCase())) {
                return entry.getName();
            }
        }
        return null;
    }
}
