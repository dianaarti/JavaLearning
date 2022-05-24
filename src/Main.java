import java.util.Random;
import java.util.Arrays;
import java.time.Duration;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.Locale;

public class Main
{
    public static Scanner input = new Scanner(System.in);
    static PrintWriter out;
    static HashMap<Integer, Long> factMap;
    static boolean ONLINE_JUDGE = false;
    static int itr;

    public static int[] readIntArray() {
        String s[] = input.nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }
    public static int readInt() {
        String n= input.nextLine();
        return Integer.parseInt(n);
    }
    public static int numberOfUniqueFromAnArrayInt(int[] arr){
        Boolean bool=false;
        int output=1;
        for (int i=0;i<arr.length-1;i++){
            bool=false;
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i] == arr[j]) {
                    bool = true;
                    break;
                }
            }
            if (bool==false)
                output++;

        }
        return output;
    }

    public static void TreeNoteTest() throws IOException{
        Reader r = new Reader();
        int n=r.nextInt();
        int[] col=r.readIntArray(n);
        int[] visited = new int[n];
        TreeNode[] nodes = new TreeNode[n];
        ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> open_nodes = new ArrayList<Integer>();
        TreeNode root;
        open_nodes.add(0);
        visited[0] = 1;
        for (int i=0 ; i<n ; ++i) {
            nodes[i] = new TreeNode(col[i],i+1);
            next.add(new ArrayList<Integer>());
        }
        root = nodes[0];
        for (int i=0 ; i<n-1 ; ++i) {
            int[] uv = r.readIntArray(2);
            int u = uv[0] - 1;
            int v = uv[1] - 1;
            next.get(u).add(v);
            next.get(v).add(u);

        }
        while (open_nodes.size() > 0) {
            int xpand = open_nodes.remove(open_nodes.size() - 1);
            Iterator<Integer> it = next.get(xpand).iterator();
            while (it.hasNext()) {
                int xnext = it.next();
                if (visited[xnext] == 0) {
                    visited[xnext] = 1;
                    open_nodes.add(xnext);
                    nodes[xpand].AddChild(nodes[xnext]);
                }
            }
        }
        //   System.out.println(nodes[0].toStringDownstream());
        //  System.out.println(nodes[1].toStringDownstream());
        // System.out.println(nodes[2].toStringDownstream());
        //        System.out.println(nodes[0].toStringPath(nodes[6]));
        //      System.out.println(nodes[0].toStringPath(nodes[10]));
        //    System.out.println(nodes[1].toStringPath(nodes[5]));

//            System.out.println(nodes[7].toStringUpstream(nodes[0]));
        //          System.out.println(nodes[10].toStringUpstream(nodes[1]));
        System.out.println(nodes[10].toStringAnyStream(nodes[3]));
    }

    public static void SortArrayObjects(){
        ArrayList<Thing> things = new ArrayList<Thing>();
        things.add(new Thing(9,1));
        things.add(new Thing(6,12));
        things.add(new Thing(3,98));
        Collections.sort(things, (Thing t1, Thing t2) -> t1.y - t2.y);
        System.out.println(String.format("%d %d %d", things.get(0).x,
                things.get(1).x, things.get(2).x));

        Thing[] things2 = new Thing[3];
        things2[0] = new Thing(1,2);
        things2[1] = new Thing(2,3);
        things2[2] = new Thing(0,5);

        Collections.sort(things, (Thing t1, Thing t2) -> t1.y - t2.y);

        System.out.println(String.format("%d %d %d", things.get(0).x,
                things.get(1).x, things.get(2).x));


    }

    public static void inheritenceTestCarVehicle(){

        // Create a myCar object
        Car myCar = new Car();

        // Call the honk() method (from the Vehicle class) on the myCar object
        myCar.honk();

        // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
        System.out.println(myCar.brand + " " + myCar.modelName);



    }
    public static void main(String[] args)
    {
        try {
            if (System.getProperty("ONLINE_JUDGE") == null && !ONLINE_JUDGE) {
                FileOutputStream output = new FileOutputStream("output.txt");
                PrintStream out = new PrintStream(output);
                System.setOut(out);
                InputStream input = new FileInputStream("input.txt");
                System.setIn(input);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try { // change here what to read from input.txt
            Reader s = new Reader();
            out = new PrintWriter(System.out);

            //  TreeNoteTest();

            //  SortArrayObjects();

            inheritenceTestCarVehicle();



            // System.out.println("");
            out.flush();

        }
        catch (Exception e) {
            out.flush();
            System.out.println(e);
            return;
        }
    }

}


