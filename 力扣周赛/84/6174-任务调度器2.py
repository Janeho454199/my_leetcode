import collections
from typing import List


class Solution:
    def taskSchedulerII(self, tasks: List[int], space: int) -> int:
        cur_day = 0
        hash_dict = collections.defaultdict(int)
        cd = set()
        n = len(tasks)
        cur_mission = 0

        while cur_mission < n:
            # 冷却完毕，可以执行任务
            if hash_dict[tasks[cur_mission]] == 0:
                hash_dict[tasks[cur_mission]] = space
                # cd列表中的其他所有天数-space
                for item in list(hash_dict):
                    if item == tasks[cur_mission]:
                        continue
                    else:
                        hash_dict[item] -= 1
                        if hash_dict[item] == 0:
                            hash_dict.pop(item)
                # 下一个任务
                cur_mission += 1
            # 休息一天
            else:
                # 减cd
                for item in list(hash_dict):
                    hash_dict[item] -= 1
                    if hash_dict[item] == 0:
                        hash_dict.pop(item)
            # 不管执行与否都过了一天
            cur_day += 1

        return cur_day

    def taskSchedulerII2(self, tasks: List[int], space: int) -> int:
        """
        大佬的题解
        """
        d = 1
        d_last_task = collections.defaultdict(int)
        for task in tasks:
            if task not in d_last_task or d_last_task[task] + space < d:
                d_last_task[task] = d
            else:
                d = d_last_task[task] + space + 1
                d_last_task[task] = d
            d += 1
        return d - 1


if __name__ == '__main__':
    s = Solution()
    print(s.taskSchedulerII2(tasks = [5,8,8,5], space = 2))