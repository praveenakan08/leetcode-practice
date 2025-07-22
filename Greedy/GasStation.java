// TC - O(n), SC - O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 0 -> cost - 3 but gas - 1 --> sum += current gas if sum >= cost then sum -= cost continue, if i == last then -> i = 0 and if i == start then return or -1
        // 1 -> cost - 4 but gas - 2
        // 2 -> cost - 5 but gas - 3
        // 3 -> cost - 1 gas - 3
        int gasSum = 0, costSum = 0;
        for(int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if(gasSum < costSum) {
            return -1;
        }

        int start = 0, myGas = 0;
        for(int i = 0; i < gas.length; i++) {
            myGas += gas[i] - cost[i];

            if(myGas < 0) {
                myGas = 0;
                start = i + 1;
            }
        }

        return start;
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;

        for(int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if(gasSum < costSum) {
            return -1;
        } 


        int start = 0, myGas = 0;
        for(int i = 0; i < gas.length; i++) {
            myGas += gas[i] - cost[i];

            if(myGas < 0) {
                myGas = 0;
                start = i + 1;
            }
        }
        

        return start;
    }
}