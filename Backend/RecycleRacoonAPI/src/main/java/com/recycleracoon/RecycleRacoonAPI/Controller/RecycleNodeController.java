package com.recycleracoon.RecycleRacoonAPI.Controller;

import com.recycleracoon.RecycleRacoonAPI.Persistence.RecycleNodeDAO;
import com.recycleracoon.RecycleRacoonAPI.Model.RecycleNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("recyclenodes")
public class RecycleNodeController {
    private static final Logger LOG = Logger.getLogger(RecycleNodeController.class.getName());
    private RecycleNodeDAO recycleNodeDao;

    public RecycleNodeController(RecycleNodeDAO recycleNodeDao){
        this.recycleNodeDao = recycleNodeDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecycleNode> getRecycleNode(@PathVariable int id){
        LOG.info("GET /recyclenodes/" + id);
        try{
            RecycleNode node = recycleNodeDao.getRecycleNode(id);
            if (node != null) {
                return new ResponseEntity<RecycleNode>(node, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<RecycleNode[]> getRecycleNodes(){
        LOG.info("GET /recyclenodes/");
        try{
            RecycleNode[] nodes = recycleNodeDao.getRecycleNodes();
            if (nodes != null){
                return new ResponseEntity<RecycleNode[]>(nodes, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<RecycleNode> createRecycleNode(@RequestBody RecycleNode node){
        LOG.info("POST /recyclenodes/" + node);
        try {
            RecycleNode newNode = recycleNodeDao.createRecycleNode(node);
            if (newNode != null){
                return new ResponseEntity<RecycleNode>(newNode, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (IOException e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<RecycleNode> updateRecycleNode(@RequestBody RecycleNode node){
        LOG.info("PUT /recyclenodes/" + node);
        try {
            RecycleNode newNode = recycleNodeDao.createRecycleNode(node);
            if (newNode != null){
                return new ResponseEntity<RecycleNode>(newNode, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<RecycleNode> deleteRecycleNode(@RequestBody RecycleNode node){
        LOG.info("DELETE /recyclenodes/" + node);
        try {
            boolean deleted = recycleNodeDao.deleteRecycleNode(node.getId());
            if (deleted){
                return new ResponseEntity<RecycleNode>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IOException e){
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
