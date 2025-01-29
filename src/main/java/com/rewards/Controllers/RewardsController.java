package com.rewards.Controllers;

import com.rewards.Model.Transaction;
import com.rewards.Service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {
    private final RewardService rewardService;

    @Autowired
    public RewardsController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Integer>> calculateRewardPoints(@RequestBody List<Transaction> transactions) {
        return ResponseEntity.ok(rewardService.calculatePoints(transactions));
    }
}

