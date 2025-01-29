package com.rewards.Service;

import com.rewards.Model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RewardServiceTest {

    private RewardService rewardService;

    @BeforeEach
    void setUp() {
        rewardService = new RewardService();
    }

    @Test
    void testCalculateRewardPoints() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("123", 120, LocalDate.now()),
                new Transaction("123", 80, LocalDate.now()),
                new Transaction("456", 50, LocalDate.now())
        );

        Map<String, Integer> points = rewardService.calculatePoints(transactions);

        assertEquals(120, points.get("123"));
        assertEquals(0, points.get("456"));
    }

}
