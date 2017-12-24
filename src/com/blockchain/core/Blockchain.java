package com.blockchain.core;


import java.sql.Timestamp;
import java.util.LinkedList;

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
		Transaction transaction = new Transaction("Miner ", "Out of thin air", 25);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Block genesis = new Block("0", 0, transaction, timestamp);
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
