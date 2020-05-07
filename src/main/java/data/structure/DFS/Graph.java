package data.structure.DFS;

/**
 * Created by dell on 2020/4/26.
 */
public class Graph {
    private final int MAX_VERTS = 20;//表示顶点的个数
    private Vertex vertexList[];//用来存储顶点的数组
    private int adjMat[][];//用邻接矩阵来存储边，数组元素表示没有边界，1表示有边界
    private int nVerts;//顶点个数
    private StackX theStack;//用栈实现深度优先搜索
    // private QueueX queue;//用队列实现广度优先搜索

    /**
     * 定点
     */
    class Vertex {
        public char label;
        public boolean isVisited = false;

        public Vertex(char label, boolean isVisited) {
            this.isVisited = isVisited;
            this.label = label;
        }
    }


    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;//初始化顶点个数为0
        //初始化邻接矩阵所有元素都为0，即所有顶点都没有边
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
        // queue = new QueueX();
    }

    public void printVertex(int i){
        System.out.println(vertexList[i].label + " ");
    }

    public void depthFirstSerch(){
        vertexList[0].isVisited = true;
        printVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()){
            int v =  getAdjUnvisitedVertex(theStack.peek());
            if (v == -1){
                theStack.pop();
            }else {
                theStack.push(v);
                vertexList[v].isVisited = true;
                printVertex(v);
            }
        }

        //栈访问完毕，重置所有标记位为false
        for (int i=0;i<nVerts;i++){
            vertexList[i].isVisited = false;
        }
    }

    //找到与某一顶点邻接且未被访问的顶点
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            //v顶点与i顶点相邻且未被访问
            if (adjMat[v][i] == 1 && vertexList[i].isVisited == false)
                return i;
        }
        return -1;
    }
}
