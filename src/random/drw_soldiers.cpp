class Solution {
public:
int SupriorReportNum(int[] ranks){
unordered_map<int, int> rankCount;

      for(int r: ranks){
          if(rankCount.contains(r))
              rankCount[r] = rankCount[r] + 1;
          else
              rankCount.insert(r, 1);
      }

      int canReportNum = 0;

      for (auto const &pair: rankCount){
          if(rankCount.contains(pair.first + 1))
              canReportNum += pair.second;
      }

      return canReportNum;
}
}