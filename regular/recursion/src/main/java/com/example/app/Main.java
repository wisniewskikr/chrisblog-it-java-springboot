package com.example.app;


public class Main {

	public static void main(String[] args) {		
		
		Leaf leaf = new Leaf();
		
		// Two Leafs left
		Leaf leafLeft1 = new Leaf();
		Leaf leafLeft2 = new Leaf();
		leaf.setLeft(leafLeft1);
		leafLeft1.setLeft(leafLeft2);
		
		// Three Leafs right
		Leaf leafRight1 = new Leaf();
		Leaf leafRight2 = new Leaf();		
		Leaf leafRight3 = new Leaf();
		leaf.setRight(leafRight1);
		leafRight1.setRight(leafRight2);
		leafRight2.setRight(leafRight3);
		
		Main main = new Main();
		int depth = main.getDepth(leaf);
		System.out.println("Depth is: " + depth);

	}
	
	public int getDepth(Leaf leaf) {
		return leaf.getDepth(leaf, 0);
	}
	
}

class Leaf {
	
	private Leaf left;
	private Leaf right;
	
	public int getDepth(Leaf leaf, int depth){
		
		depth++;
		int leftDepth;
		int rightDepth;
		
		if(leaf.getLeft() != null){
			leftDepth = getDepth(leaf.getLeft(), depth);			
		}else{
			leftDepth = depth;
		}
		
		if(leaf.getRight() != null){
			rightDepth = getDepth(leaf.getRight(), depth);			
		}else{
			rightDepth = depth;
		}
		
		if(leftDepth > rightDepth){
			return leftDepth;
		}else if(rightDepth > leftDepth){
			return rightDepth;
		}else{
			return leftDepth;
		}
		
	}
	
	public Leaf getLeft() {
		return left;
	}
	public void setLeft(Leaf left) {
		this.left = left;
	}
	
	public Leaf getRight() {
		return right;
	}
	public void setRight(Leaf right) {
		this.right = right;
	}	
	
}