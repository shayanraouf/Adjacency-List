import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shayanraouf on 5/9/2017.
 */
public class GraphNode<Type> {
    Type data;
    List<GraphNode<Type>> children = new ArrayList<>();
    Map<Type,GraphNode<Type>> map = new HashMap<Type, GraphNode<Type>>();

    public GraphNode(Type t){
        data = t;
    }
}
