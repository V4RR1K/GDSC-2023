package com.recycleracoon.RecycleRacoonAPI.Persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import com.recycleracoon.RecycleRacoonAPI.Model.RecycleNode;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@Component
public class RecycleNodeFileDAO implements RecycleNodeDAO {

    Map<Integer, RecycleNode> recycleNodes;

    private final ObjectMapper objectMapper;
    private static int nextId;
    private final String filename;

    public RecycleNodeFileDAO(@Value("${users.file}") String filename,
                              ObjectMapper objectMapper) throws IOException {
        this.objectMapper = objectMapper;
        this.filename = filename;
        load();
    }

    private synchronized static int nextId() {
        int id = nextId;
        ++nextId;
        return id;
    }

    private RecycleNode[] getNodeArray(){
        ArrayList<RecycleNode> nodeArrayList = new ArrayList<>();

        for (RecycleNode node: recycleNodes.values()) {
            nodeArrayList.add(node);
        }

        RecycleNode[] nodeList = new RecycleNode[nodeArrayList.size()];
        nodeArrayList.toArray(nodeList);
        return nodeList;
    }

    private boolean save() throws IOException{
        RecycleNode[] nodeList = getNodeArray();
        objectMapper.writeValue(new File(filename), nodeList);
        return true;
    }

    private boolean load() throws IOException {
        recycleNodes = new TreeMap<>();
        nextId = 0;

        RecycleNode[] nodeList = objectMapper.readValue(new File(filename), RecycleNode[].class);

        for (RecycleNode node : nodeList){
            recycleNodes.put(node.getId(), node);
            if (node.getId() > nextId){
                nextId = node.getId() + 1;
            }
        }
        return true;
    }


    // --------------------------------- Overrides ---------------------------------

    /**
     * getRecycleNode gets all recycle nodes
     *
     * @return all nodes in an array
     * @throws IOException if issue with internal storage
     */
    @Override
    public RecycleNode[] getRecycleNodes() throws IOException {
        synchronized(recycleNodes){
            return getNodeArray();
        }
    }

    /**
     * getRecycleNode gets a node by id
     *
     * @param id recycleid
     * @return RecycleNode
     * @throws IOException if issue with internal storage
     */
    @Override
    public RecycleNode getRecycleNode(int id) throws IOException {
        synchronized(recycleNodes){
            if (recycleNodes.containsKey(id)){
                return recycleNodes.get(id);
            } else {
                return null;
            }
        }
    }

    /**
     * createRecycleNode creates a new recyclenode
     *
     * @param newNode new node to be created
     * @return created node
     * @throws IOException if issue with internal storage
     */
    @Override
    public RecycleNode createRecycleNode(RecycleNode newNode) throws IOException {
        synchronized(recycleNodes){
            RecycleNode node = new RecycleNode(nextId(),
                    newNode.getName(),
                    newNode.getDescription(),
                    newNode.getPhotoName(),
                    newNode.getGoogleNode(),
                    newNode.getType());
            recycleNodes.put(node.getId(), node);
            save();
            return node;
        }
    }

    /**
     * updateRecycleNode updates given node with new information
     *
     * @param updatedNode given node
     * @return updated node
     * @throws IOException if issue with internal storage
     */
    @Override
    public RecycleNode updateRecycleNode(RecycleNode updatedNode) throws IOException {
        synchronized(recycleNodes){
            if (!recycleNodes.containsKey(updatedNode.getId())){
                return null;
            } else {
                recycleNodes.put(updatedNode.getId(), updatedNode);
                save();
                return updatedNode;
            }
        }
    }

    /**
     * deleteRecycleNode deletes node with given id
     *
     * @param id node id
     * @return true if node was deleted, false if not
     * @throws IOException if issue with internal storage
     */
    @Override
    public boolean deleteRecycleNode(int id) throws IOException {
        synchronized(recycleNodes){
            if (recycleNodes.containsKey(id)){
                recycleNodes.remove(id);
                return save();
            } else {
                return false;
            }
        }
    }
}
