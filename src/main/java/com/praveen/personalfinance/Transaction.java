package com.praveen.personalfinance;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Transaction {
    private Date transactionDate;
    private String transactor;
    private double transactionAmount;
    private String transactionNote;
    private TransactionCategory transactionCategory;
    private boolean isIncome;

    public Transaction(String input) {
        transactionDate = extractDate(input);
        transactor = extractName(input);
        transactionAmount = extractAmount(input);
        transactionNote = extractNote(input);
        transactionCategory = extractCategory(input);
    }

    private TransactionCategory extractCategory(String input) {
        String[] inputArr = input.split("\\s+");
        for(int i = 1; i < inputArr.length; i++) {
            if("-ctg".equals(inputArr[i-1])) {
                return TransactionCategory.getCategoryByCode(inputArr[i]);
            }
        }
        return null;
    }

    private Date extractDate(String input) {
        String[] inputArr = input.split("\\s+");
        for(int i = 1; i < inputArr.length; i++) {
            if("-d".equals(inputArr[i-1])) {
                try {
                    return new SimpleDateFormat("dd/MM/yyyy").parse(inputArr[i]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private String extractName(String input) {
        String[] inputArr = input.split("\\s+");
        for(int i = 1; i < inputArr.length; i++) {
            if("-n".equals(inputArr[i-1])) {
                return NameConstants.getNameWithAlias(inputArr[i]);
            }
        }
        return null;
    }

    private double extractAmount(String input) {
        String[] inputArr = input.split("\\s+");
        for(int i = 1; i < inputArr.length; i++) {
            if("-amt".equals(inputArr[i-1])) {
                return Double.parseDouble(inputArr[i]);
            }
        }
        return 0;
    }

    private String extractNote(String input) {
        String[] inputArr = input.split("\\s+");
        for(int i = 1; i < inputArr.length; i++) {
            if("-note".equals(inputArr[i-1])) {
                return inputArr[i];
            }
        }
        return null;
    }
}
