package com.litecoding.andorstrail.editor.entity.v42;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import com.litecoding.andorstrail.editor.entity.RewindIsNotSupportedException;

/* Related to com.gpl.rpg.AndorsTrail.model.item.Loot */
public class Loot extends SaveEntity {
	public int mExp;
	public int mGold;
	public ItemContainer mItemContainer;
	public Coord mPosition;
	public boolean mIsVisible;

	@Override
	public boolean read(DataInputStream dis, boolean rewindAfterRead) {
		//matches: version code 42
		if(rewindAfterRead) {
			mSavedException = new RewindIsNotSupportedException();
			return false;
		}
		
		try {
			mExp = dis.readInt();
			mGold = dis.readInt();
		} catch(Exception e) {
			mSavedException = e;
			return false;
		}
		
		mItemContainer = new ItemContainer();
		if(!mItemContainer.read(dis)) {
			mSavedException = mItemContainer.getLastException();
			return false;
		}
		
		mPosition = new Coord();
		if(!mPosition.read(dis)) {
			mSavedException = mPosition.getLastException();
			return false;
		}
		
		try {
			mIsVisible = dis.readBoolean();
		} catch(Exception e) {
			mSavedException = e;
			return false;
		}
		
		return true;
	}

	@Override
	public boolean write(DataOutputStream dos) {
		//matches: version code 42
		try {
			dos.writeInt(mExp);
			dos.writeInt(mGold);
		} catch(Exception e) {
			mSavedException = e;
			return false;
		}
		
		if(!mItemContainer.write(dos)) {
			mSavedException = mItemContainer.getLastException();
			return false;
		}
		
		if(!mPosition.write(dos)) {
			mSavedException = mPosition.getLastException();
			return false;
		}
		
		try {
			dos.writeBoolean(mIsVisible);
		} catch(Exception e) {
			mSavedException = e;
			return false;
		}
		
		return true;
	}

}
