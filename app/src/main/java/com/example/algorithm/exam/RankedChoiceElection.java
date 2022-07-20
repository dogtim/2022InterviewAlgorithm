package com.example.algorithm.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://en.wikipedia.org/wiki/Ranked_voting#Instant-runoff_voting
/*
* Suppose the 3 candidates are A, B, C.

Voter 1's ranked choices are [A, B]
Voter 2's ranked choices are [B, A, C]
Voter 3's ranked choices are [C]
Voter 4's ranked choices are [B, A]
Voter 5's ranked choices are [C, A]

In round 1:
A received 1 vote
B received 2 votes
C received 2 votes

Since no candidate has over 50% of the votes, the candidate with the lowest number of votes is eliminated.  In this case, A is eliminated, and voter 1's vote goes to B instead.

In round 2:
	B received 3 votes
	C received 2 votes

Voter 1's ranked choices are [_, B]
Voter 2's ranked choices are [B, _, C]
Voter 3's ranked choices are [C]
Voter 4's ranked choices are [B, _]
Voter 5's ranked choices are [C, _]
So the winner of the election is B.

Question: Please describe how you would implement an algorithm to run a ranked choice election.  Describe some of the data structures you would use.  (Write an explanation of the algorithm (e.g. using a list of steps).  Don't try to write actual working code.)

* */
public class RankedChoiceElection {

    List<List<Character>> voters;
    HashMap<Character, Integer> roundResult = new HashMap<>();

    public RankedChoiceElection(List<List<Character>> voters) {
        this.voters = voters;
    }

    public Character getWinner() {
        int totalCount = voters.size();
        int countOverHalf = totalCount / 2;

        for (List<Character> candidates : voters) {

            Character candidate = candidates.get(0);
            Integer count = roundResult.get(candidate);
            if (count == null) {
                count = 0;
            }
            count++;

            if (count >= countOverHalf) {
                return candidate;
            }

            roundResult.put(candidate, count);
        }

        int min = Integer.MAX_VALUE;
        Character willRemoveCandidate = '_';
        for(Map.Entry<Character, Integer> entry: roundResult.entrySet()) {
            int nextMin = Math.min(min, entry.getValue());
            if (nextMin != min) {
                willRemoveCandidate = entry.getKey();
            }
            min = nextMin;
        }
        
        return '_';
    }

}
