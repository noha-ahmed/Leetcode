class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] preMap = new ArrayList[numCourses];
        for(int[] pre : prerequisites){
            if(preMap[pre[0]] == null)
                preMap[pre[0]] = new ArrayList<>();
            preMap[pre[0]].add(pre[1]);
        }
        
        HashSet<Integer> path = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(preMap[i] != null && preMap[i].size() > 0)
                if(isCyclic(preMap, path, i))
                    return false;
        }
        return true;
    }
    
    private boolean isCyclic(ArrayList<Integer>[] preMap, HashSet<Integer> path, int courseNum){
        if(path.contains(courseNum)) return true;
        if(preMap[courseNum] == null || preMap[courseNum].size() == 0) return false;
        
        path.add(courseNum);
        ArrayList<Integer> pres = preMap[courseNum];
        for(int pre: pres){
            if(isCyclic(preMap, path, pre))
                return true;
        }
        path.remove(courseNum);
        preMap[courseNum] = null;
        return false;
    }
}