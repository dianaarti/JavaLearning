import java.util.ArrayList;
import java.util.Iterator;

public class TreeNode implements Iterable{
    int color;
    int id;
    int depth;
    ArrayList<TreeNode> childs;
    TreeNode father;
    public TreeNode(int color, int id) {
        this.color = color;
        this.id=id;
        childs = new ArrayList<TreeNode>();
    }
    public void AddChild(TreeNode child) {
        childs.add(child);
        child.father = this;
    }
    public String toStringDownstream() {
        String ret = Integer.toString(id)+"-"+Integer.toString(color);
        if (childs.size() > 0) {
            ret += "[";
            Iterator<TreeNode> kid = childs.iterator();

            while(kid.hasNext()) {
                TreeNode child  = kid.next();
                ret += child.toStringDownstream();
                if (kid.hasNext()) {
                    ret += " ";
                }
            }
            ret += "]";
        }
        return ret;
    }

    public String toStringPath(TreeNode nodeEnd) {
        String ret = Integer.toString(id);

        if (this==nodeEnd){
            return ret;

        }

        if (childs.size() > 0) {
            Iterator <TreeNode> kid = childs.iterator();


            while(kid.hasNext()) {
                TreeNode child  = kid.next();

                String s= child.toStringPath(nodeEnd);
                if (s!=null)
                    return ret+" "+s;
            }
        }
        return null;
    }

    public String toStringUpstream(TreeNode nodeEnd) {
        String ret = Integer.toString(id);
        if (this == nodeEnd) {
            return ret;
        }
        if (father == null) {
            return null;
        } else {
            String s = father.toStringUpstream(nodeEnd);
            if (s != null)
                return ret+" "+s;
        }

        return null;
    }


    public String toStringReversedPath(TreeNode nodeEnd) {
        String ret = Integer.toString(id);
        if (this==nodeEnd){
            return ret;
        }
        if (childs.size() > 0) {
            Iterator <TreeNode> kid = childs.iterator();

            while(kid.hasNext()) {
                TreeNode child  = kid.next();

                String s= child.toStringReversedPath(nodeEnd);
                if (s!=null)
                    return s+" "+ret;
            }
        }
        return null;
    }

    public String toStringAnyStream(TreeNode nodeEnd){
        return toStringAnyStream(nodeEnd,null);
    }

    public String toStringAnyStream(TreeNode nodeEnd, TreeNode forbidden) {
        String ret = Integer.toString(id);
        if (this == nodeEnd) {
            return ret;
        }
        if (father != null) {
            String s= father.toStringAnyStream(nodeEnd,this);
            if (s!=null)
                return ret+" "+s;
        }

        Iterator <TreeNode> kid = childs.iterator();
        while(kid.hasNext()) {
            TreeNode child  = kid.next();
            if (child!=forbidden) {
                String s;
                if (forbidden!=null)
                    s= child.toStringPath(nodeEnd);
                else
                    s= child.toStringReversedPath(nodeEnd);
                if (s!=null)
                    return ret+" "+s;
            }
        }
        return null;
    }

    @Override
    public Iterator iterator() {


        return null;
    }
}
