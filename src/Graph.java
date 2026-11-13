import java.util.ArrayList;

public class Graph {
    private int vertices;
    private ArrayList<ArrayList<Integer>> al;
    private int[][] matrix;

    Graph(int vertices_no) {
        this.vertices = vertices_no;
        this.al = new ArrayList<>();
        this.matrix = new int[vertices_no][vertices_no];

        for (int i = 0; i < vertices_no; i++) {
            al.add(new ArrayList<>());
        }
    }

    public void add_edges(int from, int to) {
        al.get(from).add(to);
        al.get(to).add(from);

        matrix[from][to] = 1;
        matrix[to][from] = 1;
    }

    public void print_graph() {
        for (int i = 0; i < this.vertices; i++) {
            System.out.println(this.al.get(i));
        }
    }

    public void dfs_list(ArrayList<Integer> labels) {
        boolean[] visited = new boolean[this.vertices];

        for (int i = 0; i < this.vertices; i++) {
            if (!visited[i]) {
                dfs_list(i, visited, labels);
            }
        }

        System.out.println();
    }

    public void dfs_list(int vertex, boolean[] visited,
                         ArrayList<Integer> labels) {
        visited[vertex] = true;
        System.out.print(labels.get(vertex) + " ");

        for (int i = 0; i < al.get(vertex).size(); i++) {
            int next = al.get(vertex).get(i);

            if (!visited[next]) {
                dfs_list(next, visited, labels);
            }
        }
    }

    public void dfs_matrix(ArrayList<Integer> labels) {
        boolean[] visited = new boolean[this.vertices];

        for (int i = 0; i < this.vertices; i++) {
            if (!visited[i]) {
                dfs_matrix(i, visited, labels);
            }
        }

        System.out.println();
    }

    public void dfs_matrix(int vertex, boolean[] visited,
                           ArrayList<Integer> labels) {
        visited[vertex] = true;
        System.out.print(labels.get(vertex) + " ");

        for (int i = 0; i < this.vertices; i++) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                dfs_matrix(i, visited, labels);
            }
        }
    }
}