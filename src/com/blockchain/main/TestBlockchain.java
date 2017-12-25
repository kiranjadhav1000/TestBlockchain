package com.blockchain.main;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import com.blockchain.core.Block;
import com.blockchain.core.Blockchain;
import com.blockchain.core.Transaction;

public class TestBlockchain {

	public static void main(String[] args) {
		Transaction transaction1;
		Transaction transaction2;
		Transaction transaction3;
		Transaction transaction4;
		
		Blockchain chain = new Blockchain();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//create and add transactions to block
		transaction1 = new Transaction("Kiran", "Ajit", 1, timestamp);
		transaction2 = new Transaction("Kiran", "Ajit", 2, timestamp);
		transaction3 = new Transaction("Kiran", "Ajit", 3, timestamp);
		List<Transaction> transactions1 = new LinkedList<Transaction>();
		transactions1.add(transaction1);
		transactions1.add(transaction2);
		transactions1.add(transaction3);
		chain.addBlock(new Block(1,transactions1,timestamp));
		
		//create and add transactions to block
		List<Transaction> transactions2 = new LinkedList<Transaction>();
		timestamp = new Timestamp(System.currentTimeMillis());
		transaction1 = new Transaction("Ajit", "Akash", 3, timestamp);
		transaction2 = new Transaction("Ajit", "Akash", 5, timestamp);
		transactions2.add(transaction1);
		transactions2.add(transaction2);
		chain.addBlock(new Block(2,transactions2,timestamp));
		
		//create and add transactions to block
		List<Transaction> transactions3 = new LinkedList<Transaction>();
		timestamp = new Timestamp(System.currentTimeMillis());
		transaction1 = new Transaction("Akash", "ABC Foundation", 12, timestamp);
		transaction2 = new Transaction("Akash", "BCD Foundation", 120, timestamp);
		transaction3 = new Transaction("Akash", "123 Foundation", 1200, timestamp);
		transaction4 = new Transaction("Akash", "9090 Foundation", 2, timestamp);
		transactions3.add(transaction1);
		transactions3.add(transaction2);
		transactions3.add(transaction3);
		transactions3.add(transaction4);
		timestamp = new Timestamp(System.currentTimeMillis());
		chain.addBlock(new Block(3,transactions3,timestamp));
		
		//print the enire block chain
		chain.printBlockchain();
	}
}
