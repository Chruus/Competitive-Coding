import java.util.*;
import java.awt.*;
import java.io.*;
public class UpgradedSearchTree
{
	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("tree.dat"));
		
		String line = fromFile.nextLine();
		
		String[] data = line.split(",");
		
		UpdatedBinaryTree tree = new UpdatedBinaryTree();
		
		for(int x=0; x<data.length;x++)
		{
			tree.add(Integer.parseInt(data[x]));
		}
	
		
		System.out.println(tree.preOrder());
		System.out.println(tree.inOrder());
		System.out.println(tree.postOrder());
	}
		
	
}

class TreeNode
{
	public Integer data;
	public TreeNode left;
	public TreeNode right;
	public int count;

	public TreeNode(Integer data)
	{
		this.data 		= data;
		count = 1;
		left = right	= null;
	}
	
	@Override 
	public String toString()
	{	return data +""+ ((count==1)?"":"("+count+")");	}
}

class UpdatedBinaryTree
{
	public TreeNode root = null;
	
	public UpdatedBinaryTree()
	{	root = null;	}
	
	public void add(Integer data)
	{
		if(root==null)
			root = new TreeNode(data);
		else
		{
			TreeNode temp = root;
			while(temp!=null)
			{
				if(temp.data.equals(data))
				{
					temp.count = temp.count+1;
					return;
				}
				else if(data.compareTo(temp.data)<0)
				{
					if(temp.left==null)
					{
						temp.left= new TreeNode(data);
						return;
					}
					else
						temp = temp.left;
				}
				else
				{
					if(temp.right==null)
					{
						temp.right = new TreeNode(data);
						return;
					}
					else
						temp = temp.right;
				}
			}
		}
	}
	
	public String preOrder()
	{
		return "["+preOrderHelper(root)+"]";
	}
	
	public String preOrderHelper(TreeNode temp)
	{
		if(temp==null)
			return "";
		else
			return ((temp==null)?"":temp) 
				+ ((temp!=null&&temp.left!=null)?" "+preOrderHelper(temp.left):"") 
				+ ((temp!=null&&temp.right!=null)?" "+preOrderHelper(temp.right):"");
	}
	
	public String inOrder()
	{
		return "["+inOrderHelper(root)+"]";
	}
	
	public String inOrderHelper(TreeNode temp)
	{
		if(temp==null)
			return "";
		else
			return  ((temp!=null&&temp.left!=null)?inOrderHelper(temp.left)+" ":"") 
				+((temp==null)?"":temp+"") 
				+((temp!=null&&temp.right!=null)?" "+inOrderHelper(temp.right):"");
	}
	
	public String postOrder()
	{
		return "["+postOrderHelper(root)+"]";
	}
	
	public String postOrderHelper(TreeNode temp)
	{
		if(temp==null)
			return "";
		else
			return postOrderHelper(temp.left) + ((temp.left!=null && temp.right!=null)?" ":"")
				+ postOrderHelper(temp.right)
				+ ((temp!=null && (temp.left!=null ||temp.right!=null))?" ":"")+temp;
	}
}

  
