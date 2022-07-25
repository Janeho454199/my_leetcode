class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        """
        思路：统计公牛次数，即secret[i] = guess[i]的个数
        统计母牛个数，即分别统计secret和guess中各数字的数量，并取最小值作为母牛
        """
        bulls = 0
        cntS, cntG = [0] * 10, [0] * 10
        for s, g in zip(secret, guess):
            if s == g:
                bulls += 1
            else:
                cntS[int(s)] += 1
                cntG[int(g)] += 1
        cows = sum(min(s, g) for s, g in zip(cntS, cntG))
        return f'{bulls}A{cows}B'