class AuthenticationManager {

    private int timeToLive;
    private Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap();
    }

    // timeToLive = 5
    // map = [aaa -> 7]

    public void generate(String tokenId, int currentTime) {
        // generate new token with expiry = timeToLive + currentTime
        this.map.put(tokenId, currentTime + this.timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        // expiry time = timeToLive + currentTime

        if(this.map.containsKey(tokenId) && this.map.get(tokenId) > currentTime) {
            this.map.put(tokenId, currentTime + this.timeToLive);
        }
        
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;

        for(String key: this.map.keySet()) {
            if(map.get(key) > currentTime) {
                count++;
            }
        }

        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */