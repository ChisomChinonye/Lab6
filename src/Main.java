import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> vertices = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/graph.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.trim().split("\\s+");

            if (values.length == 2 && values[0].matches("[0-9]+")
                    && values[1].matches("[0-9]+")) {

                int from = Integer.parseInt(values[0]);
                int to = Integer.parseInt(values[1]);

                if (!vertices.contains(from)) {
                    vertices.add(from);
                }

                if (!vertices.contains(to)) {
                    vertices.add(to);
                }
            }
        }

        br.close();

        Graph g = new Graph(vertices.size());

        br = new BufferedReader(new FileReader("src/graph.txt"));

        while ((line = br.readLine()) != null) {
            String[] values = line.trim().split("\\s+");

            if (values.length == 2 && values[0].matches("[0-9]+")
                    && values[1].matches("[0-9]+")) {

                int from = Integer.parseInt(values[0]);
                int to = Integer.parseInt(values[1]);

                g.add_edges(vertices.indexOf(from), vertices.indexOf(to));
            }
        }

        br.close();

        System.out.print("DFS using adjacency list: ");
        g.dfs_list(vertices);

        System.out.print("DFS using adjacency matrix: ");
        g.dfs_matrix(vertices);
    }
}