package Mode;

import UI.FailedJFrame;

import java.util.*;

public class Snake {
	/**
	 * ����������ѭ����
	 */
	public int c=0;
	/**
	 * �����С
	 */
	public final static int size =10;
	/**
	 * ��ͼ��С
	 */
	public static int map_size=500;
	/**
	 * ��ͷ
	 */
	private Node first;
	/**
	 * �ߵ�β�ͣ�ʵ����β���ߵ���һ���ڵ�
	 */
	private Node tail;
	/**
	 * ��β
	 */
	private Node last;
	/**
	 * �ߵ����ݽṹ
	 */
	private ArrayList<Node> s=new ArrayList<Node>();
	/**
	 * ��ͼ�������ߵĽڵ�,�ߵ�String�洢
	 */
	private HashSet<String> map=new HashSet<String>();

	/**
	 * ����
	 */
	private int dir;// 8 6 2 4  �� �� �� ��
	private int OldDir;
	/**
	 * ʳ��
	 */
	private Node food;
	//�ж��Ƿ����
	public boolean IsFailed=false;
	//�����ߵ��ٶ�
	public int Speed = 100;

	public Snake(){

	}
	public Snake(Node first,Node last,Node food,Node tail){
		this.first=first;
		this.last=last;
		this.food=food;
		this.tail=tail;
	}
	/**
	 * ��n��ӵ�s��
	 * @param n
	 */
	public void add_Node(Node n){
		s.add(0, n);
		//��ͷ��ǰ�����ƶ�
		first=s.get(0);
		//�����ӵĽڵ㲻��ʳ�ȥ��β��
		if(!n.toString().equals(food.toString())){
			tail=last;//��¼β��
			s.remove(last);
			last=s.get(s.size()-1);
		}else{//�����,���ʳ�
			food=RandomFood();
		}
	}
	/**
	 * �ƶ�
	 */
	public void move() {
		if(dir==8){
			Node n=new Node(first.getX(),first.getY()-10);
			add_Node(n);
			updataMap(s);
		}
		if(dir==6){
			Node n=new Node(first.getX()+10,first.getY());
			add_Node(n);
			updataMap(s);
		}
		if(dir==2){
			Node n=new Node(first.getX(),first.getY()+10);
			add_Node(n);
			updataMap(s);
		}
		if(dir==4){
			Node n=new Node(first.getX()-10,first.getY());
			add_Node(n);
			updataMap(s);
		}
		if((first.getX() > map_size/2 && first.getX()+10 > map_size)
				|| (first.getX() <= map_size/2 && first.getX() < 10)
				|| (first.getY() > map_size/2 && first.getY()+10 > map_size)
				|| (first.getY() <= map_size/2 && first.getY() < 10)){
			new FailedJFrame();
			this.IsFailed=true;
		}
	}
	/**
	 * �������÷����move
	 * @param dir
	 */
	public void move(int dir){
		OldDir = this.dir;
		this.dir=dir;
		move();
	}
	/**
	 * �ж�dir�����ܲ�����
	 * @paramsnake
	 * @param dir
	 * @return
	 */
	public boolean canMove(int dir){
		if(dir==8){
			int X=first.getX();
			int Y=first.getY()-10;
			if(Y<10||map.contains(X+"-"+Y)){
				return false;
			}else return true;
		}
		if(dir==6){
			int X=first.getX()+10;
			int Y=first.getY();
			if(X>Snake.map_size||map.contains(X+"-"+Y)){
				return false;
			}else return true;
		}
		if(dir==2){
			int X=first.getX();
			int Y=first.getY()+10;
			if(Y>Snake.map_size||map.contains(X+"-"+Y)){
				return false;
			}else return true;
		}
		if(dir==4){
			int X=first.getX()-10;
			int Y=first.getY();
			if(X<10||map.contains(X+"-"+Y)){
				return false;
			}else return true;
		}
		return false;
	}
	/**
	 * StringתNode
	 * @param s
	 * @return
	 */
	public Node StringToNode(String s){
		String []str=s.split("-");
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		return new Node(x,y);
	}
	/**
	 * NodeתString,ͻȻ�������ֱ��д��toString����
	 * @param n
	 * @return
	 */
//	public String NodeToString(Node n){
//		return n.getX()+"-"+n.getY();
//	}
	/**
	 * ���µ�ͼ�Ϸ��ʹ���λ��
	 * @param s
	 */
	public void updataMap(ArrayList<Node> s){
		map.clear();//���Ƴ��ɵ�վλ��
		for(Node n:s){
			map.add(n.toString());
		}
	}
	/**
	 * ʳ����������
	 */
	public Node RandomFood() {
		c=0;
		while(true){
			int x, y;
			Random r = new Random();
			 x = (r.nextInt(map_size-10)/10) *10  +10;
			 y = (r.nextInt(map_size-10)/10) *10  +10;
			Node n=new Node(x,y);
			//ʳ�ﲻ�ܳ�����������,s.contains��Ȼ��鲻��Node,
			//ͻȻ�뵽�ǲ���Node��û��дequals��������
			if(!s.contains(n)){
				return n;
			}
		}
	}

	public void setMap_size(int map_size) {
		Snake.map_size = map_size;
	}
	

	/**
	 * 
	 * @return �߳�
	 */
	public int getLen() {
		return s.size();
	}
	/**
	 * @return β��lsat�ĺ�һ���ڵ�
	 */
	public Node getTail() {
		return tail;
	}
	
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	public HashSet<String> getMap() {
		return map;
	}
	public Node getFirst() {
		return first;
	}

	public Node getLast() {
		return last;
	}

	public ArrayList<Node> getS() {
		return s;
	}

	public void setFirst(Node first) {
		this.first = first;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	public void setS(ArrayList<Node> s) {
		this.s = s;
	}
	public void setMap(HashSet<String> map) {
		this.map = map;
	}
	public void setFood(Node food) {
		this.food = food;
	}
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public Node getFood() {
		return food;
	}

	public void setSpeed(int speed){
		this.Speed = speed;
	}
}
