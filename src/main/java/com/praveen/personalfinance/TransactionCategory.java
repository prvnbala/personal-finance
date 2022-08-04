package com.praveen.personalfinance;

public enum TransactionCategory {
    HOUSE("hou", "House"),
    ESSENTIALS("ess", "Essentials"),
    NON_ESSENTIALS("nes", "Non essentials"),
    SAVINGS("sav", "Savings");

    private String code;
    private String category;

    TransactionCategory(String code, String category) {
        this.code = code;
        this.category = category;
    }

    public static TransactionCategory getCategoryByCode(String code) {
        for(TransactionCategory transactionCategory : TransactionCategory.values()) {
            if(code.equals(transactionCategory.code)) {
                return transactionCategory;
            }
        }
        return null;
    }
}
