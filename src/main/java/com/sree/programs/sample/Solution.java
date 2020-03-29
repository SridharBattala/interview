package com.sree.leave.programs.sample;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    private static final String TEXT =  "I am a {0} account with {1,number,#} units of {2} currency";

    public static void main(String args[] ) throws Exception {
    	System.out.println(getExpectedCosts(Arrays.asList(1,2,3,4)).toString());
    }
    static List<Integer> getExpectedCosts(List<Integer> transactionCosts) {
    	int oddCount=0;
    	int oddIndex=-1;
    	for(int i=0;i<transactionCosts.size(); i++) {
    		if(transactionCosts.get(i)%2!=0) {
    			oddCount=oddCount+1;
    			oddIndex=i;
    		}
    	}
    	if(oddCount==0) {
    		return getList(0,-1,transactionCosts.size());
    	}else if (oddCount==1) {
    		return getList(0,oddIndex,transactionCosts.size());
    	}else if (oddCount>1) {
    		return getList(0,-1,transactionCosts.size());
    	}
return null;
    }
    static List<Integer>  getList(int value,int oddIndex,int listLength){
    	List<Integer> list=new ArrayList<>();
    	for(int i=0;i<listLength;i++) {
    		if(i==oddIndex) {
    			list.add(1);
    		}else {
        		list.add(value);
    		}
    		
    	}
    	return list;
    }
}

abstract class  BankAccount{
	int units;
	String currency;
	String name;
	public BankAccount( String currency,int units ) {
		this.units = units;
		this.currency = currency;
	}
	public BankAccount() {
	}
	public abstract BankAccount getAccountType();
	public abstract String getName();
	
	
	public String getCurrency() {
		return String.valueOf(this.currency);
		
	}
	
	public int getUnits() {
		return this.units;
		
	}
}
class SavingsAccount extends BankAccount{
	
	public SavingsAccount( String currency,int units ) {
		super(currency,units);
		this.units = units;
		this.currency = currency;
	}
	public SavingsAccount() {
	}
	@Override
	public SavingsAccount getAccountType() {
		return new SavingsAccount();
		
	}
	@Override
	public String getName() {
		return "Savings";
		
	}
	
	
}
class CheckingAccount extends BankAccount{
	
	public CheckingAccount( String currency,int units ) {
		super(currency,units);
		this.units = units;
		this.currency = currency;
	}
	public CheckingAccount() {
	}
	public CheckingAccount getAccountType() {
		return new CheckingAccount();
		
	}
	public String getName() {
		return "Checking";
		
	}
}
class BrokerageAccount extends BankAccount{
	
	public BrokerageAccount( String currency,int units ) {
		super(currency,units);
		this.units = units;
		this.currency = currency;
	}
	public BrokerageAccount() {
	}
	public BrokerageAccount getAccountType() {
		return new BrokerageAccount();
		
	}
	public String getName() {
		return "Brokerage";
		
}}
