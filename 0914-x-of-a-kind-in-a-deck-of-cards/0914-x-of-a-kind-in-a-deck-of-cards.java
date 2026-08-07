class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int n=deck.length;
        HashMap <Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=deck[i];
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        ArrayList <Integer> freq = new ArrayList<>(hm.values());

       int first = freq.get(0);

for (int x = 2; x <= first; x++) {
    if (first % x != 0)
        continue;
    boolean ok = true;
    for (int i = 1; i < freq.size(); i++) {
        if (freq.get(i) % x != 0) {
            ok = false;
            break;
        }
    }
    if (ok)
        return true;
}

return false;
    }
}