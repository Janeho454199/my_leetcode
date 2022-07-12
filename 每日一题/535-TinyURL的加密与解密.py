import random
import string


class Codec:
    def __init__(self):
        """
        对于每个 longUrl 我们都在「大写字母/小写字母/数字」中随机 k = 6k=6 位作为其映射标识，这需要使用一个哈希表 tiny2Origin 进行记录。
        """
        # 存放互转字典，已转换的不再二次转换
        self.origin_to_tiny = {}
        self.tiny_to_origin = {}
        self.k = 6
        self.prefix = 'https://acoier.com/tags/'
        # ascii_letters方法的作用是生成全部字母
        # digits方法的作用是生成数组，包括0-9
        # ss = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'
        self.ss = string.ascii_letters + string.digits

    def encode(self, longUrl: str) -> str:
        while longUrl not in self.origin_to_tiny.keys():
            # 随机抽取六个数作为结果
            cur = ''.join([self.ss[random.randint(0, len(self.ss) - 1)] for _ in range(self.k)])
            if cur in self.tiny_to_origin.keys():
                continue
            self.tiny_to_origin[cur] = longUrl
            self.origin_to_tiny[longUrl] = cur
        return self.origin_to_tiny[longUrl]

    def decode(self, shortUrl: str) -> str:
        return self.tiny_to_origin[shortUrl]
