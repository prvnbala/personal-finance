package com.praveen.personalfinance;

import com.google.gson.Gson;

public class TransactionFileRepository implements TransactionRepository {

    @Override
    public void addTransaction(Transaction transaction) {
        Gson gson = new Gson();
        String transactionRecord = gson.toJson(transaction);
        System.out.println(transactionRecord);
    }
}
