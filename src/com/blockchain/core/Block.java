package com.blockchain.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import com.blockchain.util.SHAUtils;


public class Block {
	int index;
	Transaction transaction;
	Timestamp timestamp;
	String hash;
	String prevHash;
	int nounce=0;
	
	public Block(String prevHash, int index,Transaction transaction,Timestamp ts) {
		this.index=index;
		this.prevHash=prevHash;
		this.timestamp=ts;
		this.index=index;
		this.transaction=transaction;
		this.hash=calculateHash();;
	}
	public Block(int index,Transaction transaction,Timestamp ts) {
		this.index=index;
		this.prevHash="0";
		this.timestamp=ts;
		this.index=index;
		this.transaction=transaction;
		this.hash=calculateHash();;
	}
	//Mine the block
	void mineBlock(int difficulty){
		String difficultyString="";
		int a[] = new int[difficulty];
		for(int i=0; i<difficulty; i++)
			difficultyString = difficultyString+a[i];
		System.out.println("Block mining started :"+index);
		//generate the block hash until hash starts with difficulty string
		while(!this.hash.substring(0, difficulty).equals(difficultyString)){
			this.nounce++;
			this.hash=this.calculateHash();
			//System.out.println("\t generated hash :"+this.hash);
			//System.out.print(".");
		}
		System.out.println("\nBlock mined : "+index);
		System.out.println("\n-----------------------------------------------------------------------------");
	}
	
	public String calculateHash() {
		MessageDigest md;
		String currentHash = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(transaction.getFrom().getBytes());
			md.update(transaction.getTo().getBytes());
			md.update((byte)transaction.getAmt());
			md.update((byte)index);
			md.update(SHAUtils.hexStringToByteArray(prevHash));
			md.update(timestamp.toString().getBytes());
			md.update((byte)nounce);
			byte byteData[] = md.digest();
			currentHash = SHAUtils.byteToHex(byteData);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return currentHash;
	}
	
	public String getHash() {
		return hash;
	}

	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}

	@Override
	public String toString() {
		System.out.println("--------------------------------------------------------------------------------------------------");
		return "Block "+ index +"{index=" + index + transaction + ",timestamp=" + timestamp 
				+ ",\n\t prevHash=" + prevHash + ", hash=" + hash+ "}";
	}
	
}
