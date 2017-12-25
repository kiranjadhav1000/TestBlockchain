package com.blockchain.core;


import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class Blockchain {
	//set difficulty to mine the block
	private static final int difficulty = 1;
	
	//distributed ledger
	LinkedList<Block> blockchain = new LinkedList<Block>();
	
	public Blockchain() {
		blockchain.add(createGenesisBlock());
	}
	
	public Block getLatestBlock(){
		return blockchain.getLast();
	}
	//creating genesis block
	private Block createGenesisBlock(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		List<Transaction> transactions = new LinkedList<Transaction>();
		Transaction transaction = new Transaction("Out of thin air ", "Miner ", 25,timestamp);
		transactions.add(transaction);
		Block genesis = new Block("0", 0, transactions, timestamp);
		return genesis;
	}
	//add new block to blockchain after mining
	public void addBlock(Block block){
		block.setPrevHash(getLatestBlock().getHash());
		block.calculateHash();
		block.mineBlock(difficulty);
		blockchain.add(block);
	}
	
	public void printBlockchain(){
		for(Block b : blockchain){
			System.out.println(b.toString());
		}
	}
}
