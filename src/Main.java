import java.util.ArrayList;
import java.util.List;

/**
 * Created by shayanraouf on 5/10/2017.
 */
public class Main {

    public static void main(String[] args) {

//        List<Integer> projects = new ArrayList<>();
//        projects.add(0);
//        projects.add(1);
//        projects.add(2);
//        projects.add(3);
//        projects.add(4);
//        projects.add(5);
//        projects.add(6);
//
//        List<Integer[]> dep = new ArrayList<>();
//
//        dep.add(new Integer[]{0, 1});
//        dep.add(new Integer[]{0, 2});
//        dep.add(new Integer[]{0, 3});
//        dep.add(new Integer[]{1, 5});
//        dep.add(new Integer[]{1, 6});
//        dep.add(new Integer[]{2, 4});
//        dep.add(new Integer[]{3, 2});
//        dep.add(new Integer[]{3, 4});
//        dep.add(new Integer[]{4, 1});
//        dep.add(new Integer[]{6, 4});
//        Graph<Integer> graph = new Graph<Integer>(projects,dep);
//        graph.dfs();
        List<String> projects = new ArrayList<>();
        String p1 = "A";
        String p2 = "B";
        String p3 = "C";
        String p4 = "D";
        String p5 = "E";
        String p6 = "F";
        String p7 = "K";
        projects.add(p1);
        projects.add(p2);
        projects.add(p3);
        projects.add(p4);
        projects.add(p5);
        projects.add(p6);
        projects.add(p7);
        List<String[]> dep = new ArrayList<>();
        dep.add(new String[]{"A", "C"});
        dep.add(new String[]{"C", "E"});
        dep.add(new String[]{"E", "D"});
        dep.add(new String[]{"D", "B"});
        dep.add(new String[]{"B", "E"});
        dep.add(new String[]{"E", "A"});
        dep.add(new String[]{"A", "K"});
//        dep.add(new String[]{"D", "A"});
//        dep.add(new String[]{"B", "F"});
//        dep.add(new String[]{"D", "B"});
//        dep.add(new String[]{"A", "F"});
//        dep.add(new String[]{"C", "D"});
        Graph<String> graph = new Graph<>(projects,dep);
        //graph.dfs();
        //graph.topologicalOrdering();
        graph.bfs();

    }
}
