class Trie:

    def __init__(self):
        self.tree = {}

    def insert(self, word: str) -> None:
        cur = self.tree
        for c in word:
            if c not in cur:
                cur[c] = {}
            cur = cur[c]
        cur['#'] = {}

    def search(self, word: str) -> bool:
        cur = self.tree
        for c in word:
            if c not in cur:
                return False
            else:
                cur = cur[c]
        if '#' in cur:
            return True
        else:
            return False

    def startsWith(self, prefix: str) -> bool:
        cur = self.tree
        for c in prefix:
            if c not in cur:
                return False
            else:
                cur = cur[c]
        return True
