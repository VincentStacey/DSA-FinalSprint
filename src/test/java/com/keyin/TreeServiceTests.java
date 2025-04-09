package com.keyin.service;

import com.keyin.model.TreeRecord;
import com.keyin.repository.TreeRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TreeServiceTests {

    @Mock
    private TreeRecordRepository repo;

    @InjectMocks
    private TreeService treeService;

    @Test
    public void testProcessInput_validInput() throws Exception {
        String input = "5,2,7,1,3";
        TreeRecord expectedRecord = new TreeRecord(input, "{\"value\":5}");

        when(repo.save(Mockito.any(TreeRecord.class))).thenReturn(expectedRecord);

        TreeRecord result = treeService.processInput(input);

        assertEquals(expectedRecord.getInputNumbers(), result.getInputNumbers());
        assertEquals(expectedRecord.getTreeJson(), result.getTreeJson());
    }

    @Test
    public void testProcessInput_invalidInput() {
        String input = "bad,input";

        assertThrows(NumberFormatException.class, () -> treeService.processInput(input));
    }

    @Test
    public void testGetAllRecords() {
        TreeRecord record1 = new TreeRecord("5,2,7", "{\"value\":5}");
        TreeRecord record2 = new TreeRecord("10,4,6", "{\"value\":10}");

        List<TreeRecord> expectedRecords = Arrays.asList(record1, record2);

        when(repo.findAll()).thenReturn(expectedRecords);

        List<TreeRecord> result = treeService.getAllRecords();

        assertEquals(2, result.size());
        assertEquals(expectedRecords, result);
    }
}
