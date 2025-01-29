package com.rewards.Service;


import com.rewards.Model.Transaction;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardService {

    public Map<String, Integer> calculatePoints(List<Transaction> transactions) {
        Map<String, Integer> map = new HashMap<>();

        for (Transaction transaction : transactions) {
            int points = transactionPoints(transaction.getAmt());

            map.put(
                    transaction.getId(),
                    map.getOrDefault(transaction.getId(), 0) + points
            );
        }

        return map;
    }

    private int transactionPoints(double amt) {
        int points = 0;

        if (amt > 100) {
            // 2 points for each dollar over $100
            points += (amt - 100) * 2;
            amt = 100; // Cap the amount for the next bracket
        }

        if (amt > 50) {
            // 1 point for each dollar between $50 and $100
            points += (amt - 50) * 1;
        }

//        if (amt > 100) {
//            points += (int) ((amt - 100) * 2);
//        }
//        if (amt > 50) {
//            points += (int) (Math.min(amt, 100) - 50);
//        }

        return points;
    }

}