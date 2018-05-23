package huawei;

import java.util.*;
//题目3：给出一个字符串形式表达的二叉树，求出指定节点深度。
//输入的树形结构字符串格式为：
//    1、以父节点、左子树、右子树表示的二叉树；每个父节点不会超过两个子节点；
//    2、树的每一个节点采用单个字母表示；树的层次采用数字表示，树根的层次为1，下一层为2，不会超过9层；
//    3、字符串以“节点名称 层次数 节点名称 层次数…”的形式出现，同一个父节点下，先出现的为左子树。
//    例如字符串“a1b2c2d3e3f3”生成一棵如下的树：
//         a
//       /    \
//      b       c
//     / \      / 
//    d   e  f     
//    节点a的深度为3，节点b的深度是2，节点f的深度是1
//    输入：一行字符串，表示一个二叉树。一行字符串，一个字符一个节点，输入确保字符不会存在重复节点
//    输出：指定节点的深度，如果节点不存在，返回0；整数之间用空格隔开
//    例如：
//    输入：a1b2c2d3e3f3
//    ab
//    输出：3 2

class TreeNode{
	char label;
	int level;
	TreeNode left;
	TreeNode right;
	TreeNode(char label, int level){
		this.label=label;
		this.level=level;
		left=null;
		right=null;
	}
}
public class Q9 {
	
	static List<Queue<TreeNode>> list;
	static List<TreeNode> allnodes;
	static Map<Character,TreeNode> map;
	
	
	
	private static int findheight(TreeNode root){
		if(root==null)
			return 0;
		int left=findheight(root.left);
		int right=findheight(root.right);
		return Math.max(left,right)+1;
	}
	
	private static void test(TreeNode root){
		if(root==null)
			return;
		System.out.println(root.label+" "+root.level);
		test(root.left);
		test(root.right);
	}
	
	public static void main(String[] args){
		list = new ArrayList<>();
		allnodes = new ArrayList<>();
		map = new HashMap<>();
		list.add(new LinkedList<TreeNode>());
		
		String str="a1b2c2d3e3f4";
		String query="af";
		for(int i=0;i<str.length();i+=2){
			int level=str.charAt(i+1)-'0';
			TreeNode node=new TreeNode(str.charAt(i),level);
			map.put(node.label, node);
			
			if(list.size()<=level){
				list.add(new LinkedList<TreeNode>());
			}
			list.get(level).offer(node);
			if(!list.get(level-1).isEmpty()){
				TreeNode parent = list.get(level-1).peek();
				if(parent.left==null){
					parent.left=node;
				}
				else{
					parent.right=node;
					list.get(level-1).poll();
				}
			}
			
		}
		for(char c: query.toCharArray()){
			if(!map.containsKey(c))
				System.out.println("0");
			else
				System.out.println(findheight(map.get(c)));
		}
		
		test(map.get('a'));  //for testing.

	}
}
