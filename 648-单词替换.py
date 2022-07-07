import re
import sys
from typing import List


class Solution:
    # def replaceWords(self, dictionary: List[str], sentence: str) -> str:
    #     """
    #     思路：先spilt，生成的每个单词依次去尝试匹配dictionary，匹配上的就做替换。
    #     :param dictionary:
    #     :param sentence:
    #     :return:
    #     """
    #     sentence_list = sentence.split(' ')
    #
    #     # 不在乎在什么位置，找到就替换，如果有更短的替换就换为更短的。
    #     for index in range(len(sentence_list)):
    #         # 记录长度
    #         temp_min = len(sentence_list[index])
    #         # 记录位置
    #         first_index = sys.maxsize
    #         # 记录要替换str
    #         temp_str = ''
    #         for key_index in range(len(dictionary)):
    #             if dictionary[key_index] in sentence_list[index]:
    #                 cur_index = sentence_list[index].find(dictionary[key_index])
    #                 if temp_min > len(dictionary[key_index]) and cur_index < first_index:
    #                     temp_str = dictionary[key_index]
    #                     first_index = cur_index
    #
    #         if temp_str != '':
    #             sentence_list[index] = temp_str
    #
    #     sentence = ' '.join(sentence_list)
    #
    #     return sentence
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        """
        集合
        :param dictionary:
        :param sentence:
        :return:
        """
        dictionarySet = set(dictionary)
        words = sentence.split(' ')
        for i, word in enumerate(words):
            for j in range(1, len(words) + 1):
                if word[:j] in dictionarySet:
                    words[i] = word[:j]
                    break
        return ' '.join(words)

    def replaceWords_trie(self, dictionary: List[str], sentence: str) -> str:
        """
        字典树
        :param dictionary:
        :param sentence:
        :return:
        """
        trie = {}
        for word in dictionary:
            cur = trie
            for c in word:
                if c not in cur:
                    cur[c] = {}
                cur = cur[c]
            cur['#'] = {}

        words = sentence.split(' ')
        for i, word in enumerate(words):
            cur = trie
            for j, c in enumerate(word):
                if '#' in cur:
                    words[i] = word[:j]
                    break
                if c not in cur:
                    break
                cur = cur[c]
        return ' '.join(words)


if __name__ == '__main__':
    s = 'hello world hello'
    print(s.find('hello'))
    s = Solution()
    s.replaceWords_trie(["a", "aa", "aaa", "aaaa"], "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa")

