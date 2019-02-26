package treeutil;

import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Tree {

    public Iterator<Node> buildTreeAndGetRoots(List<MyObject> actualObjects) {
        Map<String, Node> lookup = new HashMap<>();

        for (MyObject object : actualObjects) {
            lookup.put(object.id, new Node(object));
        }
        //foreach (var item in lookup.Values)
        Collection<Node> nodes = lookup.values();
        for (Node item : nodes) {
            Node proposedParent;
            if (lookup.containsKey(item.associatedObject.parentId)) {
                proposedParent = lookup.get(item.associatedObject.parentId);
                item.parent = proposedParent;
                proposedParent.children.add(item);
            }
        }
         return (Iterator<Node>) Stream.of(lookup.values()).filter(x -> x.parent == null).iterator();
        //return lookup.values.Where(x =>x.Parent ==null);
    }

}


