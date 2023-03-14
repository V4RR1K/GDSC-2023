package com.recycleracoon.RecycleRacoonAPI.Persistence;

import com.recycleracoon.RecycleRacoonAPI.Model.RecycleNode;
import com.recycleracoon.RecycleRacoonAPI.Model.RecycleType;

import java.io.IOException;

public interface RecycleNodeDAO {
    RecycleNode[] getRecycleNodes() throws IOException;

    // RecycleNode[] getRecycleNodeByRecycleType(RecycleType type) throws IOException;

    RecycleNode getRecycleNode(int id) throws IOException;

    RecycleNode createRecycleNode(RecycleNode newNode) throws IOException;

    RecycleNode updateRecycleNode(RecycleNode updatedNode) throws IOException;

    boolean deleteRecycleNode(int id) throws IOException;
}