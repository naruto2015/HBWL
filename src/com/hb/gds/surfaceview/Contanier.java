package com.hb.gds.surfaceview;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

public class Contanier {

	private List<Contanier> children=null;
	
	public Contanier(){
		children=new ArrayList<Contanier>();
		
	}

		
	public void draw(Canvas canvas){
		childrenView(canvas);
		for(Contanier c : children){
			c.draw(canvas);
		}
	}
	
	public void childrenView(Canvas canvas){
		
	}
	
	
	public void addChildrenView(Contanier child){
		children.add(child);
	}
	
	public void removeChildrenView(Contanier child){
		children.remove(child);
	}
	
}
