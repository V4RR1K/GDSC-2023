package com.recycleracoon.RecycleRacoonAPI.Persistence;

import com.recycleracoon.RecycleRacoonAPI.Model.RecycleNode;
import com.recycleracoon.RecycleRacoonAPI.Model.RecycleType;

import java.io.IOException;

public interface RecycleNodeDAO {

    /**
     * getRecycleNode gets all recycle nodes
     * @return all nodes in an array
     * @throws IOException if issue with internal storage
     */
    RecycleNode[] getRecycleNodes() throws IOException;

    // RecycleNode[] getRecycleNodeByRecycleType(RecycleType type) throws IOException;

    /**
     * getRecycleNode gets a node by id
     * @param id recycleid
     * @return RecycleNode
     * @throws IOException if issue with internal storage
     */
    RecycleNode getRecycleNode(int id) throws IOException;

    /**
     * createRecycleNode creates a new recyclenode
     * @param newNode new node to be created
     * @return created node
     * @throws IOException if issue with internal storage
     */
    RecycleNode createRecycleNode(RecycleNode newNode) throws IOException;

    /**
     * updateRecycleNode updates given node with new information
     * @param updatedNode given node
     * @return updated node
     * @throws IOException if issue with internal storage
     */
    RecycleNode updateRecycleNode(RecycleNode updatedNode) throws IOException;

    /**
     * deleteRecycleNode deletes node with given id
     * @param id node id
     * @return true if node was deleted, false if not
     * @throws IOException if issue with internal storage
     */
    boolean deleteRecycleNode(int id) throws IOException;
}