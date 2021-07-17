package com.tupurpcheung.algorithm.graph;

import java.util.*;

/**
 * @description: 图的创建实现以及深度优先遍历和广度优先遍历
 *
 * 1：顶点使用集合存储
 * 2：使用二维数组存储对应的邻接矩阵
 * @author: tupurp
 * @create: 2020-06-23 23:03
 */
public class Graph {

    private int[][] edges; //存储相对应的邻接矩阵
    private List<String> vertex;//存储顶点
    private int numOfEdge;//表示边的数目

    private boolean[] isVisited;//记录某个节点是否已被访问

    private static final int DEFAULT_WEIGHT = 1;//边已连接状态

    /**
     * 构造函数
     * */
    public Graph(int vertexNum){
        //初始化顶点
        vertex = new ArrayList<>(vertexNum);
        //初始化矩阵
        edges = new int[vertexNum][vertexNum];

        //初始化边个数
        numOfEdge = 0;
    }


    /**
     * 插入节点
     * */
    public boolean insertVertex(String vertexVal){

        if(vertex.contains(vertexVal)){
            return false;
        }
        return vertex.add(vertexVal);
    }

    /**
     * 获取指定索引的节点值
     * */
    public String getValueByIndex(int index){
        return vertex.get(index);
    }

    /**
     * 添加边 v1顶点和v2顶点相连
     * @param v1 表示点的下标(即第几个顶点)
     * @param v2 第二个顶点的下标
     * @param weight 表示存在边的值
     * */
    private void insertEdge(int v1,int v2,int weight){
        if(v1 > edges.length){
            return;
        }
        if(v2 > edges.length){
            return;
        }

        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdge++;
    }

    /**
     * 添加边 v1顶点和v2顶点相连
     * @param v1 表示点的下标(即第几个顶点)
     * @param v2 第二个顶点的下标
     * */
    public void insertEdge(int v1,int v2){
        insertEdge(v1,v2,DEFAULT_WEIGHT);
    }

    /**
     * 返回边的个数
     * */
    public int getNumOfEdge(){
        return numOfEdge;
    }



    /**
     * 返回节点个数
     * */
    public int getNumOfVertex(){
        return vertex.size();
    }

    /**
     * 得到邻接节点的下标w
     * @return 如果存在则返回对应的下标，否则返回-1
     * */
    public int getFirstNeighbor(int v){
        int size = getNumOfVertex();
        for(int i = 0;i<size;i++){
            if(edges[v][i] > 0){
                return i;
            }
        }
        return -1;
    }
    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     * @param v 第一个节点
     * @param w 第一个节点的邻接节点w
     *
     * @return 返回w的邻接节点
     * */
    public int getNextNeighbor(int v,int w){
        int size = getNumOfVertex();
        for(int i = w + 1;i < size;i++){
            if(edges[v][i] > 0){
                return i;
            }
        }
        return  -1;
    }



    /**
     * 对一个节点进行深度优先遍历
     * */
    private void dfs(int v){
        //输出被访问的节点
        System.out.print(getValueByIndex(v) + "-->");
        isVisited[v] = true;
        //查找当前传入节点的第一个邻接节点
        int w = getFirstNeighbor(v);
        //存在第一个邻接节点
        while (w != -1){
            if(!isVisited[w]){
                //节点未被访问,递归
                dfs(w);

            }
            //节点已被访问,得到下一个邻接节点
            w = getNextNeighbor(v,w);
        }

    }
    /**
     * 深度优先遍历（使用递归）
     * 第一次就是 0
     * 1）访问初始节点v，并标记节点v为已访问
     * 2）查找节点v的第一个邻接节点w
     * 3）若w存在，则继续执行4；如果w不存在，则回到第一步，将从v的下一个节点继续
     * 4）若w未被访问，对w进行深度优先遍历递归（即把w当作另一个v，然后进行步骤123）
     * 5）查找节点v的邻接节点w的下一个邻接节点，转到步骤3
     *
     * */
    public void dfs(){
        //初始化节点访问记录
        isVisited = new boolean[edges.length];
        int size = getNumOfVertex();
        for(int i =0;i<size;i++){
            if(!isVisited[i]){
                dfs(i);
            }
        }

    }

    /**
     * 对单个节点进行广度优先遍历
     * */
    private void bfs(int v){
        int u; //队列头节点对应下标
        int w;//邻接节点w
        //队列，记录节点访问的顺序
        LinkedList<Integer> queue = new LinkedList();
        System.out.print(getValueByIndex(v) + "==>");
        //标记为已访问
        isVisited[v] = true;
        queue.addLast(v);

        //从队列出队头数据，展现该节点所在层数据
        while (!queue.isEmpty()){
            //取出队列头节点下标
            u = queue.removeFirst();
            //得到第一个邻接节点
            w = getFirstNeighbor(u);


            //查找当前层
            while (w != -1){
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "==>");
                    //标记为已访问
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //以u为前驱点，找出w后面的下一个邻接节点，广度优先
                w = getNextNeighbor(u,w);
            }
        }



    }
    /**
     * 广度优先遍历：使用一个队列来保存访问过节点的顺序，分层搜索
     * 1）访问初始节点v并标记节点v为已访问
     * 2）节点v加入队列
     * 3）当队列非空时，继续执行，否则算法结束
     * 4）出队列，取得队头节点u
     * 5）查找节点u的第一个邻接节点w
     * 6）若节点u的邻接w不存在，则转到步骤3，否则循环执行以下三个步骤
     *  6.1：若节点w尚未被访问，访问节点w并标记为已访问
     *  6.2：节点w入队列
     *  6.3：查找节点u的邻接节点w的下一个邻接节点w,步骤转移到6
     *
     * */
    public void bfs(){
        //初始化节点访问记录
        isVisited = new boolean[edges.length];
        int size = getNumOfVertex();
        for(int i =0;i<size;i++){
            if(!isVisited[i]){
                bfs(i);
            }
        }
    }

    @Override
    public String toString(){
        if(null == edges){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int[] edge:edges){
            stringBuilder.append(Arrays.toString(edge)).append("\r\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        int n = 8;
        //顶点数组
        String vertexValue[] = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(8);
        //图顶点初始化
        for(String s:vertexValue){
            graph.insertVertex(s);
        }
        //添加边1-2,1-3,2-4,2-5,4-8,5-8,1-3,3-6,3-7,6-7
        graph.insertEdge(0,1);
        graph.insertEdge(0,2);
        graph.insertEdge(1,3);
        graph.insertEdge(1,4);
        graph.insertEdge(3,7);
        graph.insertEdge(4,7);
        graph.insertEdge(2,5);
        graph.insertEdge(2,6);
        graph.insertEdge(5,6);
        System.out.print(graph);
        graph.dfs();
        System.out.println();
        graph.bfs();
    }
}