class Solution:
    def isStrictlyPalindromic(self, n: int) -> bool:
        """
        暴力
        """
        def decimalToNBaseByNormal(decimalVar, base):
            tempList = []
            temp = decimalVar
            i = 0
            while (temp > 0):
                ord = temp % base
                if (ord > 9):  # 如果余数大于9，则以字母的形式表示
                    ord = chr(65 + (ord - 10))  # 把数字转换成字符
                tempList.append(ord)
                temp = int(temp / base)
                i = i + 1
            tempList.reverse()
            binary = ""
            for j in range(len(tempList)):
                binary = binary + str(tempList[j])

            print("the decimal is: %d and after convering by %d base is %s" % (decimalVar, base, binary))
            return binary

        for i in range(2, n - 1):
            i = decimalToNBaseByNormal(n, i)
            if i != reversed(i):
                return False

        return True


if __name__ == '__main__':
    s = Solution()
    print(s.isStrictlyPalindromic(1000000000000000000))
