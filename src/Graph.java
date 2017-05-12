import java.util.*;

/**
 * Created by shayanraouf on 5/9/2017.
 */
public class Graph<Type> {
    List<GraphNode<Type>> nodes = new ArrayList<GraphNode<Type>>();
    Map<Type,GraphNode<Type>> map = new HashMap<Type, GraphNode<Type>>();

    public Graph(List<Type> dataList, List<Type[]> dependencies){
        buildGraph(dataList,dependencies);
    }

    public void buildGraph(List<Type> dataList, List<Type[]> dependencies){
        for(Type t: dataList){
            GraphNode<Type> currentNode = new GraphNode<Type>(t);
            nodes.add(currentNode);
            map.put(t,currentNode);
        }

        for(Type[] element: dependencies){
            Type src = element[0];
            Type dst = element[1];
            addEdge(src,dst);
        }
    }

    public void addEdge(Type from, Type to){
        GraphNode<Type> source = map.get(from);
        GraphNode<Type> destination = map.get(to);
        source.children.add(destination);
        source.map.put(from,destination);
    }

    public void topologicalOrdering(){
        Set<Type> visited = new HashSet<>();
        Stack<Type> stack = new Stack<>();
        for(GraphNode<Type> vertices: nodes){
            Type type = vertices.data;
            if(!visited.contains(type)){
                topologicalOrdering(type,visited,stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }

    private void topologicalOrdering(Type vertex, Set<Type> visited, Stack<Type> stack){
        visited.add(vertex);

        List<GraphNode<Type>> children = map.get(vertex).children;

        for(GraphNode<Type> v: children){

            Type currentVertex = v.data;
            if(!visited.contains(currentVertex)){
                topologicalOrdering(currentVertex,visited,stack);
            }
        }
        stack.push(vertex);
    }

    public void bfs(){
        Set<Type> visited = new HashSet<>();
        Queue<GraphNode<Type>> queue = new LinkedList<GraphNode<Type>>();

        for(GraphNode<Type> vertex: nodes){

            if(!visited.contains(vertex.data)){
                queue.add(vertex);
                visited.add(vertex.data);
                bfs(queue,visited);
            }
        }
    }

    private void bfs(Queue<GraphNode<Type>> queue, Set<Type> visited){
        if(queue.size() == 0) return;


        GraphNode<Type> node = queue.poll();
        System.out.print(node.data + " ");
        for(GraphNode<Type> vertex: map.get(node.data).children){

            if(!visited.contains(vertex.data)){
                queue.add(vertex);
                visited.add(vertex.data);
            }
        }

        bfs(queue,visited);
    }


    public void dfs(){
        Set<Type> visited = new HashSet<>();

        for(GraphNode<Type> vertex: nodes){
            Type type = vertex.data;
            if(!visited.contains(type)){
                dfs(type,visited);
            }
        }
    }

    private void dfs(Type vertex, Set<Type> visited){
        visited.add(vertex); // mark as visited
        System.out.print(vertex + " ");
        List<GraphNode<Type>> children = map.get(vertex).children;

        for(GraphNode<Type> v: children){

            Type currentVertex = v.data;
            if(!visited.contains(currentVertex)){
                dfs(currentVertex,visited);
            }
        }
    }
}
