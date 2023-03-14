package com.recycleracoon.RecycleRacoonAPI.Persistence;

import com.recycleracoon.RecycleRacoonAPI.Model.RecycleNode;

import java.io.IOException;

public class RecycleNodeFileDAO implements RecycleNodeDAO {


    /**
     * getRecycleNode gets all recycle nodes
     *
     * @return all nodes in an array
     * @throws IOException if issue with internal storage
     */
    @Override
    public RecycleNode[] getRecycleNodes() throws IOException {
        return new RecycleNode[0];
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
        return null;
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
        return null;
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
        return null;
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
        return false;
    }
}
