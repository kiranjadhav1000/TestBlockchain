package com.blockchain.main;

import java.sql.Timestamp;

import com.blockchain.core.Block;
import com.blockchain.core.Blockchain;
import com.blockchain.core.Transaction;

public class TestBlockchain {

	public static void main(String[] args) {
		Blockchain chain = new Blockchain();
		
		//create and add 1st block to blockchain
		Transaction transaction = new Transaction("Kiran", "Ajit", 2);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		chain.addBlock(new Block(1,transaction,timestamp));
		
		//create and add 2nd block to blockchain
		transaction = new Transaction("Ajit", "Akash", 3);
		timestamp = new Timestamp(System.currentTimeMillis());
		chain.addBlock(new Block(2,transaction,timestamp));
		
		//create and add 3rd block to blockchain
		transaction = new Transaction("Akash", "ABC Foundation", 12);
		timestamp = new Timestamp(System.currentTimeMillis());
		chain.addBlock(new Block(3,transaction,timestamp));
		
		//print the enire block chain
		chain.printBlockchain();
	}
}
