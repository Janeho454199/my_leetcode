"""
给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。

注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。


示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例2:
输入: num1 = "123", num2 = "456"
输出: "56088"


提示：

1 <= num1.length, num2.length <= 200
num1和 num2只能由数字组成。
num1和 num2都不包含任何前导零，除了数字0本身。
"""


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        """
        思路：类似于画草稿计算
        1 2 3
        4 5 6
        :param num1:
        :param num2:
        :return:
        """
        if num1 == "0" or num2 == "0":
            return "0"

        if len(num1) < len(num2):
            num1, num2 = num2, num1







