package com.keyin.service;

import com.keyin.model.TreeNode;
import com.keyin.model.TreeRecord;
import com.keyin.repository.TreeRecordRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeService {
    private final TreeRecordRepository repo;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TreeService(TreeRecordRepository repo) {
        this.repo = repo;
    }

    public TreeRecord processInput(String input) throws Exception {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        TreeNode root = new TreeNode(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            root.insert(numbers.get(i));
        }

        String json = objectMapper.writeValueAsString(root);
        TreeRecord record = new TreeRecord();
        record.setInputNumbers(input);
        record.setTreeJson(json);
        record.setCreatedAt(LocalDateTime.now());
        return repo.save(record);
    }

    public List<TreeRecord> getAllRecords() {
        return repo.findAll();
    }
}

